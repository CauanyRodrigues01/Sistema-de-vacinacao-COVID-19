import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FuncoesPrint {
	
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	
	public static String PrintPrioridade(Pessoa paciente){
		String nivel_prioridade = "";
		
		if ((paciente.analisaPrioridade() == 1) || (paciente.analisaPrioridade() == 2) || (paciente.analisaPrioridade() == 3)) {
			nivel_prioridade = "Alta";
		} else if ((paciente.analisaPrioridade() == 4) || (paciente.analisaPrioridade() == 5) || (paciente.analisaPrioridade() == 6)) {
			nivel_prioridade = "Média";
		} else if ((paciente.analisaPrioridade() == 7) || (paciente.analisaPrioridade() == 8)){
			nivel_prioridade = "Baixa";
		} else {
			nivel_prioridade = "Nenhuma";
		}
		return nivel_prioridade;
	}
	
	public static void CidadeFormatada(String nome_cidade) {
	    String cidade_formatada = "";
	    for (int i = 0; i<nome_cidade.length()-1; i++) {
	    	char letra = nome_cidade.charAt(i);
	    	cidade_formatada += letra;
	    	if (letra!=' ') {
	    		cidade_formatada += " ";
	    	}
	    }
	    cidade_formatada+=nome_cidade.charAt(nome_cidade.length()-1);
	    double rusbe = 64-cidade_formatada.length();
	    String espaco = "|";
	    String espaco2 = "";
	    for (int j = 0; j<Math.floor(rusbe/2)-1; j++) {
	    	espaco+=" ";
	    }
	    for (int k = 0; k<Math.round(rusbe/2)-1; k++) {
	    	espaco2+=" ";
	    }
	    espaco2+="|";
	    System.out.println(espaco+cidade_formatada+espaco2);
	}
	
	public static void CentralizaString(String centralizar) {
		String espaco2="";
		for (int k = 0; k<(64-centralizar.length()-1); k++) {
			espaco2+=" ";
		}
		espaco2+="|";
		System.out.println(centralizar+espaco2);
	}
	
	public static void LimpaTela() {
		for (int i =0; i<100; i++) {
			System.out.print("\n");
		}
	}
	
	public static void printTracos() {
		for (int i = 0; i < 64; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static String PrintMenu() {
		printTracos();
		System.out.println("|                       B E M  V I N D O                       |");
		printTracos();
		System.out.println("| [1] Cadastramento                                            |");
		System.out.println("| [2] Atendimento                                              |");
		System.out.println("| [3] Estoque                                                  |");
		System.out.println("| [4] Visualizar Informações                                   |");
		System.out.println("| [0] Sair                                                     |");
		printTracos();
		System.out.print("\n  Digite a opção: ");
		String res = sc.next();
		LimpaTela();
		return res;
	}
	
	public static String PrintMenuCadastro() {
		System.out.print("\n");
		printTracos();
		System.out.println("|                  C A D A S T R A M E N T O                   |");
		printTracos();
		System.out.println("| [1] Cadastrar Cidade                                         |");
		System.out.println("| [2] Cadastrar Local de Vacinação                             |");
		System.out.println("| [3] Cadastrar Paciente                                       |");
		System.out.println("| [4] Cadastrar Medico                                         |");
		System.out.println("| [5] Cadastrar Enfermeiro                                     |");
		System.out.println("| [6] Cadastrar Ampola                                         |");
		System.out.println("| [0] Retornar ao Menu                                         |");
		printTracos();
		System.out.print("\n  Digite a opção: ");
		String opcao = sc.next();
		LimpaTela();
		return opcao;
	}
	
	public static String PrintMenuAtendimento() {
		System.out.print("\n");
		printTracos();
		System.out.println("|                    A T E N D I M E N T O                     |");
		printTracos();
		System.out.println("| [1] Exibir Fila de Pacientes                                 |");
		System.out.println("| [2] Vacinar Paciente                                         |");
		System.out.println("| [0] Retornar ao Menu                                         |");
		printTracos();
		System.out.print("\n  Digite a opção: ");
		String opcao = sc.next();
		LimpaTela();
		return opcao;
	}
	
	public static String PrintMenuEstoque() {
		printTracos();
		CidadeFormatada("ESTOQUE");
		printTracos();
		System.out.println("| [1] Adicionar Estoque a um Local de Vacinação                |");
		System.out.println("| [0] Retornar ao Menu                                         |");
		printTracos();
		System.out.print("  Digite a opção: ");
		String opcao = sc.next();
		LimpaTela();
		return opcao;
	}
	
	public static String PrintMenuInformacoes() {
		printTracos();
		CidadeFormatada("INFORMAÇÕES");
		printTracos();
		System.out.println("| [1] Listar Cidades                                           |");
		System.out.println("| [2] Listar Locais de Vacinação                               |");
		System.out.println("| [0] Retornar ao Menu                                         |");
		printTracos();
		System.out.print("  Digite a opção: ");
		String opcao = sc.next();
		LimpaTela();
		return opcao;
	}
	
	public static void ExibirFila() {
		CentralizaString("FILA:");
	}
	
	public static String MenuCidade() {
		printTracos();
		System.out.println("|              C A D A S T R O  D E  C I D A D E               |");
		printTracos();
		return "";
	}
	
	public static String FimCadastroCidade(String nome_cidade, String uf) {
	    LimpaTela();
	    printTracos();
	    System.out.println("|               C I D A D E  C A D A S T R A D A               |");
	    CidadeFormatada(nome_cidade);
	    printTracos();
	    String string_nome = "| Nome: "+nome_cidade;
	    CentralizaString(string_nome);
	
	    String string_uf = "| UF: "+uf;
	    CentralizaString(string_uf);
	
	    String continuar = "";
	    while(!continuar.equals("0") || !continuar.equals("1")){
	      printTracos();
	    
	    System.out.println("|               R E G I S T R A R  C I D A D E ?               |");
	    printTracos();
	    System.out.println("|        [0] Registrar                [1] Não Registrar        |");
	    printTracos();
	    continuar = sc.next();
	    if (continuar.equals("0")) {
	    	CadastroFeito();
	        break;
	     } else if (continuar.equals("1")) {
	        CadastroCancelado();
	        break;
	      } else{
	        PrintErro();
	      }
	    }
	    return continuar;
	}

  public static String FimCadastroLVacinacao(String nome_lvacinacao, String horario, String nome_cidadelvacinacao, String uf_cidadelvacinacao) {
    LimpaTela();
    printTracos();
    System.out.println("|    L O C A L  D E  V A C I N A Ç Ã O  C A D A S T R A D O    |");
    CidadeFormatada(nome_lvacinacao);
    printTracos();
    String string_nome = "| Nome: "+nome_lvacinacao;
    CentralizaString(string_nome);

    String string_horario = "| Horario de Funcionamento: "+horario;
    CentralizaString(string_horario);

    String string_nome_clvacinacao = "| Localizado em: "+nome_cidadelvacinacao+"-"+uf_cidadelvacinacao;
    CentralizaString(string_nome_clvacinacao);
    String continuar = "";
    while(!continuar.equals("0") || !continuar.equals("1")){
      printTracos();
    
    System.out.println("|    R E G I S T R A R  L O C A L  D E  V A C I N A Ç Ã O ?    |");
    printTracos();
      System.out.println("|        [0] Registrar                [1] Não Registrar        |");
      printTracos();
      continuar = sc.next();
      if (continuar.equals("0")) {
        CadastroFeito();
        break;
      }
      else if (continuar.equals("1")) {
        CadastroCancelado();
        break;
      }
      else{
        PrintErro();
      }
    }
    return continuar;
  }

  public static String FimCadastroPaciente(Paciente paciente, Cidade cidade, LocalVacinacao localvacinacao) {
    LimpaTela();
    printTracos();
    System.out.println("|             P A C I E N T E  C A D A S T R A D O             |");
    CidadeFormatada(paciente.getNome());
    printTracos();
    String string_nome = "| Nome: "+paciente.getNome();
    CentralizaString(string_nome);

    String string_cpf = "| CPF: "+paciente.getCpf();
    CentralizaString(string_cpf);

    String string_dataNascimento = "| Data de Nascimento: "+paciente.getDataNascimento();
    CentralizaString(string_dataNascimento);

    String string_sus = "| SUS: "+paciente.getSus();
    CentralizaString(string_sus);

    String string_prioridade = "| Prioridade: "+paciente.analisaPrioridade()+" ["+PrintPrioridade(paciente)+"]";
    CentralizaString(string_prioridade);

    String string_cidade = "| Reside em: "+cidade.getNome()+"-"+cidade.getUF();
    CentralizaString(string_cidade);

    String string_localvacinacao = "| Será vacinado em: "+localvacinacao.getNome();
    CentralizaString(string_localvacinacao);

    String continuar = "";

    while(!continuar.equals("0") || !continuar.equals("1")){
      printTracos();
    
    System.out.println("|             R E G I S T R A R  P A C I E N T E ?             |");
    printTracos();
      System.out.println("|        [0] Registrar                [1] Não Registrar        |");
      printTracos();
      continuar = sc.next();
      if (continuar.equals("0")) {
        CadastroFeito();
        break;
      }
      else if (continuar.equals("1")) {
        paciente.setNome("ERRO");
        paciente.setCpf("ERRO");
        CadastroCancelado();
        break;
      }
      else{
        PrintErro();
      }
    }
    return continuar;
  }

  public static String FimCadastroMedico(Medico medico, Cidade cidade, LocalVacinacao localvacinacao) {
    //nome_medico, cpf, dataNascimento, cidades.get(cidade_medico), tipoPrioridade,locaisVacinacao.get(localvacinacao), crm, matricula, senha
    LimpaTela();
    printTracos();
    System.out.println("|               M É D I C O  C A D A S T R A D O               |");
    CidadeFormatada(medico.getNome());
    printTracos();
    String string_nome = "| Nome: "+medico.getNome();
    CentralizaString(string_nome);

    String string_cpf = "| CPF: "+medico.getCpf();
    CentralizaString(string_cpf);

    String string_dataNascimento = "| Data de Nascimento: "+medico.getDataNascimento();
    CentralizaString(string_dataNascimento);

    String string_matricula = "| Matrícula: "+medico.getMatricula();
    CentralizaString(string_matricula);

    String string_crm = "| CRM: "+medico.getCrm();
    CentralizaString(string_crm);

    String nivel_prioridade = "Alta";

    String string_prioridade = "| Prioridade: "+medico.analisaPrioridade()+" ["+nivel_prioridade+"]";
    CentralizaString(string_prioridade);

    String string_cidade = "| Reside em: "+cidade.getNome()+"-"+cidade.getUF();
    CentralizaString(string_cidade);

    String string_localvacinacao = "| Trabalhará em: "+localvacinacao.getNome();
    CentralizaString(string_localvacinacao);

    String continuar = "";

    while(!continuar.equals("0") || !continuar.equals("1")){
      printTracos();
    
    System.out.println("|               R E G I S T R A R  M E D I C O ?               |");
    printTracos();
      System.out.println("|        [0] Registrar                [1] Não Registrar        |");
      printTracos();
      continuar = sc.next();
      if (continuar.equals("0")) {
        CadastroFeito();
        break;
      }
      else if (continuar.equals("1")) {
        medico.setNome("ERRO");
        medico.setCpf("ERRO");
        CadastroCancelado();
        break;
      }
      else{
        PrintErro();
      }
    }
    return continuar;
  }

   public static String FimCadastroEnfermeiro(Enfermeiro enfermeiro, Cidade cidade, LocalVacinacao localvacinacao) {
    //nome_enfermeiro, cpf, dataNascimento, cidades.get(cidade_enfermeiro), tipoPrioridade, cre, locaisVacinacao.get(localvacinacao), matricula, senha
    LimpaTela();
    printTracos();
    System.out.println("|           E N F E R M E I R O  C A D A S T R A D O           |");
    CidadeFormatada(enfermeiro.getNome());
    printTracos();
    String string_nome = "| Nome: "+enfermeiro.getNome();
    CentralizaString(string_nome);

    String string_cpf = "| CPF: "+enfermeiro.getCpf();
    CentralizaString(string_cpf);

    String string_dataNascimento = "| Data de Nascimento: "+enfermeiro.getDataNascimento();
    CentralizaString(string_dataNascimento);

    String string_matricula = "| Matrícula: "+enfermeiro.getMatricula();
    CentralizaString(string_matricula);

    String string_cre = "| CRE: "+enfermeiro.getCre();
    CentralizaString(string_cre);

    String nivel_prioridade = "Alta";

    String string_prioridade = "| Prioridade: "+enfermeiro.analisaPrioridade()+" ["+nivel_prioridade+"]";
    CentralizaString(string_prioridade);

    String string_cidade = "| Reside em: "+cidade.getNome()+"-"+cidade.getUF();
    CentralizaString(string_cidade);

    String string_localvacinacao = "| Trabalhará em: "+localvacinacao.getNome();
    CentralizaString(string_localvacinacao);

    String continuar = "";

    while(!continuar.equals("0") || !continuar.equals("1")){
	      printTracos();
	    
	    System.out.println("|           R E G I S T R A R  E N F E R M E I R O ?           |");
	    printTracos();
	      System.out.println("|        [0] Registrar                [1] Não Registrar        |");
	      printTracos();
	      continuar = sc.next();
	      if (continuar.equals("0")) {
	        CadastroFeito();
	        break;
	      }
	      else if (continuar.equals("1")) {
	        enfermeiro.setNome("ERRO");
	        enfermeiro.setCpf("ERRO");
	        CadastroCancelado();
	        break;
	      }
	      else{
	        PrintErro();
	      }
    }
    return continuar;
  }

  public static String FimCadastroAmpola(Ampola ampola) {
    //abricante, eficacia, lote, validade, prazo
    LimpaTela();
    printTracos();
    System.out.println("|               A M P O L A  C A D A S T R A D A               |");
    CidadeFormatada(ampola.getFabricante());
    printTracos();
    String string_fabricante = "| Fabricante: "+ampola.getFabricante();
    CentralizaString(string_fabricante);

    String string_eficacia = "| Eficácia: "+ampola.getEficacia();
    CentralizaString(string_eficacia);

    String string_lote = "| Lote: "+ampola.getLote();
    CentralizaString(string_lote);

    String string_validade = "| Validade do Lote: "+ampola.getValidade();
    CentralizaString(string_validade);

    String string_prazo = "| Prazo da Ampola: "+ampola.getPrazo();
    CentralizaString(string_prazo);

    String continuar = "";

    while(!continuar.equals("0") || !continuar.equals("1")){
      printTracos();
    
    System.out.println("|               R E G I S T R A R  A M P O L A ?               |");
    printTracos();
      System.out.println("|        [0] Registrar                [1] Não Registrar        |");
      printTracos();
      continuar = sc.next();
      if (continuar.equals("0")) {
        CadastroFeito();
        break;
      }
      else if (continuar.equals("1")) {
        CadastroCancelado();
        break;
      }
      else{
        PrintErro();
      }
    }
    return continuar;
  }
  public static String FimEstoqueVacina(String nome_localVacinacao, int numAmpola, String fabricante) {
    LimpaTela();
    printTracos();
    System.out.println("|             A M P O L A S  A D I C I O N A D A S             |");
    printTracos();
    
    String string_fabricante = "| Fabricante: "+fabricante;
    CentralizaString(string_fabricante);

    String string_quantidade = "| Quantidade: "+numAmpola+" unidades";
    CentralizaString(string_quantidade);

    String continuar = "";

    while(!continuar.equals("0") || !continuar.equals("1")){
      printTracos();
    
    System.out.println("|              A D I C I O N A R  A M P O L A S ?              |");
    printTracos();
      System.out.println("|        [0] Adicionar                [1] Não Adicionar        |");
      printTracos();
      continuar = sc.next();
      if (continuar.equals("0")) {
        LimpaTela();
        FuncoesPrint.printTracos();
        System.out.println("|             A M P O L A S  A D I C I O N A D A S             |");
        FuncoesPrint.printTracos();
        break;
      }
      else if (continuar.equals("1")) {
        LimpaTela();
        FuncoesPrint.printTracos();
        System.out.println("|         A M P O L A S  N Ã O  A D I C I O N A D A S          |");
        FuncoesPrint.printTracos();
        break;
      }
      else{
        PrintErro();
      }
    }
    return continuar;
  }

  public static void PrintFila(HashMap<String,ArrayList<Pessoa>> fila, String chave, int value, int j) {
    String string_posicao = "| "+(j+1)+".";
    String string_nome = " Nome: "+(fila.get(chave).get(value).getNome());
    CentralizaString(string_posicao+string_nome);

    String string_cpf = "|    CPF: "+(fila.get(chave).get(value).getCpf());
    CentralizaString(string_cpf);

    //String string_prioridade = (((fila.get(chave)).get(value)).getTipoPrioridade());

    //String string_prioridade
    String prioridade_string = "|    Prioridade: "+(((fila.get(chave)).get(value)).getTipoPrioridade())+" ["+PrintPrioridade(fila.get(chave).get(value))+"]";
    CentralizaString(prioridade_string);
    printTracos();
  }

  public static void CadastroFeito() {
    LimpaTela();
    FuncoesPrint.printTracos();
    System.out.println("|                  C A D A S T R O  F E I T O                  |");
    FuncoesPrint.printTracos();
  }

  public static void CadastroCancelado() {
    LimpaTela();
    FuncoesPrint.printTracos();
    System.out.println("|              C A D A S T R O  C A N C E L A D O              |");
    FuncoesPrint.printTracos();
  }

  public static String MenuLocalVacinacao() {
    printTracos();
    System.out.println("|   C A D A S T R O  D E  L O C A L  D E  V A C I N A Ç Ã O    |");
    printTracos();
    return "";
  }

  public static String MenuPaciente() {
    printTracos();
    System.out.println("|            C A D A S T R O  D E  P A C I E N T E             |");
    printTracos();
    return "";
  }

  public static String MenuMedico() {
    printTracos();
    System.out.println("|              C A D A S T R O  D E  M E D I C O               |");
    printTracos();
    return "";
  }

  public static String MenuEnfermeiro() {
    printTracos();
    System.out.println("|          C A D A S T R O  D E  E N F E R M E I R O           |");
    printTracos();
    return "";
  }

  public static String MenuAmpola() {
    printTracos();
    System.out.println("|              C A D A S T R O  D E  A M P O L A               |");
    printTracos();
    return "";
  }

  public static int MenuPrioridades(){
    LimpaTela();
    printTracos();
    System.out.println("|                M E N U  P R I O R I D A D E S                |");
    printTracos();
    System.out.println("| [1] O Paciente é Institucionalizado                          |");
    System.out.println("| [2] O Paciente vive em terras indígenas                      |");
    System.out.println("| [3] O Paciente é um Profissional da Saúde                    |");
    System.out.println("| [4] O Paciente vive em uma Comunidade tradicional Ribeirinha |");
    System.out.println("| [5] o Paciente vive em uma comunidade tradicional quilombola |");
		System.out.println("| [6] o Paciente que possui qualquer tipo de Comorbidades      |");
    System.out.println("| [0] Nenhuma das opções                                       |");
    printTracos();
    System.out.print("\n  Digite a opção: ");
    int opcao = sc.nextInt();
    return opcao;
  }

  public static String RetornaMenu(String opcao) {
    System.out.print("\n");
    printTracos();
    System.out.println("|              R E T O R N A N D O  A O  M E N U               |");
    printTracos();
    System.out.print("\n");
    return opcao;
  }

  public static String FimdoPrograma() {
    System.out.print("\n");
    printTracos();
    System.out.println("|                 F I M  D O  P R O G R A M A                  |");
    printTracos();
    return "";
  }

  public static String PrintErro() {
    System.out.print("\n");
    printTracos();
    System.out.println("|                  O P Ç Ã O  I N V Á L I D A                  |");
    printTracos();
    System.out.print("\n");
    return "";
  }

  public static void MatriculaInexistente() {
    LimpaTela();
    printTracos();
    System.out.println("|           M A T R I C U L A  I N E X I S T E N T E           |");
    printTracos();
  }

  public static void SenhaIncorreta() {
    LimpaTela();
    printTracos();
    System.out.println("|                 S E N H A  I N C O R R E T A                 |");
    printTracos();
  }

  public static void NaoVacinado(LocalVacinacao local) {
    FuncoesPrint.LimpaTela();
    FuncoesPrint.printTracos();
		System.out.println("| P A C I E N T E  N Ã O  P Ô D E  S E R  V A C I N A D O |");
    System.out.println("|                N Ã O  H Á  A M P O L A S  E M                |");
    FuncoesPrint.CidadeFormatada(local.getNome());
    FuncoesPrint.printTracos();
  }

  public static void Imunizado(int num){
    if (num == 0) {
      FuncoesPrint.LimpaTela();
      FuncoesPrint.printTracos();
			System.out.println("| P E S S O A  P A R C I A L M E N T E  I M U N I Z A D A |");
      FuncoesPrint.printTracos();
    }

    else if (num == 1) {
      FuncoesPrint.LimpaTela();
      FuncoesPrint.printTracos();
			System.out.println("|                P E S S O A  I M U N I Z A D A                |");
      FuncoesPrint.printTracos();
    }

    else if (num == 2) {
      FuncoesPrint.LimpaTela();
      FuncoesPrint.printTracos();
			System.out.println("|    E S S A  P E S S O A  J Á  E S T Á  I M U N I Z A D A     |");
      FuncoesPrint.printTracos();
    }
    
    else if (num == 3 ) {
      FuncoesPrint.LimpaTela();
      FuncoesPrint.printTracos();
			System.out.println("|           P E S S O A  N Ã O  E N C O N T R A D A            |");
      FuncoesPrint.printTracos();
    }
  
  }
}