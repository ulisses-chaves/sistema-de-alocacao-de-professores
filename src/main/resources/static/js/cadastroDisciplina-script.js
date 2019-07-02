$(function(){
    $('#formularioDisciplina').submit(function(){
        var dados = $('#formularioDisciplina').serialize();
        $.post('/fazerCadastroDisciplina',dados)
            .done(function (data, textStatus, jqXHR) {
                window.history.back();
            })
            .fail(function (xhr, status, error) {
                alert(xhr.responseText);
            })
        
        return false;
    });
});

