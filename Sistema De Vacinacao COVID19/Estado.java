import java.util.ArrayList;

/**
 * <b>Estado</b> � a classe que armazena os atributos e m�todos do Estado do SistemaCovid.
 * @author Maria Eduarda Viana Cordeiro dos Santos
 * @date 28/04/2021
 */
public class Estado {

	/**
	 * <b>UF</b> � o atributo que armazena a UF (Unidade Federativa) do Estado.
	 */
	private String UF;

	/**
	 * <b>nome</b> � o atributo que armazena o nome do Estado.
	 */
	private String nome;

	/**
	 * <b>cidades</b> � o atributo que armazena a lista de cidades do Estado.
	 */
	private ArrayList<Cidade> cidades;

	/**
	 * <b>numTotalPessoas</b> � o atributo que armazena o n�mero total de pessoas do Estado.
	 */
	private int numTotalPessoas;

	/**
	 * <b>numPessoasImunizadas</b> � o atributo que armazena o n�mero de pessoas imunizadas do Estado.
	 */
	private int numPessoasImunizada;


	/**
	 * <b>estoque</b> � o atributo que armazena o estoque de vacinas do Estado.
	 */
	private int estoque;

	/**
	 * <b>locaisVacinacao</b> � o atributo que armazena os locais de vacina��o do Estado.
	 */
	private int locaisVacinacao;
	
	/**
	 * M�todo que constr�i um objeto do tipo Estado.
	 * @param UF O valor da UF do Estado.
	 * @param numTotalPessoas O valor do n�mero total de pessoas no Estado.
	 * @param numPessoasImunizada O valor do n�mero de pessoas imunizadas no Estado.
	 */
	public Estado(String UF, String nome, int numTotalPessoas, int numPessoasImunizada) {
		this.UF = UF;
		this.nome = nome;
		this.numTotalPessoas = numTotalPessoas;
		this.numPessoasImunizada = numPessoasImunizada;
		this.cidades = new ArrayList <Cidade>();

	}
	
	/**
	 * M�todo que retorna o nome do Estado.
	 * @return O nome do Estado.
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
	 * M�todo que retorna a UF do Estado.
	 * @return A UF do Estado.
	 */
	public String getUF() {
		return UF;
	}

	/**
	 * M�todo que altera o valor do atributo UF.
	 * @param uF A nova UF do Estado.
	 */
	public void setUF(String uF) {
		UF = uF;
	}
	
	/**
	 * M�todo que retorna a lista de cidades do Estado.
	 * @return A lista de cidades do Estado.
	 */
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	/**
	 * M�todo que altera o valor do atributo cidades.
	 * @param cidades A nova lista de cidades do Estado.
	 */
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}

	/**
	 * M�toro que retorna o n�mero total de pessoas no Estado.
	 * @return O n�mero total de pessoas do Estado.
	 */
	public int getNumTotalPessoas() {
		return numTotalPessoas;
	}

	/**
	 * M�todo que altera o valor do atributo numTotalPessoas.
	 * @param numTotalPessoas O novo n�mero total de pessoas no Estado.
	 */
	public void setNumTotalPessoas(int numTotalPessoas) {
		this.numTotalPessoas = numTotalPessoas;
	}

	/**
	 * M�todo que retorna o n�mero de pessoas imunizadas no Estado.
	 * @return
	 */
	public int getNumPessoasImunizada() {
		return numPessoasImunizada;
	}

	/**
	 * M�todo que altera o valor do atributo numPessoasImunizada.
	 * @param numPessoasImunizada O novo n�mero de pessoas imunizadas no Estado.
	 */
	public void setNumPessoasImunizada(int numPessoasImunizada) {
		this.numPessoasImunizada = numPessoasImunizada;
	}
	
	/**
	 * M�todo que compara se o objeto passado como par�metro � do tipo Estado.
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
	 * M�todo que retorna o nome e UF do Estado em String.
	 */
	public String toString() {
		return getNome()+"-"+getUF();
	}

  /**
  * Metodo que adiciona uma cidade dentro da lista de cidades do estado
  */
  public void addCidade(Cidade cidade) {
		this.cidades.add(cidade);
	}

  /**
  * Metodo que retorna quantas pessoas n�o est�o imunizadas no Estado
  */
  public int CalcularPessoaNaoImunizada() {
		int pessoaNaoImunizadas = getNumTotalPessoas() - getNumPessoasImunizada();
		return pessoaNaoImunizadas; 
	}

  /*
  public void CalcularVacinaNecessaria() {
		// TODO Auto-generated method stub
		falta implementar esse metodo
	}
  */

}
