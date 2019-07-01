$(function(){
    $('#formCadastro').submit(function(){
        console.log('submetendo no seu cu');
        var dados = $('#formCadastro').serialize();
        console.log(dados);
        $.post('/fazerCadastroProfessor',dados)
            .done(function (){
                    alert('foi')
            })
            .fail(function (xhr, status, error) {
                alert('>>'+error);
            })
        return false;
    });
});