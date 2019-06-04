import {MenuCoordenadorTemplate} from '/templates/menu-coordenador-template.js'

const MenuCoordenador = Vue.component ('menuCoordenador', {
    template: MenuCoordenadorTemplate,
    methods: {
        semMouse(){
            document.getElementById('texto-menu').innerHTML = '';
        },
        logout(){
            document.getElementById('texto-menu').innerHTML = 'Encerre a sessão';
        },
        horarioObr(){
            document.getElementById('texto-menu').innerHTML = 'Defina o horário das disciplinas obrigatórias';
        },
        slotsDisc(){
            document.getElementById('texto-menu').innerHTML = 'Defina os slots das disciplinas';
        },
        histAlocacao(){
            document.getElementById('texto-menu').innerHTML = 'Visualize o histórico de alocações';
        },
    }
})

export {MenuCoordenador}