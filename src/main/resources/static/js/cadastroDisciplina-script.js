
$(function(){
    $('#formularioDisciplina').submit(function(){
        var dados = $('#formularioDisciplina').serialize();
        alert('sexo!!!');
        /*$.post('/fazerCadastroDisciplina',dados)
            .done(function (data, textStatus, jqXHR) {
                alert("foi")
            })
            .fail(function (xhr, status, error) {
                alert(xhr.responseText);
            })*/
        
        return false;
    });
});

