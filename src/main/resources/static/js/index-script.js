var naoLogado = true;
$(function () {
    $('#formLogin').submit(function () {
        if(naoLogado){
            var dados = $(this).serialize();
            $.ajax({
                type: 'POST',
                url: '/logar',
                data: dados,
                success: function (result) {
                    naoLogado=false;
                    document.formLogin.submit();
                },
                error: function (xhr, status, error) {
                    alert('ERROR>>' + xhr.responseText);
                }
            });

            return false;
        }
    });
});
