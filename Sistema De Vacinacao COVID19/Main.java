import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//Esses hash maps são para linkar as strings digitadas pelo usuario que representa uma instancia a uma verdadeira instancia
		HashMap <String, Cidade> cidades = new HashMap <String, Cidade> ();
		HashMap <String, LocalVacinacao> locaisVacinacao = new HashMap <String, LocalVacinacao> ();
		HashMap <String, Fabricante> fabricantes = new HashMap <String, Fabricante> ();
    

		//Esse hash maps são para identificar as instancias de pessoas presentes nos diversos locais
		HashMap <String, ArrayList<Pessoa>> locaisVPacientes= new HashMap <String,ArrayList<Pessoa>> (); 
	
		//Esse hash maps são para identificar as instancias de pessoas presentes nas diversas cidades
		HashMap <String, ArrayList<Pessoa>> pessoasDaCidade= new HashMap <String, ArrayList<Pessoa>> ();
		

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String opcao = "";
		while(!opcao.equals("0")) {
			System.out.println("\nB E M  V I N D O\n");
			System.out.println("[1] Cadastrar Cidade");
			System.out.println("[2] Cadastrar Local de Vacinação");
			System.out.println("[3] Cadastrar Paciente");
			System.out.println("[4] Cadastrar Medico");
			System.out.println("[5] Cadastrar Enfermeiro");
			System.out.println("[6] Cadastrar Fabricante");
			System.out.println("[7] Cadastrar Ampola");
			System.out.println("[0] Sair");
			System.out.println("\nDigite a opção:");
			opcao = sc.nextLine();


			switch(opcao) {
        case "0": {
          System.out.println("\nPROGRAMA ENCERRADO\n");
          break;
        }
				case "1": {
					System.out.println("\nCADASTRO DE CIDADE\n");
					System.out.println("Nome: "); String nome_cidade = sc.nextLine().toUpperCase();	  
					System.out.println("Uf: "); String uf = sc.nextLine().toUpperCase();
					System.out.println("Numero Total de Pessoas Vacinadas: "); int numpessoasvacinadas = sc2.nextInt();
					System.out.println("Numero do Estoque da Vacina da cidade: "); int estoque_cidade = sc2.nextInt();
					Cidade cidade = new Cidade (nome_cidade, uf, numpessoasvacinadas, estoque_cidade);
					cidades.put(nome_cidade, cidade);
					
					System.out.println(cidades);
					break;  
				}
				
				case "2":{
					System.out.println("\nCADASTRO DE LOCAL DE VACINAÇÃO\n");
					System.out.println("Nome: "); String nome_lvacinacao = sc.nextLine().toUpperCase();
					System.out.println("Horario de funcionamento: "); String horario = sc.nextLine();
					System.out.println("Numero do Estoque da Vacina do local: "); int estoque_lvacinacao = sc2.nextInt();
					System.out.println("Cidade: "); String cidade = sc.nextLine().toUpperCase();
					
					if(cidades.containsKey(cidade) == false) {
						System.out.println("\nESSA CIDADE AINDA NÃO FOI CADASTRADA, É NECESSÁRIO CADASTRÁ-LA.");
						System.out.println("\nCADASTRO DE CIDADE - "+cidade+"\n");
            String nome_cidadelv = cidade;
						//System.out.println("Nome: "); String nome_cidadelv = sc.nextLine().toUpperCase();	  
						System.out.println("Uf: "); String uf = sc.nextLine().toUpperCase();
						System.out.println("Numero Total de Pessoas Vacinadas: "); int numpessoasvacinadas = sc2.nextInt();
						System.out.println("Numero do Estoque da Vacina da cidade: "); int estoque_cidadelv = sc2.nextInt();
							
						Cidade cidade_lvacinacao = new Cidade (nome_cidadelv,uf,numpessoasvacinadas,estoque_cidadelv);
						cidades.put(nome_cidadelv, cidade_lvacinacao);

					}

          LocalVacinacao local = new LocalVacinacao(nome_lvacinacao, horario, estoque_lvacinacao, cidades.get(cidade));
          locaisVacinacao.put(nome_lvacinacao, local);
					
					System.out.println(locaisVacinacao);
					System.out.println(cidades);
					break;
				}
				
				case "3":{
					System.out.println("\nCADASTRO DE PACIENTE\n");
					System.out.println("Nome: "); String nome_paciente = sc.nextLine();
					System.out.println("cpf: "); String cpf = sc.nextLine();
					System.out.println("Data nascimento: "); String dataNascimento = sc.nextLine();
					System.out.println("Cidade: "); String cidade_paciente = sc.nextLine().toUpperCase();

          if(cidades.containsKey(cidade_paciente) == false) {
						System.out.println("\nESSA CIDADE AINDA NÃO FOI CADASTRADA, É NECESSÁRIO CADASTRÁ-LA.");

            System.out.println("\nCADASTRO DE CIDADE - "+cidade_paciente+"\n");
            String nome_cidade = cidade_paciente;
						System.out.println("UF: "); String uf = sc.nextLine().toUpperCase();
						System.out.println("Numero Total de Pessoas Vacinadas: "); int numpessoasvacinadas = sc2.nextInt();
						System.out.println("Numero do Estoque da Vacina da cidade: "); int estoque_cidade = sc2.nextInt();
							
						Cidade cidade = new Cidade (nome_cidade, uf, numpessoasvacinadas, estoque_cidade);
						cidades.put(nome_cidade, cidade);
            System.out.println("\nFIM DO CADASTRO DE CIDADE -"+cidade_paciente+"\n");
           
 
          }
          System.out.println(cidades);
          
					System.out.println("Local de Vacinação: "); String localvacinacao = sc.nextLine().toUpperCase();

          if(locaisVacinacao.containsKey(localvacinacao)==false) {
            System.out.println("\nESSE LOCAL DE VACINAÇÃO AINDA NÃO FOI CADASTRADO, É NECESSÁRIO CADASTRÁ-LO.");

            System.out.println("\nCADASTRO DE LOCAL DE VACINAÇÃO - "+localvacinacao+"\n");
            String nome_lvacinacao = localvacinacao;
					  System.out.println("Horario de funcionamento: "); String horario = sc.nextLine();
					  System.out.println("Numero do Estoque da Vacina do local: "); int estoque_lvacinacao = sc2.nextInt();
            
            LocalVacinacao local = new LocalVacinacao(nome_lvacinacao, horario, estoque_lvacinacao, cidades.get(cidade_paciente));
            locaisVacinacao.put(nome_lvacinacao, local);

            System.out.println("\nFIM DO CADASTRO DE LOCAL DE VACINAÇÃO - "+localvacinacao+"\n");
          }
          System.out.println(locaisVacinacao);
					System.out.println(cidades);
          
          System.out.println("Tipo Prioridade: "); int tipoPrioridade = sc2.nextInt();
          //implementar codigo que calcula prioridade automaticamente :)
      
					System.out.println("SUS: "); int sus = sc2.nextInt();
					
					Paciente paciente = new Paciente(nome_paciente, cpf, dataNascimento, cidades.get(cidade_paciente), locaisVacinacao.get(localvacinacao),tipoPrioridade, sus);

          //Condição feita para colocar paciente dentro da sua cidade na lista de cidades
					if (pessoasDaCidade.get(cidade_paciente) == null){
						pessoasDaCidade.put(cidade_paciente, new ArrayList<Pessoa>()); 
					} pessoasDaCidade.get(cidade_paciente).add(paciente);
					System.out.println(pessoasDaCidade);
          //Condição feita para colocar paciente dentro do seu local de vacinação na lista de locaisvacinacao
					if (locaisVPacientes.get(localvacinacao) == null){
						locaisVPacientes.put(localvacinacao, new ArrayList<Pessoa>()); 
					} locaisVPacientes.get(localvacinacao).add(paciente);
					System.out.println(locaisVPacientes);
					break;
				}
				
				case "4":{
					System.out.println("\nCADASTRO DE MEDICO\n");
					System.out.println("Nome: "); String nome_medico = sc.nextLine();
					System.out.println("cpf: "); String cpf = sc.nextLine();
					System.out.println("Data nascimento: "); String dataNascimento = sc.nextLine();
					System.out.println("Cidade: "); String cidade_medico = sc.nextLine().toUpperCase();;

          if(cidades.containsKey(cidade_medico) == false) {
						System.out.println("\nESSA CIDADE AINDA NÃO FOI CADASTRADA, É NECESSÁRIO CADASTRÁ-LA.");

            System.out.println("\nCADASTRO DE CIDADE - "+cidade_medico+"\n");
            String nome_cidade = cidade_medico;
						System.out.println("Uf: "); String uf = sc.nextLine().toUpperCase();
						System.out.println("Numero Total de Pessoas Vacinadas: "); int numpessoasvacinadas = sc2.nextInt();
						System.out.println("Numero do Estoque da Vacina da cidade: "); int estoque_cidade = sc2.nextInt();
							
						Cidade cidade = new Cidade (nome_cidade, uf, numpessoasvacinadas, estoque_cidade);
						cidades.put(nome_cidade, cidade);

            System.out.println("\nFIM CADASTRO DE CIDADE - "+cidade_medico+"\n");
           
          }

					System.out.println("Tipo Prioridade: "); int tipoPrioridade = sc2.nextInt();
          //implementar codigo para calcular prioridade automaticamente :)
          
					System.out.println("CRM: "); int crm = sc2.nextInt();
					System.out.println("Local Vacinaçao: "); String localvacinacao = sc.nextLine().toUpperCase();

          if(locaisVacinacao.containsKey(localvacinacao)==false) {
            System.out.println("\nESSE LOCAL DE VACINAÇÃO AINDA NÃO FOI CADASTRADO, É NECESSÁRIO CADASTRÁ-LO.");

            System.out.println("\nCADASTRO DE LOCAL DE VACINAÇÃO - "+localvacinacao+"\n");
            String nome_lvacinacao = localvacinacao;
					  System.out.println("Horario de funcionamento: "); String horario = sc.nextLine();
					  System.out.println("Numero do Estoque da Vacina do local: "); int estoque_lvacinacao = sc2.nextInt();
            
            LocalVacinacao local = new LocalVacinacao(nome_lvacinacao, horario, estoque_lvacinacao, cidades.get(cidade_medico));
            locaisVacinacao.put(nome_lvacinacao, local);

            System.out.println("\nFIM DO CADASTRO DE LOCAL DE VACINAÇÃO - "+localvacinacao+"\n");
          }
          
					System.out.println("Matricula: "); int matricula= sc2.nextInt();
					System.out.println("Senha: "); String senha = sc.nextLine();
					
					Medico medico = new Medico(nome_medico, cpf, dataNascimento, cidades.get(cidade_medico), tipoPrioridade,locaisVacinacao.get(localvacinacao), crm, matricula, senha);

          //Condição feita para colocar medico dentro da sua cidade na lista de cidades
					if (pessoasDaCidade.get(cidade_medico) == null){
						pessoasDaCidade.put(cidade_medico, new ArrayList<Pessoa>()); 
					} pessoasDaCidade.get(cidade_medico).add(medico);
          	System.out.println(pessoasDaCidade);
          //Condição feita para colocar medico dentro do seu local de vacinação na lista de locaisvacinacao
          if (locaisVPacientes.get(localvacinacao) == null){
						locaisVPacientes.put(localvacinacao, new ArrayList<Pessoa>()); 
					} locaisVPacientes.get(localvacinacao).add(medico);
            System.out.println(locaisVPacientes);
					break;
				}
				
				case "5":{
					System.out.println("\nCADASTRO DE ENFERMEIRO\n");
					System.out.println("Nome: "); String nome_enfermeiro = sc.nextLine();
					System.out.println("cpf: "); String cpf = sc.nextLine();
					System.out.println("Data nascimento: "); String dataNascimento = sc.nextLine();
					System.out.println("Cidade: "); String cidade_enfermeiro = sc.nextLine().toUpperCase();

          if(cidades.containsKey(cidade_enfermeiro) == false) {
						System.out.println("\nESSA CIDADE AINDA NÃO FOI CADASTRADA, É NECESSÁRIO CADASTRÁ-LA.");
            
            System.out.println("\nCADASTRO DE CIDADE - "+cidade_enfermeiro+"\n");
            String nome_cidade = cidade_enfermeiro;
						
						System.out.println("Uf: "); String uf = sc.nextLine().toUpperCase();
						System.out.println("Numero Total de Pessoas Vacinadas: "); int numpessoasvacinadas = sc2.nextInt();
						System.out.println("Numero do Estoque da Vacina da cidade: "); int estoque_cidade = sc2.nextInt();
							
						Cidade cidade = new Cidade (nome_cidade, uf, numpessoasvacinadas, estoque_cidade);
						cidades.put(nome_cidade, cidade);

            System.out.println("\nFIM DO CADASTRO DE CIDADE - "+cidade_enfermeiro+"\n");
          }

					System.out.println("Tipo Prioridade: "); int tipoPrioridade = sc2.nextInt();

          //implementar codigo para calcular prioridade automaticamente :)

					System.out.println("CRE: "); int cre = sc2.nextInt();
					System.out.println("Local Vacinaçao: "); String localvacinacao = sc.nextLine().toUpperCase();

          if(locaisVacinacao.containsKey(localvacinacao)==false) {
            System.out.println("\nESSE LOCAL DE VACINAÇÃO AINDA NÃO FOI CADASTRADO, É NECESSÁRIO CADASTRÁ-LO.");
            
            System.out.println("\nCADASTRO DE LOCAL DE VACINAÇÃO - "+localvacinacao+"\n");
            String nome_lvacinacao = localvacinacao;
					  System.out.println("Horario de funcionamento: "); String horario = sc.nextLine();
					  System.out.println("Numero do Estoque da Vacina do local: "); int estoque_lvacinacao = sc2.nextInt();
            
            LocalVacinacao local = new LocalVacinacao(nome_lvacinacao, horario, estoque_lvacinacao, cidades.get(cidade_enfermeiro));
            locaisVacinacao.put(nome_lvacinacao, local);

            System.out.println("\nFIM DO CADASTRO DE LOCAL DE VACINAÇÃO - "+localvacinacao+"\n");
          }

					System.out.println("Matricula: "); int matricula= sc2.nextInt();
					System.out.println("Senha: "); String senha = sc.nextLine();
					
					Enfermeiro enfermeiro = new Enfermeiro(nome_enfermeiro, cpf, dataNascimento, cidades.get(cidade_enfermeiro), tipoPrioridade, cre, locaisVacinacao.get(localvacinacao), matricula, senha);

          //Condição feita para colocar enfermeiro dentro da sua cidade na lista de cidades
					if (pessoasDaCidade.get(cidade_enfermeiro) == null){
						pessoasDaCidade.put(cidade_enfermeiro, new ArrayList<Pessoa>()); 
					} pessoasDaCidade.get(cidade_enfermeiro).add(enfermeiro);
           System.out.println(pessoasDaCidade);
          //Condição feita para colocar enfermeiro dentro do seu local de vacinação na lista de locaisvacinacao
          if (locaisVPacientes.get(localvacinacao) == null){
						locaisVPacientes.put(localvacinacao, new ArrayList<Pessoa>()); 
					} locaisVPacientes.get(localvacinacao).add(enfermeiro);
            System.out.println(locaisVPacientes);
					break;
				}
				
				case "6":{
					System.out.println("\nCADASTRO DE FABRICANTE\n");
					System.out.println("Nome: "); String nome = sc.nextLine().toUpperCase();
					System.out.println("Eficacia: "); double eficacia = sc2.nextDouble();
					Fabricante fabricante = new Fabricante(eficacia,nome);
					fabricantes.put(nome,fabricante);
					break;
				}
				
				case "7":{
					System.out.println("\nCADASTRO DA AMPOLA\n");
					System.out.println("Lote: "); int lote = sc2.nextInt();
					System.out.println("Validade: "); String validade = sc.nextLine();
					System.out.println("Prazo: "); String prazo = sc.nextLine();
					System.out.println("Fabricante: "); String fabricante_Ampola= sc.nextLine().toUpperCase();

          if(fabricantes.containsKey(fabricante_Ampola) == false) {
						System.out.println("\nESSE FABRICANTE AINDA NÃO FOI CADASTRADO, É NECESSÁRIO CADASTRÁ-LO.");
            
            System.out.println("\nCADASTRO DE FABRICANTE - "+fabricante_Ampola+"\n");
            String nome_fabricante = fabricante_Ampola;
						
						System.out.println("Eficacia: "); double eficacia = sc2.nextDouble();
						
						Fabricante fabricante = new Fabricante (eficacia, nome_fabricante);
						fabricantes.put(nome_fabricante, fabricante);

            System.out.println("\nFIM DO CADASTRO DE FABRICANTE - "+fabricante_Ampola+"\n");
          }
					Ampola ampola = new Ampola(lote, validade, prazo, fabricantes.get(fabricante_Ampola));
          System.out.println(fabricantes);
					break;
				}

        default: {
          System.out.println("Opção invalida! Digite novamente.");
        } 
			}
		}
    
	}
}