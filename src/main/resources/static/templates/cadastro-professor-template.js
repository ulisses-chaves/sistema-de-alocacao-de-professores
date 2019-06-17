const CadastroProfessorTemplate= `
    <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1 class="mt-4 text-center color-dark font-weigh-700">Cadastro Professor</h1>
                    <hr class="title-row">
                </div>
            </div>
            <form v-on:submit.prevent="cadastrar">
                <div class="form-cadastro bg-dark col-lg-10 col-xl-9 m-auto pt-4 pb-4 px-5">
                    <p class="text-center">Insira suas informações para o cadastro</p>
                    <hr style="background: #ebe9e9">
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iNome">Nome</label>
                        <div class="col-sm-10 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="text" name="nome" id="iNome" placeholder="Nome Completo" v-model="professor.nome" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iCpf">CPF</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="text" name="cpf" id="iCpf" placeholder="CPF (apenas números)" v-model="professor.cpf" required>
                        </div>
                        <div class="col-sm-1"><!--apenas para espaçamento--></div>
                        <label class="col-sm-1 col-form-label" for="iSenha">Senha</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="password" name="senha" id="iSenha" placeholder="Senha (letras e números)" v-model="professor.senha" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iEmail">Email</label>
                        <div class="col-sm-10 my-1 mb-4">
                            <input class="form-control tamanho-input p-1" type="email" name="email" id="iEmail" placeholder="Email" v-model="professor.email" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <label class="col-sm-2 col-form-label" for="iTipo">Tipo</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <select class="form-control tamanho-input p-1" id="iTipo" v-model="professor.tipo">
                                <option value="professor">Professor</option>
                                <option value="supervisor">Supervisor</option>
                                <option value="coordenador">Coordenador</option>
                            </select>
                        </div>
                        <div class="col-sm-1"><!--apenas para espaçamento--></div>
                        <label class="col-sm-1 col-form-label" for="iArea">Área</label>
                        <div class="col-sm-4 my-1 mb-4">
                            <select class="form-control tamanho-input p-1" id="iArea" v-model="professor.area">
                                <option value="arq">Arq</option>
                                <option value="ensiso">Ensiso</option>
                                <option value="fc">FC</option>
                            </select>
                        </div>
                    </div>
                    <hr style="background: #ebe9e9">
                    <div v-if="width >= 576" class="row">
                        <div class="col-sm-6 text-right">
                            <button class="btn btn-outline-light" value="Entrar">Cadastrar</button>
                        </div>
                        <div class="col-sm-6">
                            <button type="button" onclick="window.location.href='#/'" id="btn-voltar" class="btn btn-outline-light">Voltar</button>
                        </div>
                    </div>
                    <div v-else class="row">
                        <div class="col-sm-6 text-center mt-2 mb-3">
                            <button class="btn btn-outline-light" value="Entrar">Cadastrar</button>
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