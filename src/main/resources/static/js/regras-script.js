var condicao = false;
function mostrarForm (valor) {
    if (condicao == true) {
        document.getElementById('tempPref').style.display = 'none';
        document.getElementById('numPref').style.display = 'none';
        document.getElementById('horMaxMin').style.display = 'none';
        document.getElementById('qtdCad').style.display = 'none';
        condicao = false;
    }
    switch (valor){
        case '1':
            document.getElementById('tempPref').style.display = 'block';
            condicao = true;
            break;
        case '2':
            document.getElementById('numPref').style.display = 'block';
            condicao = true;
            break;
        case '3':
            document.getElementById('horMaxMin').style.display = 'block';
            condicao = true;
            break;
        case '4':
            document.getElementById('qtdCad').style.display = 'block';
            condicao = true;
            break;
    }
}