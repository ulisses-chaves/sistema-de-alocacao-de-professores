function atualizarAulas(ev){
    ev.preventDefault();
    let valor = $('#' + ev.target.id).attr('data-area');
    console.log(valor)
    var dados = {area: valor};
    $.get('/atualizarAulas',dados)
    .done(function (fragment){
        $('#aulinhas').replaceWith(fragment);
    });
}