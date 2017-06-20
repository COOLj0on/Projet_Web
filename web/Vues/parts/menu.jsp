<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<div class="row">
    <nav class="navbar navbar-embossed" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="#">Portail ENI</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-01">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="#">Accueil</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">QCM <b class="caret"></b></a>
                    <span class="dropdown-arrow"></span>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="http://localhost:8080/Test"></c:url>">Listes des QCM</a></li>
                        <c:if test="${sessionScope.formateur != null}">
                            <li class="divider"></li>
                            <li><a href="<c:url value="http://localhost:8080/Test?action=gerer"></c:url>">Gérer les QCM</a></li>
                        </c:if>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Thèmes <b class="caret"></b></a>
                    <span class="dropdown-arrow"></span>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/Theme">Listes des thèmes</a></li>
                        <c:if test="${sessionScope.formateur != null}">
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/Theme?action=new">Créer un thème</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
            <c:choose>
                <c:when test = "${sessionScope.formateur == null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<c:url value="http://localhost:8080/Formateur"></c:url>">Se connecter</a></li>
                    </ul>
                </c:when>
                <c:when test = "${sessionScope.formateur != null}">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Bonjour, ${sessionScope.formateur.prenom} <b class="caret"></b></a>
                            <span class="dropdown-arrow"></span>
                            <ul class="dropdown-menu">
                                <li class="divider"></li>
                                <li><a href="<c:url value="http://localhost:8080/Formateur?action=deconnecter"></c:url>"><span class="glyphicon glyphicon-log-out"></span> Se déconnecter</a></li>
                            </ul>
                        </li>
                        <li><a><span class="glyphicon glyphicon-cog"></span></a></li>
                        <li><a><span class="glyphicon glyphicon-envelope"></span><span class="badge">5</span></a></li>
                    </ul>
                </c:when>
            </c:choose>
        </div><!-- /.navbar-collapse -->
    </nav>
</div>
