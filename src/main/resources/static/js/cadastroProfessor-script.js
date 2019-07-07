$(function(){
    $('#formCadastro').submit(function(){
        var dados = $('#formCadastro').serialize();
        console.log(dados);
        $.post('/variavel/professores',dados)
            .done(function (){
                    alert('foi')
            })
            .fail(function (xhr, status, error) {
                alert('>>'+error);
            })
        return false;
    });
});