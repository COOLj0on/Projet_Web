<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>
<div class="row">
    <div class="col-md-12">
        <c:if test="${error != null}">
            <span class="text-danger">${error}</span>
        </c:if>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Enonce</th>
                <th>Image</th>
                <th>Theme</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="question" items="${questions}">
                <tr>
                    <td>${question.idQuestion}</td>
                    <td>${question.enonce}</td>
                    <td>
                        <div class="col-xs-6 col-md-3">
                            <a href="#" class="thumbnail">
                                <img src="http://localhost:8080/data/img/${question.image}.jpg" alt="">
                            </a>
                        </div>
                    </td>
                    <td>${question.theme.libelle}</td>
                    <td>
                        <div class="btn-group btn-group-sm" role="group" aria-label="">
                            <a href="${pageContext.request.contextPath}/Question?action=edit&id=${question.idQuestion}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-list" aria-hidden="true"></span>Modifier</a>
                            <a href="${pageContext.request.contextPath}/Question?action=delete&id=${question.idQuestion}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Supprimer</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../parts/footer.jsp"/>
