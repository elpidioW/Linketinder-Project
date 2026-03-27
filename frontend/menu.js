
const botaoCadastroCandidato = document.getElementById("cd_candidato");
const botaoCadastroEmpresa = document.getElementById("cd_empresa");
const botaoPerfilCandidato = document.getElementById("pf_candidato");
const botaoPerfilEmpresa = document.getElementById("pf_empresa");


botaoCadastroCandidato.onclick = function(){
    window.open("candidato/cadastro/cadastro-candidato.html", "_blank");
}

botaoCadastroEmpresa.onclick = function(){
    console.log("clicou");
}

botaoPerfilCandidato.onclick = function(){
    console.log("clicou");
}

botaoPerfilEmpresa.onclick = function(){
    console.log("clicou");
}