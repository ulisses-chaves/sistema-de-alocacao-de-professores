
$(function(){
    $('#formularioDisciplina').submit(function(){
        var dados = $('#formularioDisciplina').serialize();
        $.post('/variavel/disciplinas',dados)
            .done(function (data, textStatus, jqXHR) {
                alert('foi');
            })
            .fail(function (xhr, status, error) {
                alert(xhr.responseText);
            })
        
        return false;
    });
});

