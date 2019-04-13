$(function(){
    
        $('#formLogin').submit(function (){
           alert("b");
            $.ajax({
                type: 'POST',
                url: '/api/ajaxrest/index_testes',
                success: function (result){
                    $('#resposta').html(result);
                },
                error: function (xhr, status, error) {
                    alert(xhr.responseText);
                }
            }); 
        });
    
});
