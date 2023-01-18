<%@ page import="java.util.List" %>
<%@ page import="mix.projetcloudenchere.model.Categorieproduit" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%


    List<Categorieproduit> categorieproduits = (List<Categorieproduit>) request.getAttribute("categories");
%>
<html>
<head>
    <title>Login administrateur</title>
</head>
<body>

<h1>Login Admin</h1>

<div>
    <a href="/listeRechargement">Voir les rechargements a valider</a>
</div>
<div>

</div>
<div>
    Inserer une nouvelle Categorie
    <div>
        <form method="post" action="/categories">
            <input name="categorie" type="text" >
            <input type="submit">
        </form>
    </div>

    <div>
        <h3>Liste des categories Existantes</h3>
        <table>
            <tr>
                <th>Categorie</th>
            </tr>
            <% for (Categorieproduit e : categorieproduits) {%>
            <tr>
                <td><%= e.getCategorie() %></td>
            </tr>
            <% }%>
        </table>
    </div>
    <%= categorieproduits.size() + "Taille" %>
</div>


</body>
</html>
