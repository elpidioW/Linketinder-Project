import { testeImportacao, validarNome, validarEmail, validarCNPJ, validarPais, validarEstado, validarCEP } from '../../utils/validacoes.js';
const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas = [];
if (localStorageEmpresas) {
    listaEmpresas = JSON.parse(localStorageEmpresas);
}
const formulario = document.getElementById('formularioCadastroEmpresa');
formulario.addEventListener('submit', function (evento) {
    evento.preventDefault();
    const id = Date.now();
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const cnpj = document.getElementById('cnpj').value;
    const pais = document.getElementById('pais').value;
    const estado = document.getElementById('estado').value;
    const cep = document.getElementById('cep').value;
    const descricao = document.getElementById('descricao').value;
    //VAGAS
    const tituloVaga1 = document.getElementById('tituloVaga1').value;
    const descricaoVaga1 = document.getElementById('descricaoVaga1').value;
    //Vai pegar todos os checbox com nome competeciaVaga1 e ver se estao marcados
    const checkMarcados = document.querySelectorAll('input[name="competenciaVaga1"]:checked');
    const competenciasVaga1 = [];
    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competenciasVaga1.push(checkbox.value);
    });
    const vaga1 = {
        id: Date.now() - 1,
        titulo: tituloVaga1,
        descricao: descricaoVaga1,
        competencias: competenciasVaga1
    };
    let vaga2 = null;
    const tituloVaga2 = document.getElementById('tituloVaga2').value;
    const descricaoVaga2 = document.getElementById('descricaoVaga2').value;
    if (tituloVaga2 && descricaoVaga2) {
        //Vai pegar todos os checbox com nome competeciaVaga2 e ver se estao marcados
        const checkMarcados2 = document.querySelectorAll('input[name="competenciaVaga2"]:checked');
        const competenciasVaga2 = [];
        //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
        checkMarcados2.forEach((checkbox) => {
            competenciasVaga2.push(checkbox.value);
        });
        vaga2 = {
            id: Date.now(),
            titulo: tituloVaga2,
            descricao: descricaoVaga2,
            competencias: competenciasVaga2
        };
    }
    const vetorAuxiliar = [];
    vetorAuxiliar.push(vaga1);
    if (vaga2) {
        vetorAuxiliar.push(vaga2);
    }
    //VALIDAÇÕES:
    let erros = [];
    if (!validarNome(nome)) {
        erros.push('Nome inválido');
    }
    if (!validarEmail(email)) {
        erros.push('Email inválido');
    }
    if (!validarCNPJ(cnpj)) {
        erros.push('CNPJ inválido');
    }
    if (!validarPais(pais)) {
        erros.push('País inválido');
    }
    if (!validarEstado(estado)) {
        erros.push('Estado inválido');
    }
    if (!validarCEP(cep)) {
        erros.push('CEP inválido');
    }
    if (erros.length > 0) {
        alert('Erros encontrados:\n' + erros.join('\n'));
        return;
    }
    const empresa = {
        id: Date.now(),
        nome: nome,
        email: email,
        cnpj: cnpj,
        pais: pais,
        estado: estado,
        cep: cep,
        descricao: descricao,
        vagas: vetorAuxiliar
    };
    listaEmpresas.push(empresa);
    localStorage.setItem('empresas', JSON.stringify(listaEmpresas));
    alert('Empresa cadastrada com sucesso!');
    formulario.reset();
});
const botaoVoltar = document.getElementById('botao_voltar');
botaoVoltar.onclick = function () {
    window.close();
};
//# sourceMappingURL=cadastro-empresa.js.map