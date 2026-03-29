
const botaoCadastroCandidato = document.getElementById("cd_candidato");
const botaoCadastroEmpresa = document.getElementById("cd_empresa");
const botaoPerfilCandidato = document.getElementById("pf_candidato");
const botaoPerfilEmpresa = document.getElementById("pf_empresa");


botaoCadastroCandidato.onclick = function(){
    window.open("candidato/cadastro/cadastro-candidato.html");
}

botaoCadastroEmpresa.onclick = function(){
    window.open("empresa/cadastro/cadastro-empresa.html");
}

botaoPerfilCandidato.onclick = function(){
    window.open("candidato/perfil/perfil-candidato.html");
}

botaoPerfilEmpresa.onclick = function(){
    window.open("empresa/perfil/perfil-empresa.html");
}