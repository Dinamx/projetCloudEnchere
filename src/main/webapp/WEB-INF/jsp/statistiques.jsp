<%@ page import="java.util.List" %>
<%@ page import="mix.projetcloudenchere.model.Categorieproduit" %>
<%@ page import="mix.projetcloudenchere.views.ClientActif" %>
<%@ page import="mix.projetcloudenchere.views.NmCategorie" %>
<%@ page import="mix.projetcloudenchere.views.NmEnchereCategorie" %>
<%@ page import="mix.projetcloudenchere.views.CategoriePrisee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%


    List<ClientActif> clientactif = (List<ClientActif>) request.getAttribute("client_actif");
    List<NmCategorie> nmCategories = (List<NmCategorie>) request.getAttribute("nm_categorie");
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
                <th>mois</th>
                <th>annee</th>
            </tr>
            <tr>
                    <% for (NmCategorie  e: nmCategories) {%>
            <tr>
                <td><%= e.getNombreEnchere() %></td>
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
        <h3>Les clients les plus actifs </h3>
        <table border="2">
            <tr>
                <th>nombre_enchere</th>
                <th>nombre_mise</th>
                <th>mise_lapluselevee</th>
                <th>nom et prenom</th>
            </tr>
            <% for (ClientActif e : clientactif) {%>
            <tr>
            <td><%= e.getNombreEnchere() %></td>
            <td><%= e.getNombreMise() %></td>
            <td><%= e.getMiseLapluselevee() %></td>
            <td><%= e.getNomPrenom() %></td>

            </tr>
            <% }%>

        </table>
    </div>
</div>

<div>
    <p><button><a href="acceuilAdmin.jsp">Retour</a></button></p>
</div>

</body>

</html>