var primeiraPreferencia = null;
var segundaPreferencia = null;
var disciplinas = new Array ();

window.onload = function () {
    $.ajax({
        type:'GET',
        url:'variavel/disciplinas', //rota que recebe um array de objetos de todas as disciplinas cadastradas
        success: function (responseText, textStatus, jqXHR) {
            console.log (responseText)
            var corpoTabela = document.querySelector ("#tabelaEsquerda");
            var disciplinas = responseText;
            for (let index = 0; index <= disciplinas.length; index++) {
                var linha = document.createElement("tr");
                var campoDisciplina = document.createElement("td");
                var campoCurso = document.createElement("td");
                var campoTipo = document.createElement("td");
                var campoButao = document.createElement("td");
                var textoDisciplina = document.createTextNode (disciplinas[index].nome);
                var textoCurso = document.createTextNode (disciplinas[index].area);
                var textoTipo = document.createTextNode (disciplinas[index].tipo);
                var butao = document.createElement ("button");

                butao.className = "btn btn-primary"
                butao.innerHTML = ">>"
                butao.addEventListener("click", function () {
                    if (primeiraPreferencia == null) {
                        primeiraPreferencia = disciplinas[index];
                        preencherTabelaPrimeira (primeiraPreferencia);
                    }else if (segundaPreferencia == null) {
                        segundaPreferencia = disciplinas[index];
                        if (primeiraPreferencia == segundaPreferencia) {
                            alert ('Essa já é sua primeira preferencia')
                            segundaPreferencia = null
                        }else {
                            preencherTabelaSegunda (segundaPreferencia);
                        }
                    }else {
                        alert ('Você já escolheu duas opções')
                    }
                })

                campoDisciplina.appendChild (textoDisciplina);
                campoCurso.appendChild (textoCurso);
                campoTipo.appendChild (textoTipo);
                campoButao.appendChild (butao);
                
                linha.appendChild (campoDisciplina);
                linha.appendChild (campoCurso);
                linha.appendChild (campoTipo);
                linha.appendChild (campoButao);

                corpoTabela.appendChild (linha);
            }
        },
        error: function (xhr, status, error) {
            console.log (error)
            console.log (status)
            console.log (xhr.responseText)
            alert('>>'+xhr.responseText);
        }
    });
}

function preencherTabelaPrimeira () {
    if (primeiraPreferencia != null) {
        var corpoTabelaEscolhida = document.querySelector('#tabelaDireita');
        var linha = document.createElement("tr");
        var campoButaoTirar = document.createElement("td");
        var campoDisciplinaEscolhida = document.createElement("td");

        var butaoTirar = document.createElement ("button");
        var textoDisciplinaEscolhida = document.createTextNode (primeiraPreferencia.nome);

        butaoTirar.className = "btn btn-warning"
        butaoTirar.innerHTML = "<<"
        butaoTirar.addEventListener("click", function () {
            primeiraPreferencia = null;
            linha.style.display = 'none'
            campoButaoTirar.style.display = 'none'
            campoDisciplinaEscolhida.style.display = 'none'
        })

        campoButaoTirar.appendChild (butaoTirar);
        campoDisciplinaEscolhida.appendChild (textoDisciplinaEscolhida);

        linha.appendChild (campoButaoTirar);
        linha.appendChild (campoDisciplinaEscolhida);
        corpoTabelaEscolhida.appendChild (linha);
    }
}

function preencherTabelaSegunda () {
    if (segundaPreferencia != null) {
        var corpoTabelaEscolhida = document.querySelector('#tabelaDireita');
        var linha = document.createElement("tr");
        var campoButaoTirar = document.createElement("td");
        var campoDisciplinaEscolhida = document.createElement("td");

        var butaoTirar = document.createElement ("button");
        var textoDisciplinaEscolhida = document.createTextNode (segundaPreferencia.nome);

        butaoTirar.className = "btn btn-warning"
        butaoTirar.innerHTML = "<<"
        butaoTirar.addEventListener("click", function () {
            segundaPreferencia = null;
            linha.style.display = 'none'
            campoButaoTirar.style.display = 'none'
            campoDisciplinaEscolhida.style.display = 'none'
        })

        campoButaoTirar.appendChild (butaoTirar);
        campoDisciplinaEscolhida.appendChild (textoDisciplinaEscolhida);

        linha.appendChild (campoButaoTirar);
        linha.appendChild (campoDisciplinaEscolhida);
        corpoTabelaEscolhida.appendChild (linha);
    }
}

function atualizarPreferencias () {
    if (primeiraPreferencia == null || segundaPreferencia == null) {
        alert ('Selecione suas duas preferências');
    }else {
        console.log (segundaPreferencia)
        var id1 = primeiraPreferencia.id;
        var id2 = segundaPreferencia.id;
        
        /*$.ajax({
            type:'GET',
            url:'variavel/conta',
            success: function (responseText, textStatus, jqXHR) {
                console.log (responseText.data.id)
            },
            error: function (xhr, status, error) {
                
                alert('>>'+xhr.responseText);
            }
        })*/
        $.ajax({
            type:'POST',
            url:'variavel/preferencia', //rota que recebe um array de objetos de todas as disciplinas cadastradas
            data: { cpf: '123456' , idDisciplina1: id1, idDisciplina2: id2 },
            success: function (responseText, textStatus, jqXHR) {
                alert ('Você escolheu ' + primeiraPreferencia.nome + " e " + segundaPreferencia.nome + ' como preferências. \nAlterações podem ser feitas a qualquer momento!\nBasta escolher novas opções para substituir.')
                window.location.href = "/menuProfessor";
            },
            error: function (xhr, status, error) {
                console.log (error)
                console.log (status)
                console.log (xhr.responseText)
                alert('>>'+xhr.responseText);
            }
        })
        //TENTEI POR FETCH MAS N FUNCIONA!

        /*fetch('/variavel/preferencia', {
            method: 'POST',
            body: JSON.stringify({
                cpf: '11111',
                id1,
                id2
            })
        })
            .then (function (response) {
                return response.json();
            })
            .then (function (data) {
                alert ('Você escolheu ' + primeiraPreferencia.nome + " e " + segundaPreferencia.nome + ' como preferências. \nAlterações podem ser feitas a qualquer momento!\nBasta escolher novas opções para substituir.')
                window.location.href = "";
            })
            .catch (error => {
                console.log (error.response)
            })*/
    }
}