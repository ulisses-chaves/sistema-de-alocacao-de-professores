window.onload = function () {
    $.ajax({
        type:'GET',
        url:'https://reqres.in/api/users?page=2', // rota que traga um array de objetos, cada objeto com 3 atributos: nome do professor, nome da disciplina e o periodo que ele lecionou
        success: function (responseText, textStatus, jqXHR) {
            var corpo_tabela = document.querySelector ("#tabela");
            var historico = responseText.data;
            for (let index = 0; index <= historico.length; index++) {
                //criando elementos
                var linha = document.createElement("tr");
                var campo_professor = document.createElement("td");
                var campo_disciplina = document.createElement("td");
                var campo_alocacao = document.createElement("td");
                //criando nós 
                var texto_professor = document.createTextNode(historico[index].professor);
                var texto_disciplina = document.createTextNode(historico[index].disciplina);
                var texto_alocacao = document.createTextNode(historico[index].periodo);
                //vinculando os nós aos elementos
                campo_professor.appendChild(texto_professor);
                campo_disciplina.appendChild(texto_disciplina);
                campo_alocacao.appendChild(texto_alocacao);
                linha.appendChild(campo_professor);
                linha.appendChild(campo_disciplina);
                linha.appendChild(campo_alocacao);
                //vinculando os elementos ao documento
                corpo_tabela.appendChild(linha); 
            }
        }
    })
};