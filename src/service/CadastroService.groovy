package service

import model.Candidato
import model.Empresa

class CadastroService {

    List<Candidato> listaCandidatos = []
    List<Empresa> listaEmpresas = []


    public void popularBanco(){
        Candidato c1 = new Candidato("João Silva", "joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 28)
        Candidato c2 = new Candidato("Maria Oliveira", "maria@email.com", "RJ", "Brasil", "20000-000", "Desenvolvedora Frontend", new ArrayList<String>(["Angular", "TypeScript", "HTML", "CSS"]), "23456789012", 25)
        Candidato c3 = new Candidato("Carlos Souza", "carlos@email.com", "MG", "Brasil", "30000-000", "Engenheiro de Dados", new ArrayList<String>(["Python", "Pandas", "SQL", "Airflow"]), "34567890123", 30)
        Candidato c4 = new Candidato("Ana Costa", "ana@email.com", "PR", "Brasil", "80000-000", "Desenvolvedora Mobile", new ArrayList<String>(["Kotlin", "Android", "Firebase"]), "45678901234", 27)
        Candidato c5 = new Candidato("Lucas Mendes", "lucas@email.com", "RS", "Brasil", "90000-000", "DevOps Engineer", new ArrayList<String>(["Docker", "Kubernetes", "CI/CD", "AWS"]), "56789012345", 29)

        Empresa emp1 = new Empresa("TechNova", "contato@technova.com", "SP", "Brasil", "01000-000", "Empresa de software corporativo", ["Java", "Groovy", "Spring"] as ArrayList<String>, "12.345.678/0001-90")
        Empresa emp2 = new Empresa("InovaData", "rh@inovadata.com", "RJ", "Brasil", "20000-000", "Consultoria em dados e BI", ["Python", "SQL", "Power BI"] as ArrayList<String>, "23.456.789/0001-10")
        Empresa emp3 = new Empresa("CloudMax", "suporte@cloudmax.com", "MG", "Brasil", "30000-000", "Soluções em cloud computing", ["AWS", "Docker", "Kubernetes"] as ArrayList<String>, "34.567.890/0001-21")
        Empresa emp4 = new Empresa("CyberSecure", "admin@cybersecure.com", "PR", "Brasil", "80000-000", "Segurança da informação", ["Pentest", "LGPD", "Firewall"] as ArrayList<String>, "45.678.901/0001-32")
        Empresa emp5 = new Empresa("DevSolutions", "contato@devsolutions.com", "RS", "Brasil", "90000-000", "Fábrica de software sob demanda", ["React", "Node.js", "Microservices"] as ArrayList<String>, "56.789.012/0001-43")

        listaCandidatos.addAll(c1, c2, c3, c4, c5)
        listaEmpresas.addAll(emp1, emp2, emp3, emp4, emp5)
    }


    public void listarCandidatos(){
        for(c in listaCandidatos){
            c.exibirPerfil()
        }
    }

    public void listarEmpresas(){
        for(c in listaCandidatos){
            c.exibirPerfil()
        }
    }

    /*public void cadastrarCandidato(){

    }

    public void cadastrarEmpresa(){
*/




}
