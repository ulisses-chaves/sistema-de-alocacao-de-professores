import {MenuProfessorTemplate} from '/templates/menu-professor-template.js'

const MenuProfessor = Vue.component('menuProfessor', {
    template: MenuProfessorTemplate,
    methods: {
        semMouse(){
            document.getElementById('texto-menu').innerHTML = '';
        },
        logout(){
            document.getElementById('texto-menu').innerHTML = 'Encerre a sessão';
        },
        defPreferencias(){
            document.getElementById('texto-menu').innerHTML = 'Defina suas preferências para as disciplinas que deseja lecionar';
        },
        visAlocacoes(){
            document.getElementById('texto-menu').innerHTML = 'Visualize as alocações realizadas';
        },
    }
})

export {MenuProfessor}