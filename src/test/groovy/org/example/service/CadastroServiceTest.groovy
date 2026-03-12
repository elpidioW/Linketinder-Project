package test

import org.example.service.CadastroService
import org.junit.Ignore
import org.junit.jupiter.api.Test

import static org.junit.Assert.*


class cadastroServiceTest{

    def cadastroService;

    @Test
    public void testCadastrarCandidatoCerto(){
        cadastroService = new CadastroService();

        cadastroService.cadastrarCandidato("João Silva", "joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);

        assertFalse(cadastroService.listaCandidatos.isEmpty())
    }

    @Ignore
    public void testCadastrarUsuarioErrado(){}
    @Ignore
    public void testCadastrarUsuarioCerto(){}

    //cadastrarEmpresa("TechNova", "contato@technova.com", "SP", "Brasil", "01000-000", "Empresa de software corporativo", ["Java", "Groovy", "Spring"] as ArrayList<String>, "12.345.678/0001-90")
    //


}
