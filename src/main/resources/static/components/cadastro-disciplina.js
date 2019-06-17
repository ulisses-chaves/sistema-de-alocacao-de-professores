import {CadastroDisciplinaTemplate} from '/templates/cadastro-disciplina-template.js'

const CadastroDisciplina = Vue.component ('cadastroDisciplina', {
    template: CadastroDisciplinaTemplate,
    data () {
    	return {
    		disciplina: {
    			nome: '',
    			codigo: '',
    			area: '',
    			curso: '',
    			ch: '',
    			titulo: '',
    			tipo: '',
    		}
    	}
    },
    computed: {
        width: function () {
            return (window.innerWidth > 0) ? window.innerWidth : screen.width;
        }
    },
    methods: {
    	cadastrarDisciplina () {
			let url = 'https://reqres.in/api/users';  // << TIRA ESSE LINK E BOTA A URL DA API AQUI
			axios.post (url, this.disciplina)
				.then (function (response) {
					console.log(response)
				})
		}
    }
})

export {CadastroDisciplina}