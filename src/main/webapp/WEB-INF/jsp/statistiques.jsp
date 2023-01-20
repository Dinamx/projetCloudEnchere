<%@ page import="java.util.List" %>
<%@ page import="mix.projetcloudenchere.model.Categorieproduit" %>
<%@ page import="mix.projetcloudenchere.views.ClientActif" %>
<%@ page import="mix.projetcloudenchere.views.NmEnchereCategorie" %>
<%@ page import="mix.projetcloudenchere.views.CategoriePrisee" %>
<%@ page import="mix.projetcloudenchere.views.NmEnchereUtilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%

    List<ClientActif> clientActifs=(List<ClientActif>) request.getAttribute("clien_actif");
    List<NmEnchereUtilisateur> nmCategories = (List<NmEnchereUtilisateur>) request.getAttribute("nm_enchere_utilisateur");
    List<NmEnchereCategorie> nmEnchereCategories = (List<NmEnchereCategorie>) request.getAttribute("nm_enchere_categorie");
    List<CategoriePrisee> categoriePrisees = (List<CategoriePrisee>) request.getAttribute("categorie_prisee");
%>
<html>

<head>
    <title>Tableau statistiques</title>
</head>

<body>

<h1>Tableau statistiques</h1>
<div>

</div>
<div>
    <div>
        <table border="2">
            <tr>
                <h3>Les clients les plus actifs</h3>
                <th>Nom et prenom</th>
                <th>Nombre d'enchere total</th>
                <th>Mise la plus elevee</th>
                <th>Nombre de mise total</th>
            </tr>
            <% for (ClientActif  e: clientActifs) {%>
            <tr>
                <td><%= e.getNomPrenom() %></td>
                <td><%= e.getNombreEnchere() %></td>
                <td><%= e.getMiseLapluselevee() %></td>
                <td><%= e.getNombreMise() %></td>
            </tr>
            <% }%>
            </tr>


        </table>
    </div>

    <div>
        <table border="2">
            <tr>
                <h3>Nombre des encheres par mois</h3>
                <th>nombre_enchere</th>
                <th>mois</th>
                <th>categorie</th>
            </tr>
            <% for (NmEnchereCategorie  e: nmEnchereCategories) {%>
            <tr>
                <td><%= e.getNombreEnchere() %></td>
                <td><%= e.getMois() %></td>
                <td><%= e.getCategorie() %></td>

            </tr>
            <% }%>
            </tr>


        </table>
    </div>
    <div>
        <h3>Nombre des encheres par categorie par mois</h3>
        <table border="2">
            <tr>
                <th>nombre_enchere</th>
                <th>Nom et prenom</th>
                <th>mois</th>
                <th>annee</th>
            </tr>
            <tr>
                    <% for (NmEnchereUtilisateur  e: nmCategories) {%>
            <tr>
                <td><%= e.getNombreEnchere() %></td>
                <td><%= e.getNomPrenom() %></td>
                <td><%= e.getMois() %></td>
                <td><%= e.getAnnee() %></td>

            </tr>
            <% }%>
            </tr>

        </table>
    </div>

    <div>
        <h3>Les 3 categories les plus prisees</h3>
        <table border="2">
            <tr>
                <th>nombre_enchere</th>
                <th>categorie</th>

            </tr>
            <tr>
                    <% for (CategoriePrisee e : categoriePrisees) {%>
            <tr>
                <td><%= e.getNombreEnchere() %></td>
                <td><%= e.getCategorie() %></td>


            </tr>
            <% }%>
            </tr>

        </table>
    </div>
    <div>
    </div>
</div>

<div>
    <p><button><a href="acceuilAdmin.jsp">Retour</a></button></p>
</div>

</body>

</html>