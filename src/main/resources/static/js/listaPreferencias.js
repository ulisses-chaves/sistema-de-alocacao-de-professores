window.onload = function () {
    $.ajax({
        type:'GET',
        url:'', // rota que traga um array de objetos, cada objeto com 3 atributos: nome do professor, a primeira preferencia dele e a segunda preferencia
        success: function (responseText, textStatus, jqXHR) {
            var corpo_tabela = document.querySelector("#tabela");
            var preferencias = responseText.data;
            for (let index = 0; index <= preferencias.length; index++) {
            
                var linha = document.createElement("tr");
                var nomeProfessor = document.createElement("td");
                var primeiraEscolha = document.createElement("td");
                var segundaEscolha = document.createElement("td");

                nomeProfessor.className = "bold";
                primeiraEscolha.className = "bold";
                segundaEscolha.className = "bold";

                var texto_nome = document.createTextNode(preferencias[index].professor);
                var texto_primeira = document.createTextNode(preferencias[index].primeiraPreferencia);
                var text_segunda = document.createTextNode(preferencias[index].segundaPreferencia);

                nomeProfessor.appendChild(texto_nome);
                primeiraEscolha.appendChild(texto_primeira);
                segundaEscolha.appendChild(text_segunda);
                linha.appendChild(nomeProfessor);
                linha.appendChild(primeiraEscolha);
                linha.appendChild(segundaEscolha);

                corpo_tabela.appendChild(linha);
            }
        }
    }); 
}