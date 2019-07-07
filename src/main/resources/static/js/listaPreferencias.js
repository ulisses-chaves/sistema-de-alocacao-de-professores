var preferencia = new Array();

window.onload = function () {
    $.ajax({
        type:'GET',
        url:'variavel/professores', // rota que traga um array de objetos, cada objeto com 3 atributos: nome do professor, a primeira preferencia dele e a segunda preferencia
        success: function (responseText, textStatus, jqXHR) {
            var corpo_tabela = document.querySelector("#tabela");
            preferencias = responseText;
            for (let index = 0; index <= preferencias.length; index++) {
            
                if (preferencias[index].preferencia1 == null) preferencias[index].preferencia1 = 'Ainda não escolheu';
                if (preferencias[index].preferencia2 == null) preferencias[index].preferencia2 = 'Ainda não escolheu';

                var linha = document.createElement("tr");
                var nomeProfessor = document.createElement("td");
                var primeiraEscolha = document.createElement("td");
                var segundaEscolha = document.createElement("td");

                nomeProfessor.className = "bold";
                primeiraEscolha.className = "bold";
                segundaEscolha.className = "bold";

                var texto_nome = document.createTextNode(preferencias[index].nome);
                var texto_primeira = document.createTextNode(preferencias[index].preferencia1);
                var text_segunda = document.createTextNode(preferencias[index].preferencia2);

                nomeProfessor.appendChild(texto_nome);
                primeiraEscolha.appendChild(texto_primeira);
                segundaEscolha.appendChild(text_segunda);
                linha.appendChild(nomeProfessor);
                linha.appendChild(primeiraEscolha);
                linha.appendChild(segundaEscolha);

                corpo_tabela.appendChild(linha);
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