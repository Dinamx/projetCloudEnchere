
create sequence sqtokenadmin;
create sequence sqtokenuser;

create table Utilisateur(
idUtilisateur serial primary key,
nom varchar(20),
prenom varchar(20),
email varchar(20),
mdp varchar(20),
DateInscription date default CURRENT_DATE,
compte float default 0
);

INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('John', 'Doe', 'john.doe@example.com', 'password123');
INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('Jane', 'Smith', 'jane@example.com', 'password456');


create table Admin(
idAdmin serial primary key,    
email varchar(20),
mdp varchar(20)
);

INSERT INTO Admin (email, mdp) VALUES ('admin@example.com', 'adminpassword');


create table RechargementCompte(
idRechargementCompte serial primary key,    
idUtilisateur int references Utilisateur(idUtilisateur),
montant float,
DateHeureRechargement TIMESTAMP default CURRENT_TIMESTAMP ,
estValider int default 0
);

insert into RechargementCompte(idUtilisateur,montant) values (1,300) , (1,400) ;

create table CategorieProduit(
idCategorieProduit serial primary key,
categorie varchar(100)
);

create table Produit(
idProduit serial primary key,
nomProduit varchar(50),
description text,
prix float,
numero_serie varchar(30),
DateSortie date,
Etat int,
Provenance varchar(10),
photo text default 'vide.png',
idCategorieProduit int REFERENCES CategorieProduit(idCategorieProduit)
);



create table Enchere(
idEnchere serial primary key,
idUtilisateur int references Utilisateur(idUtilisateur),
description text,
prixMinimumVente float,
durreEnchere int,
DateHeureEnchere TIMESTAMP default CURRENT_TIMESTAMP,
status int default 0
);

INSERT INTO Enchere (idUtilisateur, description, prixMinimumVente,durreEnchere) 
VALUES (1, 'Enchere pour un iPhone', 700,30);
INSERT INTO Enchere (idUtilisateur, description, prixMinimumVente,durreEnchere)  
VALUES (2, 'Enchere pour une chemise',300,40);



create table Produit_Enchere(
idEnchere int references Enchere(idEnchere),
idProduit int references Produit(idProduit)
);

INSERT INTO Produit_Enchere (idEnchere, idProduit) VALUES (1, 1);
INSERT INTO Produit_Enchere (idEnchere, idProduit) VALUES (2, 4);
INSERT INTO Produit_Enchere (idEnchere, idProduit) VALUES (2, 5);



create table HistoriqueOffre(
idHistoriqueOffre serial primary key,
idEnchere int references Enchere(idEnchere),
idUtilisateur int references Utilisateur(idUtilisateur),
durreEnchere int,
montant_offre float,
DateHeureMise TIMESTAMP default CURRENT_TIMESTAMP
);

INSERT INTO HistoriqueOffre (idEnchere, idUtilisateur, montant_offre) VALUES (1, 1, 750);
INSERT INTO HistoriqueOffre (idEnchere, idUtilisateur, montant_offre) VALUES (1, 2, 800);
INSERT INTO HistoriqueOffre (idEnchere, idUtilisateur, montant_offre) VALUES (2, 2,600);
INSERT INTO HistoriqueOffre (idEnchere, idUtilisateur, montant_offre) VALUES (2, 1,900);


create table ResultatEnchere(
idResultatEnchere serial primary key,
idEnchere int references Enchere(idEnchere),
idUtilisateur int references Utilisateur(idUtilisateur),
prix_gagnant float,
DateHeureGagnat TIMESTAMP default CURRENT_TIMESTAMP
);

INSERT INTO ResultatEnchere (idEnchere, idUtilisateur, prix_gagnant) VALUES (1, 1, 800);
INSERT INTO ResultatEnchere (idEnchere, idUtilisateur, prix_gagnant) VALUES (2, 2, 40);


create table PourcentagePrelevee(
id integer primary key,
pourcentage float,
date TIMESTAMP default CURRENT_TIMESTAMP
);


create table PrelevementEnchere(
idPrelevement serial primary key,
idEnchere int references Enchere(idEnchere),
montant float,
DatePrelevement DATE default CURRENT_DATE
);


