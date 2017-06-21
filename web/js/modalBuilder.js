/**
 * Created by jdiaz2016 on 21/06/2017.
 */
function getInput(name,label,type, placeholder, data){
    var output =$('<div class="form-group">')
            .append($('<label for="'+name+'" class="col-lg-3 control-label">').text(label))
            .append($('<div class="col-lg-9">')
            .append($('<input value="'+data+'" type="text" class="form-control" name="'+name+'" id="'+name+'" placeholder="'+placeholder+'">')));
    return output;
}

function buildForm(){
    var output = $('<form method="" action="">');
    return output;
}