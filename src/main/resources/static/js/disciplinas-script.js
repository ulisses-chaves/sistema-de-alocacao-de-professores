var y=0;
$(function () {
    $.fn.troca = function (other) {
        if($(other).attr('class') == 'disciplina')
            other = $(other).parent();
        if($(other).attr('class') == 'espaco-disciplina'){
            console.log("TROCA");
            console.log("this:" + $(this).attr('id'));
            console.log("outra:" + $(other).attr('id'));

            var a = $(this).children();
            $(this).children().remove();

            var b = $(other).children();
            $(other).children().remove();

            $(this).append(b);
            $(other).append(a);
        }
    }
    $('#form-troca').submit(function () {
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
    });
    $(document).ready(function (){
        $('#venha').children().each(function (){
            var x=0;
            $(this).children().each(function () {
                $(this).attr('id','x'+ x++ + 'y' +y);
            })
            $(this).attr('id','div' + y++);
        });
    });
});
var origin = "";

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    origin = $('#' + ev.target.id).parent().attr('id');
    console.log("origin:" + origin);

}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    console.log('target:' + ev.target.id);
    if (origin != undefined && origin !== ev.target.id) {
        console.log('hm..');
        $('#' + origin).troca('#' + ev.target.id);
    }
    else{
        ev.target.appendChild(document.getElementById(data));
        console.log('a');
    }
}