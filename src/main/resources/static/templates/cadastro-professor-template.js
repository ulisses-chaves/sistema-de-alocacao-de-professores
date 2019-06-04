const CadastroProfessorTemplate= `
    <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="mt-4 text-center color-dark font-weigh-700">Cadastro Professor</h1>
                    <hr class="title-row">
                </div>
            </div>
            <form action="">
                <div class="form-cadastro bg-dark col-lg-10 col-xl-9 m-auto pt-4 pb-4 px-5">
                    <p class="text-center">Insira suas informações para o cadastro</p>
                    <hr style="background: #ebe9e9">
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iNome">Nome</label>
                        <div class="col-sm-10 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="text" name="nome" id="iNome" placeholder="Nome Completo" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iCpf">CPF</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="text" name="cpf" id="iCpf" placeholder="CPF (apenas números)" required>
                        </div>
                        <div class="col-sm-1"><!--apenas para espaçamento--></div>
                        <label class="col-sm-1 col-form-label" for="iSenha">Senha</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="password" name="senha" id="iSenha" placeholder="Senha (letras e números)" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iEmail">Email</label>
                        <div class="col-sm-10 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="email" name="email" id="iEmail" placeholder="Email" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iTipo">Tipo</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <select class="form-control tamanho-input p-1" id="iTipo">
                                <option>Professor</option>
                                <option>Supervisor</option>
                                <option>Coordenador</option>
                            </select>
                        </div>
                        <div class="col-sm-1"><!--apenas para espaçamento--></div>
                        <label class="col-sm-1 col-form-label" for="iArea">Área</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <select class="form-control tamanho-input p-1" id="iArea">
                                <option>Arq</option>
                                <option>Ensiso</option>
                                <option>FC</option>
                            </select>
                        </div>
                    </div>
                    <hr style="background: #ebe9e9">
                    <div v-if="width >= 576" class="row">
                        <div class="col-sm-6 text-right">
                            <button type="submit" id="btn-logar" class="btn btn-outline-light" value="Entrar">Cadastrar</button>
                        </div>
                        <div class="col-sm-6">
                            <button type="button" onclick="window.location.href='#/'" id="btn-voltar" class="btn btn-outline-light">Voltar</button>
                        </div>
                    </div>
                    <div v-else class="row">
                        <div class="col-sm-6 text-center mt-2 mb-3">
                            <button type="submit" id="btn-logar" class="btn btn-outline-light" value="Entrar">Cadastrar</button>
                        </div>
                        <div class="col-sm-6 text-center" >
                            <button type="button" onclick="window.location.href='#/'" id="btn-voltar" class="btn btn-outline-light">Voltar</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
`

export { CadastroProfessorTemplate }