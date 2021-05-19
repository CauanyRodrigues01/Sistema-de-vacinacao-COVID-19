/**
 * <b>Medico</b> � a classe que armazena os atributos e m�todos de um M�dico do SistemaCovid.
 *  Ela extends a classe Pessoa, ou seja, herda todos os metodos e atributos de Pessoa.
 *  Essa Classe tamb�m implementa a interface ProfissionalSaude, assim recebendo todos os metodos dessa interface.
 * @author Cauany Nunes Rodrigues
 */
public class Medico extends Pessoa implements ProfissionalSaude {
	
	/**
	 * <b>crm</b> � o atributo que armazena o CRM (Conselho Nacional de Medicina) ativo do M�dico.
	 */
	private int crm;
	
	/**
	 * <b>matricula</b> � o atributo que armazena a matr�cula do M�dico.
	 */
	private int matricula;
	
	/**
	 * <b>senha</b> � o atributo que armazena a senha do M�dico.
	 */
	private String senha;

	/**
	 * M�todo que constr�i um objeto do tipo Medico.
	 * @param nome O valor do nome do M�dico herdado de Pessoa.
	 * @param cpf O valor do CPF da M�dico herdado de Pessoa.
	 * @param dataNascimento O valor da data de nascimento do M�dico herdado de Pessoa.
	 * @param cidade O valor da cidade do M�dico herdado de Pessoa.
	 * @param tipoPrioridade O valor da prioridade na vacina��o do M�dico herdado de Pessoa.
	 * @param localVacinacao O valor do local de vacina��o do M�dico herdado de Pessoa.
	 * @param crm O valor da CRM do M�dico.
	 * @param matricula O valor da matricula do M�dico.
	 * @param senha O valor da senha do M�dico.
	 */
	public Medico(String nome, String cpf, String dataNascimento, Cidade cidade, int tipoPrioridade, LocalVacinacao localVacinacao, int crm, int matricula, String senha) {
    super(nome, cpf, dataNascimento, cidade, localVacinacao, tipoPrioridade);
		this.crm = crm;
		this.matricula = matricula;
		this.senha = senha;
	}
	
	/**
	 * M�todo que altera o valor do atributo matricula.
	 * @param A nova matr�cula do M�dico.
	 */
	public void setMatricula(int matricula) {
		this.matricula = matricula;
		
	}
	
	/**
	 * M�todo que altera o valor do atributo senha.
	 * @param A nova senha do M�dico.
	 */
	public void setSenha(String senha) {
		this.senha = senha;
		
	}
	
	/**
	 * M�todo que retorna o crm do M�dico.
	 * @return O crm do M�dico.
	 */
	public int getCrm() {
		return crm;
	}

	/**
	 * M�todo que altera o valor do atributo crm.
	 * @param O novo CRM do M�dico. 
	 */
	public void setCrm(int crm) {
		this.crm = crm;
	}

	/**
	 * M�todo que retorna a matr�cula do M�dico.
	 * @return A matr�cula do M�dico.
	 */
	public int getMatricula() {
		return matricula;
	}

	/**
	 * M�todo que retorna a senha do M�dico.
	 * @return A senha do M�dico.
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * M�todo que verifica se um objeto � do tipo Medico.
	 * Caso o seja, ele compara a matr�cula das duas classes Medico.
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
	 * M�todo que retorna o Nome e o Cpf do M�dico em String.
	 */
	public String toString() {
		return getNome() +  " CPF: " + getCpf();
	}
	
}
