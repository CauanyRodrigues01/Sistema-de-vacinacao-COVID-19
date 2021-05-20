import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Essa Classe possui todas as funções que serão chamadas em Cadastro
public class FuncoesCadastramento {
	static Scanner sc2 = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);
	static HashMap <String, Cidade> Hashcidades = new HashMap <String, Cidade> ();
	static HashMap <String, ArrayList<Pessoa>> pessoasDaCidade= new HashMap <String, ArrayList<Pessoa>> ();
	static HashMap <String, ArrayList<Pessoa>> locaisVPacientes= new HashMap <String,ArrayList<Pessoa>> (); 
	
	public static void printTracos() {
		for (int i = 0; i < 38; i++) {
			System.out.print("-");
		}
		
		System.out.println();
	}	
	
	//Essa função é chamada para cadastrar uma cidade que ainda não foi cadastrada
	public static Cidade CadastroCidade(String cidade, HashMap <String, Cidade> cidades ) {
    FuncoesPrint.LimpaTela();
    FuncoesPrint.printTracos();
	System.out.println("|ESSA CIDADE AINDA NÃO FOI CADASTRADA, É NECESSÁRIO CADASTRÁ-LA|");
    FuncoesPrint.printTracos();
    System.out.println("\n");
    String nome_cidade = cidade;
    FuncoesPrint.printTracos();
	FuncoesPrint.CidadeFormatada(cidade);
    FuncoesPrint.printTracos();
	System.out.print("| UF: "); 
    String uf = sc2.nextLine().toUpperCase();
    FuncoesPrint.LimpaTela();
    Cidade cidade_lvacinacao = new Cidade (nome_cidade,uf);
		Hashcidades = cidades;
    if (FuncoesPrint.FimCadastroCidade(nome_cidade, uf).equals("1")) {
      cidade_lvacinacao.setNome("ERRO");
      cidade_lvacinacao.setUF("ERRO");
    }
		return cidade_lvacinacao;
	}
	
	//Essa função é chamada para cadastrar um local de vacinação que ainda não foi cadastrado
	public static LocalVacinacao CadastroLocalVacinacao(String local, String cidade, String nome_cidadelvacinacao, String uf_cidadelvacinacao) {
    FuncoesPrint.LimpaTela();
    FuncoesPrint.printTracos();
	System.out.println("|       ESSE LOCAL DE VACINAÇÃO AINDA NÃO FOI CADASTRADO       |");
    System.out.println("|                   É NECESSÁRIO CADASTRÁ-LO                   |");
    FuncoesPrint.printTracos();
    System.out.println("\n");
    String nome_lvacinacao = local;
    FuncoesPrint.printTracos();
	FuncoesPrint.CidadeFormatada(nome_lvacinacao);
    FuncoesPrint.printTracos();
	System.out.print("| Horario de Funcionamento: "); 
    String horario = sc2.nextLine().toUpperCase();
    FuncoesPrint.LimpaTela();
    LocalVacinacao localVacinacao = new LocalVacinacao(nome_lvacinacao, horario, Hashcidades.get(cidade));
    if (FuncoesPrint.FimCadastroLVacinacao(nome_lvacinacao, horario, nome_cidadelvacinacao, uf_cidadelvacinacao).equals("1")) {
      localVacinacao.setNome("ERRO");
      localVacinacao.setHorarioAtendimento("ERRO");
    }
		return localVacinacao;
	}
	
	//Essa função é chamada para colocar uma pessoa dentro da sua cidade na lista de cidades
	public static HashMap<String, ArrayList<Pessoa>> PessoasNaCidade(String cidade, Pessoa pessoa) {
		if (pessoasDaCidade.get(cidade) == null){
			pessoasDaCidade.put(cidade, new ArrayList<Pessoa>()); 
		} pessoasDaCidade.get(cidade).add(pessoa);
		return pessoasDaCidade;
	}
	
	//Essa função é chamada para colocar uma pessoa dentro do seu local de vacinação na lista de locaisvacinacao
	public static HashMap<String, ArrayList<Pessoa>> PessoasNoLocalVacinação(String localvacinacao, Pessoa pessoa) {
		if (locaisVPacientes.get(localvacinacao) == null){
			locaisVPacientes.put(localvacinacao, new ArrayList<Pessoa>()); 
		} locaisVPacientes.get(localvacinacao).add(pessoa);
		return locaisVPacientes;
	}
	
}
