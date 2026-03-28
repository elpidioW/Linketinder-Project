import type { Empresa } from "../../empresa/cadastro/cadastro-empresa";


const localStorageCandidatos = localStorage.getItem('candidatos');
let listaCandidatos: Empresa[] = [];
if(localStorageCandidatos){
    listaCandidatos = JSON.parse(localStorageCandidatos);
}


const tabela = document.getElementById('tabelaCandidatos') as HTMLTableElement;
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