<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../parts/header.jsp"/>
<jsp:include page="../parts/menu.jsp"/>

<div class="row">
    <div class="col-md-offset-4 col-md-8">
        <fieldset>
            <legend>Connexion</legend>
            <form action="" method="">
                <div class="form-group">
                    <label for="identifiant" class="col-lg-2 control-label">Identifiant</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" name="identifiant" id="identifiant" placeholder="identifiant">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-lg-2 control-label">Identifiant</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" id="password" name="password" placeholder="mot de passe">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-12">
                        <input type="submit" value="Se connecter">
                    </div>
                </div>
            </form>
        </fieldset>
    </div>
</div>
<jsp:include page="../parts/footer.jsp"/>
