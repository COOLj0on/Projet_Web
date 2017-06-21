<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../parts/header.jsp"/>
<jsp:include page="../../parts/menu.jsp"/>
<div class="row">
    <div class="col-md-offset-4 col-md-4">
        <fieldset>
            <legend>Creation Theme</legend>
            <form action="" method="POST">
                <div class="form-group">
                    <label for="libelle" class="col-lg-3 control-label">Libelle</label>
                    <div class="col-lg-9">
                        <input type="text" class="form-control" id="libelle" name="libelle" placeholder="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-6">
                        <br>
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in"></span> GO</button>
                    </div>
                    <div class="col-lg-6 text-right">
                        <br>
                        <button type="reset" class="btn btn-danger"><span class="glyphicon glyphicon-warning-sign"></span> Annuler</button>
                    </div>
                </div>
            </form>
        </fieldset>
    </div>

<jsp:include page="../../parts/footer.jsp"/>