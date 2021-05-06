import java.util.ArrayList;

/**
 * <b>Cidade</b> é a classe que armazena os atributos e métodos da Cidade do SistemaCovid.
 * @author Maria Eduarda Viana Cordeiro dos Santos
 * @date 28/04/2021
 */
public class Cidade {

	/**
	 * <b>nome</b> é o atributo que armazena o nome da Cidade.
	 */
	private String nome;

	/**
	 * <b>UF</b> é o atributo que armazena a UF (Unidade Federativa) da Cidade.
	 */
	private String UF;

	/**
	 * <b>locaisVacinacao</b> é o atributo que armazena os locais de vacinação da Cidade.
	 */
	private ArrayList<LocalVacinacao> locaisVacinacao;

	/**
	 * <b>numTotalPessoa</b> é o atributo que armazena o número total de pessoas na Cidade.
	 */
	private int numTotalPessoas;

	/**
	 * <b>numPessoasImunizada</b> é o atributo que armazena o número de pessoas imunizadas na Cidade.
	 */
	private int numPessoasImunizada;

	/**
	 * <b>pessoas</b> é o atributo que armazena a lista de pessoas na Cidade.
	 */
	private ArrayList<Pessoa>pessoas;

	/**
	 * <b>estoque</b> é o atributo que armazena o estoque de vacinas na Cidade.
	 */
	private int estoque;

	/**
	 * Método que constrói um objeto do tipo Cidade.
	 * @param nome O valor do nome da Cidade.
	 * @param UF O valor da UF da Cidade.
	 * @param numTotalPessoas O valor do numero total de pessoas na Cidade.
	 * @param numPessoasImunizada O valor de pessoas imunizadas na Cidade.
	 * @param estoque O valor do estoque na Cidade.
	 * @param locaisVacinacao O valor dos locais de vacinação da Cidade.
	 */
	public Cidade(String nome, String UF, int numTotalPessoas, int numPessoasImunizada, int estoque) {
		this.nome = nome;
		this.UF = UF;
		this.numTotalPessoas = numTotalPessoas;
		this.numPessoasImunizada = numPessoasImunizada;
		this.estoque = estoque;
		this.locaisVacinacao =  new ArrayList<LocalVacinacao>();
	}
	
	/**
	 * Método que retorna o nome da Cidade.
	 * @return O nome da Cidade.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que altera o valor do atributo nome.
	 * @param nome O novo nome da Cidade.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna a UF da Cidade.
	 * @return A UF da Cidade.
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * Método que altera o valor do atributo UF
	 * @param uf A nova UF da Cidade.
	 */
	public void setUF(String uf) {
		UF = uf;
	}

	/**
	 * Método que retorna o número total de pessoas na Cidade.
	 * @return O número total de pessoas na Cidade.
	 */
	public int getNumTotalPessoas() {
		return numTotalPessoas;
	}

	/**
	 * Método que altera o valor do atributo numTotalPessoas.
	 * @param numTotalPessoas O novo número total de pessoas na Cidade.
	 */
	public void setNumTotalPessoas(int numTotalPessoas) {
		this.numTotalPessoas = numTotalPessoas;
	}

	/**
	 * Método que retorna o número de pessoas imunizadas na Cidade.
	 * @return O número de pessoas imunizadas na Cidade.
	 */
	public int getNumPessoasImunizada() {
		return numPessoasImunizada;
	}

	/**
	 * Método que altera o valor do atributo numPessoasImunizada.
	 * @param numPessoasImunizada O novo número de pessoas imunizadas
   * na Cidade.
	 */
	public void setNumPessoasImunizada(int numPessoasImunizada) {
		this.numPessoasImunizada = numPessoasImunizada;
	}

	/**
	 * Método que retorna o estoque da Cidade.
	 * @return O estoque da Cidade.
	 */
	public int getEstoque() {
		return estoque;
	}

	/**
	 * Método que altera o valor do atributo estoque.
	 * @param estoque O novo estoque da Cidade.
	 */
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	/**
	 * Método que retorna a lista de locais de vacinação.
	 * @return A lista de locais de vacinação na Cidade.
	 */
	public ArrayList<LocalVacinacao> getLocaisVacinacao() {
		return locaisVacinacao;
	}

	/**
	 * Método que altera o valor do atributo locaisVacinacao.
	 * @param locaisVacinacao A nova lista de locais de vacinação
   * na Cidade.
	 */
	public void setLocaisVacinacao(ArrayList<LocalVacinacao> locaisVacinacao) {
		this.locaisVacinacao = locaisVacinacao;
	}
	
	/**
	 * Método que compara se o objeto passado como parâmetro é do tipo Cidade.
	 * Caso o seja, ele compara o nome e UF de duas Cidades.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Cidade))
			return false;
		Cidade exemplo = (Cidade) obj;
		if (this.nome.equals(exemplo.getNome()) && this.UF.equals(exemplo.getUF()))
			return true;
		return false;
	}

  /**
	 * Metodo que retorna o nome e UF da Cidade em String.
	 */
	public String toString() {
		return "Cidade: "+getNome()+"-"+getUF();
  }
  /**
  * Metodo que adiciona um local de vacinação dentro da lista de locais de vacinação da cidade
  */
    public void addLocalVacinacao(LocalVacinacao local){
		  this.locaisVacinacao.add(local);
	}

  /**
  * Metodo que retorna quantas pessoas não estão imunizadas na cidade 
  */
  public int CalcularPessoaNaoImunizada(){
		int pessoaNaoImunizadas = getNumTotalPessoas() - getNumPessoasImunizada();
		return pessoaNaoImunizadas; 
	}

   /**
  * Metodo que retorna quantos locais de vacinação existe na cidade
  */
  public int CalcularLocaisVacinacao() {
		int NumLocaisVacinacao = locaisVacinacao.size();
		return NumLocaisVacinacao;
	}



}
