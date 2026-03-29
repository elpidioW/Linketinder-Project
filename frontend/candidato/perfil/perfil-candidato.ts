import type { Empresa } from "../../empresa/cadastro/cadastro-empresa";
import type { Vaga } from "../../empresa/cadastro/cadastro-empresa";



const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas: Empresa[] = [];
if(localStorageEmpresas){
    listaEmpresas = JSON.parse(localStorageEmpresas);
}


const tabela = document.getElementById('tabelaEmpresas') as HTMLTableElement;
tabela.innerHTML = '';


listaEmpresas.forEach((empresa) => {

    empresa.vagas.forEach((vaga: Vaga) => {
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