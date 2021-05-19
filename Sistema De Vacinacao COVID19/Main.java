import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/*

Exception in thread "main" java.lang.NumberFormatException: For input string: ""
    at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.base/java.lang.Integer.parseInt(Integer.java:662)
    at java.base/java.lang.Integer.parseInt(Integer.java:770)
    at Paciente.calculaIdade(Paciente.java:194)
    at Paciente.calculaFaixaEtaria(Paciente.java:168)
    at Paciente.analisaPrioridade(Paciente.java:99)
    at FuncoesPrint.FimCadastroPaciente(FuncoesPrint.java:258)
    at Main.main(Main.java:148)
 * */

public class Main {
	public static void main(String[] args) {

    //String nome_cidadelvacinacao = "";
    //String uf_cidadelvacinacao = " "; 
				
		//Esses hash maps são para linkar as strings digitadas pelo usuario que representa uma instancia a uma verdadeira instancia
		HashMap <String, Cidade> cidades = new HashMap <String, Cidade> ();
		HashMap <String, LocalVacinacao> locaisVacinacao = new HashMap <String, LocalVacinacao> ();
    HashMap <String, ArrayList<Pessoa>> fila = new HashMap <String, ArrayList<Pessoa>> ();
    HashMap <String, Pessoa> PessoasParaVacina= new HashMap <String, Pessoa> ();
    HashMap <String, Ampola > ampolas = new HashMap <String, Ampola> ();
    
		//Esse hash maps são para identificar as instancias de pessoas presentes nos diversos locais
		HashMap <String, ArrayList<Pessoa>> locaisVPacientes= new HashMap <String,ArrayList<Pessoa>> (); 
    
    //Esse hash maps são para identificar as instancias de pessoas presentes nas diversas cidades
		HashMap <String, ArrayList<Pessoa>> pessoasDaCidade= new HashMap <String, ArrayList<Pessoa>> ();
				
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		String res = "";
				
		while(!res.equals("0")) {
      String opcao = "";
      res = FuncoesPrint.PrintMenu();

      switch(res) {
        
        case "0": { // Sair do programa
          FuncoesPrint.FimdoPrograma();
          break;
        }

        case "1": { // Tela de cadastro
				  while(!opcao.equals("0")) {
					  //Chama função pra printar menu
					  opcao = FuncoesPrint.PrintMenuCadastro();
					
            switch(opcao) {

              case "0": { // Sair da tela de cadastro 
                FuncoesPrint.RetornaMenu(opcao);
                break;
              }
							
              case "1": { // Cadastro de cidade 
                FuncoesPrint.MenuCidade();
                System.out.print("| Nome: ");
                String nome_cidade = sc.nextLine().toUpperCase();	  
                System.out.print("| UF: ");
                String uf = sc.nextLine().toUpperCase();
                if (FuncoesPrint.FimCadastroCidade(nome_cidade, uf).equals("0")) {
                  Cidade cidade = new Cidade (nome_cidade, uf);
                  cidades.put(nome_cidade, cidade);
                }
                break;  
              }
              
              case "2": { // Cadastro do Local de Vacinação
                FuncoesPrint.MenuLocalVacinacao();
                System.out.print("| Nome: ");
                String nome_lvacinacao = sc.nextLine().toUpperCase();
                System.out.print("| Horario de Funcionamento: ");
                String horario = sc.nextLine();
                System.out.print("| Cidade: ");
                String cidade = sc.nextLine().toUpperCase();
                if(cidades.containsKey(cidade) == false) {
                  //Chama função para cadrastar uma cidade ainda nao cadastrada, essa função retorna a cidade que logo abaixo vai para a lista de cidades
                  Cidade cidade_lvacinacao = FuncoesCadastramento.CadastroCidade(cidade,cidades);
                  //nome_cidadelvacinacao = cidade_lvacinacao.getNome();
                  //uf_cidadelvacinacao = cidade_lvacinacao.getUF();
                  if ((cidade_lvacinacao.getNome()+"-"+cidade_lvacinacao.getUF()).equals("ERRO-ERRO")){
                    FuncoesPrint.CadastroCancelado();
                    break;
                  }
                  cidades.put(cidade, cidade_lvacinacao);
                }
                //FuncoesPrint.FimcadastroLVacinacao(nome_lvacinacao, horario, estoque_lvacinacao, nome_cidadelvacinacao, uf_cidadelvacinacao);
                LocalVacinacao local = new LocalVacinacao(nome_lvacinacao, horario, cidades.get(cidade));
                cidades.get(cidade).addLocalVacinacao(local);
                locaisVacinacao.put(nome_lvacinacao, local);
                break;
              }
              
              case "3": { // Cadastro de paciente 
                FuncoesPrint.MenuPaciente();
                System.out.print("Nome: "); String nome_paciente = sc.nextLine();
                System.out.print("CPF: "); String cpf = sc.nextLine();
                String dataNascimento = "";
                while (true) {
                	try {
                    	System.out.print("Data nascimento: "); dataNascimento = sc.nextLine();
                    	String teste = dataNascimento.substring(6);
                    	break;
                    } catch(java.lang.StringIndexOutOfBoundsException e) {
                    	System.out.println("Formato de data não aceito. Digite uma data com o seguinte formmato: dd/mm/yyyy");
                    }
                }
                
                
				System.out.print("SUS: "); int sus = sc2.nextInt();
                System.out.print("Cidade: "); String cidade_paciente = sc.nextLine().toUpperCase();
                if(cidades.containsKey(cidade_paciente) == false) {
                  //Chama função para cadrastar uma cidade ainda nao cadastrada, essa função retorna a cidade que logo abaixo vai para a lista de cidades
                  Cidade cidade_lvacinacao = FuncoesCadastramento.CadastroCidade(cidade_paciente,cidades);	
                  cidades.put(cidade_paciente, cidade_lvacinacao);
                }
                System.out.print("Local de Vacinação: "); String localvacinacao = sc.nextLine().toUpperCase();
                if(locaisVacinacao.containsKey(localvacinacao)==false) {
                //Chama função para cadrastar um local de vacinação ainda nao cadastrado, essa função retorna o local de vacinação que logo abaixo vai para a lista de locaisVacinacao
                  LocalVacinacao local = FuncoesCadastramento.CadastroLocalVacinacao(localvacinacao,cidade_paciente);
                  cidades.get(cidade_paciente).addLocalVacinacao(local);
                  locaisVacinacao.put(localvacinacao, local);
                }
                
                System.out.println("Tipo Prioridade: "); 
                int tipoPrioridade = FuncoesPrint.MenuPrioridades();

                Paciente paciente = new Paciente(nome_paciente, cpf, dataNascimento, cidades.get(cidade_paciente), locaisVacinacao.get(localvacinacao),tipoPrioridade, sus);

              (locaisVacinacao.get(localvacinacao)).AdicionarPessoa(paciente);

			          int prioridadeFila = paciente.analisaPrioridade();
			          String prioridade = Integer.toString(prioridadeFila);
			          if (fila.get(prioridade) == null){
			        	  fila.put(prioridade, new ArrayList<Pessoa>()); 
				      	} fila.get(prioridade).add(paciente);

                if (PessoasParaVacina.get(cpf) == null){
				    	  	PessoasParaVacina.put(cpf, paciente); 
					      } 


                //Chama a função para colocar paciente na lista de sua cidade
                pessoasDaCidade = FuncoesCadastramento.PessoasNaCidade(cidade_paciente,paciente);
                System.out.println(pessoasDaCidade);
                //Chama a função para colocar paciente na lista do seu local de vacinação
                locaisVPacientes = FuncoesCadastramento.PessoasNoLocalVacinação(localvacinacao, paciente);
                break;
              }
              
              case "4": { // Cadastro de médico 
                FuncoesPrint.MenuMedico();
                System.out.print("Nome: "); String nome_medico = sc.nextLine();
                System.out.print("CPF: "); String cpf = sc.nextLine();
                System.out.print("Data nascimento: "); String dataNascimento = sc.nextLine();
                System.out.print("CRM: "); int crm = sc2.nextInt();
                System.out.print("Matricula: "); int matricula= sc2.nextInt();
                System.out.print("Senha: "); String senha = sc.nextLine();
                System.out.print("Cidade: "); String cidade_medico = sc.nextLine().toUpperCase();;
                if(cidades.containsKey(cidade_medico) == false) {
                  //Chama função para cadrastar uma cidade ainda nao cadastrada, essa função retorna a cidade que logo abaixo vai para a lista de cidades
                  Cidade cidade = FuncoesCadastramento.CadastroCidade(cidade_medico, cidades);
                  cidades.put(cidade_medico, cidade);
                }

                int tipoPrioridade = 3;
                System.out.print("Local Vacinaçao: "); String localvacinacao = sc.nextLine().toUpperCase();
                if(locaisVacinacao.containsKey(localvacinacao)==false) {
                  //Chama função para cadrastar um local de vacinação ainda nao cadastrado, essa função retorna o local de vacinação que logo abaixo vai para a lista de locaisVacinacao
                  LocalVacinacao local = FuncoesCadastramento.CadastroLocalVacinacao(localvacinacao, cidade_medico);
                  cidades.get(cidade_medico).addLocalVacinacao(local);
                  locaisVacinacao.put(localvacinacao, local);
                }
                      
                Medico medico = new Medico(nome_medico, cpf, dataNascimento, cidades.get(cidade_medico), tipoPrioridade,locaisVacinacao.get(localvacinacao), crm, matricula, senha);

                (locaisVacinacao.get(localvacinacao)).AdicionarPessoa(medico);

                int prioridadeFila = medico.analisaPrioridade();
			          String prioridade = Integer.toString(prioridadeFila);
			          if (fila.get(prioridade) == null){
			        	  fila.put(prioridade, new ArrayList<Pessoa>()); 
				      	} fila.get(prioridade).add(medico);

                if (PessoasParaVacina.get(cpf) == null){
				    	  PessoasParaVacina.put(cpf, medico); 
					      }

                //Chama a função para colocar medico na lista de sua cidade
                pessoasDaCidade = FuncoesCadastramento.PessoasNaCidade(cidade_medico,medico);
                System.out.println(pessoasDaCidade);
                //Chama a função para colocar medico na lista do seu local de vacinação
                locaisVPacientes = FuncoesCadastramento.PessoasNoLocalVacinação(localvacinacao, medico);
                break;
              }
                
              case "5": { // Cadastro de enfermeiro 
                FuncoesPrint.MenuEnfermeiro();
                System.out.print("Nome: "); String nome_enfermeiro = sc.nextLine();
                System.out.print("CPF: "); String cpf = sc.nextLine();
                System.out.print("Data de Nascimento: "); String dataNascimento = sc.nextLine();
								System.out.print("CRE: "); int cre = sc2.nextInt();
                System.out.print("Matricula: "); int matricula= sc2.nextInt();
                System.out.print("Senha: "); String senha = sc.nextLine();
                System.out.print("Cidade: "); String cidade_enfermeiro = sc.nextLine().toUpperCase();
                if(cidades.containsKey(cidade_enfermeiro) == false) {
                  //Chama função para cadrastar uma cidade ainda nao cadastrada, essa função retorna a cidade que logo abaixo vai para a lista de cidades
                  Cidade cidade = FuncoesCadastramento.CadastroCidade(cidade_enfermeiro, cidades);
                  cidades.put(cidade_enfermeiro, cidade);
                }

                int tipoPrioridade = 3;

                System.out.print("Local Vacinaçao: "); String localvacinacao = sc.nextLine().toUpperCase();
                if(locaisVacinacao.containsKey(localvacinacao)==false) {
                  //Chama função para cadrastar um local de vacinação ainda nao cadastrado, essa função retorna o local de vacinação que logo abaixo vai para a lista de locaisVacinacao
                  LocalVacinacao local = FuncoesCadastramento.CadastroLocalVacinacao(localvacinacao, cidade_enfermeiro);
                  cidades.get(cidade_enfermeiro).addLocalVacinacao(local);
                  locaisVacinacao.put(localvacinacao, local);
								}
                      
                Enfermeiro enfermeiro = new Enfermeiro(nome_enfermeiro, cpf, dataNascimento, cidades.get(cidade_enfermeiro), tipoPrioridade, cre, locaisVacinacao.get(localvacinacao), matricula, senha);

                (locaisVacinacao.get(localvacinacao)).AdicionarPessoa(enfermeiro);

                int prioridadeFila = enfermeiro.analisaPrioridade();
			          String prioridade = Integer.toString(prioridadeFila);
			          if (fila.get(prioridade) == null){
			        	  fila.put(prioridade, new ArrayList<Pessoa>()); 
				      	} fila.get(prioridade).add(enfermeiro);

                if (PessoasParaVacina.get(cpf) == null){
				    	  PessoasParaVacina.put(cpf, enfermeiro); 
					      }

                //Chama a função para colocar enfermeiro na lista de sua cidade
                pessoasDaCidade = FuncoesCadastramento.PessoasNaCidade(cidade_enfermeiro,enfermeiro);
                System.out.println(pessoasDaCidade);
                //Chama a função para colocar enfermeiro na lista do seu local de vacinação
                locaisVPacientes = FuncoesCadastramento.PessoasNoLocalVacinação(localvacinacao, enfermeiro);
                break;
              }
                
              case "6":{ // Cadastro de Ampola 
                FuncoesPrint.MenuAmpola();
                System.out.print("Nome de Fabricante: "); String fabricante = sc2.nextLine().toUpperCase();
                System.out.print("Eficacia: "); String eficacia = sc2.nextLine();
                System.out.print("Lote: "); int lote = sc.nextInt();
                System.out.print("Validade: "); String validade = sc2.nextLine();
                System.out.print("Prazo: "); String prazo = sc2.nextLine();

                Ampola ampola = new Ampola(fabricante, eficacia, lote, validade, prazo);
                ampolas.put(fabricante, ampola);
                break;
              }
              default: {
                FuncoesPrint.PrintErro();
              } 
            }
          }
        break;
        }//case "1":

        case "2": { // Tela de atendimento
    					while (!opcao.equals("0")) {
            opcao = FuncoesPrint.PrintMenuAtendimento(); 
						
						switch(opcao) {
							case "0": {
								FuncoesPrint.RetornaMenu(opcao);
								break;
							}
							case "1":{
                FuncoesPrint.printTracos();
                FuncoesPrint.CidadeFormatada("FILA");
                FuncoesPrint.printTracos();
                //System.out.println("Fila:");
								for(int b = 0;b < 10; b++){
									String v = Integer.toString(b);
									if(!(fila.get(v) == null)){
										for(int j = 0;j < fila.get(v).size(); j++) {
											if (fila.get(v).get(j).getStatus() != 0) {
												System.out.println(" "+(fila.get(v)).get(j));
											}
										}
									}
								}
								break;
							}

							case "2": {
                FuncoesPrint.printTracos();
                FuncoesPrint.CidadeFormatada("VACINAÇÃO");
                FuncoesPrint.printTracos();
								System.out.print("| CPF do Paciente: ");
								String cpf = sc.nextLine();
									if(!(PessoasParaVacina.get(cpf) == null)){
										LocalVacinacao local = PessoasParaVacina.get(cpf).getLocalVacinacao();
										if (local.getAmpolas().size() == 0) {
											System.out.println("Local de vacinação desse paciente não tem Ampolas");
										} else {
											if (PessoasParaVacina.get(cpf).getStatus() == 2) {
												PessoasParaVacina.get(cpf).recebeDose(); 
												System.out.println("Pessoa parcialmente imunizada");
											} else if (PessoasParaVacina.get(cpf).getStatus() == 1) {
												PessoasParaVacina.get(cpf).recebeDose(); 
												System.out.println("Pessoa imunizada");
											} else {
												System.out.println("Pessoa já foi vacinada");
												}
											} 
										} else {
											System.out.println("Pessoa não encontrada");
									}
                break;
							}
							default: {
								FuncoesPrint.PrintErro();
							}
						}//switch
          }//while
					break;
        }//case "2":

        case "3": { // Tela de gerenciamento de estoque
					String op = "";
					while (!op.equals("0")) {
            System.out.println("[1] Gerenciar estoque de um local de vacinação");
						System.out.println("[0] Retornar ao menu");
            System.out.print(" Digite a opção: ");
						op = sc.nextLine();

            switch(op) {
							case "0": {
								FuncoesPrint.FimdoPrograma();
								break;
							}
              case "1": {
                System.out.println("\nGerenciamento de estoque\n");

					    	System.out.print("Qual local de vacinação deseja gerenciar? ");
                String nome = sc.nextLine().toUpperCase();

              	if(locaisVacinacao.containsKey(nome)){
									LocalVacinacao local = locaisVacinacao.get(nome);

									System.out.print("\nNúmero de novas ampola: ");
									int numAmpola = sc2.nextInt();
								
									System.out.print("\nO fabricante da ampola que está sendo adicionada: ");
									String fabricante = sc.nextLine().toUpperCase();

									if(ampolas.containsKey(fabricante)){
										local.calculaEstoque(numAmpola, ampolas.get(fabricante));
									} else {
										System.out.println("Fabricante inexistente");
									}
              	} else {
              			System.out.println("\nLOCAL DE VACINAÇÃO INEXISTENTE \n");
									}

              	break;
              }//case1
							
							default: {
								FuncoesPrint.PrintErro();
							}
            }//switch
					}//while
          break;
        }//case "3":

        case "4": { // Tela de vizualização de informações
        	String option = "";
        	while (!option.equals("0")) {
        		System.out.println("[1] Visualizar cidades");
        		System.out.println("[2] Visualizar locais de vacinação");
        		System.out.println("[0] retornar ao menu");
        		System.out.print("\nDigite a opção: ");
        		option = sc.next();
        		switch(option) {
	        		case "1": {
	        			System.out.print("Cidades: \n");
	        			for(String chave : cidades.keySet()) {
	        				Cidade cidade = cidades.get(chave);
	        				System.out.println("\n "+cidade);
	        				System.out.println(" Número total de pessoas: "+cidade.calculaPessoas());
	        				System.out.println(" Número total de pessoas imunizadas: "+cidade.calculaPessoasImunizadas());
	        				System.out.println(" Número total de pessoas parcialmente imunizadas: "+cidade.calculaPessoasParcialmenteImunizadas());
	        				System.out.println(" Número total de pessoas não imunizadas: "+cidade.calculaPessoasNaoImunizadas());
	        			}
	        			break;
	        		}
	        		case "2": {
	        			System.out.print("Locais de vacinação: \n");
	        			for(String chave : locaisVacinacao.keySet()) {
	        				LocalVacinacao local = locaisVacinacao.get(chave);
	        				System.out.println("\n "+local);
	        				System.out.println(" Número total de pessoas: "+local.calculaPessoas());
	        				System.out.println(" Número total de pessoas imunizadas: "+local.calculaPessoasImunizadas());
	        				System.out.println(" Número total de pessoas parcialmente imunizadas: "+local.calculaPessoasParcialmenteImunizadas());
	        				System.out.println(" Número total de pessoas não imunizadas: "+local.calculaPessoasNaoImunizadas());
								}
	        			break;        			
	        		}
	        		case "0": {
	        			FuncoesPrint.FimdoPrograma();
	        			break;
	        		}
	        		default: {
	        			FuncoesPrint.PrintErro();
	        		}
        		} //switch
        	} //while
        	break;
        }//case "4":

        default: {
          FuncoesPrint.PrintErro();
        }
		  }//switch(res)
    }//while(!res.equals("0"))    
  }
}	                                                