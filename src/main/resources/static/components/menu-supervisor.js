import {MenuSupervisorTemplate} from '/templates/menu-supervisor-template.js'

const MenuSupervisor = Vue.component ('menuSupervisor', {
    template: MenuSupervisorTemplate,
    methods: {
        semMouse(){
            document.getElementById('texto-menu').innerHTML = '';
        },
        logout(){
            document.getElementById('texto-menu').innerHTML = 'Encerre a sessão';
        },
        histAlocacao(){
            document.getElementById('texto-menu').innerHTML = 'Visualize o histórico de alocações';
        },
        preencherSlotsDisc(){
            document.getElementById('texto-menu').innerHTML = 'Preencha os slots das disciplinas';
        },
        alocarProf(){
            document.getElementById('texto-menu').innerHTML = 'Alocar os professores para as disciplinas';
        },
        preferencias(){
            document.getElementById('texto-menu').innerHTML = 'Visualize e decida as preferências de cada professor para as disciplinas';
        },
        mostrar() {
            document.getElementById('aba').style.display = 'block';
        },
        esconder() {
            document.getElementById('aba').style.display = 'none';
        },
    }
})

export {MenuSupervisor}