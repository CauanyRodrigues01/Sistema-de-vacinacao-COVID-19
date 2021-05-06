/**
 * <b>Pessoa</b> é a classe que armazena os atributos e métodos de uma pessoa 
 * no SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
public class Pessoa {

  /**
   * <b>nome</b> é o atributo que armazena o nome da Pessoa.
   */
	private String nome;

  /**
   * <b>cpf</b> é o atributo que armazena o CPF da Pessoa.
   */
	private int cpf;

  /**
   * <b>dataNascimento</b> é o atributo que armazena a data de nascimento
   * da Pessoa.
   */
	private String dataNascimento;

  /**
   * <b>cidade</b> é o atributo que armazena a cidade em que a Pessoa mora.
   */
	private Cidade cidade;

  /**
   * <b>status</b> é o atributo que armazena o status de imunização da Pessoa.
   */
  private int status = 2;

  /**
   * <b>tipoPrioridade</b> é o atributo que armazena o tipo de prioridade na
   * fila de vacinação da Pessoa.
   */
	private int tipoPrioridade;

	/**
   * Método que constrói um objeto do tipo Pessoa.
	 * @param nome O valor do nome da Pessoa.
	 * @param cpf O valor da CPF da Pessoa.
	 * @param dataNascimento O valor da data de nascimento da Pessoa.
	 * @param cidade O valor da cidade da Pessoa.
	 * @param status O valor do status de imunização da Pessoa.
	 * @param tipoPrioridade O valor da prioridade na vacinação da Pessoa.
   */
	public Pessoa(String nome, int cpf, String dataNascimento, Cidade cidade, int tipoPrioridade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.tipoPrioridade = tipoPrioridade;
	}
	
	/**
   * Método que retorna o nome da Pessoa.
	 * @return O nome da Pessoa.
	 */
	public String getNome() {
		return nome;
	}
  
	/**
   * Método que altera o valor do atributo nome.
	 * @param nome O novo nome da Pessoa.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
   * Método que retorna o CPF da Pessoa.
	 * @return O CPF da Pessoa.
	 */
	public int getCpf() {
		return cpf;
	}

	/**
   * Método que altera o valor do atributo cpf.
	 * @param cpf O novo CPF da Pessoa.
	 */
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	/**
   * Método que retorna a data de nascimento da Pessoa.
	 * @return A data de nascimento da Pessoa.
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}
	/**
   * Método que altera o valor do atributo dataNascimento.
	 * @param dataNascimento A nova data de nascimento da Pessoa.
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
   * Método que retorna a cidade da Pessoa.
	 * @return A cidade da Pessoa.
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
   * Método que altera o valor do atributo cidade.
	 * @param cidade A nova cidade da Pessoa.
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

  /**
   * Método que retorna o status de imunização da Pessoa.
	 * @return O status de imunização da Pessoa.
	 */
	public int getStatus() {
		return status;
	}

	/**
   * Método que altera o valor do atributo status.
	 * @param status O novo status de imunização da Pessoa.
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
   * Método que retorna o tipo de prioridade da Pessoa.
	 * @return O tipo de prioridade da Pessoa.
	 */
	public int getTipoPrioridade() {
		return tipoPrioridade;
	}

	/**
   * Método que altera o valor do atributo tipoPrioridade.
	 * @param tipoPrioridade O novo tipo de prioridade da Pessoa.
	 */
	public void setTipoPrioridade(int tipoPrioridade) {
		this.tipoPrioridade = tipoPrioridade;
	}
	
  /**
   * Método que verifica se o objeto é do tipo Pessoa.
   * Caso o seja, ele compara o CPF das duas classes Pessoa.
   */
	public boolean equals(Object obj) {
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa obj2 = (Pessoa) obj;
		if (obj2.getCpf() == this.getCpf())
			return true;
		return false;
	}
	
  /**
   * Método que retorna o nome e CPF da Pessoa em String.
   */
	public String toString() {
		return "Pessoa:\nNome: " + getNome() + ", Cpf: " + getNome();
	}
}
