import {testeImportacao, validarNome, validarEmail, validarCPF, validarEstado, validarCEP} from '../../utils/validacoes.js';


export interface Candidato{
    id: number
    nome: string
    email: string
    cpf: string
    idade: number
    estado: string
    cep: string
    descricao: string
    competencias: string[]
}


const localStorageCandidatos = localStorage.getItem('candidatos');
let listaCandidatos: Candidato[] = [];
if(localStorageCandidatos){
    listaCandidatos = JSON.parse(localStorageCandidatos);
}

const formulario = document.getElementById('formularioCadastroUsuario') as HTMLFormElement;

formulario.addEventListener('submit', function(evento){
    evento.preventDefault();


    const id: number = Date.now();
    const nome:string = (document.getElementById('nome') as HTMLInputElement).value;
    const email:string = (document.getElementById('email') as HTMLInputElement).value;
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


    //Validações e a impressão dos erros
    let erros: string[] = [];
    if(!validarNome(nome)){
        erros.push('Nome inválido');
    }
    if(!validarEmail(email)){
        erros.push('Email inválido');
    }
    if(!validarCPF(cpf)){
        erros.push('CPF inválido');
    }
    if(idade < 18 || idade > 100){
        erros.push('Idade inválida');
    }
    if(!validarEstado(estado)){
        erros.push('Estado inválido');
    }
    if(!validarCEP(cep)){
        erros.push('CEP inválido');
    }
    if(erros.length > 0){
        alert(erros.join('\n'));
        return;
    }



    const candidato: Candidato = {
        id: id,
        nome: nome,
        email: email,
        cpf: cpf,
        idade: idade,
        estado: estado,
        cep: cep,
        descricao: descricao,
        competencias: competencias
    }

   listaCandidatos.push(candidato);
   localStorage.setItem('candidatos', JSON.stringify(listaCandidatos));

    alert('Candidato cadastrado com sucesso!');
    formulario.reset();

});



const botaoVoltar = document.getElementById('botao_voltar') as HTMLButtonElement;
botaoVoltar.onclick = function(){
    window.history.back();
}