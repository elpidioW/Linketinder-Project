const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas = [];
if (localStorageEmpresas) {
    listaEmpresas = JSON.parse(localStorageEmpresas);
}
const tabela = document.getElementById('tabelaEmpresas');
tabela.innerHTML = '';
listaEmpresas.forEach((empresa) => {
    empresa.vagas.forEach((vaga) => {
        const linha = `
        <tr>
        <td>${empresa.pais}</td>
        <td>${empresa.estado}</td>
        <td>${empresa.descricao}</td>
        <td>${vaga.titulo}</td>
        <td>${vaga.descricao}</td>
        <td>${vaga.competencias.join(' | ')}</td>
        </tr>
        `;
        tabela.innerHTML += linha;
    });
});
const botaoVoltar = document.getElementById('botao_voltar');
botaoVoltar.onclick = function () {
    window.history.back();
};
export {};
//# sourceMappingURL=perfil-candidato.js.map