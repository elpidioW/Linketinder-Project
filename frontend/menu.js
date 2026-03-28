
const botaoCadastroCandidato = document.getElementById("cd_candidato");
const botaoCadastroEmpresa = document.getElementById("cd_empresa");
const botaoPerfilCandidato = document.getElementById("pf_candidato");
const botaoPerfilEmpresa = document.getElementById("pf_empresa");


botaoCadastroCandidato.onclick = function(){
    window.open("candidato/cadastro/cadastro-candidato.html", "_blank");
}

botaoCadastroEmpresa.onclick = function(){
    window.open("empresa/cadastro/cadastro-empresa.html", "_blank");
}

botaoPerfilCandidato.onclick = function(){
    window.open("candidato/perfil/perfil-candidato.html", "_blank");
}

botaoPerfilEmpresa.onclick = function(){
    window.open("empresa/perfil/perfil-empresa.html", "_blank");
}