-- Details enchere
CREATE OR REPLACE VIEW vue_enchere_produit_utilisateur AS
SELECT Enchere.idEnchere, Enchere.idUtilisateur, Utilisateur.nom, Utilisateur.prenom, Enchere.idProduit, Produit.nomProduit, Enchere.description, Enchere.prixMinimumVente, Enchere.dureeEnchere, Enchere.DateHeureEnchere, Enchere.status ,produit.idcategorieproduit,  c.categorie
FROM Enchere
         INNER JOIN Produit ON Enchere.idProduit = Produit.idProduit
         INNER JOIN Utilisateur ON Enchere.idUtilisateur = Utilisateur.idUtilisateur
inner join categorieproduit c on c.idcategorieproduit = produit.idcategorieproduit;


-- Details comptes a recharger
create or replace view vuedetailrechargementNonValides as
    select r.idrechargementcompte,r.montant,r.dateheurechargement,u.idutilisateur,u.nom,u.prenom,u.email,u.dateinscription from rechargementcompte r join utilisateur u on u.idutilisateur = r.idutilisateur where r.validation = 0;

create or replace  view detail_enchere as
select e.idenchere,e.prixminimumvente,e.description as descriptionEnchere,u.idutilisateur,u.nom,u.prenom,p.description,p.idcategorieproduit,p.photo,p.nomproduit,e.dateheureenchere,e.dateheureenchere + e.dureeenchere * INTERVAL '1 minute' as dateFin
,
       CASE
           WHEN e.dateheureenchere + e.dureeenchere * INTERVAL '1 minute' > NOW() THEN 'en cours'
           ELSE 'fini'
           END as etatEnchere
from enchere e join utilisateur u on e.idutilisateur = u.idutilisateur join produit p on p.idproduit = e.idproduit;

-- sous vues pour voir l'actuel compte des gens
create or replace view surenchereDetails as
select s.idsurenchere as idsurenchere, s.idenchere ,s.idutilisateur as idsurencherisseur , s.montant_offre , s.dateheuremise , de.prixminimumvente,de.descriptionEnchere , de.nom , de.prenom ,de.idutilisateur  , de.description ,de.idcategorieproduit , de.nomproduit,de.dateheureenchere ,de.dateFin , de.etatEnchere
from surenchere s
    join detail_enchere de
        on s.idenchere = de.idenchere;


-- Toutes les encheres que l'user a gagné
create or replace view vueOffreGagneUser as
SELECT   MAX(s.montant_offre) as montant_offre_max, idsurencherisseur , dateFin , dateheuremise , idenchere
FROM surenchereDetails s
GROUP BY  s.idenchere,s.idsurencherisseur , dateFin , dateheuremise , idenchere
ORDER BY montant_offre_max desc


create or replace view argentSortant as
WITH max_surenchere AS (
SELECT idenchere, MAX(montant_offre) as montant_offre_max
FROM surenchereDetails
GROUP BY idenchere
)
SELECT s.montant_offre as montant_offre_max, s.idsurencherisseur, s.dateFin, s.dateheuremise, s.idenchere
FROM surenchereDetails s
         JOIN max_surenchere m on s.idenchere = m.idenchere
WHERE s.montant_offre = m.montant_offre_max
ORDER BY montant_offre_max DESC


select * from argentSortant;

create or replace view soldeUser;

select * from rechargementcompte where validation = 1;

-- Mbola tsy vita
select sum(montant), * from rechargementcompte where validation=1 ,


-- Nombre d'enchere par categorie par mois

-- 1
Create or replace view nm_enchere_categorie as
select c.idCategorieProduit,coalesce(count(e.*),0) as nombre_enchere,c.categorie,to_char(e.DateHeureEnchere,'Month') as mois from enchere e join produit p using(idproduit) join categorieproduit c using(idcategorieproduit) group by c.idCategorieProduit,c.categorie,mois;

-- Nombre d'enchere par utilisateur mois par annee
-- 2
Create or replace view nm_enchere_utilisateur as
select u.idutilisateur,concat(u.nom ,' '||u.prenom) as nom_prenom,coalesce(count(e.*),0) as nombre_enchere,to_char(e.DateHeureEnchere,'Month') as mois,extract(year from e.DateHeureEnchere) as annee from enchere e join utilisateur u using(idutilisateur) group by  u.idutilisateur,mois,annee;

-- Les  3 categories les plus prisees
-- 3
Create or replace view categorie_prisees as
select c.idcategorieproduit,coalesce(count(e.*),0) as nombre_enchere,c.categorie from enchere e join produit p using(idproduit) join categorieproduit c using(idcategorieproduit) group by c.categorie,c.idCategorieProduit order by nombre_enchere DESC limit 3;

-- Les clients les plus actifs 
-- 4
Create or replace view client_actif as
select u.idutilisateur,coalesce((select count(*) from enchere where idutilisateur=u.idutilisateur),0) as nombre_enchere,coalesce((select count(*) from surenchere  where idutilisateur=u.idutilisateur),0)as nombre_mise,coalesce((select max(montant_offre) from surenchere where idutilisateur=u.idutilisateur),0) as mise_lapluselevee,(select concat(u.nom ,' '||u.prenom) from utilisateur where idutilisateur=u.idutilisateur) as nom_prenom from utilisateur u order by nombre_enchere,nombre_mise,mise_lapluselevee desc limit 3;


-- 5 solde d'un client (Gain en rechargement -depense en encheres)
Create or replace view solde_utilisateur as
select  
coalesce((select sum(montant) from rechargementcompte where idutilisateur=u.idutilisateur and validation=1)-(select sum(montant_offre) from surenchere where idutilisateur=u.idutilisateur),0)
as solde_actuelle,
u.idutilisateur 
from utilisateur u;

-- Vue pour le trigger des notifications.
-- select * from detail_enchere;

-- select * from detail_enchere where idenchere not in (select idenchere from notification);


-- Compte actuel d'un client

-- Total
create or replace  view deposit as
select idutilisateur,sum(montant) from rechargementcompte where idutilisateur = 1 and validation = 1 group by idutilisateur;

-- Maximum de chaque enchere
create or replace view max_auction as
select max(montant_offre) as gagnant,idenchere,idutilisateur from surenchere group by idenchere,idutilisateur;

create or replace view winnedAuction as
    select sum(gagnant) as depense, idutilisateur from max_auction group by idutilisateur;

select * from winnedAuction;

drop view compteActuel;
create or replace view compteActuel as
select ROW_NUMBER() OVER (ORDER BY d.idutilisateur) as fakeid
     , d.idutilisateur ,(d.sum - depense )as compte   from deposit d join winnedAuction w on d.idutilisateur= w.idutilisateur ;

select * from compteActuel;

