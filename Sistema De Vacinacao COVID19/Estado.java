import java.util.ArrayList;

/**
 * <b>Estado</b> é a classe que armazena os atributos e métodos do Estado do SistemaCovid.
 * @author Maria Eduarda Viana Cordeiro dos Santos
 * @date 28/04/2021
 */
public class Estado {

	/**
	 * <b>UF</b> é o atributo que armazena a UF (Unidade Federativa) do Estado.
	 */
	private String UF;

	/**
	 * <b>nome</b> é o atributo que armazena o nome do Estado.
	 */
	private String nome;

	/**
	 * <b>cidades</b> é o atributo que armazena a lista de cidades do Estado.
	 */
	private ArrayList<Cidade> cidades;

	/**
	 * <b>numTotalPessoas</b> é o atributo que armazena o número total de pessoas do Estado.
	 */
	private int numTotalPessoas;

	/**
	 * <b>numPessoasImunizadas</b> é o atributo que armazena o número de pessoas imunizadas do Estado.
	 */
	private int numPessoasImunizada;

	/**
	 * <b>numPessoasNaoImunizadas</b> é o atributo que armazena o número de pessoas não imunizadas do Estado.
	 */
	private int numPessoasNaoImunizadas;

	/**
	 * <b>estoque</b> é o atributo que armazena o estoque de vacinas do Estado.
	 */
	private int estoque;

	/**
	 * <b>locaisVacinacao</b> é o atributo que armazena os locais de vacinação do Estado.
	 */
	private int locaisVacinacao;
	
	/**
	 * Método que constrói um objeto do tipo Estado.
	 * @param UF O valor da UF do Estado.
	 * @param numTotalPessoas O valor do número total de pessoas no Estado.
	 * @param numPessoasImunizada O valor do número de pessoas imunizadas no Estado.
	 * @param numPessoasNaoImunizadas O valor do número de pessoas nao imunizadas no Estado.
	 * @param estoque O valor do estoque de vacinas do Estado.
	 * @param locaisVacinacao O valor dos locais de vacinação do Estado.
	 */
	public Estado(String UF, String nome, int numTotalPessoas, int numPessoasImunizada, int numPessoasNaoImunizadas, int estoque, int locaisVacinacao) {
		this.UF = UF;
		this.nome = nome;
		this.numTotalPessoas = numTotalPessoas;
		this.numPessoasImunizada = numPessoasImunizada;
		this.estoque = estoque;
		this.locaisVacinacao = locaisVacinacao;
		this.cidades = new ArrayList <Cidade>();
		
	}
	
	/**
	 * Método que retorna o nome do Estado.
	 * @return O nome do Estado.
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
	 * Método que retorna a UF do Estado.
	 * @return A UF do Estado.
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * Método que altera o valor do atributo UF.
	 * @param uF A nova UF do Estado.
	 */
	public void setUF(String uF) {
		UF = uF;
	}
	
	/**
	 * Método que retorna a lista de cidades do Estado.
	 * @return A lista de cidades do Estado.
	 */
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * Método que altera o valor do atributo cidades.
	 * @param cidades A nova lista de cidades do Estado.
	 */
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}

	/**
	 * Métoro que retorna o número total de pessoas no Estado.
	 * @return O número total de pessoas do Estado.
	 */
	public int getNumTotalPessoas() {
		return numTotalPessoas;
	}

	/**
	 * Método que altera o valor do atributo numTotalPessoas.
	 * @param numTotalPessoas O novo número total de pessoas no Estado.
	 */
	public void setNumTotalPessoas(int numTotalPessoas) {
		this.numTotalPessoas = numTotalPessoas;
	}

	/**
	 * Método que retorna o número de pessoas imunizadas no Estado.
	 * @return
	 */
	public int getNumPessoasImunizada() {
		return numPessoasImunizada;
	}

	/**
	 * Método que altera o valor do atributo numPessoasImunizada.
	 * @param numPessoasImunizada O novo número de pessoas imunizadas no Estado.
	 */
	public void setNumPessoasImunizada(int numPessoasImunizada) {
		this.numPessoasImunizada = numPessoasImunizada;
	}

	/**
	 * Método que retorna o número de pessoas não imunizadas no Estado.
	 * @return O número de pessoas não imunizadas no Estado.
	 */
	public int getNumPessoasNaoImunizadas() {
		return numPessoasNaoImunizadas;
	}

	/**
	 * Método que altera o valor do atributo numPessoasNaoImunizadas.
	 * @param numPessoasNaoImunizadas O novo número de pessoas não imunizadas no Estado.
	 */
	public void setNumPessoasNaoImunizadas(int numPessoasNaoImunizadas) {
		this.numPessoasNaoImunizadas = numPessoasNaoImunizadas;
	}

	/**
	 * Método que retorna o estoque de vacinas do Estado.
	 * @return O estoque de vacinas do Estado.
	 */
	public int getEstoque() {
		return estoque;
	}

	/**
	 * Método que altera o valor do atributo estoque.
	 * @param estoque O novo estoque de vacinas do Estado.
	 */
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	/**
	 * Método que retorna os locais de vacinação do Estado.
	 * @return Os locais de vacinação do Estado.
	 */
	public int getLocaisVacinacao() {
		return locaisVacinacao;
	}

	/**
	 * Método que altera o valor do atributo LocaisVacinacao.
	 * @param locaisVacinacao O novo número de locais de vacinação do Estado.
	 */
	public void setLocaisVacinacao(int locaisVacinacao) {
		this.locaisVacinacao = locaisVacinacao;
	}
	
	/**
	 * Método que compara se o objeto passado como parâmetro é do tipo Estado.
	 * Caso o seja, ele compara a igualdade entre os nomes e UFs de duas classes Estado.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Estado))
			return false;
		Estado exemplo = (Estado) obj;
		if (this.nome.equals(exemplo.getNome()) && this.UF.equals(exemplo.getUF()))
			return true;
		return false;
	}

  /**
	 * Método que retorna o nome e UF do Estado em String.
	 */
	public String toString() {
		return getNome()+"-"+getUF();
	}
}
