<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri='http://java.sun.com/jsp/jstl/fmt' %>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<div class="row">
    <div class="col-xs-12">
        <nav class="navbar navbar-inverse navbar-embossed" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
                    <span class="sr-only">Toggle navigation</span>
                </button>
                <a class="navbar-brand" href="#">Flat UI</a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse-01">
                <ul class="nav navbar-nav navbar-left">
                    <li><a href="#fakelink">Menu Item<span class="navbar-unread">1</span></a></li>
                    <li><a href="<c:url value="http://localhost:8080/TPWeb/RouterServlet?page=index"></c:url>">Accueil</a></li>
                    <li><a href="<c:url value="http://localhost:8080/TPWeb/Animateur"></c:url>">Accès animateur</a></li>
                    <li><a href="<c:url value="http://localhost:8080/TPWeb/Stagiaire"></c:url>">Accès stagiaire</a></li>
                    <li><a href="<c:url value="http://localhost:8080/TPWeb/Session"></c:url>">Session</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Formation <b class="caret"></b></a>
                        <span class="dropdown-arrow"></span>
                        <ul class="dropdown-menu">
                            <li><a href="<c:url value="http://localhost:8080/TPWeb/Formation"></c:url>">Formations</a></li>
                            <c:if test="${sessionScope.animateur != null}">
                                <li class="divider"></li>
                                <li><a href="<c:url value="http://localhost:8080/TPWeb/Formation?action=gerer"></c:url>">Gérer les formations</a></li>
                                <li><a href="<c:url value="http://localhost:8080/TPWeb/Formation?action=new"></c:url>">Ajouter une formation</a></li>
                            </c:if>
                        </ul>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" action="" role="search">
                    <div class="form-group">
                        <div class="input-group">
                            <input class="form-control" id="navbarInput-01" type="search" placeholder="Search">
                            <span class="input-group-btn">
                      <button type="submit" class="btn"><span class="fui-search"></span></button>
                    </span>
                        </div>
                    </div>
                </form>
            </div><!-- /.navbar-collapse -->
        </nav>
    </div>
</div>
