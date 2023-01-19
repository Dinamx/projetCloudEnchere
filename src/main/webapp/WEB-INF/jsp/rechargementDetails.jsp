<%@ page import="java.util.List" %>
<%@ page import="mix.projetcloudenchere.views.Vuedetailrechargementnonvalide" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    List<Vuedetailrechargementnonvalide> liste = (List<Vuedetailrechargementnonvalide>) request.getAttribute("nonvalide");
%>
<html>
<head>
    <title>Rechargement des comptes </title>
    <link rel="stylesheet" href="public/graindashboard/css/graindashboard.css">
</head>
<body class="has-sidebar has-fixed-sidebar-and-header">

<!-- Header -->
<header class="header bg-body">
    <nav class="navbar flex-nowrap p-0">
        <div class="navbar-brand-wrapper d-flex align-items-center col-auto">
        </div>
        <div class="header-content col px-md-3">
            <div class="d-flex align-items-center">
                <!-- Side Nav Toggle -->
                <a class="js-side-nav header-invoker d-flex mr-md-2" href="#" data-close-invoker="#sidebarClose"
                   data-target="#sidebar" data-target-wrapper="body">
                    <i class="gd-align-left"></i>
                </a>
                <!-- End Side Nav Toggle -->
                <!-- User Avatar -->
                <div class="dropdown mx-3 dropdown ml-2">
                    <a id="profileMenuInvoker" class="header-complex-invoker" href="#" aria-controls="profileMenu"
                       aria-haspopup="true" aria-expanded="false" data-unfold-event="click"
                       data-unfold-target="#profileMenu" data-unfold-type="css-animation"
                       data-unfold-duration="300" data-unfold-animation-in="fadeIn"
                       data-unfold-animation-out="fadeOut">
                    </a>
                    <ul id="profileMenu"
                        class="unfold unfold-user unfold-light unfold-top unfold-centered position-absolute pt-2 pb-1 mt-4 unfold-css-animation unfold-hidden fadeOut"
                        aria-labelledby="profileMenuInvoker" style="animation-duration: 300ms;">
                        <li class="unfold-item">
                            <a class="unfold-link d-flex align-items-center text-nowrap" href="#">
                                    <span class="unfold-item-icon mr-3">
                                        <i class="gd-user"></i>
                                    </span> My Profile </a>
                        </li>
                        <li class="unfold-item unfold-item-has-divider">
                            <a class="unfold-link d-flex align-items-center text-nowrap" href="#">
                                    <span class="unfold-item-icon mr-3">
                                        <i class="gd-power-off"></i>
                                    </span> Sign Out </a>
                        </li>
                    </ul>
                </div>
                <!-- End User Avatar -->
            </div>
        </div>
    </nav>
</header>
<!-- End Header -->


<main class="main">
    <!-- Sidebar Nav -->
    <aside id="sidebar"  class="js-custom-scroll side-nav">
        <ul id="sideNav" class="side-nav-menu side-nav-menu-top-level mb-0">
            <!-- Title -->
            <li class="sidebar-heading h6">Que faire?</li>
            <!-- End Title -->
            <!-- Documentation -->
            <li class="side-nav-menu-item">
                <a class="side-nav-menu-link media align-items-center" href="/home" >
                        <span class="side-nav-menu-icon d-flex mr-3">
                            <i class="gd-home"></i>
                        </span>
                    <span class="side-nav-fadeout-on-closed media-body">Acceuil</span>
                </a>
                <a class="side-nav-menu-link media align-items-center" href="/stat" target="_blank">
                        <span class="side-nav-menu-icon d-flex mr-3">
                            <i class="gd-stats-up"></i>
                        </span>
                    <span class="side-nav-fadeout-on-closed media-body">Voir les statistiques</span>
                </a>
            </li>
            <!-- End Documentation -->
        </ul>
    </aside>
    <!-- End Sidebar Nav -->

    <div class="content">
    <div class="py-4 px-3 px-md-4">
        <div class="card mb-3 mb-md-4">
            <div class="card-body">
                <h3>Liste des rechargements a valider</h3>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">Rechargement Compte</li>
                        <li class="breadcrumb-item active" aria-current="page">Liste</li>
                    </ol>
                </nav>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th class="font-weight-semi-bold border-top-0 py-2">Date</th>
                        <th class="font-weight-semi-bold border-top-0 py-2">Name</th>
                        <th class="font-weight-semi-bold border-top-0 py-2">First Name</th>
                        <th class="font-weight-semi-bold border-top-0 py-2">Montant</th>
                        <th class="font-weight-semi-bold border-top-0 py-2">Sign up on</th>
                        <th class="font-weight-semi-bold border-top-0 py-2">Validate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Vuedetailrechargementnonvalide unit : liste) {%>
                    <tr>
                        <td class="py-3"><%= unit.getDateheurechargement() %></td>
                        <td class="py-3"><%= unit.getNom() %></td>
                        <td class="py-3"><%= unit.getPrenom() %></td>
                        <td class="py-3"><%= unit.getMontant() %></td>
                        <td class="py-3"><%= unit.getDateinscription() %></td>
                        <td class="py-3"><a class="btn btn-success" href="/listeRechargement/<%= unit.getIdrechargementcompte()%>">Valider</a></td>
                    </tr>
                    <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </div>
    <!-- Footer -->
    <footer class="small p-3 px-md-4 mt-auto">
        <div class="row justify-content-between">
            <%--                <div class="col-lg text-center text-lg-left mb-3 mb-lg-0">--%>
            <%--                    <ul class="list-dot list-inline mb-0">--%>
            <%--                        <li class="list-dot-item list-dot-item-not list-inline-item mr-lg-2"><a class="link-dark"--%>
            <%--                                                                                                href="#">FAQ</a></li>--%>
            <%--                        <li class="list-dot-item list-inline-item mr-lg-2"><a class="link-dark" href="#">Support</a>--%>
            <%--                        </li>--%>
            <%--                        <li class="list-dot-item list-inline-item mr-lg-2"><a class="link-dark" href="#">Contact--%>
            <%--                            us</a></li>--%>
            <%--                    </ul>--%>
            <%--                </div>--%>
            <div class="col-lg text-center mb-3 mb-lg-0">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item mx-2"><a class="link-muted" href="#"><i
                            class="gd-github"></i></a></li>
                </ul>
            </div>
            <div class="col-lg text-center text-lg-right"> &copy; 2023 Projet Cloud Enchere
            </div>
        </div>
    </footer>
    <!-- End Footer -->
    </div>
</main>


</body>
</html>
