/**
 * <b>Enfermeiro</b> é a classe que armazena os atributos e métodos de um enfermeiro do SistemaCovid.
 * Ela extends a classe Pessoa, ou seja, herda todos os metodos e atributos de Pessoa.
 * Essa Classe também implementa a interface ProfissionalSaude, assim recebendo todos os metodos dessa interface.
 * @author Cauany Nunes Rodrigues
 */
public class Enfermeiro extends Pessoa implements ProfissionalSaude {
	
	/**
	 * <b>cre</b> é o atributo que armazena o CRE (Conselho Regional de Enfermagem) ativo  do Enfermeiro.
	 */
	private int cre;
	
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
	 * @param nome O valor do nome do Enfermeiro herdado de Pessoa.
	 * @param cpf O valor da CPF da Enfermeiro herdado de Pessoa.
	 * @param dataNascimento O valor da data de nascimento do Enfermeiro herdado de Pessoa.
	 * @param cidade O valor da cidade do Enfermeiro herdado de Pessoa.
	 * @param tipoPrioridade O valor da prioridade na vacinação do Enfermeiro herdado de Pessoa.
	 * @param localVacinacao O valor do local de vacinação do Enfermeiro herdado de Pessoa.
	 * @param cre O valor da CRE do Enfermeiro.
	 * @param matricula O valor da matricula do Enfermeiro.
	 * @param senha O valor da senha do Enfermeiro.
	 */
	public Enfermeiro(String nome, String cpf, String dataNascimento, Cidade cidade, int tipoPrioridade, int cre, LocalVacinacao localVacinacao, int matricula, String senha) {
		super(nome, cpf, dataNascimento, cidade, localVacinacao, tipoPrioridade);
		this.cre = cre;
		this.matricula = matricula;
		this.senha = senha;
	}
	
	/**
	 * Método que altera o valor do atributo matricula.
	 * @param A nova matrícula do Enfermeiro.
	 */
	public void setMatricula(int matricula) {
		this.matricula = matricula;
		
	}
	
	/**
	 * Método que altera o valor do atributo senha.
	 * @param A nova senha do Enfermeiro.
	 */
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
	public void setCre(int cre) {
		this.cre = cre;
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
		if (obj2.getCre() == this.getCre())
			return true;
		return false;
	}
	
	/**
	 * Método que retorna o nome e o cpf do Enfermeiro em String.
	 */
	public String toString() {
		return  getNome() + " CPF: " + getCpf();
	}
	
}
