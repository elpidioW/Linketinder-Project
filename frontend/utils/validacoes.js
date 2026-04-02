export function testeImportacao() {
    console.log('Teste de importação de funções de validação');
}
//Candidato e Empresa
export function validarNome(nome) {
    const regex = /^[a-zA-ZÀ-ü\s'-]+$/;
    return regex.test(nome);
}
//Candidato e Empresa
export function validarEstado(estado) {
    const regex = /^[a-zA-ZÀ-ü\s'-]+$/;
    return regex.test(estado);
}
//Candidato e Empresa
export function validarEmail(email) {
    const regex = /\S+@\w+\.\w{2,6}(\.\w{2})?/g;
    return regex.test(email);
}
//Candidato
export function validarCPF(cpf) {
    const regex = /^\d{3}\.\d{3}\.\d{3}\-\d{2}$/;
    return regex.test(cpf);
}
//Candidato
export function validarCEP(cep) {
    const regex = /^\d{5}-\d{3}$/;
    return regex.test(cep);
}
//Empresa
export function validarCNPJ(cnpj) {
    const regex = /^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/;
    return regex.test(cnpj);
}
//Empresa
export function validarPais(pais) {
    const regex = /^[a-zA-ZÀ-ü\s'-]+$/;
    return regex.test(pais);
}
//# sourceMappingURL=validacoes.js.map