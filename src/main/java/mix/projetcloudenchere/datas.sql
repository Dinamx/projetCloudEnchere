insert into categorieproduit (idcategorieproduit, categorie)
values (default ,'Verrerie'),
 (default ,'Medieval'),
 (default ,'Medecine');



INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('John', 'Wick', 'user1@example.com', 'user1');
INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('Jane', 'Smith', 'jane@example.com', 'password456');
INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('Mike', 'Johnson', 'mike@example.com', 'password123');
INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('Emma', 'Williams', 'emma@example.com', 'password789');
INSERT INTO Utilisateur (nom, prenom, email, mdp) VALUES ('Daniel', 'Jones', 'daniel@example.com', 'password000');


INSERT INTO rechargementcompte (idUtilisateur, montant) VALUES (1, 50.00);
INSERT INTO rechargementcompte (idUtilisateur, montant) VALUES (2, 100.00);
INSERT INTO rechargementcompte (idUtilisateur, montant) VALUES (3, 25.00);
INSERT INTO rechargementcompte (idUtilisateur, montant) VALUES (4, 10.00);
INSERT INTO rechargementcompte (idUtilisateur, montant) VALUES (5, 5.00);



INSERT INTO CategorieProduit (categorie) VALUES ('Electronique');
INSERT INTO CategorieProduit (categorie) VALUES ('Vêtements');
INSERT INTO CategorieProduit (categorie) VALUES ('Outils');
INSERT INTO CategorieProduit (categorie) VALUES ('Livres');
INSERT INTO CategorieProduit (categorie) VALUES ('Meubles');




INSERT INTO Produit (idUtilisateur, nomProduit, description, photo, idCategorieProduit) VALUES (1, 'Téléviseur 4K', 'Téléviseur 4K avec une résolution incroyable', '', 1);
INSERT INTO Produit (idUtilisateur, nomProduit, description, photo, idCategorieProduit) VALUES (2, 'Robot de cuisine', 'Robot de cuisine multifonctionnel avec un grand bol', '', 2);
INSERT INTO Produit (idUtilisateur, nomProduit, description, photo, idCategorieProduit) VALUES (3, 'Clé à choc électrique', 'Clé à choc électrique professionnelle avec une grande puissance', '', 3);
INSERT INTO Produit (idUtilisateur, nomProduit, description, photo, idCategorieProduit) VALUES (4, 'Roman de science-fiction', 'Roman de science-fiction captivant avec une histoire intrigante', '', 4);
INSERT INTO Produit (idUtilisateur, nomProduit, description, photo, idCategorieProduit) VALUES (5, 'Canapé en cuir', 'Canapé en cuir confortable et élégant', '', 5);



insert into notification values (default , 1, 1 , default , false);
