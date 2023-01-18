<%@ page import="java.util.List" %>
<%@ page import="mix.projetcloudenchere.views.Vuedetailrechargementnonvalide" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    List<Vuedetailrechargementnonvalide> liste = (List<Vuedetailrechargementnonvalide>) request.getAttribute("nonvalide");
%>
<html>
<head>
    <title>Details des rechargements </title>
</head>
<body>

<div>
    <h3> Liste des rechargements non valides</h3>
    <table>
        <tr>
            <td>Date</td>
            <td>Name</td>
            <td>First Name</td>
            <td>Montant</td>
            <td>Sign up on</td>
            <td>Validate</td>
        </tr>
        <% for (Vuedetailrechargementnonvalide unit : liste) {%>
        <tr>
            <th><%= unit.getDateheurechargement() %></th>
            <th><%= unit.getNom() %></th>
            <th><%= unit.getPrenom() %></th>
            <th><%= unit.getMontant() %></th>
            <th><%= unit.getDateinscription() %></th>
            <th><a href="/listeRechargement/<%= unit.getIdrechargementcompte()%>">Valider</a></th>
        </tr>
        <% } %>
    </table>
</div>

<p>Recharger le compte de quelqu'un</p>



</body>
</html>
