const MenuCoordenadorTemplate= `
    <div class="container">
        <div class="row mt-4">
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
                <h2 class="text-center color-dark">Coordenador</h2>
                <div class="text-center">
                    <img src="/img/businessman.png" alt="">
                </div>
            </div>
            <div class="mt-3 col-12 col-sm-12 col-lg-8 col-xl-8">
                <ul class="text-left">
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="horarioObr()" v-on:mouseout="semMouse ()">
                            <img src="/img/clock.png" alt="Horário Obrigatórias">
                            <br>
                            <p class="color-dark">Obrigatórias</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="slotsDisc ()" v-on:mouseout="semMouse ()">
                            <img src="/img/books-stack-of-three.png" alt="Slots Disciplinas">
                            <br>
                            <p class="color-dark">Slots</p>
                        </a>
                    </li>
                     <li class="d-inline-block mx-4">
                        <a href="" v-on:mouseover="histAlocacao ()" v-on:mouseout="semMouse ()">
                            <img src="/img/eye.png" alt="Histórico Alocação">
                            <br>
                            <p class="color-dark">Histórico</p>
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

export {MenuCoordenadorTemplate}