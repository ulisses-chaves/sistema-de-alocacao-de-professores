import Vue from '/js/vue.js'
import { Login } from '/components/login.js'
import { CadastroProfessor } from '/components/cadastro-professor.js'
import { CadastroDisciplina } from '/components/cadastro-disciplina.js'
import { MenuProfessor } from '/components/menu-professor.js'
import { MenuSupervisor } from '/components/menu-supervisor.js'
import { MenuCoordenador } from '/components/menu-coordenador.js'
//import { Regras } from '/components/regras.js'

Vue.use (VueRouter)

const router = new VueRouter({
    routes: [   
        { path: '/', component: Login },
        { path: '/cadastroProfessor', component: CadastroProfessor },
        { path: '/cadastroDisciplina', component: CadastroDisciplina },
        { path: '/menuProfessor', component: MenuProfessor },
        { path: '/menuSupervisor', component: MenuSupervisor },
        { path: '/menuCoordenador', component: MenuCoordenador },
        /*{ path: '/regras', component: Regras }*/
    ]
})

new Vue ({
    el: "#app",
    router  
})