$(function() {
    $('#theme').autocomplete({
        // This shows the min length of charcters that must be typed before the autocomplete looks for a match.
        minLength: 1,
        source:function( request, response ) {
            $.ajax({
                url: "http://localhost:8080/api/Theme",
                dataType: "json",
                success: function( data ) {
                    var all =  $.map(data, function (value, key) {
                        return {
                            label: value.libelle,
                            value: value.id
                        }
                    });
                    var results = $.ui.autocomplete.filter(all, request.term);
                    response(results);
                }
            });
        },
        focus: function(event, ui) {
            $('#theme').val(ui.item.label);
            return false;
        },
        // Once a value in the drop down list is selected, do the following:
        select: function(event, ui) {
            // place the person.given_name value into the textfield called 'select_origin'...
            $('#theme').val(ui.item.label);
            // and place the person.id into the hidden textfield called 'link_origin_id'.
            $('#themeId').val(ui.item.value);
            return false;
        }
    });
});
function addQuestionLine(){
    var output = $('<div class="form-group">'+
        '<div class="input-group">'+
        '<span class="input-group-addon">'+
        '<input type="checkbox"/>'+
        '</span>'+
        '<input type="text" class="form-control">'+
        '<span class="input-group-btn">'+
        '<button class="btn btn-default" onclick="addQuestionLine();" type="button"><span class="glyphicon glyphicon-plus-sign"></span></button>'+
        '<button class="btn btn-danger" onclick="deleteQuestionLine(this);" type="button"><span class="glyphicon glyphicon-trash"></span></button>'+
        '</span>'+
        '</div>'+
        '</div>');
    $("#reponse-container").append(output);
}

function deleteQuestionLine(event){
    var toRemove = $(event).closest('.form-group');
    toRemove.remove();
}