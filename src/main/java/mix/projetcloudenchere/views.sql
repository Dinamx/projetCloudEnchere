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

