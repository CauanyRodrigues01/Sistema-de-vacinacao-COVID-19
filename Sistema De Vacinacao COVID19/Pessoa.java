/**
 * <b>Pessoa</b> é a classe que armazena os atributos e métodos de uma pessoa no SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
abstract class Pessoa {
	
	/**
	 * <b>nome</b> é o atributo que armazena o nome da Pessoa.
	 */
	private String nome;
	
	/**
	 * <b>cpf</b> é o atributo que armazena o CPF da Pessoa.
	 */
	private String cpf;
	
	/**
	 * <b>dataNascimento</b> é o atributo que armazena a data de nascimento da Pessoa.
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
	 * <b>tipoPrioridade</b> é o atributo que armazena o tipo de prioridade na fila de vacinação da Pessoa.
	 */
	private int tipoPrioridade;
	
	/**
	 * <b>localVacinacao</b> é o atributo que armazena o local de vacinação de qual a Pessoa pertence ou seja, de onde ela vai se vacinada.
	 */
	private LocalVacinacao localVacinacao;

	/**
	 * Método que constrói um objeto do tipo Pessoa.
	 * @param nome O valor do nome da Pessoa.
	 * @param cpf O valor da CPF da Pessoa.
	 * @param dataNascimento O valor da data de nascimento da Pessoa.
	 * @param cidade O valor da cidade da Pessoa.
	 * @param localVacinacao O valor do Local de Vacinacao.
	 * @param tipoPrioridade O valor que indica a prioridade da Pessoa.
	 */
	public Pessoa(String nome, String cpf, String dataNascimento, Cidade cidade, LocalVacinacao localVacinacao, int tipoPrioridade) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.localVacinacao = localVacinacao;
		this.tipoPrioridade = tipoPrioridade;
	}

	/**Método para definir qual prioridade a Pessoa tem.
	 * @author Cauany Nunes Rodrigues
	 * @return int - Número que indica a prioridade da Pessoa.
	 */
	public int analisaPrioridade() {
		
		return getTipoPrioridade();
		
	}
	
	/**
	 * Método que altera o status da Pessoa e atualiza a dose da ampola.
	 * @author Cauany Nunes Rodrigues
	 */
	public void recebeDose() {
		
		// Primeiro pegamos do local de vacinação a lista de ampolas e então pegamos a primeira ampola dessa lista.
		// Depois chamamos o método diminuiDose() nessa ampola.
		getLocalVacinacao().getAmpolas().get(0).diminuiDose();
		
		// Status de Pessoa é inicializado igual a 2.
		// Devemos entçao alterar o status de Paciente para -1 quando ele recebe uma dose.
		// Se o status era igual a 2, vai passar a ter somente 1, ou seja, está parcialmente vacinado.
		// Se o status era igual a 1, vai passar a ter 0, ou seja, está vacinado.
		int status = getStatus();
		setStatus(status - 1);
		
		// Quando a Pessoa receber a dose demos analisar se ampola acabou ou não e então tomar as providências necessárias.
		getLocalVacinacao().analisaAmpola();
		
	}
	
	/**
	 * Método que retorna o nome da Pessoa.
	 * @return nome O nome da Pessoa.
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
	 * @return cpf O CPF da Pessoa.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Método que altera o valor do atributo cpf.
	 * @param cpf O novo CPF da Pessoa.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * Método que retorna a data de nascimento da Pessoa.
	 * @return dataNascimento A data de nascimento da Pessoa.
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
	 * @return cidade A cidade da Pessoa.
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
	 * @return status O status de imunização da Pessoa.
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
	 * @return tipoPrioridade O tipo de prioridade da Pessoa.
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
	 * Método que retorna o localVacinacao da Pessoa.
	 * @return localVacinacao O localVacinacao da Pessoa.
	 */
	public LocalVacinacao getLocalVacinacao() {
		return localVacinacao;
	}

	/**
	 * Método que altera o valor do atributo localVacinacao.
	 * @param localVacinacao O novo localVacinacao da Pessoa.
	 */
	public void setLocalVacinacao(LocalVacinacao localVacinacao) {
		this.localVacinacao = localVacinacao;
	}
	
	/**
	 * Método que verifica se o objeto é do tipo Pessoa.
	 * Caso o seja, ele compara o CPF das duas classes Pessoa.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa obj2 = (Pessoa) obj;
		if (obj2.getCpf().equals(this.getCpf()))
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
