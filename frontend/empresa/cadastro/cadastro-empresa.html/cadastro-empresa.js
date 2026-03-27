const localStorageEmpresas = localStorage.getItem('empresas');
let listaEmpresas = [];
if (localStorageEmpresas) {
    listaEmpresas = JSON.parse(localStorageEmpresas);
}
const formulario = document.getElementById('formularioCadastroEmpresa');
let auxID = 0;
formulario.addEventListener('submit', function (evento) {
    evento.preventDefault();
    //const id: number = auxID++;
    const id = Date.now();
    const nome = document.getElementById('nome').value;
    //const email:string = (document.getElementById('email') as HTMLInputElement).value;
    const cnpj = document.getElementById('cnpj').value;
    const pais = document.getElementById('pais').value;
    const estado = document.getElementById('estado').value;
    const cep = document.getElementById('cep').value;
    const descricao = document.getElementById('descricao').value;
    //Vai pegar todos os checbox com nome competecia e ver se estao marcados
    const checkMarcados = document.querySelectorAll('input[name="competencia"]:checked');
    const competencias = [];
    //Vai pegar o valor de cada checkbox marcado e adicionar no array competencias
    checkMarcados.forEach((checkbox) => {
        competencias.push(checkbox.value);
    });
    const empresa = {
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
    };
    listaEmpresas.push(empresa);
    localStorage.setItem('empresas', JSON.stringify(listaEmpresas));
});
export {};
//# sourceMappingURL=cadastro-empresa.js.map