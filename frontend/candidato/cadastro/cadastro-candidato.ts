

export interface Candidato{
    id: number
    nome: string
    //email: string
    cpf: string
    idade: number
    estado: string
    cep: string
    descricao: string
    competencias: string[]
}


let listaCandidatos: Candidato[] = [];



const formulario = document.getElementById('formularioCadastroUsuario') as HTMLFormElement;

let auxID: number = 0;
formulario.addEventListener('submit', function(evento){
    evento.preventDefault();

    const id: number = auxID++;
    const nome:string = (document.getElementById('nome') as HTMLInputElement).value;
    //const email:string = (document.getElementById('email') as HTMLInputElement).value;
    const cpf:string = (document.getElementById('cpf') as HTMLInputElement).value;
    const idade:number = parseInt((document.getElementById('idade') as HTMLInputElement).value);
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

    const candidato: Candidato = {
        id: id,
        nome: nome,
        //email: email,
        cpf: cpf,
        idade: idade,
        estado: estado,
        cep: cep,
        descricao: descricao,
        competencias: competencias
    }

   listaCandidatos.push(candidato);

   console.log(listaCandidatos); 

});