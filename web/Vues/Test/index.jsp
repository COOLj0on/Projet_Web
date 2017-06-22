<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Informations sur les tests</h3>
            </div>
            <div class="panel-body">
                Les tests vous sont attribués par un formateur ou un recruteur. Vous pouvez effectuez les tests dans l'ordre que vous souhaitez.<br>
                Veillez à bien vérifier le temps restants et le nombre de questions restantes.<br>
                Bonne chance !
            </div>
        </div>
        <div class="alert alert-dismissible alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>Aide : </strong> Pour lancer un test, seléctionnez en un en double cliquant dessus.
        </div>

        <ul class="nav nav-tabs">
            <li class="active"><a href="#home" data-toggle="tab">ECF</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div class="tab-pane fade active in" id="ecf">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Autre</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!--Ajouter ici le contenu dynamique-->
                    <tr>
                        <td>1</td>
                        <td>JOJO l'abricot</td>
                        <td>Autre truc</td>
                        <td>
                            <div class="btn-group btn-group-sm" role="group" aria-label="">
                                <a href="#" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>Modifier</a>
                                <a href="#" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>Détails</a>
                                <a href="#" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span>Supprimer</a>
                            </div>
                        </td>
                    </tr>
                    <!---->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:if test="${sessionScope.formateur != null}">
        <div class="col-md-12 text-center">
            <a href="#" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> Créer un test</a>
        </div>
    </c:if>
    <div class="col-md-12 text-center">
        <ul class="pagination">
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">&raquo;</a></li>
        </ul>
    </div>
</div>

<jsp:include page="../parts/footer.jsp"/>