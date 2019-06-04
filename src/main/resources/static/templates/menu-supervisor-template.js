const MenuSupervisorTemplate= `
    <div class="container">
        <div class="col mt-2">
            <a href=""><img style="width: 30px" v-on:mouseover="mostrar()" v-on:mouseout="esconder()" src="/img/settings.png" alt=""></a>
            <div style="display: none" id="aba">
                <label class="color-dark m-0">Regras</label>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <p class="text-center color-dark">Olá professor(a) Ana, bem-vindo(a) ao <img style="width: 45px" src="/img/SAP-preto.png" alt=""> </p>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h1 class="mt-3 text-center color-dark font-weigh-700">Menu</h1>
                <hr class="title-row">
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12 col-sm-12 col-lg-4 col-xl-4">
                <h2 class="text-center color-dark">Supervisor</h2>
                <div class="text-center">
                    <img src="/img/workers-team.png" alt="">
                </div>
            </div>
            <div class="col-12 col-sm-12 col-lg-8 col-xl-8">
                <ul class="text-left">
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="histAlocacao ()" v-on:mouseout="semMouse ()">
                            <img src="/img/edit-document.png" alt="Histórico de Alocações">
                            <br>
                            <p class="color-dark">Histórico</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="preencherSlotsDisc ()" v-on:mouseout="semMouse ()">
                            <img src="/img/books-stack-of-three.png" alt="Slots das Disciplinas">
                            <br>
                            <p class="color-dark">Slots</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="alocarProf ()" v-on:mouseout="semMouse ()">
                            <img src="/img/group-of-people-in-a-formation(1).png" alt="Alocar Professores">
                            <br>
                            <p class="color-dark">Alocação</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="preferencias ()" v-on:mouseout="semMouse ()">
                            <img src="/img/cursor.png" alt="Preferências">
                            <br>
                            <p class="color-dark">Preferências</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="logout ()" v-on:mouseout="semMouse ()">
                            <img src="/img/runer-silhouette-running-fast.png" alt="Sair">
                            <br>
                            <p class="color-dark">Logout</p>
                        </a>
                    </li>
                </ul>
                <div class="color-dark text-center">
                    <p class="h3" id="texto-menu"></p>
                </div>
            </div>
        </div>
    </div>
    `

export {MenuSupervisorTemplate}