<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="parts/header.jsp"/>
<jsp:include page="parts/menu.jsp"/>
<div class="row">
    <div class="col-md-12">
        <div class="jumbotron">
            <h1>ENI Portail</h1>
            <p>Vous pouvez désormais effectuer vos tests (ECF, VAE, et tests de recrutement) depuis ce portail. Munissez-vous de
            <br>votre adresse mail @campus-eni.fr pour vous conencter.</p>
            <c:if test = "${sessionScope.formateur == null}">
                <p><button type="button" class="btn btn-default"><span class="glyphicon glyphicon-log-in"></span> Se connecter</button></p>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="parts/footer.jsp"/>