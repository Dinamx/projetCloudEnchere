<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <title>Login administrateur</title>
</head>
<body>

<h1>Login Admin</h1>
<form method="POST" action="/login" class="login-form">
    <div class="form-group">
        <input type="text" class="form-control rounded-left"  name="email" value="${email}" required>
    </div>
    <div class="form-group d-flex">
        <input type="password" class="form-control rounded-left" placeholder="Mot de passe" name="password" value="${mdp}" required>
    </div>
    <div class="form-group">
        <button type="submit" class="form-control btn btn-primary rounded submit px-3">connexion</button>
    </div>
    <div class="form-group d-md-flex">
        <%
            if(request.getParameter("error")!=null){ %>
        <p style="color:red;">Connexion échouée, veuillez réessayer</p>
        <% } %>
    </div>
</form>
</body>
</html>
