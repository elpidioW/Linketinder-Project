const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas = [];
if (localStorageEmpresas) {
    listaEmpresas = JSON.parse(localStorageEmpresas);
}
const tabela = document.getElementById('tabelaEmpresas');
tabela.innerHTML = '';
listaEmpresas.forEach((empresa) => {
    const linha = `
        <tr>
            <td>${empresa.pais}</td>
            <td>${empresa.estado}</td>
            <td>${empresa.descricao}</td>
            <td>${empresa.competencias.join(' | ')}</td>
        </tr>
    `;
    tabela.innerHTML += linha;
});
export {};
//# sourceMappingURL=perfil-candidato.js.map