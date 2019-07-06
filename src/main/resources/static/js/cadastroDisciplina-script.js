
$(function(){
    $('#formularioDisciplina').submit(function(){
        var dados = $('#formularioDisciplina').serialize();
<<<<<<< HEAD
        $.post('/variavel/disciplinas',dados)
            .done(function (data, textStatus, jqXHR) {
                alert('foi');
=======
        alert('sexo!!!');
        /*$.post('/fazerCadastroDisciplina',dados)
            .done(function (data, textStatus, jqXHR) {
                alert("foi")
>>>>>>> 51eee38cd00788acbce0292c385f72ed15004a16
            })
            .fail(function (xhr, status, error) {
                alert(xhr.responseText);
            })*/
        
        return false;
    });
});

