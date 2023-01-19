<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
    <link rel="stylesheet" href="public/graindashboard/css/graindashboard.css">
    <title>Login administrateur</title>
</head>
<body class="">
<main class="main">
    <div class="content">
        <div class="container-fluid pb-5">
            <div class="row justify-content-md-center">
                <div class="card-wrapper col-12 col-md-4 mt-5">
                    <div class="brand text-center mb-3">
                        <h3>Bienvenue</h3>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Login</h4>
                            <form method="POST" action="/login" >
                                <div class="form-group">
                                    <label for="email">E-Mail Address</label>
                                    <input id="email" type="email" class="form-control" name="email" value="${email}" required
                                           autofocus="">
                                </div>
                                <div class="form-group">
                                    <label for="password">Password </label>
                                    <input id="password" type="password" class="form-control" name="password" value="${mdp}" required
                                           required=""></div>
                                <div class="form-group no-margin">
                                    <input class="btn btn-primary" type="submit" value="Se connecter" />
                                </div>
                                <div class="form-group d-md-flex">
                                    <%
                                        if(request.getParameter("error")!=null){ %>
                                    <p style="color:red;">Connexion échouée, veuillez réessayer</p>
                                    <% } %>
                                </div>
                            </form>
                        </div>
                    </div>
                    <footer class="footer mt-3">
                        <div class="container-fluid">
                            <div class="footer-content text-center small">
                                <span class="text-muted">Dina ft Eloic , projet 2023</span>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="public/graindashboard/js/graindashboard.js"></script>
<script src="public/graindashboard/js/graindashboard.vendor.js"></script>
</body>
</html>
