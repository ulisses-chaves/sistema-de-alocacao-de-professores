function atualizarAulas(){
    var dados = {area: 1};
    $.get('/atualizarAulas',dados)
    .done(function (fragment){
        $('#aulinhas').replaceWith(fragment);
    });
}