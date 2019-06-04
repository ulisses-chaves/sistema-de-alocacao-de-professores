const MenuProfessorTemplate = `
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
                <h2 class="text-center color-dark">Professor</h2>
                <div class="text-center">
                    <img src="/img/icon.png" alt="">
                </div>
            </div>
            <div class="col-12 col-sm-12 col-lg-8 col-xl-8">
                <ul class="text-left">
                    <li class="d-inline-block mx-5">
                        <a href="" v-on:mouseover="defPreferencias" v-on:mouseout="semMouse ()">
                            <img src="/img/touch-of-one-finger-of-solid-black-hand-symbol.png" alt="Definir Preferências">
                            <br>
                            <p class="color-dark">Preferencias</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-5">
                        <a href="" v-on:mouseover="visAlocacoes ()" v-on:mouseout="semMouse ()">
                            <img src="/img/eye.png" alt="Visualizar Alocações">
                            <br>
                            <p class="color-dark">Alocações</p>
                        </a>
                    </li>
                    <li class="d-inline-block mx-5">
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

export {MenuProfessorTemplate}