/**
 * <b>Medico</b> é a classe que armazena os atributos e métodos de um Médico do SistemaCovid.
 *  Ela extends a classe Pessoa, ou seja, herda todos os metodos e atributos de Pessoa.
 *  Essa Classe também implementa a interface ProfissionalSaude, assim recebendo todos os metodos dessa interface.
 * @author Cauany Nunes Rodrigues
 */
public class Medico extends Pessoa implements ProfissionalSaude {
	
	/**
	 * <b>crm</b> é o atributo que armazena o CRM (Conselho Nacional de Medicina) ativo do Médico.
	 */
	private int crm;
	
	/**
	 * <b>matricula</b> é o atributo que armazena a matrícula do Médico.
	 */
	private int matricula;
	
	/**
	 * <b>senha</b> é o atributo que armazena a senha do Médico.
	 */
	private String senha;

	/**
	 * Método que constrói um objeto do tipo Medico.
	 * @param nome O valor do nome do Médico herdado de Pessoa.
	 * @param cpf O valor do CPF da Médico herdado de Pessoa.
	 * @param dataNascimento O valor da data de nascimento do Médico herdado de Pessoa.
	 * @param cidade O valor da cidade do Médico herdado de Pessoa.
	 * @param tipoPrioridade O valor da prioridade na vacinação do Médico herdado de Pessoa.
	 * @param localVacinacao O valor do local de vacinação do Médico herdado de Pessoa.
	 * @param crm O valor da CRM do Médico.
	 * @param matricula O valor da matricula do Médico.
	 * @param senha O valor da senha do Médico.
	 */
	public Medico(String nome, String cpf, String dataNascimento, Cidade cidade, int tipoPrioridade, LocalVacinacao localVacinacao, int crm, int matricula, String senha) {
    super(nome, cpf, dataNascimento, cidade, localVacinacao, tipoPrioridade);
		this.crm = crm;
		this.matricula = matricula;
		this.senha = senha;
	}
	
	/**
	 * Método que altera o valor do atributo matricula.
	 * @param A nova matrícula do Médico.
	 */
	public void setMatricula(int matricula) {
		this.matricula = matricula;
		
	}
	
	/**
	 * Método que altera o valor do atributo senha.
	 * @param A nova senha do Médico.
	 */
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
		if (obj2.getCrm() == this.getCrm())
			return true;
		return false;
	}
	
	/**
	 * Método que retorna o Nome e o Cpf do Médico em String.
	 */
	public String toString() {
		return getNome() +  " CPF: " + getCpf();
	}
	
}
