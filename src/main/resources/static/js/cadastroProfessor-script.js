$(function(){
    $('#formCadastro').submit(function(){
        var dados = $('#formCadastro').serialize();
<<<<<<< HEAD
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
=======
        console.log(dados);
        $.post('/variavel/professores',dados)
            .done(function (){
                    alert('foi')
            })
            .fail(function (xhr, status, error) {
                alert('>>'+error);
            })
>>>>>>> 0ba513ef651d88c5aa2e356b202402477ccb139a
        return false;
    });
});