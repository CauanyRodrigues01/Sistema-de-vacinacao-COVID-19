import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Essa Classe possui todas as fun��es que ser�o chamadas em Cadastro
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
	
	//Essa fun��o � chamada para cadastrar uma cidade que ainda n�o foi cadastrada
	public static Cidade CadastroCidade(String cidade, HashMap <String, Cidade> cidades ) {
    FuncoesPrint.LimpaTela();
    FuncoesPrint.printTracos();
	System.out.println("|ESSA CIDADE AINDA N�O FOI CADASTRADA, � NECESS�RIO CADASTR�-LA|");
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
	
	//Essa fun��o � chamada para cadastrar um local de vacina��o que ainda n�o foi cadastrado
	public static LocalVacinacao CadastroLocalVacinacao(String local, String cidade, String nome_cidadelvacinacao, String uf_cidadelvacinacao) {
    FuncoesPrint.LimpaTela();
    FuncoesPrint.printTracos();
	System.out.println("|       ESSE LOCAL DE VACINA��O AINDA N�O FOI CADASTRADO       |");
    System.out.println("|                   � NECESS�RIO CADASTR�-LO                   |");
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
	
	//Essa fun��o � chamada para colocar uma pessoa dentro da sua cidade na lista de cidades
	public static HashMap<String, ArrayList<Pessoa>> PessoasNaCidade(String cidade, Pessoa pessoa) {
		if (pessoasDaCidade.get(cidade) == null){
			pessoasDaCidade.put(cidade, new ArrayList<Pessoa>()); 
		} pessoasDaCidade.get(cidade).add(pessoa);
		return pessoasDaCidade;
	}
	
	//Essa fun��o � chamada para colocar uma pessoa dentro do seu local de vacina��o na lista de locaisvacinacao
	public static HashMap<String, ArrayList<Pessoa>> PessoasNoLocalVacina��o(String localvacinacao, Pessoa pessoa) {
		if (locaisVPacientes.get(localvacinacao) == null){
			locaisVPacientes.put(localvacinacao, new ArrayList<Pessoa>()); 
		} locaisVPacientes.get(localvacinacao).add(pessoa);
		return locaisVPacientes;
	}
	
}
