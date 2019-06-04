import { CadastroProfessorTemplate } from '/templates/cadastro-professor-template.js'

const CadastroProfessor = Vue.component('cadastroProfessor', {
    template: CadastroProfessorTemplate,
    computed: {
        width: function () {
            return (window.innerWidth > 0) ? window.innerWidth : screen.width;
        }
    }
})

export {CadastroProfessor}