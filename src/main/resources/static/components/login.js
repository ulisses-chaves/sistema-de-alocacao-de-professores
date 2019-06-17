import { LoginTemplate } from '/templates/login-template.js';

const Login = Vue.component('login', {
    template: LoginTemplate,
    data () {
    	return {
    		user: {
    			login: '',
    			password: ''
    		}
    	}
    },
	methods: {
		logar () {
			let url = 'https://reqres.in/api/users';  // << TIRA ESSE LINK E BOTA A URL DA API AQUI
			axios.post (url, this.user).then (function (response) {
				console.log(response)
			})
		}
	}
})

export {Login}