var botao_adicionar = document.querySelector("#adicionar_dados");
var campo_professor = document.querySelector("input[name='nome']");
var campo_disciplina = document.querySelector("input[name='disciplina']");
var campo_alocacao = document.querySelector("input[name='alocacao']");
var corpo_tabela = document.querySelector("tbody");

var Objeto = {
    professor, 
    discplina,
    alocacao
};
    
    window.onload = function () {
     this.criar_linha_tabela = function () {
    //criando elementos
    var linha = document.createElement("tr");
    var campo_professor = document.createElement("td");
    var campo_disciplina = document.createElement("td");
    var campo_alocacao = document.createElement("td");
    //criando nós 
    var texto_professor = document.createTextNode(this.nome);
    var texto_disciplina = document.createTextNode(this.disciplina);
    var texto_alocacao = document.createTextNode(this.alocacao);
    //vinculando os nós aos elementos
    campo_professor.appendChild(texto_professor);
    campo_disciplina.appendChild(texto_disciplina);
    campo_alocacao.appendChild(texto_alocacao);
    linha.appendChild(campo_professor);
    linha.appendChild(campo_disciplina);
    linha.appendChild(campo_alocacao);
    //vinculando os elementos ao documento
    corpo_tabela.appendChild(linha);
    
    
};

function adicionar_dados(event) {
    event.preventDefault();
    nova_linha= new Objeto(campo_professor, campo_disciplina, campo_alocacao);
    nova_linha.criar_linha_tabela();  
};   
};
