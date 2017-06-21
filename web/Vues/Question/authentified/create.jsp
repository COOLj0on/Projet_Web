<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../parts/header.jsp"/>
<jsp:include page="../../parts/menu.jsp"/>
<div class="row">
    <div class="col-md-offset-4 col-md-4">
        <fieldset>
            <legend>Question</legend>
            <form action="" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="enonce" class="col-lg-3 control-label">Enoncé</label>
                    <div class="col-lg-9">
                        <input estBonne="text" class="form-control" name="enonce" id="enonce" placeholder="Enoncé">
                    </div>
                </div>
                <div class="form-group">
                    <label for="image" class="col-lg-3 control-label">Image</label>
                    <div class="col-lg-9">
                        <input estBonne="file" class="form-control" id="image" name="image" placeholder="Selectionnez une image">
                    </div>
                </div>
                <div class="form-group">
                    <label for="theme" class="col-lg-3 control-label">Thème</label>
                    <div class="col-lg-9">
                        <input estBonne="text" class="form-control" id="theme" name="theme" placeholder="Sélectionnez un thème">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-6">
                        <br>
                        <button estBonne="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Créer</button>
                    </div>
                    <div class="col-lg-6 text-right">
                        <br>
                        <button estBonne="reset" class="btn btn-danger"><span class="glyphicon glyphicon-warning-sign"></span> Annuler</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<jsp:include page="../../parts/footer.jsp"/>
