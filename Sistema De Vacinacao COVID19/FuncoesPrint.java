import java.io.IOException;
import java.util.Scanner;

public class FuncoesPrint {
  static Scanner sc2 = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);

  public static void CidadeFormatada(String nome_cidade){
    String cidade_formatada = "";
    for (int i = 0; i<nome_cidade.length()-1; i++){
      char letra = nome_cidade.charAt(i);
      cidade_formatada += letra;
      if (letra!=' '){
        cidade_formatada += " ";
      }
    }
    cidade_formatada+=nome_cidade.charAt(nome_cidade.length()-1);
    double rusbe = 64-cidade_formatada.length();
    String espaco = "|";
    String espaco2 = "";
    for (int j = 0; j<Math.floor(rusbe/2)-1; j++){
      espaco+=" ";
    }
    for (int k = 0; k<Math.round(rusbe/2)-1; k++){
      espaco2+=" ";
    }
    espaco2+="|";
    System.out.println(espaco+cidade_formatada+espaco2);
  }

  public static void CentralizaString(String centralizar) {
    String espaco2="";
    for (int k = 0; k<(64-centralizar.length()-1); k++){
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

  public static void ExibirFila() {
    CentralizaString("FILA:");
    /*for(int b = 0;b < 10; b++){
      String v = Integer.toString(b);
      if(!(fila.get(v) == null)){
        for(int j = 0;j < fila.get(v).size(); j++) {
          System.out.println(" "+(fila.get(v)).get(j));
        }
      }
		}*/
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
    
    System.out.println("|                            INSIRA                            |");
    printTracos();
      System.out.println("|     [0] Registrar Cidade        [1] Não Registrar Cidade     |");
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

  public static String FimCadastroLVacincao(String nome_lvacinacao, String horario, int estoque_lvacinacao, String nome_cidadelvacinacao, String uf_cidadelvacinacao) {
    LimpaTela();
    printTracos();
    System.out.println("|    L O C A L  D E  V A C I N A Ç Ã O  C A D A S T R A D O    |");
    CidadeFormatada(nome_lvacinacao);
    printTracos();
    String string_nome = "| Nome: "+nome_lvacinacao;
    CentralizaString(string_nome);

    String string_horario = "| Horario: "+horario;
    CentralizaString(string_horario);

    String string_estoque_lvacinacao = "| Estoque de vacinas: "+estoque_lvacinacao;
    CentralizaString(string_estoque_lvacinacao);

    String string_nome_clvacinacao = "| Cidade em que está situado: "+nome_cidadelvacinacao+"-"+uf_cidadelvacinacao;
    CentralizaString(string_nome_clvacinacao);
    String continuar = "";
    while(!continuar.equals("0") || !continuar.equals("1")){
      printTracos();
    
    System.out.println("|                            INSIRA                            |");
    printTracos();
      System.out.println("|[0] Registrar L de Vacinação  [1] Não Registrar L de Vacinação|");
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
}