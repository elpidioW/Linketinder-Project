import type { Empresa } from "../../empresa/cadastro/cadastro-empresa";


const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas: Empresa[] = [];
if(localStorageEmpresas){
    listaEmpresas = JSON.parse(localStorageEmpresas);
}


const tabela = document.getElementById('tabelaEmpresas') as HTMLTableElement;
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