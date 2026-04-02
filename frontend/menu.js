
const botaoCadastroCandidato = document.getElementById("cd_candidato");
const botaoCadastroEmpresa = document.getElementById("cd_empresa");
const botaoPerfilCandidato = document.getElementById("pf_candidato");
const botaoPerfilEmpresa = document.getElementById("pf_empresa");


botaoCadastroCandidato.onclick = function(){
    window.location.href = "candidato/cadastro/cadastro-candidato.html";
}

botaoCadastroEmpresa.onclick = function(){
    window.location.href = "empresa/cadastro/cadastro-empresa.html";
}

botaoPerfilCandidato.onclick = function(){
    window.location.href = "candidato/perfil/perfil-candidato.html";
}

botaoPerfilEmpresa.onclick = function(){
    window.location.href = "empresa/perfil/perfil-empresa.html";
}