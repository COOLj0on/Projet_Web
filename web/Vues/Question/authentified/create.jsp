<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../parts/header.jsp"/>
<jsp:include page="../../parts/menu.jsp"/>
<script src="js/question.js"></script>

<div class="row">
    <div class="col-md-offset-3 col-md-6">
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
</div>
<script>
    $(document).ready(function() {
        $('#summernote').summernote({
            height: 300
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
<jsp:include page="../../parts/footer.jsp"/>
