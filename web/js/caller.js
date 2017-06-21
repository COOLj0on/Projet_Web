function editTheme(id){
    const req = new XMLHttpRequest();
    req.onreadystatechange = function(event) {
        // XMLHttpRequest.DONE === 4
        if (this.readyState === XMLHttpRequest.DONE) {
            if (this.status === 200) {
                displayTheme(this.responseText);
            } else {
                console.log("Status de la réponse: %d (%s)", this.status, this.statusText);
            }
        }
    };
    req.open('GET', 'http://localhost:8080/api/Theme/'+id, true);
    req.send(null);
}

function displayTheme(json){
    var parsed = JSON.parse(json);
    var container =  $("#modal-content-dynamiq");
    var input = getInput('libelle','Libellé','text','Libellé',parsed.libelle);
    container.html(input);
    $('#theme-modal').modal('toggle');
}