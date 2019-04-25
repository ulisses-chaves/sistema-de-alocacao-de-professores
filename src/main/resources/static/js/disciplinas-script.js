var slots="";
$(function () {
    $.fn.troca = function (other) {
        if($(other).attr('class') == 'disciplina')
            other = $(other).parent();
        if($(other).attr('class') == 'espaco-disciplina'){
            var a = $(this).children().attr('data-slot');
            var b = $(other).children().attr('data-slot');
            var dados={n1:a,n2:b};
            console.log('trocando');
            $.post('/alterarSlots',dados)
             .done(function(){
                 console.log('enviado');
                $.get('/atualizarSlots',function(fragment){
                    console.log('recebendo');
                    $('#disciplinas').replaceWith(fragment);
                    console.log('recebido');
                });
            });
            console.log('feito');
        }
    };
    $('.dsc').dblclick(function() {
        slots = $(this).data('slot');
        $('#exampleModal').modal('show');
    });
    $('#exampleModal').on('show.bs.modal', function (event) {
        console.log('aaaaa');

        // Se necessário, você pode iniciar uma requisição AJAX aqui e, então, fazer a atualização em um callback.
        // Atualiza o conteúdo do modal. Nós vamos usar jQuery, aqui. No entanto, você poderia usar uma biblioteca de data binding ou outros métodos.
        var modal = $(this)
        modal.find('.modal-title').text('informações da disciplina');
        modal.find('.modal-body #message-text').val('slot:' + slots)
    })
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

