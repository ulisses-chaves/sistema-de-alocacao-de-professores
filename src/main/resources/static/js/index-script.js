var naoLogado = true;
var result = "";
$(function () {
    $('#formLogin').submit(function () {
       
            var dados = $(this).serialize();
            if(naoLogado){
                $.ajax({
                    type: 'POST',
                    url: 'fazerLogin',
                    data: dados,
                    success: function (rs) {
                        naoLogado=false;
                        console.log(rs);
                        result = rs;
                        document.formLogin.submit();
                    },
                    error: function (xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });            
                return false;
            }
            else{
                $.ajax({
                    type: 'POST',
                    url: 'logar',
                    data: result,
                    success: function () {
                    },
                    error: function (xhr, status, error) {
                        alert(xhr.responseText);
                    }
                });
            }
    });
});
