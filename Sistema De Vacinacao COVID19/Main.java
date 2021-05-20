import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// Esses hash maps s�o para armazenar as instancias criadas durante a execu��o do programa
		// As Strings dessa HashMap faz refer�ncia �s intancias de acordo com o que foi digitado pelo usu�rio
		HashMap <String, Cidade> cidades = new HashMap <String, Cidade> ();
		HashMap <String, LocalVacinacao> locaisVacinacao = new HashMap <String, LocalVacinacao> ();
		HashMap <String, Pessoa> PessoasParaVacina= new HashMap <String, Pessoa> ();
		HashMap <String, Ampola > ampolas = new HashMap <String, Ampola> ();
		
		// As Strings dessa HashMap faz refer�ncia aos ArrayLists de pessoas de acordo com as 8 prioridades
		HashMap <String, ArrayList<Pessoa>> fila = new HashMap <String, ArrayList<Pessoa>> ();
		
		// As Strings dessa HashMap faz refer�ncia aos ArrayLists de pessoas de acordo com o local de vacina��o
		HashMap <String, ArrayList<Pessoa>> locaisVPacientes= new HashMap <String,ArrayList<Pessoa>> ();
		
		// As Strings dessa HashMap faz refer�ncia aos ArrayLists de pessoas de acordo com sua cidade
		HashMap <String, ArrayList<Pessoa>> pessoasDaCidade= new HashMap <String, ArrayList<Pessoa>> ();
		
		// Esse hashmap serve para armazenar as matr�culas e senhas dos m�dicos e enfermeiros
		HashMap <String, String> acesso = new HashMap <String, String> ();
		
		// Verificadores que servem para salvar o registro no final de cada cadastro
		String verificador1 = "";
		String verificador2 = "";
		
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
						//Chama fun��o pra printar menu
						opcao = FuncoesPrint.PrintMenuCadastro();
						
						switch(opcao) {
							case "0": { // Sair da tela de cadastro
								FuncoesPrint.RetornaMenu(opcao);
								break;
							}
							case "1": { // Cadastro de cidade
								FuncoesPrint.MenuCidade();
								System.out.print("| Nome: "); String nome_cidade = sc.nextLine().toUpperCase();
								System.out.print("| UF: "); String uf = sc.nextLine().toUpperCase();
								if (FuncoesPrint.FimCadastroCidade(nome_cidade, uf).equals("0")) {
									// Cria a nova inst�ncia de Cidade
									Cidade cidade = new Cidade (nome_cidade, uf);
									// Armazena a cidade cadastrada na hashMap
									cidades.put(nome_cidade, cidade);
								}
								break;
							}
							
							case "2": { // Cadastro do Local de Vacina��o
								FuncoesPrint.MenuLocalVacinacao(); 
								System.out.print("| Nome: "); String nome_lvacinacao = sc.nextLine().toUpperCase();
								System.out.print("| Hor�rio de Funcionamento: "); String horario = sc.nextLine();
								System.out.print("| Cidade: "); String cidade = sc.nextLine().toUpperCase();
								
								// Se a cidade informada n�o existir
								if(cidades.containsKey(cidade) == false) {
									//Chama fun��o para cadrastar uma cidade ainda nao cadastrada, essa fun��o retorna a cidade que logo abaixo vai para a lista de cidades
									Cidade cidade_lvacinacao = FuncoesCadastramento.CadastroCidade(cidade,cidades);
									verificador1 = cidade_lvacinacao.getNome();
									verificador2 = cidade_lvacinacao.getUF();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
										FuncoesPrint.CadastroCancelado();
										break;
									}
									// Armazena a cidade cadastrada na hashMap
									cidades.put(cidade, cidade_lvacinacao);
								}
								verificador1 =  (cidades.get(cidade)).getNome();
								verificador2 = (cidades.get(cidade)).getUF();
								
								// Cria a nova inst�ncia de LocalVacinacao
								LocalVacinacao local = new LocalVacinacao(nome_lvacinacao, horario, cidades.get(cidade));
								
								String continuar = FuncoesPrint.FimCadastroLVacinacao(nome_lvacinacao, horario, verificador1, verificador2);
								if (continuar.equals("1")) {
									break;
								}
								
								// Armazena o local de vacina��o na cidade
								cidades.get(cidade).addLocalVacinacao(local);
								
								// Armazena o local de vacina��o cadastrada na hashMap
								locaisVacinacao.put(nome_lvacinacao, local);
								break;
							}
							
							case "3": { // Cadastro de paciente 
								FuncoesPrint.MenuPaciente();
								System.out.print("| Nome: "); String nome_paciente = sc.nextLine();
								System.out.print("| CPF: "); String cpf = sc.nextLine();
								
								// Esse bloco de c�digo vai analisar a data de nascimento informada pelo usu�rio
								String dataNascimento = "";
								int verificador = 0;
								while (true) {
									try {
										System.out.print("| Data de Nascimento (DD/MM/AAAA): "); dataNascimento = sc.nextLine();
										if (dataNascimento.length() != 9){
											for (int i = 0; i < dataNascimento.length(); i++) {
												if ("/0123456789".contains(Character.toString(dataNascimento.charAt(i)))) {
													verificador++;
												}
											}
										}
										if (verificador < 10) {
											boolean erro = true;
											if (erro) {
												// Exception criada para o pr�prio programa
												throw new DateErrorException();
											}
										} else {
											break;
										}
									} catch(DateErrorException e) {
										FuncoesPrint.printTracos();
										System.err.println(e.toString());
										FuncoesPrint.printTracos();
									}
								}
								System.out.print("| SUS: "); int sus = sc2.nextInt();
								System.out.print("| Cidade: "); String cidade_paciente = sc.nextLine().toUpperCase();
								
								// Se a cidade informada n�o existir
								if(cidades.containsKey(cidade_paciente) == false) {
									//Chama fun��o para cadrastar uma cidade ainda nao cadastrada, essa fun��o retorna a cidade que logo abaixo vai para a lista de cidades
									Cidade cidade_lvacinacao = FuncoesCadastramento.CadastroCidade(cidade_paciente,cidades);
									verificador1 = cidade_lvacinacao.getNome();
									verificador2 = cidade_lvacinacao.getUF();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
										FuncoesPrint.CadastroCancelado();
										break;
									}
									// Armazena a cidade cadastrada na hashMap
									cidades.put(cidade_paciente, cidade_lvacinacao);
								}
								
								System.out.print("| Local de Vacina��o: ");
								String localvacinacao = sc.nextLine().toUpperCase();
								
								// Se o local de vacina��o informado n�o existir
								if(locaisVacinacao.containsKey(localvacinacao)==false) {
									//Chama fun��o para cadrastar um local de vacina��o ainda nao cadastrado, essa fun��o retorna o local de vacina��o que logo abaixo vai para a lista de locaisVacinacao
									LocalVacinacao local = FuncoesCadastramento.CadastroLocalVacinacao(localvacinacao,cidade_paciente, verificador1, verificador2);
									verificador1 = local.getNome();
									verificador2 = local.getHorarioAtendimento();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
										FuncoesPrint.CadastroCancelado();
										break;
									}
									// Armazena o local de vacina��o na cidade
									cidades.get(cidade_paciente).addLocalVacinacao(local);
									// Armazena o local de vacina��o cadastrada na hashMap
									locaisVacinacao.put(localvacinacao, local);
								}
								
								int tipoPrioridade = FuncoesPrint.MenuPrioridades();
								
								// Cria a nova inst�ncia de local de vacina��o
								Paciente paciente = new Paciente(nome_paciente, cpf, dataNascimento, cidades.get(cidade_paciente), locaisVacinacao.get(localvacinacao),tipoPrioridade, sus);
								FuncoesPrint.FimCadastroPaciente(paciente, cidades.get(cidade_paciente), locaisVacinacao.get(localvacinacao));
								verificador1 = paciente.getNome();
								verificador2 = paciente.getCpf();
								if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
									FuncoesPrint.CadastroCancelado();
									break;
								} else {
									
									// Armazena o paciente na lista de pessoas do seu Local de vacina��o
									(locaisVacinacao.get(localvacinacao)).AdicionarPessoa(paciente);
									// Chama o m�todo para analisar a prioridade da fila do qual o paciente pertence
									int prioridadeFila = paciente.analisaPrioridade();
									
									// Bloco de c�digo que adiciona as pessoas na fila de acordo com sua prioridade
									String prioridade = Integer.toString(prioridadeFila);
									if (fila.get(prioridade) == null){
										fila.put(prioridade, new ArrayList<Pessoa>());
									}
									fila.get(prioridade).add(paciente);
									if (PessoasParaVacina.get(cpf) == null) {
										PessoasParaVacina.put(cpf, paciente);
									}
									
									//Chama a fun��o para colocar paciente na lista de sua cidade
									pessoasDaCidade = FuncoesCadastramento.PessoasNaCidade(cidade_paciente,paciente);
									//Chama a fun��o para colocar paciente na lista do seu local de vacina��o
									locaisVPacientes = FuncoesCadastramento.PessoasNoLocalVacina��o(localvacinacao, paciente);
								}
								break;
							}
							
							case "4": { // Cadastro de m�dico
								FuncoesPrint.MenuMedico();
								System.out.print("| Nome: "); String nome_medico = sc.nextLine();
								System.out.print("| CPF: "); String cpf = sc.nextLine();
								
								// Esse bloco de c�digo vai analisar a data de nascimento informada pelo usu�rio
								String dataNascimento = "";
								int verificador = 0;
								while (true) {
									try {
										System.out.print("| Data de Nascimento (DD/MM/AAAA): "); dataNascimento = sc.nextLine();
										if (dataNascimento.length() != 9){
											for (int i = 0; i < dataNascimento.length(); i++) {
												if ("/0123456789".contains(Character.toString(dataNascimento.charAt(i)))) {
													verificador++;
												}
											}
										}
										if (verificador < 10) {
											boolean erro = true;
											if (erro) {
												// Exception criada para o pr�prio programa
												throw new DateErrorException();
											}
										} else {
											break;
										}
									} catch(DateErrorException e) {
										FuncoesPrint.printTracos();
										System.err.println(e.toString());
										FuncoesPrint.printTracos();
									}
								}
								
								System.out.print("| CRM: "); int crm = sc2.nextInt();
								System.out.print("| Matricula: "); int matricula= sc2.nextInt();
								System.out.print("| Senha: "); String senha = sc.nextLine();
								System.out.print("| Cidade: "); String cidade_medico = sc.nextLine().toUpperCase();
								
								// Se a cidade informada n�o existir
								if(cidades.containsKey(cidade_medico) == false) {
									//Chama fun��o para cadrastar uma cidade ainda nao cadastrada, essa fun��o retorna a cidade que logo abaixo vai para a lista de cidades
									Cidade cidade = FuncoesCadastramento.CadastroCidade(cidade_medico, cidades);
									verificador1 = cidade.getNome();
									verificador2 = cidade.getUF();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
										FuncoesPrint.CadastroCancelado();
										break;
									}
									
									// Armazena a cidade cadastrada na hashMap
									cidades.put(cidade_medico, cidade);
								}
								// M�dico � um profissional de sa�de e por isso o tipoPrioridade � igual a 3
								int tipoPrioridade = 3;
								
								System.out.print("| Local de Vacina��o: ");
								String localvacinacao = sc.nextLine().toUpperCase();
								// Se o local de vacina��o n�o existir
								if(locaisVacinacao.containsKey(localvacinacao)==false) {
									//Chama fun��o para cadrastar um local de vacina��o ainda nao cadastrado, essa fun��o retorna o local de vacina��o que logo abaixo vai para a lista de locaisVacinacao
									LocalVacinacao local = FuncoesCadastramento.CadastroLocalVacinacao(localvacinacao, cidade_medico, verificador1, verificador2);
									verificador1 = local.getNome();
									verificador2 = local.getHorarioAtendimento();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
										FuncoesPrint.CadastroCancelado();
										break;
									}
									// Armazena o local de vacina��o na cidade
									cidades.get(cidade_medico).addLocalVacinacao(local);
									// Armazena o local de vacina��o cadastrada na hashMap
									locaisVacinacao.put(localvacinacao, local);
								}
								
								// Cria a nova inst�ncia de M�dico
								Medico medico = new Medico(nome_medico, cpf, dataNascimento, cidades.get(cidade_medico), tipoPrioridade,locaisVacinacao.get(localvacinacao), crm, matricula, senha);
								String matriculaString = Integer.toString(matricula);
								// Adiciona o acesso desse m�dico
								acesso.put(matriculaString, senha);
								FuncoesPrint.FimCadastroMedico(medico, cidades.get(cidade_medico), locaisVacinacao.get(localvacinacao));
								verificador1 = medico.getNome();
								verificador2 = medico.getCpf();
								if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
									FuncoesPrint.CadastroCancelado();
									break;
								} else {
									
									// Armazena o medico na lista de pessoas do seu Local de vacina��o
									(locaisVacinacao.get(localvacinacao)).AdicionarPessoa(medico);
									// Chama o m�todo para analisar a prioridade da fila do qual o medico pertence
									int prioridadeFila = medico.analisaPrioridade();
									
									// Bloco de c�digo que adiciona as pessoas na fila de acordo com sua prioridade
									String prioridade = Integer.toString(prioridadeFila);
									if (fila.get(prioridade) == null){
										fila.put(prioridade, new ArrayList<Pessoa>());
									}
									fila.get(prioridade).add(medico);
									if (PessoasParaVacina.get(cpf) == null){
										PessoasParaVacina.put(cpf, medico);
									}
									
									//Chama a fun��o para colocar medico na lista de sua cidade
									pessoasDaCidade = FuncoesCadastramento.PessoasNaCidade(cidade_medico,medico);
									//Chama a fun��o para colocar medico na lista do seu local de vacina��o
									locaisVPacientes = FuncoesCadastramento.PessoasNoLocalVacina��o(localvacinacao, medico);
								}
								break;
							}
							
							case "5": { // Cadastro de enfermeiro
								FuncoesPrint.MenuEnfermeiro();
								System.out.print("| Nome: "); String nome_enfermeiro = sc.nextLine();
								System.out.print("| CPF: "); String cpf = sc.nextLine();
								
								// Esse bloco de c�digo vai analisar a data de nascimento informada pelo usu�rio
								String dataNascimento = "";
								int verificador = 0;
								while (true) {
									try {
										System.out.print("| Data de Nascimento (DD/MM/AAAA): "); dataNascimento = sc.nextLine();
										if (dataNascimento.length() != 9){
											for (int i = 0; i < dataNascimento.length(); i++) {
												if ("/0123456789".contains(Character.toString(dataNascimento.charAt(i)))) {
													verificador++;
												}
											}
										}
										if (verificador < 10) {
											boolean erro = true;
											if (erro) {
												// Exception criada para o pr�prio programa
												throw new DateErrorException();
											}
										} else {
											break;
										}
									} catch(DateErrorException e) {
										FuncoesPrint.printTracos();
										System.err.println(e.toString());
										FuncoesPrint.printTracos();
									}
								}
								
								System.out.print("| CRE: "); int cre = sc2.nextInt();
								System.out.print("| Matr�cula: "); int matricula= sc2.nextInt();
								System.out.print("| Senha: "); String senha = sc.nextLine();
								System.out.print("| Cidade: "); String cidade_enfermeiro = sc.nextLine().toUpperCase();
								
								// Se a cidade informada n�o existir
								if(cidades.containsKey(cidade_enfermeiro) == false) {
									//Chama fun��o para cadrastar uma cidade ainda nao cadastrada, essa fun��o retorna a cidade que logo abaixo vai para a lista de cidades
									Cidade cidade = FuncoesCadastramento.CadastroCidade(cidade_enfermeiro, cidades);
									verificador1 = cidade.getNome();
									verificador2 = cidade.getUF();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")) {
										FuncoesPrint.CadastroCancelado();
										break;
									}
									
									// Armazena a cidade cadastrada na hashMap
									cidades.put(cidade_enfermeiro, cidade);
								}
								// Enfermeiro � um profissional de sa�de e por isso o tipoPrioridade � igual a 3
								int tipoPrioridade = 3;
								
								System.out.print("| Local de Vacina��o: "); String localvacinacao = sc.nextLine().toUpperCase();
								// Se o local de vacina��o informado n�o existir
								if(locaisVacinacao.containsKey(localvacinacao)==false) {
									//Chama fun��o para cadrastar um local de vacina��o ainda nao cadastrado, essa fun��o retorna o local de vacina��o que logo abaixo vai para a lista de locaisVacinacao
									LocalVacinacao local = FuncoesCadastramento.CadastroLocalVacinacao(localvacinacao, cidade_enfermeiro, verificador1, verificador2);
									verificador1 = local.getNome();
									verificador2 = local.getHorarioAtendimento();
									if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
										FuncoesPrint.CadastroCancelado();
										break;
									}									
									// Armazena o local de vacina��o na cidade
									cidades.get(cidade_enfermeiro).addLocalVacinacao(local);
									// Armazena o local de vacina��o cadastrada na hashMap
									locaisVacinacao.put(localvacinacao, local);
								}
								
								// Cria a nova int�ncia de enfermeiro
								Enfermeiro enfermeiro = new Enfermeiro(nome_enfermeiro, cpf, dataNascimento, cidades.get(cidade_enfermeiro), tipoPrioridade, cre, locaisVacinacao.get(localvacinacao), matricula, senha);
								// Adiciona o acesso desse enfermeiro
								String matriculaString = Integer.toString(matricula);
								acesso.put(matriculaString, senha);
								
								FuncoesPrint.FimCadastroEnfermeiro(enfermeiro, cidades.get(cidade_enfermeiro), locaisVacinacao.get(localvacinacao));
								verificador1 = enfermeiro.getNome();
								verificador2 = enfermeiro.getCpf();
								if ((verificador1+"-"+verificador2).equals("ERRO-ERRO")){
									FuncoesPrint.CadastroCancelado();
									break;
								} else {
									
									// Armazena o enfermeiro na lista de pessoas do seu Local de vacina��o
									(locaisVacinacao.get(localvacinacao)).AdicionarPessoa(enfermeiro);
									// Chama o m�todo para analisar a prioridade da fila do qual o enfermeiro pertence
									int prioridadeFila = enfermeiro.analisaPrioridade();
									
									// Bloco de c�digo que adiciona as pessoas na fila de acordo com sua prioridade
									String prioridade = Integer.toString(prioridadeFila);
									if (fila.get(prioridade) == null){
										fila.put(prioridade, new ArrayList<Pessoa>());
									}
									fila.get(prioridade).add(enfermeiro);
									if (PessoasParaVacina.get(cpf) == null) {
										PessoasParaVacina.put(cpf, enfermeiro);
									}
									
									//Chama a fun��o para colocar enfermeiro na lista de sua cidade
									pessoasDaCidade = FuncoesCadastramento.PessoasNaCidade(cidade_enfermeiro,enfermeiro);
									//Chama a fun��o para colocar enfermeiro na lista do seu local de vacina��o
									locaisVPacientes = FuncoesCadastramento.PessoasNoLocalVacina��o(localvacinacao, enfermeiro);
								}
								break;
							}
							
							case "6":{ // Cadastro de Ampola
								FuncoesPrint.MenuAmpola();
								System.out.print("| Nome de Fabricante: "); String fabricante = sc.nextLine().toUpperCase();
								System.out.print("| Efic�cia: "); String eficacia = sc.nextLine();
								System.out.print("| Lote: "); int lote = sc2.nextInt();
								System.out.print("| Validade: "); String validade = sc.nextLine();
								System.out.print("| Prazo: "); String prazo = sc.nextLine();
								
								// Cria nova inst�ncia de ampola
								Ampola ampola = new Ampola(fabricante, eficacia, lote, validade, prazo);
								FuncoesPrint.FimCadastroAmpola(ampola);
								// Armazena a ampola cadastrada na hashMap
								ampolas.put(fabricante, ampola);
								break;
							}
							default: {
								FuncoesPrint.PrintErro();
							}
						}
					}
				break;
			} // FIM DE TELA CADASTRO
	
	        case "2": { // Tela de atendimento
	        	while (!opcao.equals("0")) {
	        		opcao = FuncoesPrint.PrintMenuAtendimento();
	        		switch(opcao) {
		        		case "0": {
		        			FuncoesPrint.RetornaMenu(opcao);
		        			break;
		        		}
		        		case "1":{ // Exibir Fila de Pacientes 
		        			FuncoesPrint.printTracos();
		        			FuncoesPrint.CidadeFormatada("FILA");
		        			FuncoesPrint.printTracos();
		        			
		        			// Esse bloco exibe a fila 
		        			String chave = "";
		        			int value = 0;
		        			int j = 0;
		        			for(int b = 0;b < 10; b++) {
		        				chave = Integer.toString(b);
		        				if(!(fila.get(chave) == null)){
		        					for(value = 0; value< fila.get(chave).size(); value++) {
		        						if (fila.get(chave).get(value).getStatus() != 0) {
		        							FuncoesPrint.PrintFila(fila, chave, value, j);
		        							j++;
		        						}
		        					}
		        				}
		        			} 
		        			break;
		        		}
		        		
		        		case "2": { // Vacinar Paciente
		        			FuncoesPrint.printTracos();
		        			FuncoesPrint.CidadeFormatada("VACINA��O");
		        			FuncoesPrint.printTracos();
		        			System.out.print("| Insira sua matr�cula: ");
		        			String matricula = sc2.next();
		        			int num = 0;
		        			// Verifica se a matricula digitada existe
		        			if(acesso.containsKey(matricula)) {
		        				System.out.print("| Insira sua senha: ");
		        				String senha = sc2.next();
		        				// Verifica se a senha digitada � compat�vel com a matr�cula
		        				if(acesso.get(matricula).equals(senha)){
		        					// Pede o CPF do paciente que vai ser vacinado
		        					System.out.print("| CPF do Paciente: ");
		        					String cpf = sc.nextLine();
		        					// Se a pessoa existir
		        					if(!(PessoasParaVacina.get(cpf) == null)){
		        						LocalVacinacao local = PessoasParaVacina.get(cpf).getLocalVacinacao();
		        						// Se o local de vacina��o n�o tiver vacinas, as pessoas desse local n�o pode ser vacinadas
		        						if (local.getAmpolas().size() == 0) {
		        							FuncoesPrint.NaoVacinado(local);
		        						} else {
		        							// Se a pessoa n�o foi vacinada ela pode ser vacinada
		        							if (PessoasParaVacina.get(cpf).getStatus() == 2) {
		        								PessoasParaVacina.get(cpf).recebeDose();
		        								num = 0;
		        								FuncoesPrint.Imunizado(num);
		        							} 
		        							// Se a pessoa est� parcialmente imunizada, ela pode ser vacinada
		        							else if (PessoasParaVacina.get(cpf).getStatus() == 1) {
		        								PessoasParaVacina.get(cpf).recebeDose(); 
		        								num = 1;
		        								FuncoesPrint.Imunizado(num);
		        							}
		        							// Se a pessoa j� foi vacinada, ela n�o pode ser vacinada
		        							else {
		        								num = 2;
		        								FuncoesPrint.Imunizado(num);
		        							}
		        						}
		        					} else {
		        						num = 3;
		        						FuncoesPrint.Imunizado(num);
		        					}
		        				} else {
		        					FuncoesPrint.SenhaIncorreta();
		        				}
		        			} else {
		        				FuncoesPrint.MatriculaInexistente();
		        			}
		        			break;
		        		} default: {
		        			FuncoesPrint.PrintErro();
		        		}
		        	}//switch
	        	}//while
	        	break;
	        } // FIM TELA DE ANTENDIMENTO
	        
	        case "3": { // Tela de gerenciamento de estoque
	        	while (!opcao.equals("0")) {
	        		opcao = FuncoesPrint.PrintMenuEstoque();
	        		switch(opcao) {
		        		case "0": {
		        			FuncoesPrint.RetornaMenu(opcao);
		        			break;
		        		}
		        		
		        		case "1": { // Adicionar Estoque a um Local de Vacina��o 
		        			FuncoesPrint.printTracos();
		        			FuncoesPrint.CidadeFormatada("GERENCIAMENTO DE ESTOQUE");
		        			FuncoesPrint.printTracos();
		        			System.out.print("| Insira o Local de Vacina��o: ");
		        			String nome = sc.nextLine().toUpperCase();
		        			
		        			// Se o local de vacina��o existir 
		        			if(locaisVacinacao.containsKey(nome)) {
		        				LocalVacinacao local = locaisVacinacao.get(nome);
		        				System.out.print("| Ampolas adicionadas ao Estoque: ");
		        				int numAmpola = sc2.nextInt();
		        				System.out.print("| Fabricante das Ampolas adicionadas: ");
		        				String fabricante = sc.nextLine().toUpperCase();
		        				// Se a ampola existir
		        				if(ampolas.containsKey(fabricante)){
		        					String adiciona_final = FuncoesPrint.FimEstoqueVacina(nome, numAmpola, fabricante);
		        					if (adiciona_final.equals("1")) {
		        						break;
		        					}
		        					// Chama o m�todo de LocalVacincao que calcula e adiciona o novo estoque do local
		        					local.calculaEstoque(numAmpola, ampolas.get(fabricante));
		        				} else {
		        					FuncoesPrint.printTracos();
		        					FuncoesPrint.CidadeFormatada("FABRICANTE INEXISTENTE");
		        					FuncoesPrint.printTracos();
		        				}
		        			} else {
		        				FuncoesPrint.printTracos();
		        				FuncoesPrint.CidadeFormatada("LOCAL DE VACINA��O INEXISTENTE");
		        				FuncoesPrint.printTracos();
		        			}
		        			break;
		        		}//case1
		        		default: {
		        			FuncoesPrint.PrintErro();
		        		}
	        		}//switch
	        	}//while
	        	break;
	        }// FIM TELA DE CADASTRO
	        
	        case "4": { // Tela de vizualiza��o de informa��es
	        	opcao = "";
	        	while (!opcao.equals("0")) {
	        		opcao = FuncoesPrint.PrintMenuInformacoes();
	        		switch(opcao) {
		        		case "1": { // Listar Cidades 
		        			FuncoesPrint.printTracos();
		        			FuncoesPrint.CidadeFormatada("CIDADES");
		        			FuncoesPrint.printTracos();
		        			for(String chave : cidades.keySet()) {
		        				Cidade cidade = cidades.get(chave);
		        				FuncoesPrint.CentralizaString("| "+cidade+":");
		        				// Chama o m�todo calculaPessoas() que soma todas as pessoas de todos os locais de vacina��o dessa cidade
		        				String string_populacao = "| Popula��o: "+cidade.calculaPessoas()+" pessoas";
		        				FuncoesPrint.CentralizaString(string_populacao);
		        				
		        				// Chama o m�todo calculaPessoasImunizadas() que soma todas as pessoas imunizadas de todos os locais de vacina��o dessa cidade
		        				String string_imunizados = "| Popula��o Imunizada: "+cidade.calculaPessoasImunizadas()+" pessoas";
		        				FuncoesPrint.CentralizaString(string_imunizados);
		        				
		        				// Chama o m�todo calculaPessoasNaoImunizadas() que soma todas as pessoas n�o imunizadas de todos os locais de vacina��o dessa cidade
		        				String string_naoimunizados = "| Popula��o n�o Imunizada: "+cidade.calculaPessoasNaoImunizadas()+" pessoas";
		        				FuncoesPrint.CentralizaString(string_naoimunizados);
		        				FuncoesPrint.printTracos();
		        			}
		        			break;
		        		}
		        		
		        		case "2": { // Listar Locais de Vacina��o 
		        			FuncoesPrint.printTracos();
		        			FuncoesPrint.CidadeFormatada("LOCAIS DE VACINA��O");
		        			FuncoesPrint.printTracos();
		        			for(String chave : locaisVacinacao.keySet()) {
		        				LocalVacinacao local = locaisVacinacao.get(chave);
		        				FuncoesPrint.CentralizaString("| "+local+":");
		        				
		        				// Chama o m�todo calculaPessoas() que soma todas as pessoas dos local de vacina��o
		        				String string_pacientes = "| Pacientes: "+local.calculaPessoas()+" pessoas";
		        				FuncoesPrint.CentralizaString(string_pacientes);
		        				
		        				// Chama o m�todo calculaPessoasImunizadas() que soma todas as pessoas imunizadas dos local de vacina��o
		        				String string_imunizados = "| Pacientes Imunizados: "+local.calculaPessoasImunizadas()+" pessoas";
		        				FuncoesPrint.CentralizaString(string_imunizados);
		        				
		        				// Chama o m�todo calculaPessoasNaoImunizadas() que soma todas as pessoas n�o imunizadas dos local de vacina��o
		        				String string_naoimunizados = "| Pacientes n�o Imunizados: "+local.calculaPessoasNaoImunizadas()+" pessoas";
		        				FuncoesPrint.CentralizaString(string_naoimunizados);
		        				
		        				FuncoesPrint.printTracos();
		        			}
		        			break; 
		        		}
		        		
		        		case "0": {
		        			FuncoesPrint.RetornaMenu(opcao);
		        			break;
		        		}
		        		default: {
		        			FuncoesPrint.PrintErro();
		        		}
		        	} //switch
	        	} //while
	        	break;
	        } // FIM TELA DE INFORMA��ES
	        
	        default: {
	        	FuncoesPrint.PrintErro();
	        }
	      }//switch(res)
		}//while(!res.equals("0"))
	}
}	                                                