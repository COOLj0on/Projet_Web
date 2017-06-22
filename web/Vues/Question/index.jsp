<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>
<script src="js/question.js"></script>
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
    <br>
    <div class="col-md-12 text-center">
        <button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-question">Créer une question</button>
    </div>
</div>
<div class="modal fade bs-question" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Créer une question</h4>
            </div>
            <div class="modal-body">
                <form action="" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <div class="col-lg-12">
                            <div id="summernote"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="file" name="img" class="file">
                        <div class="input-group col-xs-12">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                            <input type="text" class="form-control input-lg" disabled placeholder="Télécharger une image">
                            <span class="input-group-btn">
                            <button class="browse btn btn-primary input-lg" type="button"><i class="glyphicon glyphicon-search"></i> Rechercher</button>
                        </span>
                        </div>
                    </div>
                    <div class="alert alert-dismissible alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        Cochez la checkbox à gauche de la réponse pour indiquer si elle est correcte.
                    </div>
                    <br>
                    <div id="reponse-container">
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon">
                                    <input type="checkbox"/>
                                </span>
                                <input type="text" class="form-control">
                                 <span class="input-group-btn">
                                    <button class="btn btn-default" onclick="addQuestionLine();" type="button"><span class="glyphicon glyphicon-plus-sign"></span></button>
                                    <button class="btn btn-danger" onclick="deleteQuestionLine(this);" type="button"><span class="glyphicon glyphicon-trash"></span></button>
                                 </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-12">
                            <input type="text" class="form-control" id="theme" placeholder="Sélectionnez un thème">
                            <input type="hidden" class="form-control" id="themeId" name="theme">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-lg-6">
                            <br>
                            <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Créer</button>
                        </div>
                        <div class="col-lg-6 text-right">
                            <br>
                            <button type="reset" class="btn btn-danger"><span class="glyphicon glyphicon-warning-sign"></span> Annuler</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            height: 150
        });
        $(document).on('click', '.browse', function(){
            var file = $(this).parent().parent().parent().find('.file');
            file.trigger('click');
        });
        $(document).on('change', '.file', function(){
            $(this).parent().find('.form-control').val($(this).val().replace(/C:\\fakepath\\/i, ''));
        });
    });

</script>
<jsp:include page="../parts/footer.jsp"/>
