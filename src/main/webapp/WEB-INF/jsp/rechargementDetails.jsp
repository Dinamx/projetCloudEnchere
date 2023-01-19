<%@ page import="java.util.List" %>
<%@ page import="mix.projetcloudenchere.views.Vuedetailrechargementnonvalide" %>
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
                <a class="side-nav-menu-link media align-items-center" href="/listeRechargement" target="_blank">
                        <span class="side-nav-menu-icon d-flex mr-3">
                            <i class="gd-file"></i>
                        </span>
                    <span class="side-nav-fadeout-on-closed media-body">Voir les payements a valider</span>
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
