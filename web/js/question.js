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