function efetuarCadastro(){
    let formCadastro = document.getElementById('formCadastro');
    let nome = document.getElementById('iNome');
    let login = document.getElementById('iLogin');
    let senha = document.getElementById('iSenha');
    let email = document.getElementById('iEmail');
    let codigo = document.getElementById('iCodigo');
    let area = document.getElementById('iArea');

    formCadastro.addEventListener("submit", function(event){
        event.preventDefault();                      //comando para não haver o carregamento da página
        let dados = {
            name: nome.value,
            login: login.value,
            senha: senha.value,
            email: email.value,
            codigo: codigo.value,
            area: area.value
        };
        fetch('https://reqres.in/api/users', {       //dentro das '' botar o endereço da requisição. Esse link é uma requisição fake apenas para testar o código
            method: 'POST',
            body: JSON.stringify(dados)
        })
        .then(function(response) {
            if(!response.ok) throw Error(response.statusText);
            else return response.json();
        })
        .then(function(response){
            alert("Cadastro realizado com sucesso!");
            window.history.back();
        })
        .catch(e => alert('Cadastro não realizado!'))
    })
}