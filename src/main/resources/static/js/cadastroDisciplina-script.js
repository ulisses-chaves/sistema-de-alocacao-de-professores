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
        return false;
    });
});

