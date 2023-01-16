
Create database enchere;
Create role enchere;
Alter role enchere login password 'enchere';
Alter database enchere owner to enchere;
\c enchere enchere
enchere

drop table surencherir;
drop table Produit_image;
drop table Produitenenchere;
drop table enchere;
drop table rechargementcompte;
drop table Produit;
drop table categorie;
drop table utilisateur;

-- Supprimer toutes les tables
DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;

-- 1
Create table utilisateur(
    idUtilisateur serial primary key not null,
    nom varchar(20) not null,
    prenom varchar(20) not null,
    email varchar(20) not null,
    mdp varchar(20) not null,
    solde_compte float default 0
);

-- 2
Create table admin(
    idAdmin serial primary key not null,
    nom text not null,
    mdp text not null,
    compte float default 0
);



-- 3
Create table Categorie(
    idCategorie serial primary key not null,
    categorie text not null
);

-- 4
Create table rechargementcompte(
    idUtilisateur int not null references Utilisateur(idUtilisateur),
    montantrecharge float,
    dateheurechargement timestamp default current_timestamp,
    validation int default 0
);

-- 5
Create table Enchere(
    idEnchere serial primary key not null,
    idUtilisateur int  not null references utilisateur(idUtilisateur),
    dureeEnchere double precision default 0 not null,
    description TEXT,
    idCategorie int not null references categorie(idCategorie),
    dateheureenchere timestamp default current_timestamp,
    prixminimalvente float not null

);

-- 6
-- Debiter sur le compte de l'utilisateur
Create table surencherir(
    idSurencherir serial primary key not null,
    idEnchere int references Enchere(idEnchere),
    idUtilisateur int references Utilisateur(idUtilisateur),
    montant float not null,
    dateheuresurenchere timestamp default current_timestamp
);

-- 7
Create table Produit_image(
    idEnchere int not null references enchere(idEnchere),
    image TEXT
);

-- 8
-- Rehefa vita ilay enchere, miala amin'ilay vola hazon'ilay utilisateur avy @ ny prix de vente ilay enchere ny commission an'ilay site  10%
Create table commission(
    idEnchere int not null references Enchere(idEnchere),
    commission float/*Pourcentage*/
);
