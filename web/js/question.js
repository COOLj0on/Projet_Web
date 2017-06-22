$(function() {
    $( "#theme" ).autocomplete({
        source: function( request, response ) {
            $.ajax({
                url: "http://localhost:8080/api/Theme",
                dataType: "json",
                success: function( data ) {
                    var re = $.ui.autocomplete.escapeRegex(request.term);
                    var matcher = new RegExp( "^" + re, "i" );
                    response($.grep(data, function(item){
                        return matcher.test(item.libelle)
                    }));
                }
            });
        },
        select: function(event, ui) {
            $('#theme').val(ui.item.libelle);
            $('#theme').val(ui.item.id);

        }
    });
});
/*
 *
 return {
 label: item.libelle,
 value: item.id
 }
 * */