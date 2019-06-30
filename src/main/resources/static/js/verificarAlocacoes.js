var botao_adicionar = document.querySelector("#adicionar_dados");
var campo_disciplina = document.querySelector("input[name='disciplina']");
var campo_periodo = document.querySelector("input[name='periodo']");
var corpo_tabela = document.querySelector("tbody");

var Objeto = {
    discplina, 
    periodo
};
    
    window.onload = function () {
     this.criar_linha_tabela = function () {
    //criando elementos
    var linha = document.createElement("tr");
    var campo_disciplina = document.createElement("td");
    var campo_periodo = document.createElement("td");
    //criando nós 
    var texto_disciplina = document.createTextNode(this.disciplina);
    var texto_periodo = document.createTextNode(this.alocacao);
    //vinculando os nós aos elementos
    campo_disciplina.appendChild(texto_disciplina);
    campo_periodo.appendChild(texto_alocacao);
    linha.appendChild(campo_disciplina);
    linha.appendChild(campo_periodo);
    //vinculando os elementos ao documento
    corpo_tabela.appendChild(linha);
    
    
};

Function adicionar_dados(event) {
    event.preventDefault();
    nova_linha= new Objeto(campo_disciplina, campo_periodo);
    nova_linha.criar_linha_tabela();  
};   
};
