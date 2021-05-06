/**
 * <b>Medico</b> é a classe que armazena os atributos e métodos
 * de um Médico do SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
public class Medico extends Pessoa implements ProfissionalSaude {
	
  /**
   * <b>crm</b> é o atributo que armazena o CRM (Conselho Nacional de 
   * Medicina) ativo do Médico.
   */
	private int crm;

  /**
   * <b>localVacinacao</b> é o atributo que armazena o local de vacinação
   * onde o Médico atua.
   */
	private LocalVacinacao localVacinacao;

  /**
   * <b>matricula</b> é o atributo que armazena a matrícula do Médico.
   */
	private int matricula;

  /**
   * <b>senha</b> é o atributo que armazena a senha do Médico.
   */
	private String senha;

	/**
   * Método Construtor da classe Médico.
   * @param nome O valor do nome do Médico.
	 * @param cpf O valor da CPF da Médico.
	 * @param dataNascimento O valor da data de nascimento do Médico.
	 * @param cidade O valor da cidade do Médico.
	 * @param status O valor do status de imunização do Médico.
	 * @param tipoPrioridade O valor da prioridade na vacinação do Médico.
   * @param crm O valor da CRM do Médico.
   * @param localVacinacao O valor do local de vacinação do Médico.
   * @param matricula O valor da matricula do Médico.
   * @param senha O valor da senha do Médico.
   */
	public Medico(String nome, int cpf, String dataNascimento, Cidade cidade, int tipoPrioridade, int crm, LocalVacinacao localVacinacao, int matricula, String senha) {
    super(nome, cpf, dataNascimento, cidade, tipoPrioridade);
		this.crm = crm;
		this.localVacinacao = localVacinacao;
		this.matricula = matricula;
		this.senha = senha;
	}

  /**
   * Método que altera o valor do atributo localVacinacao.
   * @param O novo local de vacinação do Médico.
   */
	@Override
	public void setLocalVacinacao(LocalVacinacao localVacinacao) {
		this.localVacinacao = localVacinacao;
		
	}

  /**
   * Método que altera o valor do atributo matricula.
   * @param A nova matrícula do Médico.
   */
	@Override
	public void setMatricula(int matricula) {
		this.matricula = matricula;
		
	}

  /**
   * Método que altera o valor do atributo senha.
   * @param A nova senha do Médico.
   */
	@Override
	public void setSenha(String senha) {
		this.senha = senha;
		
	}
	/**
   * Método que retorna o crm do Médico.
	 * @return O crm do Médico.
	 */
	public int getCrm() {
		return crm;
	}

	/**
   * Método que altera o valor do atributo crm.
	 * @param O novo CRM do Médico. 
	 */
	public void setCrm(int crm) {
		this.crm = crm;
	}

	/**
   * Método que retorna o local de vacinação do Médico.
	 * @return O local de vacinação do Médico.
	 */
	 public LocalVacinacao getLocalVacinacao() {
		return localVacinacao;
	}

	/**
   * Método que retorna a matrícula do Médico.
	 * @return A matrícula do Médico.
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
   * Método que retorna a senha do Médico.
	 * @return A senha do Médico.
	 */
	public String getSenha() {
		return senha;
	}
	
  /**
   * Método que verifica se um objeto é do tipo Medico.
   * Caso o seja, ele compara a matrícula das duas classes Medico.
   */
	public boolean equals(Object obj) {
		if (!(obj instanceof Medico))
			return false;
		Medico obj2 = (Medico) obj;
		if (obj2.getMatricula() == this.getMatricula())
			return true;
		return false;
	}
	
  /**
   * Método que retorna o nome e a matrícula do Médico em String.
   */
	public String toString() {
		return "Medico:\nNome: " + getNome() + ", Matricula: " + getMatricula();
	}
	
}
