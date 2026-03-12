package org.example.service

import org.example.model.Candidato
import org.example.model.Empresa

class CadastroService {

    List<Candidato> listaCandidatos = []
    List<Empresa> listaEmpresas = []
    int idProximoCandidato = 0
    int idProximaEmpresa = 0


    public void popularBanco(){
        cadastrarCandidato("João Silva", "joao@email.com", "SP", "Brasil", "01000-000", "Desenvolvedor Backend Java", new ArrayList<String>(["Java", "Spring", "SQL", "Git"]), "12345678901", 28)
        cadastrarCandidato("Maria Oliveira", "maria@email.com", "RJ", "Brasil", "20000-000", "Desenvolvedora Frontend", new ArrayList<String>(["Angular", "TypeScript", "HTML", "CSS"]), "23456789012", 25)
        cadastrarCandidato("Carlos Souza", "carlos@email.com", "MG", "Brasil", "30000-000", "Engenheiro de Dados", new ArrayList<String>(["Python", "Pandas", "SQL", "Airflow"]), "34567890123", 30)
        cadastrarCandidato("Ana Costa", "ana@email.com", "PR", "Brasil", "80000-000", "Desenvolvedora Mobile", new ArrayList<String>(["Kotlin", "Android", "Firebase"]), "45678901234", 27)
        cadastrarCandidato("Lucas Mendes", "lucas@email.com", "RS", "Brasil", "90000-000", "DevOps Engineer", new ArrayList<String>(["Docker", "Kubernetes", "CI/CD", "AWS"]), "56789012345", 29)

        cadastrarEmpresa("TechNova", "contato@technova.com", "SP", "Brasil", "01000-000", "Empresa de software corporativo", ["Java", "Groovy", "Spring"] as ArrayList<String>, "12.345.678/0001-90")
        cadastrarEmpresa("InovaData", "rh@inovadata.com", "RJ", "Brasil", "20000-000", "Consultoria em dados e BI", ["Python", "SQL", "Power BI"] as ArrayList<String>, "23.456.789/0001-10")
        cadastrarEmpresa("CloudMax", "suporte@cloudmax.com", "MG", "Brasil", "30000-000", "Soluções em cloud computing", ["AWS", "Docker", "Kubernetes"] as ArrayList<String>, "34.567.890/0001-21")
        cadastrarEmpresa("CyberSecure", "admin@cybersecure.com", "PR", "Brasil", "80000-000", "Segurança da informação", ["Pentest", "LGPD", "Firewall"] as ArrayList<String>, "45.678.901/0001-32")
        cadastrarEmpresa("DevSolutions", "contato@devsolutions.com", "RS", "Brasil", "90000-000", "Fábrica de software sob demanda", ["React", "Node.js", "Microservices"] as ArrayList<String>, "56.789.012/0001-43")

    }


    public void listarCandidatos(){
        for(c in listaCandidatos){
            c.exibirPerfil()
            print("\n")
        }
    }

    public void listarEmpresas(){
        for(c in listaEmpresas){
            c.exibirPerfil()
            print("\n")
        }
    }

    public void cadastrarCandidato(String nome, String email, String estado, String pais, String cep, String descricao, ArrayList<String> competencias, String cpf, int idade){
        Candidato candidato = new Candidato(idProximoCandidato, nome, email, estado, pais, cep, descricao, competencias, cpf, idade)
        listaCandidatos.add(candidato)
        idProximoCandidato++
    }

    public void cadastrarEmpresa(String nome, String email, String estado, String pais, String cep, String descricao, ArrayList<String> competencias, String cnpj){
        Empresa empresa = new Empresa(idProximaEmpresa, nome, email, estado, pais, cep, descricao, competencias, cnpj)
        listaEmpresas.add(empresa)
        idProximaEmpresa++
    }


}
