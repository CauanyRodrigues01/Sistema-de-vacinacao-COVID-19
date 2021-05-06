import java.util.ArrayList;

/**
 * <b>Cidade</b> � a classe que armazena os atributos e m�todos da Cidade do SistemaCovid.
 * @author Maria Eduarda Viana Cordeiro dos Santos
 * @date 28/04/2021
 */
public class Cidade {

	/**
	 * <b>nome</b> � o atributo que armazena o nome da Cidade.
	 */
	private String nome;

	/**
	 * <b>UF</b> � o atributo que armazena a UF (Unidade Federativa) da Cidade.
	 */
	private String UF;

	/**
	 * <b>locaisVacinacao</b> � o atributo que armazena os locais de vacina��o da Cidade.
	 */
	private ArrayList<LocalVacinacao> locaisVacinacao;

	/**
	 * <b>numTotalPessoa</b> � o atributo que armazena o n�mero total de pessoas na Cidade.
	 */
	private int numTotalPessoas;

	/**
	 * <b>numPessoasImunizada</b> � o atributo que armazena o n�mero de pessoas imunizadas na Cidade.
	 */
	private int numPessoasImunizada;

	/**
	 * <b>pessoas</b> � o atributo que armazena a lista de pessoas na Cidade.
	 */
	private ArrayList<Pessoa>pessoas;

	/**
	 * <b>estoque</b> � o atributo que armazena o estoque de vacinas na Cidade.
	 */
	private int estoque;

	/**
	 * M�todo que constr�i um objeto do tipo Cidade.
	 * @param nome O valor do nome da Cidade.
	 * @param UF O valor da UF da Cidade.
	 * @param numTotalPessoas O valor do numero total de pessoas na Cidade.
	 * @param numPessoasImunizada O valor de pessoas imunizadas na Cidade.
	 * @param estoque O valor do estoque na Cidade.
	 * @param locaisVacinacao O valor dos locais de vacina��o da Cidade.
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
	 * M�todo que retorna o nome da Cidade.
	 * @return O nome da Cidade.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo que altera o valor do atributo nome.
	 * @param nome O novo nome da Cidade.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo que retorna a UF da Cidade.
	 * @return A UF da Cidade.
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * M�todo que altera o valor do atributo UF
	 * @param uf A nova UF da Cidade.
	 */
	public void setUF(String uf) {
		UF = uf;
	}

	/**
	 * M�todo que retorna o n�mero total de pessoas na Cidade.
	 * @return O n�mero total de pessoas na Cidade.
	 */
	public int getNumTotalPessoas() {
		return numTotalPessoas;
	}

	/**
	 * M�todo que altera o valor do atributo numTotalPessoas.
	 * @param numTotalPessoas O novo n�mero total de pessoas na Cidade.
	 */
	public void setNumTotalPessoas(int numTotalPessoas) {
		this.numTotalPessoas = numTotalPessoas;
	}

	/**
	 * M�todo que retorna o n�mero de pessoas imunizadas na Cidade.
	 * @return O n�mero de pessoas imunizadas na Cidade.
	 */
	public int getNumPessoasImunizada() {
		return numPessoasImunizada;
	}

	/**
	 * M�todo que altera o valor do atributo numPessoasImunizada.
	 * @param numPessoasImunizada O novo n�mero de pessoas imunizadas
   * na Cidade.
	 */
	public void setNumPessoasImunizada(int numPessoasImunizada) {
		this.numPessoasImunizada = numPessoasImunizada;
	}

	/**
	 * M�todo que retorna o estoque da Cidade.
	 * @return O estoque da Cidade.
	 */
	public int getEstoque() {
		return estoque;
	}

	/**
	 * M�todo que altera o valor do atributo estoque.
	 * @param estoque O novo estoque da Cidade.
	 */
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	/**
	 * M�todo que retorna a lista de locais de vacina��o.
	 * @return A lista de locais de vacina��o na Cidade.
	 */
	public ArrayList<LocalVacinacao> getLocaisVacinacao() {
		return locaisVacinacao;
	}

	/**
	 * M�todo que altera o valor do atributo locaisVacinacao.
	 * @param locaisVacinacao A nova lista de locais de vacina��o
   * na Cidade.
	 */
	public void setLocaisVacinacao(ArrayList<LocalVacinacao> locaisVacinacao) {
		this.locaisVacinacao = locaisVacinacao;
	}
	
	/**
	 * M�todo que compara se o objeto passado como par�metro � do tipo Cidade.
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
  * Metodo que adiciona um local de vacina��o dentro da lista de locais de vacina��o da cidade
  */
    public void addLocalVacinacao(LocalVacinacao local){
		  this.locaisVacinacao.add(local);
	}

  /**
  * Metodo que retorna quantas pessoas n�o est�o imunizadas na cidade 
  */
  public int CalcularPessoaNaoImunizada(){
		int pessoaNaoImunizadas = getNumTotalPessoas() - getNumPessoasImunizada();
		return pessoaNaoImunizadas; 
	}

   /**
  * Metodo que retorna quantos locais de vacina��o existe na cidade
  */
  public int CalcularLocaisVacinacao() {
		int NumLocaisVacinacao = locaisVacinacao.size();
		return NumLocaisVacinacao;
	}



}
