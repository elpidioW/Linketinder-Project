import { testeImportacao, validarNome, validarEmail, validarCPF, validarEstado, validarCEP } from '../../utils/validacoes.js';
const localStorageCandidatos = localStorage.getItem('candidatos');
let listaCandidatos = [];
if (localStorageCandidatos) {
    listaCandidatos = JSON.parse(localStorageCandidatos);
}
const formulario = document.getElementById('formularioCadastroUsuario');
formulario.addEventListener('submit', function (evento) {
    evento.preventDefault();
    const id = Date.now();
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const cpf = document.getElementById('cpf').value;
    const idade = parseInt(document.getElementById('idade').value);
    const estado = document.getElementById('estado').value;
    const cep = document.getElementById('cep').value;
    const descricao = document.getElementById('descricao').value;
    //Vai pegar todos os checbox com nome competecia e ver se estao marcados
    const checkMarcados = document.querySelectorAll('input[name="competencia"]:checked');
    const competencias = [];
    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competencias.push(checkbox.value);
    });
    //Validações e a impressão dos erros
    let erros = [];
    if (!validarNome(nome)) {
        erros.push('Nome inválido');
    }
    if (!validarEmail(email)) {
        erros.push('Email inválido');
    }
    if (!validarCPF(cpf)) {
        erros.push('CPF inválido');
    }
    if (idade < 18 || idade > 100) {
        erros.push('Idade inválida');
    }
    if (!validarEstado(estado)) {
        erros.push('Estado inválido');
    }
    if (!validarCEP(cep)) {
        erros.push('CEP inválido');
    }
    if (erros.length > 0) {
        alert(erros.join('\n'));
        return;
    }
    const candidato = {
        id: id,
        nome: nome,
        email: email,
        cpf: cpf,
        idade: idade,
        estado: estado,
        cep: cep,
        descricao: descricao,
        competencias: competencias
    };
    listaCandidatos.push(candidato);
    localStorage.setItem('candidatos', JSON.stringify(listaCandidatos));
    alert('Candidato cadastrado com sucesso!');
    formulario.reset();
});
const botaoVoltar = document.getElementById('botao_voltar');
botaoVoltar.onclick = function () {
    window.history.back();
};
//# sourceMappingURL=cadastro-candidato.js.map