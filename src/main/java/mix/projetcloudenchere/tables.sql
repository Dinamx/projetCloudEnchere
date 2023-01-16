
Create database enchere;
Create role enchere;
Alter role enchere login password 'enchere';
Alter database enchere owner to enchere;
\c enchere enchere
enchere


-- Supprimer toutes les tables
DO $$ DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END $$;

-- 1
create table Utilisateur(
                            idUtilisateur serial primary key,
                            nom varchar(20),
                            prenom varchar(20),
                            email varchar(20),
                            mdp varchar(20),
                            DateInscription date default CURRENT_DATE
);

INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('John', 'Wick', 'user1@example.com', 'user1');
INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('Jane', 'Smith', 'jane@example.com', 'password456');

-- 2
create table Admin(
                      idAdmin serial primary key,
                      email varchar(20),
                      mdp varchar(20)
);
INSERT INTO Admin (email, mdp) VALUES ('admin@gmail.com', 'adminpassword');

-- 3
create table tokenAdmin(
                           idtokenadmin serial primary key ,
                           idadmin int references Admin(idAdmin),
                           token varchar(100),
                           datecreation date,
                           dateexpiration date,
                           role varchar(10)
);

-- 4
create table tokenUser(
                          idtokenuser serial primary key ,
                          idUtilisateur int references Utilisateur(idUtilisateur),
                          token varchar(100),
                          datecreation date,
                          dateexpiration date,
                          role varchar(10)
);

-- 5
create table compte(
                                   idcompte serial primary key,
                                   iduser int references Utilisateur(idUtilisateur),
                                   montant double precision,
                                   DateHeureRechargement TIMESTAMP default CURRENT_TIMESTAMP ,
                                   estValider int default 0
);

-- 6
Create table rechargementcompte(
                                    idRechargementCompte serial primary key not null,
                                    idUtilisateur int not null references utilisateur(idUtilisateur),
                                    montant float not null,
                                    dateheurechargement timestamp default CURRENT_TIMESTAMP,
                                    validation int default 0
);


-- 7
create table CategorieProduit(
                                 idCategorieProduit serial primary key,
                                 categorie varchar(20)
);
-- 8
create table Produit(
                        idProduit serial primary key,
                        idUtilisateur int references Utilisateur(idUtilisateur),
                        nomProduit varchar(50),
                        description text,
                        photo text default '',
                        -- data:image/png;base64,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
                        idCategorieProduit int REFERENCES CategorieProduit(idCategorieProduit)
);
-- 9
Create table Produit_image(
    idProduit int not null references Produit(idProduit),
    image TEXT
);


--  10
create table Enchere(
                        idEnchere serial primary key,
                        idUtilisateur int references Utilisateur(idUtilisateur),
                        idProduit int not null references Produit(idProduit),
                        description text,
                        prixMinimumVente double precision,
                        dureeEnchere int,
                        DateHeureEnchere TIMESTAMP default CURRENT_TIMESTAMP,
                        status int default 0
);



-- 11
create table surenchere(
                                idSurenchere serial primary key,
                                idEnchere int references Enchere(idEnchere),
                                idUtilisateur int references Utilisateur(idUtilisateur),
                                montant_offre float,
                                DateHeureMise TIMESTAMP default CURRENT_TIMESTAMP
);
-- 12
create table PourcentagePrelevee(
                                    id integer primary key,
                                    pourcentage float,
                                    date TIMESTAMP default CURRENT_TIMESTAMP
);

-- 13
Create table PrelevementEnchere(
    idPrelevement serial primary key,
    idEnchere int not null references Enchere(idEnchere),
    montant float not null,
    dateprelevement date default current_date
);



