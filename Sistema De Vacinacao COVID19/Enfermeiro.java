/**
 * <b>Enfermeiro</b> é a classe que armazena os atributos e métodos
 * de um enfermeiro do SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
public class Enfermeiro extends Pessoa implements ProfissionalSaude {
	
  /**
   * <b>cre</b> é o atributo que armazena o CRE (Conselho Regional
   * de Enfermagem) ativo  do Enfermeiro.
   */
	private int cre;

  /**
   * <b>localVacinacao</b> é o atributo que armazena o local de vacinação
   * em que o Enfermeiro trabalha.
   */
	private LocalVacinacao localVacinacao;

  /**
   * <b>matricula</b> é o atributo que armazena a matricula do Enfermeiro.
   */
	private int matricula;

  /** 
   * <b>senha</b> é o atributo que armazena a senha do Enfermeiro.
   */
	private String senha;
	
  /**
	 * Método que constrói um objeto do tipo Enfermeiro.
	 * @param nome O valor do nome do Enfermeiro.
	 * @param cpf O valor da CPF da Enfermeiro.
	 * @param dataNascimento O valor da data de nascimento do Enfermeiro.
	 * @param cidade O valor da cidade do Enfermeiro.
	 * @param status O valor do status de imunização do Enfermeiro.
	 * @param tipoPrioridade O valor da prioridade na vacinação do Enfermeiro.
	 * @param cre O valor da CRE do Enfermeiro.
	 * @param localVacinacao O valor do local de vacinação do Enfermeiro.
	 * @param matricula O valor da matricula do Enfermeiro.
	 * @param senha O valor da senha do Enfermeiro.
	 */
	public Enfermeiro(String nome, int cpf, String dataNascimento, Cidade cidade, int tipoPrioridade, int cre, LocalVacinacao localVacinacao, int matricula, String senha) {
    super(nome, cpf, dataNascimento, cidade, tipoPrioridade);
		this.cre = cre;
		this.localVacinacao = localVacinacao;
		this.matricula = matricula;
		this.senha = senha;
	}

  /**
   * Método que altera o valor do atributo localVacinacao.
   * @param O novo local de vacinação do Enfermeiro.
   */
	@Override
	public void setLocalVacinacao(LocalVacinacao localVacinacao) {
		this.localVacinacao = localVacinacao;
		
	}
  
  /**
   * Método que altera o valor do atributo matricula.
   * @param A nova matrícula do Enfermeiro.
   */
	@Override
	public void setMatricula(int matricula) {
		this.matricula = matricula;
		
	}

  /**
   * Método que altera o valor do atributo senha.
   * @param A nova senha do Enfermeiro.
   */
	@Override
	public void setSenha(String senha) {
		this.senha = senha;
		
	}

	/**
   * Método que retorna o CRE do Enfermeiro.
	 * @return O CRE do Enfermeiro.
	 */
	public int getCre() {
		return cre;
	}

	/**
   * Método que altera o valor do atributo cre.
	 * @param crm O novo CRE do Enfermeiro.
	 */
	public void setCrm(int cre) {
		this.cre = cre;
	}

	/**
   * Método que retorna o local de vacinação do Enfermeiro.
	 * @return o local de vacinação do Enfermeiro.
	 */
	 public LocalVacinacao getLocalVacinacao() {
		return localVacinacao;
	}

	/**
   * Método que retorna a matrícula do Enfermeiro.
	 * @return A matrícula do Enfermeiro.
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
   * Método que retorna a senha do Enfermeiro.
	 * @return A senha do Enfermeiro.
	 */
	public String getSenha() {
		return senha;
	}
	
  /**
   * Método que verifica se um objeto é do tipo Enfermeiro.
   * Caso o seja, ele compara a matricula das duas classes Enfermeiro.
   */
	public boolean equals(Object obj) {
		if (!(obj instanceof Enfermeiro))
			return false;
		Enfermeiro obj2 = (Enfermeiro) obj;
		if (obj2.getMatricula() == this.getMatricula())
			return true;
		return false;
	}
	
  /*
   * Método que retorna o nome e matrícula do Enfermeiro em String.
   */
  public String toString() {
		return "Enfermeiro:\nNome: " + getNome() + ", Matricula: " + getMatricula();
	}
	
}
