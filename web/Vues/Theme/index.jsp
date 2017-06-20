<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>
<div class="row">
    <div class="col-md-12">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Libelle</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="theme" items="${themes}">
                <tr>
                    <td>${theme.idTheme}</td>
                    <td>${theme.libelle}</td>
                    <td>
                        <div class="btn-group btn-group-sm" role="group" aria-label="">
                            <a href="${pageContext.request.contextPath}/Question?theme=${theme.idTheme}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-list" aria-hidden="true"></span>Questions</a>
                            <a href="${pageContext.request.contextPath}/Theme?action=edit&id=${theme.idTheme}" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>Modifier</a>
                            <a href="${pageContext.request.contextPath}/Theme?action=delete&id=${theme.idTheme}" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Supprimer</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="../parts/footer.jsp"/>
