/**
 * <b>Pessoa</b> � a classe que armazena os atributos e m�todos de uma pessoa no SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
abstract class Pessoa {
	
	/**
	 * <b>nome</b> � o atributo que armazena o nome da Pessoa.
	 */
	private String nome;
	
	/**
	 * <b>cpf</b> � o atributo que armazena o CPF da Pessoa.
	 */
	private String cpf;
	
	/**
	 * <b>dataNascimento</b> � o atributo que armazena a data de nascimento da Pessoa.
	 */
	private String dataNascimento;
	
	/**
	 * <b>cidade</b> � o atributo que armazena a cidade em que a Pessoa mora.
	 */
	private Cidade cidade;
	
	/**
	 * <b>status</b> � o atributo que armazena o status de imuniza��o da Pessoa.
	 */
	private int status = 2;
	
	/**
	 * <b>tipoPrioridade</b> � o atributo que armazena o tipo de prioridade na fila de vacina��o da Pessoa.
	 */
	private int tipoPrioridade;
	
	/**
	 * <b>localVacinacao</b> � o atributo que armazena o local de vacina��o de qual a Pessoa pertence ou seja, de onde ela vai se vacinada.
	 */
	private LocalVacinacao localVacinacao;

	/**
	 * M�todo que constr�i um objeto do tipo Pessoa.
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

	/**M�todo para definir qual prioridade a Pessoa tem.
	 * @author Cauany Nunes Rodrigues
	 * @return int - N�mero que indica a prioridade da Pessoa.
	 */
	public int analisaPrioridade() {
		
		return getTipoPrioridade();
		
	}
	
	/**
	 * M�todo que altera o status da Pessoa e atualiza a dose da ampola.
	 * @author Cauany Nunes Rodrigues
	 */
	public void recebeDose() {
		
		// Primeiro pegamos do local de vacina��o a lista de ampolas e ent�o pegamos a primeira ampola dessa lista.
		// Depois chamamos o m�todo diminuiDose() nessa ampola.
		getLocalVacinacao().getAmpolas().get(0).diminuiDose();
		
		// Status de Pessoa � inicializado igual a 2.
		// Devemos ent�ao alterar o status de Paciente para -1 quando ele recebe uma dose.
		// Se o status era igual a 2, vai passar a ter somente 1, ou seja, est� parcialmente vacinado.
		// Se o status era igual a 1, vai passar a ter 0, ou seja, est� vacinado.
		int status = getStatus();
		setStatus(status - 1);
		
		// Quando a Pessoa receber a dose demos analisar se ampola acabou ou n�o e ent�o tomar as provid�ncias necess�rias.
		getLocalVacinacao().analisaAmpola();
		
	}
	
	/**
	 * M�todo que retorna o nome da Pessoa.
	 * @return nome O nome da Pessoa.
	 */
	public String getNome() {
		return nome;
	}
  
	/**
	 * M�todo que altera o valor do atributo nome.
	 * @param nome O novo nome da Pessoa.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo que retorna o CPF da Pessoa.
	 * @return cpf O CPF da Pessoa.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * M�todo que altera o valor do atributo cpf.
	 * @param cpf O novo CPF da Pessoa.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	/**
	 * M�todo que retorna a data de nascimento da Pessoa.
	 * @return dataNascimento A data de nascimento da Pessoa.
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	/**
	 * M�todo que altera o valor do atributo dataNascimento.
	 * @param dataNascimento A nova data de nascimento da Pessoa.
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * M�todo que retorna a cidade da Pessoa.
	 * @return cidade A cidade da Pessoa.
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * M�todo que altera o valor do atributo cidade.
	 * @param cidade A nova cidade da Pessoa.
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	/**
	 * M�todo que retorna o status de imuniza��o da Pessoa.
	 * @return status O status de imuniza��o da Pessoa.
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * M�todo que altera o valor do atributo status.
	 * @param status O novo status de imuniza��o da Pessoa.
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * M�todo que retorna o tipo de prioridade da Pessoa.
	 * @return tipoPrioridade O tipo de prioridade da Pessoa.
	 */
	public int getTipoPrioridade() {
		return tipoPrioridade;
	}

	/**
	 * M�todo que altera o valor do atributo tipoPrioridade.
	 * @param tipoPrioridade O novo tipo de prioridade da Pessoa.
	 */
	public void setTipoPrioridade(int tipoPrioridade) {
		this.tipoPrioridade = tipoPrioridade;
	}

	/**
	 * M�todo que retorna o localVacinacao da Pessoa.
	 * @return localVacinacao O localVacinacao da Pessoa.
	 */
	public LocalVacinacao getLocalVacinacao() {
		return localVacinacao;
	}

	/**
	 * M�todo que altera o valor do atributo localVacinacao.
	 * @param localVacinacao O novo localVacinacao da Pessoa.
	 */
	public void setLocalVacinacao(LocalVacinacao localVacinacao) {
		this.localVacinacao = localVacinacao;
	}
	
	/**
	 * M�todo que verifica se o objeto � do tipo Pessoa.
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
	 * M�todo que retorna o nome e CPF da Pessoa em String.
	 */
	public String toString() {
		return "Pessoa:\nNome: " + getNome() + ", Cpf: " + getNome();
	}
}