--- chiffre d'affaire par annee , mois ----
create or replace view chiffreAffaireMoisAnnee as
WITH months(month, year) AS (SELECT generate_series(1, 12), extract(year from current_date))SELECT months.month, months.year, coalesce(SUM(pe.montant),0) as montant FROM months LEFT JOIN PrelevementEnchere pe ON extract(month from pe.DatePrelevement) = months.month AND extract(year from pe.DatePrelevement) = months.year GROUP BY months.month, months.year;


--Chiffre d'affaire de l'application----
select sum(montant) from PrelevementEnchere; 


create table tokenAdmin(
idtokenadmin varchar(10) primary key not null default 'token'||nextval('sqtokenadmin'),
idadmin int references Admin(idAdmin),
token varchar(100),
datecreation date,
dateexpiration date,
role varchar(10)
);


create table tokenUser(
idtokenuser varchar(10) primary key not null default 'token'||nextval('sqtokenuser'),
idUtilisateur int references Utilisateur(idUtilisateur),    
token varchar(100),
datecreation date,
dateexpiration date,
role varchar(10)
);


--statistiques-----

-- view 1 : nombre de membres par jour , mois , annee



select count(idUtilisateur) as nombre , extract(year from DateInscription) as annee , extract(month from DateInscription) as mois , to_char(DateInscription,'Mon') from Utilisateur group by extract(year from DateInscription) , extract(month from DateInscription),to_char(DateInscription,'Mon');



-- view 2 : nombre total enchere par jour , mois , annee


select count(idEnchere) as nombre , extract(year from DateHeureEnchere) as annee , extract(month from DateHeureEnchere) as mois , to_char(DateHeureEnchere,'Mon') from enchere group by extract(year from DateHeureEnchere) , extract(month from DateHeureEnchere),to_char(DateHeureEnchere,'Mon');


-- view 3 : nombre de catégorie  produits vendus par catégories

create or replace view categorieProduitVendu as  
WITH all_categories AS (SELECT idCategorieProduit FROM CategorieProduit)
SELECT cp2.idCategorieProduit, cp2.categorie , COUNT(re.idEnchere) as total_produit_vendu
FROM all_categories cp
LEFT JOIN Produit p 
using(idCategorieProduit)
LEFT JOIN Produit_Enchere pe 
using(idProduit)
LEFT JOIN Enchere e 
using(idEnchere)
LEFT JOIN ResultatEnchere re 
ON re.idEnchere = e.idEnchere AND re.idEnchere = pe.idEnchere
LEFT JOIN CategorieProduit cp2
ON cp2.idCategorieProduit = cp.idCategorieProduit
GROUP BY cp2.idCategorieProduit,cp2.categorie order by COUNT(re.idEnchere) desc;



-- view 6 : nombre de vente  des produits par client


create or replace view StatClient as
WITH all_utilisateurs AS ( SELECT idUtilisateur FROM utilisateur)
SELECT cp2.nom ,cp2.prenom , cp2.idUtilisateur , COUNT(e.idUtilisateur) as nombre_produit_vendu
FROM all_utilisateurs cp
LEFT JOIN Enchere e 
using(idUtilisateur)
LEFT JOIN utilisateur cp2
ON cp2.idUtilisateur = cp.idUtilisateur
GROUP BY cp2.idUtilisateur order by COUNT(e.idUtilisateur) desc;




-- Annee | Mois | jour | nombre de membres |nombre total enchere | nombre de lots qui ont été vendus | montant total des ventes réalisées



------


-----view-----

create or replace view ProduitCategorie as
select p.idProduit , p.nomProduit , p.description , p.prix , p.numero_serie , p.DateSortie , p.Etat , p.Provenance , p.photo , c.idCategorieProduit , c.categorie  from Produit p inner join CategorieProduit c using(idCategorieProduit);



create or replace view v_total_membre as
select count(idUtilisateur) as nombre , extract(year from DateInscription) as annee , extract(month from DateInscription) as mois, extract(day from DateInscription) as jour from Utilisateur group by
extract(year from DateInscription) , extract(month from DateInscription) , extract(day from DateInscription)










