$(function(){
    $('#formCadastro').submit(function(){
        var dados = $('#formCadastro').serialize();
        $.ajax({
            type:'POST',
            url:'fazerCadastroProfessor',
            data:dados,
            success: function (data, textStatus, jqXHR) {
                window.history.back();
            },
            error: function (xhr, status, error) {
                alert('>>'+xhr.responseText);
            }
        });
        return false;
    });
});