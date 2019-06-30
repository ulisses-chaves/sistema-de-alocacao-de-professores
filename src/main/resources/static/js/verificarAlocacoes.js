window.onload = function () {
	$.ajax({
        type:'GET',
        url:'', // rota que traga um array de objetos, cada objeto com 3 atributos: nome do professor, a primeira preferencia dele e a segunda preferencia
        success: function (responseText, textStatus, jqXHR) {
			var corpo_tabela = document.querySelector("#tabela");
			var disciplinas = responseText.data;
			for (let index = 0; index <= disciplinas.length; index++) {
			    //criando elementos
			    var linha = document.createElement("tr");
			    var campo_disciplina = document.createElement("td");
			    var campo_periodo = document.createElement("td");
			    //criando nós 
			    var texto_disciplina = document.createTextNode(disciplinas[index].disciplina);
			    var texto_periodo = document.createTextNode(disciplinas[index].periodo);
			    //vinculando os nós aos elementos
			    campo_disciplina.appendChild(texto_disciplina);
			    campo_periodo.appendChild(texto_periodo);
			    linha.appendChild(campo_disciplina);
			    linha.appendChild(campo_periodo);
			    //vinculando os elementos ao documento
			    corpo_tabela.appendChild(linha);
			}
        }
	})   
};