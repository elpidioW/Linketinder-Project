package test

import org.example.service.CadastroService
import org.junit.Ignore
import org.junit.jupiter.api.Test

import static org.junit.Assert.*


class cadastroServiceTest{

    def cadastroService;

    @Test
    public void testCadastraCandidatoCerto(){
        cadastroService = new CadastroService();
        cadastroService.cadastrarCandidato("João Silva", "joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
        assertFalse(cadastroService.listaCandidatos.isEmpty())
    }

    @Test
    public void testNaoCadastraUsuarioErrado(){
        cadastroService = new CadastroService();
        try{
            cadastroService.cadastrarCandidato("João Silva", "joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
            cadastroService.cadastrarCandidato("joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
            cadastroService.cadastrarCandidato(12,"joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
            fail()
        }catch(MissingMethodException e){
            assertTrue(true)
        }
    }


    @Test
    public void testCadastraEmpresaCerta(){
        cadastroService = new CadastroService();
        cadastroService.cadastrarCandidato(cadastrarEmpresa("TechNova", "contato@technova.com", "SP", "Brasil", "01000-000", "Empresa de software corporativo", ["Java", "Groovy", "Spring"] as ArrayList<String>, "12.345.678/0001-90"))
        assertFalse(cadastroService.listaCandidatos.isEmpty())
    }

    @Test
    public void testNaoCadastraUsuarioErrado(){
        cadastroService = new CadastroService();
        try{
            cadastroService.cadastrarCandidato("João Silva", "joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
            cadastroService.cadastrarCandidato("joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
            cadastroService.cadastrarCandidato(12,"joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 24);
            fail()
        }catch(MissingMethodException e){
            assertTrue(true)
        }
    }

    @Ignore
    public void testCadastrarEmpresaCerta(){


    }

    //cadastrarEmpresa("TechNova", "contato@technova.com", "SP", "Brasil", "01000-000", "Empresa de software corporativo", ["Java", "Groovy", "Spring"] as ArrayList<String>, "12.345.678/0001-90")
    //


}
