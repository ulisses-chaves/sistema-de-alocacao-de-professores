function semMouse(){
    document.getElementById('texto-menu').innerHTML = '';
}
function logout(){
    document.getElementById('texto-menu').innerHTML = 'Encerre a sessão';
}
/* professor */
function defPreferencias(){
    document.getElementById('texto-menu').innerHTML = 'Defina suas preferências para as disciplinas que deseja lecionar';
}
function visAlocacoes(){
    document.getElementById('texto-menu').innerHTML = 'Visualize as alocações realizadas';
}
/* supervisor */
function histAlocacao(){
    document.getElementById('texto-menu').innerHTML = 'Visualize o histórico de alocações';
}
function preencherSlotsDisc(){
    document.getElementById('texto-menu').innerHTML = 'Preencha os slots das disciplinas';
}
function alocarProf(){
    document.getElementById('texto-menu').innerHTML = 'Alocar os professores às disciplinas e as disciplinas aos horários';
}
function preferencias(){
    document.getElementById('texto-menu').innerHTML = 'Visualize as preferências de cada professor para as disciplinas';
}
function mostrar() {
	document.getElementById('aba').style.display = 'block';
}
function esconder () {
	document.getElementById('aba').style.display = 'none';
}
/* coordenador */
function horarioObr(){
    document.getElementById('texto-menu').innerHTML = 'Defina o horário das disciplinas obrigatórias';
}
function slotsDisc(){
    document.getElementById('texto-menu').innerHTML = 'Defina os slots das disciplinas';
}