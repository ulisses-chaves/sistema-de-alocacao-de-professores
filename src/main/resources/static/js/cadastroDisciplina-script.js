<<<<<<< HEAD
$(function(){
    $('#formCadastro').submit(function(){
        var dados = $('#formCadastro').serialize();
        $.ajax({
            type:'POST',
            url:'fazerCadastroDisciplina',
            data:dados,
            success: function (data, textStatus, jqXHR) {
                window.history.back();
            },
            error: function (xhr, status, error) {
                alert(xhr.responseText);
            }
        });
=======

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
        
>>>>>>> 0ba513ef651d88c5aa2e356b202402477ccb139a
        return false;
    });
});

