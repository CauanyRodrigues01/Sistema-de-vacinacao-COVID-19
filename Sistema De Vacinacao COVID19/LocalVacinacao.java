import java.util.ArrayList;

/**
 * <b>LocalVacinacao</b> � a classe que armazena os atributos e m�todos do Local de Vacina��o do SistemaCovid.
 * @author Pedro Lobo Nascimento
 * @date 26/04/2021
 */
public class LocalVacinacao {

	/**
	 * <b>nome</b> � o atributo que armazena o nome do Local de Vacina��o
	 */
	private String nome;
	/**
	 * <b>horarioAtendimento</b> � o atributo que armazena o horario de atendimento do Local de Vacina��o.
	 */
	private String horarioAtendimento;

	/**
	 *<b>profissionaisSaude</b> � o atributo que armazena o n�mero de profissionais da sa�de no Local de Vacina��o.
	 */
	private int profissionaisSaude;

	/**
	 * <b>estoqueVacina</b> � o atributo que armazena o estoque de vacinas do Local de Vacina��o.
	 */
	private int estoqueVacina;

	/**
	 * <b>Cidade<b> � o atributo que armazena a cidade do Local de Vacina��o.
	 */
	private Cidade cidade;

	/**
	 * <b>Medico<b> � o atributo que armazena a lista de m�dicos do Local de Vacina��o.
	 */
	private ArrayList<Medico> medicos;

	/**
	 * <b>Enfermeiro<b> � o atributo que armazena a lista de enfermeiros do Local de Vacina��o.
	 */
	private ArrayList<Enfermeiro> enfermeiros;

	/**
	 * M�todos Construtores.
	 * @param nome O valor do nome do Local de Vacina��o.
	 * @param horarioAtendimento O valor do horario de atendimento do Local de Vacina��o.
	 * @param profissionaisSaude O valor do n�mero de profissionais de sa�de do Local de Vacina��o.
	 * @param numPessoasNaoImunizada O valor do n�mero de pessoas n�o imunizadas do Local de Vacina��o.
	 * @param estoqueVacina O valor do estoque de vacinas do Local de Vacina��o.
	 * @param cidade O valor da cidade do Local de Vacina��o.
	 */
	public LocalVacinacao (String nome, String horarioAtendimento, int estoqueVacina, Cidade cidade) {
		this.nome = nome;
		this.horarioAtendimento = horarioAtendimento;
		this.estoqueVacina = estoqueVacina;
		this.cidade = cidade;
		this.medicos = new ArrayList();
		this.enfermeiros = new ArrayList();
    //adicionar lista pessoas 
	}

	/**
	 * M�todo que retorna o valor do nome do Local de Vacina��o.
	 * @return O nome do Local de Vacina��o.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo que altera o valor do atributo nome.
	 * @param nome O novo nome do Local de Vacina��o.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo que retorna o valor do horario de atendimento do Local de Vacina��o.
	 * @return O horario de atendimento do Local de Vacina��o.
	 */
	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}
	
	/**
	 * M�todo que altera o valor do atributo horarioAtendimento.
	 * @param horarioAtendimento O novo horario de atendimento do Local de Vacina��o.
	 */
	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	
	/**
	 * M�todo que retorna o n�mero de profissionais de sa�de do Local de Vacina��o.
	 * @return O n�mero de profissionais de sa�de do Local de Vacina��o.
	 */
	public int getProfissionaisSaude() {
		return profissionaisSaude;
	}
	
	/**
	 * M�todo que altera o valor do atributo profissionaisSaude.
	 * @param profissionaisSaude O novo n�mero de profissionais de saude do Local de Vacina��o.
	 */
	public void setProfissionaisSaude(int profissionaisSaude) {
		this.profissionaisSaude = profissionaisSaude;
	}

	/**
	 * M�todo que retorna o valor do estoque de vacinas no Local de Vacina��o
	 * @return O valor do estoque de vacinas no Local de Vacina��o.
	 */
	public int getEstoqueVacina() {
		return estoqueVacina;
	}

	/**
	 * M�todo que altera o valor do atributo estoqueVacina.
	 * @param estoqueVacina O novo n�mero do estoque de vacinas do Local de Vacina��o.
	 */
	public void setEstoqueVacina(int estoqueVacina) {
		this.estoqueVacina = estoqueVacina;
	}

	/**
	 * M�todo que retorna o valor da cidade do Local de Vacina��o.
	 * @return A cidade do Local de Vacina��o.
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * M�todo que altera o valor do atributo cidade.
	 * @param cidade A nova cidade do Local de Vacina��o.
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * M�todo que retorna o valor da lista de m�dicos no Local de Vacina��o.
	 * @return A lista de m�dicos no Local de Vacina��o.
	 */
	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	/**
	 * M�todo que altera o valor do atributo medicos.
	 * @param medicos A nova lista de m�dicos no Local de Vacina��o.
	 */
	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	/**
	 * M�todo que retorna o valor da lista de enfermeiros no Local de Vacina��o.
	 * @return A lista de enfermeiros no Local de Vacina��o.
	 */
	public ArrayList<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	/**
	 * M�todo que altera o valor do atributo enfermeiros.
	 * @param enfermeiros A nova lista de enfermeiros no Local de Vacina��o.
	 */
	public void setEnfermeiros(ArrayList<Enfermeiro> enfermeiros) {
		this.enfermeiros = enfermeiros;
	}

	/**
	 * M�todo que compara se o objeto passado como par�metro � do tipo LocalVacinacao.
	 * Caso o seja, ele compara o nome duas classes LocalVacinacao.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof LocalVacinacao))
			return false;
		LocalVacinacao exemplo = (LocalVacinacao) obj;
		if (this.nome.equals(exemplo.getNome()))
			return true;
		return false;
	}

	/**
	 * M�todo que retorna o local de vacina��o e o hor�rio de atendimento em String.
	 */
	public String toString() {
		return "Local de vacina��o:\nNome: "+getNome()+"\nHorario de atendimento: "+getHorarioAtendimento();
	}

  /**
   * M�todo que soma os elementos na lista de M�dicos.
   */
  public void AdicionarMedico(Medico medico) {
		this.medicos.add(medico);
	}
  
  /**
   * M�todo que soma os elementos na lista de Enfermeiro.
   */
  public void AdicionarEnfermeiro(Enfermeiro enfermeiro) {
    this.enfermeiros.add(enfermeiro);
  }
  
  /**
   * M�todo que soma a lista de M�dicos e Enfermeiros.
   */
  public int CalcularProfissionaisSaude(){
    return medicos.size()+enfermeiros.size();
  }
}
