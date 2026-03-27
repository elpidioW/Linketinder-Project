

export interface Empresa{
    id: number
    nome: string
    //email: string
    cnpj: string
    pais: string
    estado: string
    cep: string
    descricao: string
    competencias: string[]
}


const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas: Empresa[] = [];
if(localStorageEmpresas){
    listaEmpresas = JSON.parse(localStorageEmpresas);
}


const formulario = document.getElementById('formularioCadastroEmpresa') as HTMLFormElement;

let auxID: number = 0;
formulario.addEventListener('submit', function(evento){
    evento.preventDefault();

    //const id: number = auxID++;
    const id: number = Date.now();
    const nome:string = (document.getElementById('nome') as HTMLInputElement).value;
    //const email:string = (document.getElementById('email') as HTMLInputElement).value;
    const cnpj:string = (document.getElementById('cnpj') as HTMLInputElement).value;
    const pais:string = (document.getElementById('pais') as HTMLInputElement).value;
    const estado:string = (document.getElementById('estado') as HTMLInputElement).value;
    const cep:string = (document.getElementById('cep') as HTMLInputElement).value;
    const descricao:string = (document.getElementById('descricao') as HTMLTextAreaElement).value;
    

    
    //Vai pegar todos os checbox com nome competecia e ver se estao marcados
    const checkMarcados = document.querySelectorAll<HTMLInputElement>(
        'input[name="competencia"]:checked'
    );

    const competencias: string[] = [];

    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competencias.push(checkbox.value);
    });

    const empresa: Empresa = {
        //id: id,
        id: Date.now(),
        nome: nome,
        //email: email,
        cnpj: cnpj,
        pais: pais,
        estado: estado,
        cep: cep,
        descricao: descricao,
        competencias: competencias
    }

   listaEmpresas.push(empresa);
   localStorage.setItem('empresas', JSON.stringify(listaEmpresas));

});