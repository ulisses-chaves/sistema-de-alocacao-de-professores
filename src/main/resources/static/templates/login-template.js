const LoginTemplate = `
<div class="container mb-4">
    <div class="row">
        <div class="col-sm-12 col-md-6 col-lg-6 pt-5 divLogoDescricao">
            <img src="/img/sistema-preto.png" class="logoDescricao" alt="logoSAP" title="Sistema de Alocação de Professores">
        </div>
        <div class="col-sm-12 col-md-6 col-lg-6 pt-4">
            <div class="login col-sm-12 col-md-12 col-lg-9 col-xl-8 bg-dark p-3">
                <form v-on:submit.prevent="logar">
                    <label for="inputLogin">Login:</label>
                    <input type="text" class="form-control tamanho-input p-1" id="inputLogin" placeholder="Seu login" v-model="user.login" required>
                    <label class= "mt-2" for="inputSenha">Senha:</label>
                    <input type="password" class="form-control tamanho-input h-30px p-1" id="inputSenha" placeholder="Sua senha" v-model="user.password" required>
                    <div class="links my-3 p-1">
                        <a href="#/cadastroProfessor">Cadastro</a> <br>
                        <a href="" data-toggle="modal" data-target="#modalRecuperar">Esqueceu a senha?</a>
                    </div>
                    <div class="text-right pr-3 my-1 mt-4">
                        <button class="btn btn-outline-light" value="Entrar">Entrar</button>
                    </div>
                </form> 
                <div id="resposta"></div>
            </div>            
        </div>
    </div>
    <!-- MODAL-RECUPERAR -->
    <div class="modal fade" tabindex="-1" role="dialog" id="modalRecuperar">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="color-dark">Recuperar Senha</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="">
                    <div class="modal-body">
                        <p class="color-dark">Informe os dados abaixo:</p>
                        <div class="form-row">
                            <label class="col-sm-2 col-form-label color-dark" for="iCpf"><strong>CPF</strong></label>
                            <div class="col-sm-10 my-1 mb-4">
                                <input class="form-control tamanho-input p-1 border-dark" type="text" name="cpf" id="iCpf" placeholder="Seu CPF (apenas números)" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <label class="col-sm-2 col-form-label color-dark" for="iEmail"><strong>Email</strong></label>
                            <div class="col-sm-10 my-1 mb-4">
                                <input class="form-control tamanho-input p-1 border-dark" type="text" name="email" id="iEmail" placeholder="Seu email" required>
                            </div>
                        </div> 
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-dark">Recuperar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    `

export { LoginTemplate }