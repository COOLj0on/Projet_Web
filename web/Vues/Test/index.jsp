<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>
<div class="row">
    <div class="col-md-12">
        <table class="table-striped">
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
        <a href="#" class="btn btn-default">Créer un test</a>
    </div>
</div>

<jsp:include page="../parts/footer.jsp"/>