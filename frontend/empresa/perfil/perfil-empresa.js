const localStorageCandidatos = localStorage.getItem('candidatos');
let listaCandidatos = [];
if (localStorageCandidatos) {
    listaCandidatos = JSON.parse(localStorageCandidatos);
}
const tabela = document.getElementById('tabelaCandidatos');
tabela.innerHTML = '';
listaCandidatos.forEach((candidato) => {
    const linha = `
        <tr>
            <td>${candidato.estado}</td>
            <td>${candidato.descricao}</td>
            <td>${candidato.competencias.join(' | ')}</td>
        </tr>
    `;
    tabela.innerHTML += linha;
});
export {};
//# sourceMappingURL=perfil-empresa.js.map