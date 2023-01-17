<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login administrateur</title>
</head>
<body>

<h1>Login Admin</h1>

<div>
    Inserer une nouvelle Categorie
    <form action="/categories" method="post">
        <input type="text" name="nomCategorie">
        <input type="submit">
    </form>
    <% if (request.getParameter("produit") != null){ %>
    <div>
        <h3>Liste des Categories deja existants</h3>
        <table>
            <tr>
                <th></th>
            </tr>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>
    <% }%>
</div>

<div>
    <a href="/voirTransactions"></a>
</div>
<div>

</div>



</body>
</html>
