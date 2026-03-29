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
    const tituloVaga2 = document.getElementById('tituloVaga2').value;
    const descricaoVaga2 = document.getElementById('descricaoVaga2').value;
    //Vai pegar todos os checbox com nome competeciaVaga2 e ver se estao marcados
    const checkMarcados2 = document.querySelectorAll('input[name="competenciaVaga2"]:checked');
    const competenciasVaga2 = [];
    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competenciasVaga2.push(checkbox.value);
    });
    const vaga2 = {
        id: Date.now(),
        titulo: tituloVaga2,
        descricao: descricaoVaga2,
        competencias: competenciasVaga2
    };
    const empresa = {
        id: Date.now(),
        nome: nome,
        email: email,
        cnpj: cnpj,
        pais: pais,
        estado: estado,
        cep: cep,
        descricao: descricao,
        vagas: [vaga1, vaga2]
    };
    listaEmpresas.push(empresa);
    localStorage.setItem('empresas', JSON.stringify(listaEmpresas));
});
export {};
//# sourceMappingURL=cadastro-empresa.js.map