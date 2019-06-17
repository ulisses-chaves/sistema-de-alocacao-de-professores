import { CadastroProfessorTemplate } from '/templates/cadastro-professor-template.js'

const CadastroProfessor = Vue.component('cadastroProfessor', {
    template: CadastroProfessorTemplate,
    data () {
    	return {
    		professor: {
    			nome: '',
    			cpf: '',
    			senha: '',
    			email: '',
    			tipo: '',
    			area: ''
    		}
    	}
    },
    computed: {
        width: function () {
            return (window.innerWidth > 0) ? window.innerWidth : screen.width;
        }
    },
    methods: {
    	cadastrar () {
    		let url = 'https://reqres.in/api/users';
    		axios.post (url, this.professor)
    			.then (function (response) {
    				console.log(response)
    			})
    	}
    }
})

export {CadastroProfessor}