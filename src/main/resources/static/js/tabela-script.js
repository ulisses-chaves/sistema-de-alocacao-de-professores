var professores = [];
var y=0;
var codigo=false,nome=false,email=false,telefone=false;
function addProfessor(p){
    professores.push(p);
    addColuna(p);
}

function addColuna(p){
    $('#tabela tbody').append(
        "<tr id=y"+y+">"+
            "<td id=y"+y+"x0>"+p.codigo+"</td>"+
            "<td id=y"+y+"x1>"+p.nome+"</td>"+
            "<td id=y"+y+"x2>"+p.email+"</td>"+
            "<td id=y"+y+"x3>m0k "+p.telefone+"</td>"+
        "</tr>"
    );
    y++;
}

function removeColuna(index){
    $('#y'+index).remove();
}

function ordenar(coluna){
	let cresc;
    switch(coluna){
        case 1:
         	codigo = !codigo;
        	cresc = codigo ? 1 : -1;
            professores.sort(function(a,b){
                return cresc * ((a.codigo == b.codigo) ? 0 : (a.codigo > b.codigo) ? 1 : -1);
            });
            break;
        case 2:
        	nome = !nome;
        	cresc = nome ? 1 : -1;
            professores.sort(function(a,b){
                return cresc * ((a.nome == b.nome) ? 0 : (a.nome > b.nome) ? 1 : -1);
            });
            break;
        case 3:
        	email = !email;
        	cresc = email ? 1 : -1;
            professores.sort(function(a,b){
                return cresc * ((a.email == b.email) ? 0 : (a.email > b.email) ? 1 : -1);
            });
            break;
        case 4:
        	telefone = !telefone;
        	cresc = telefone ? 1 : -1;
            professores.sort(function(a,b){
                return cresc * ((a.telefone == b.telefone) ? 0 : (a.telefone > b.telefone) ? 1 : -1);
            });
    }
    atualiza();
}

function atualiza (){
	for (let i=0 ; i<professores.length ; i++){
		for (let j=0 ; j<4 ; j++){
			console.log
			$('#y'+i+'x'+j).text(professores[i].getConteudo(j));
		}
	}
}

function getData(id) {
    let v = id.substring(1,id.indexOf('x'));
    for(let x=0 ; x<4 ; x++){
        professores[v].setConteudo(x,$('#y'+v+'x'+x).text());
    }
    
}

$(function () {
    $('#btn').click(function (){
        console.log('clickado');
        $.ajax({
            type: 'GET',
            url: '/',
            succes: function (msg) {
                alert(msg);
            },
            error: function (xhr, status, error) {
                alert('>>'+xhr.responseText);
            }
        });
    });
    $("td").dblclick(function () {
        var conteudoOriginal = $(this).text();
        var meuNome = $(this).attr('id');
        $(this).addClass("celulaEmEdicao");
        $(this).html("<input type='text' value='" + conteudoOriginal + "' />");
        $(this).children().first().focus();
 
        $(this).children().first().keypress(function (e) {
            if (e.which == 13) {
                var novoConteudo = $(this).val();
                $(this).parent().text(novoConteudo);
                $(this).parent().removeClass("celulaEmEdicao");
                getData(meuNome);
            }
        });
         
        $(this).children().first().blur(function(){
            $(this).parent().text(conteudoOriginal);
            $(this).parent().removeClass("celulaEmEdicao");
        });
    });
    $('#codigo').click(function (){ordenar(1);});
    $('#nome').click(function (){ordenar(2);});
    $('#email').click(function (){ordenar(3);});
    $('#telefone').click(function (){ordenar(4);});
});

