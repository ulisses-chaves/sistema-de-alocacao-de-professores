import {CadastroDisciplinaTemplate} from '/templates/cadastro-disciplina-template.js'

const CadastroDisciplina = Vue.component ('cadastroDisciplina', {
    template: CadastroDisciplinaTemplate,
    computed: {
        width: function () {
            return (window.innerWidth > 0) ? window.innerWidth : screen.width;
        }
    }
})

export {CadastroDisciplina}