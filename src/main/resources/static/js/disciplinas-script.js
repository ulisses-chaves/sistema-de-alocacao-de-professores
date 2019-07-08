var origin = "";
var info = new Array(8);
var idCurso;
var nPeriodo;
$(function () {

    $.fn.troca = function (other) {
        if ($(other).attr('class') == 'disciplina')
            other = $(other).parent();
        if ($(other).attr('class').includes('text'))
            other = $(other).parent().parent();
        if ($(other).attr('class') == 'espaco-disciplina') {
            var a = $(this).children().attr('data-numero');
            var b = $(other).children().attr('data-numero');
            var dados={
                idCurso:idCurso,
                nPeriodo:nPeriodo,
                n1:a,
                n2:b
            };
            var parametros = {
                idCurso:idCurso,
                nPeriodo:nPeriodo
            };
            $.post('/alterarSlots',dados)
                    .done(function () {
                        $.get('/atualizarSlots',parametros)
                            .done(function (fragment) {
                            $('#div-disciplinas').replaceWith(fragment);
                        }).fail(function (erros) {
                            alert('troca get ' + erros);
                        });
                    })
                .fail(function (erros) {
                    alert('troca post ' + erros);
                });
        } else
            console.log('other class is:' + $(other).attr('class'));
    };

    $('#modal-disciplina').on('show.bs.modal', function (event) {
        var modal = $(this);
        modal.find('.modal-title').text('informações da disciplina');
        modal.find('.modal-body #modal-nome').val(info[0]);
        modal.find('.modal-body #modal-codigo').val(info[1]);
        modal.find('.modal-body #modal-turma').val(info[2]);
        modal.find('.modal-body #modal-cor').val(info[3]);
        modal.find('.modal-body #modal-tipo').val(info[4]);
        modal.find('.modal-body #recipient-area').val(info[5]);
        modal.find('.modal-body #modal-curso').val(info[6]);
        modal.find('.modal-body #modal-periodo').val(info[7]);
    });

    $(document).ready(function () {
        var parametros = {
            idCurso:1,
            nPeriodo:1
        };
        $.get('/atualizarSlots', parametros)
            .done(function (fragment) {
                $('#conteudo').replaceWith(fragment);
            });
    });
});

function irParaDisciplinas() {
    $.get('/atualizarSlots', function (fragment) {
        $('#navegaca-disciplina').replaceWith(fragment);
    }).fail(function (erros) {
        alert('atualiza ' + erros);
    });
}

function dblclickDisicplina(event){
    let a = $('#' + event.target.id);
    showDisciplinaModal(a);
}

function dblclickDisicplinaText(event){
    let a = $('#' + event.target.id);
    showDisciplinaModal($(a).parent());
}

function showDisciplinaModal(a) {
    info[0] = $(a).data('nome');
    info[1] = $(a).data('codigo');
    info[2] = $(a).data('turma');
    info[3] = $(a).data('cor');
    info[4] = $(a).data('tipo');
    info[5] = $(a).data('area');
    info[6] = $(a).data('curso');
    info[7] = $(a).data('periodo');
    $('#modal-disciplina').modal('show');
}

function mudaPeriodo(v) {
    var i = parseInt(v);
    var parametros = {
        idCurso:idCurso,
        nPeriodo:i
    };
    $.get('/atualizarSlots', parametros)
        .done(function (fragment) {
            $('#div-disciplinas').replaceWith(fragment);
        });
}

function mudaCurso(v) {
    var i = parseInt(v);
    var parametros = {
        idCurso:i,
        nPeriodo:1
    };
    $.get('/atualizarSlots', parametros)
        .done(function (fragment) {
            $('#div-disciplinas').replaceWith(fragment);
        });
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    ev.dataTransfer.setData("text", ev.target.id);
    origin = $('#' + ev.target.id).parent().attr('id');
}

function drop(ev) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("text");
    if (origin != undefined && origin !== ev.target.id) {
        $('#' + origin).troca('#' + ev.target.id);
    }
}