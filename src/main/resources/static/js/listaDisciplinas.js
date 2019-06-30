this.nome = nome;
this.primeira = primeira;
this.segunda = segunda;

var corpo_tabela = document.querySelector("tbody");

this.criar_linha_tabela = function(){

    var linha = document.createElement("tr");
    var nomeProfessor = document.createElement("td");
    var primeiraEscolha = document.createElement("td");
    var segundaEscolha = document.createElement("td");

    nomeProfessor.className = "bold";
    primeiraEscolha.className = "bold";
    segundaEscolha.className = "bold";

    var texto_nome = document.createTextNode(this.nome);
    var texto_primeira = document.createTextNode(this.primeira);
    var text_segunda = document.createTextNode(this.segunda);

    nomeProfessor.appendChild(texto_nome);
    primeiraEscolha.appendChild(texto_primeira);
    segundaEscolha.appendChild(text_segunda);
    linha.appendChild(nomeProfessor);
    linha.appendChild(primeiraEscolha);
    linha.appendChild(segundaEscolha);

    corpo_tabela.appendChild(linha);
}