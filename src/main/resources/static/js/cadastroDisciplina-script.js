function efetuarCadastro(){
    let formCadastro = document.getElementById('formCadastro');
    let disciplina = document.getElementById('iDisciplina');
    let codigo = document.getElementById('iCodigo');
    let curso = document.getElementById('iCurso');
    let area = document.getElementById('iArea');
    let obr = document.getElementById('iObr');
    let opt = document.getElementById('iOpt');

    formCadastro.addEventListener("submit", function(event){
        event.preventDefault();                      //comando para não haver o carregamento da página
        let dados = {
            disciplina: disciplina.value,
            codigo: codigo.value,
            curso: curso.value,
            area: area.value,
            obr: obr.value,
            opt: opt.value
        };
        fetch('/fazerCadastroDisciplina', {       //dentro das '' botar o endereço da requisição. Esse link é uma requisição fake apenas para testar o código
            method: 'POST',
            body: JSON.stringify(dados)
        })
        .then(function(response) {
            console.log(response);
            if(!response.ok) throw Error(response.statusText);
            else return response.json();
        })
        .then(function(response){
            alert("Cadastro realizado com sucesso!");
            window.history.back();
        })
        .catch(e => alert(e.toString()))
    })
}