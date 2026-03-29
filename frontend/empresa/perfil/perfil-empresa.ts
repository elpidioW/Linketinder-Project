import type { Candidato } from "../../candidato/cadastro/cadastro-candidato";
declare var Chart: any; // Forma mais simples de evitar o erro de new Chart

const localStorageCandidatos = localStorage.getItem('candidatos');
let listaCandidatos: Candidato[] = [];
if(localStorageCandidatos){
    listaCandidatos = JSON.parse(localStorageCandidatos);
}


const tabela = document.getElementById('tabelaCandidatos') as HTMLTableElement;
tabela.innerHTML = '';


const qtdCompetencias: { [key: string]: number } = {}; //Um obj vazio q vai guardar a qtd de competencias no padrão "{python: 3    Java:2}"
listaCandidatos.forEach((candidato) => {

    //Tabela
    const linha = `
        <tr>
            <td>${candidato.estado}</td>
            <td>${candidato.descricao}</td>
            <td>${candidato.competencias.join(' | ')}</td>
        </tr>
    `;
    tabela.innerHTML += linha;
    

    //Gráfico de barras
    candidato.competencias.forEach((competencia) => {
        qtdCompetencias[competencia] = (qtdCompetencias[competencia] || 0) + 1; //Se a competencia tá no obj add 1 || se não tá inicia com 0 e add 1
    });

});

const nomes = Object.keys(qtdCompetencias);
const quantidades = Object.values(qtdCompetencias);


const ctx = document.getElementById('graficoCompetencias') as HTMLCanvasElement;

new Chart(ctx, {
    type: 'bar',
    data: {
        labels: nomes,
        datasets: [{
            label: 'Quantidade de Candidatos por Competência',
            data: quantidades
        }]
    }
});