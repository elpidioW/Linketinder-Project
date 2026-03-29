
export interface Empresa{
    id: number
    nome: string
    email: string
    cnpj: string
    pais: string
    estado: string
    cep: string
    descricao: string
    vagas: Vaga[]
}

export interface Vaga{
    id: number
    titulo: string
    descricao: string
    competencias: string[]
}


const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas: Empresa[] = [];
if(localStorageEmpresas){
    listaEmpresas = JSON.parse(localStorageEmpresas);
}


const formulario = document.getElementById('formularioCadastroEmpresa') as HTMLFormElement;

formulario.addEventListener('submit', function(evento){
    evento.preventDefault();

    const id: number = Date.now();
    const nome:string = (document.getElementById('nome') as HTMLInputElement).value;
    const email:string = (document.getElementById('email') as HTMLInputElement).value;
    const cnpj:string = (document.getElementById('cnpj') as HTMLInputElement).value;
    const pais:string = (document.getElementById('pais') as HTMLInputElement).value;
    const estado:string = (document.getElementById('estado') as HTMLInputElement).value;
    const cep:string = (document.getElementById('cep') as HTMLInputElement).value;
    const descricao:string = (document.getElementById('descricao') as HTMLTextAreaElement).value;
    

    const tituloVaga1:string = (document.getElementById('tituloVaga1') as HTMLInputElement).value;
    const descricaoVaga1:string = (document.getElementById('descricaoVaga1') as HTMLTextAreaElement).value;
    //Vai pegar todos os checbox com nome competeciaVaga1 e ver se estao marcados
    const checkMarcados = document.querySelectorAll<HTMLInputElement>(
        'input[name="competenciaVaga1"]:checked'
    );
    const competenciasVaga1: string[] = [];

    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competenciasVaga1.push(checkbox.value);
    });

    const vaga1: Vaga = {
    id: Date.now() - 1,
    titulo: tituloVaga1,
    descricao: descricaoVaga1,
    competencias: competenciasVaga1
    };



    const tituloVaga2:string = (document.getElementById('tituloVaga2') as HTMLInputElement).value;
    const descricaoVaga2:string = (document.getElementById('descricaoVaga2') as HTMLTextAreaElement).value;
    //Vai pegar todos os checbox com nome competeciaVaga2 e ver se estao marcados
    const checkMarcados2 = document.querySelectorAll<HTMLInputElement>(
        'input[name="competenciaVaga2"]:checked'
    );
    const competenciasVaga2: string[] = [];

    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competenciasVaga2.push(checkbox.value);
    });
    const vaga2: Vaga = {
    id: Date.now(),
    titulo: tituloVaga2,
    descricao: descricaoVaga2,
    competencias: competenciasVaga2
    };





    const empresa: Empresa = {
        id: Date.now(),
        nome: nome,
        email: email,
        cnpj: cnpj,
        pais: pais,
        estado: estado,
        cep: cep,
        descricao: descricao,
        vagas: [vaga1, vaga2]
    }

   listaEmpresas.push(empresa);
   localStorage.setItem('empresas', JSON.stringify(listaEmpresas));

});




const botaoVoltar = document.getElementById('botao_voltar') as HTMLButtonElement;
botaoVoltar.onclick = function(){
    window.close();
}