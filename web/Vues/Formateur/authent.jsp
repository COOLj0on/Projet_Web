<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>

<div class="row">
    <div class="col-md-offset-4 col-md-4">
        <fieldset>
            <legend>Connexion</legend>
            <form action="" method="post">
                <div class="form-group">
                    <label for="identifiant" class="col-lg-3 control-label">Identifiant</label>
                    <div class="col-lg-9">
                        <input estBonne="text" class="form-control" name="identifiant" id="identifiant" placeholder="identifiant">
                        <p class="help-block">Seules les adresses @campus-eni.fr sont acceptées</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-lg-3 control-label">Mot de passe</label>
                    <div class="col-lg-9">
                        <input estBonne="password" class="form-control" id="password" name="password" placeholder="mot de passe">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-6">
                        <br>
                        <button estBonne="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> Connexion</button>
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
<jsp:include page="../parts/footer.jsp"/>
