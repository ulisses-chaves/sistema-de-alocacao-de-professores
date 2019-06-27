
class Professor {
    constructor(codigo,nome,email,telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }
    getConteudo(index){
        switch(index){
            case 0: return this.codigo;
            case 1: return this.nome;
            case 2: return this.email;
            case 3: return this.telefone;
        }
    }
    setConteudo(index,conteudo){
        switch(index){
            case 0: this.codigo = conteudo; break;
            case 1: this.nome = conteudo; break;
            case 2: this.email = conteudo; break;
            case 3: this.telefone = conteudo; break;
        }
    }
}