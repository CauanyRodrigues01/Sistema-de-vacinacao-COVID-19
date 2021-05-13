import java.util.ArrayList;

/**
 * <b>LocalVacinacao</b> é a classe que armazena os atributos e métodos do Local de Vacinação do SistemaCovid.
 * @author Pedro Lobo Nascimento
 * @date 26/04/2021
 */
public class LocalVacinacao {

	/**
	 * <b>nome</b> é o atributo que armazena o nome do Local de Vacinação
	 */
	private String nome;
	
	/**
	 * <b>horarioAtendimento</b> é o atributo que armazena o horario de atendimento do Local de Vacinação.
	 */
	private String horarioAtendimento;

	/**
	 *<b>profissionaisSaude</b> é o atributo que armazena o número de profissionais da saúde no Local de Vacinação.
	 */
	private int profissionaisSaude;

	/**
	 * <b>estoqueVacina</b> é o atributo que armazena o estoque de vacinas do Local de Vacinação.
	 */
	private int estoqueVacina;

	/**
	 * <b>Cidade<b> é o atributo que armazena a cidade do Local de Vacinação.
	 */
	private Cidade cidade;

	/**
	 * <b>Medico<b> é o atributo que armazena a lista de médicos do Local de Vacinação.
	 */
	private ArrayList<Medico> medicos;

	/**
	 * <b>Enfermeiro<b> é o atributo que armazena a lista de enfermeiros do Local de Vacinação.
	 */
	private ArrayList<Enfermeiro> enfermeiros;
	
	/**
	 * <b>pessoas</b> é o atributo que armazena a lista de pessoas do Local de Vacinação.
	 */
	private ArrayList<Pessoa> pessoas;
	
	/**
	 * <b>ampolas</b> é o atributo que armazena a lista de ampolas do Local de Vacinação.
	 */
	private ArrayList<Ampola> ampolas;
	
	/**
	 * Métodos Construtores.
	 * @param nome O valor do nome do Local de Vacinação.
	 * @param horarioAtendimento O valor do horario de atendimento do Local de Vacinação.
	 * @param profissionaisSaude O valor do número de profissionais de saúde do Local de Vacinação.
	 * @param numPessoasNaoImunizada O valor do número de pessoas não imunizadas do Local de Vacinação.
	 * @param estoqueVacina O valor do estoque de vacinas do Local de Vacinação.
	 * @param cidade O valor da cidade do Local de Vacinação.
	 */
	public LocalVacinacao (String nome, String horarioAtendimento, int estoqueVacina, Cidade cidade) {
		this.nome = nome;
		this.horarioAtendimento = horarioAtendimento;
		this.estoqueVacina = estoqueVacina;
		this.cidade = cidade;
		this.medicos = new ArrayList<Medico>();
		this.enfermeiros = new ArrayList<Enfermeiro>();
		this.pessoas = new ArrayList<Pessoa>();
		this.ampolas = new ArrayList<Ampola>();
	}
	
	/**
	 * Método que repõe o estoque e preenche a lista de ampolas com a quantidade correspondente ao número do estoque.
	 * @param numNovasAmpola - número que será somado com o número de ampolas já existentes. 
	 * @param ampola - a lista de ampolas vai ter N ampolas do mesmo tipo da ampola passada como parêmetro.
	 * @author Cauany Nunes Rodrigues
	 */
	public void calculaEstoque(int numNovasAmpola, Ampola ampola) {
		
		// novoEstoque será o resultado do número de estoque já existente mais o número de ampolas adicionais.
		int novoEstoque = getEstoqueVacina() + numNovasAmpola;
		// estoqueVacina recebe o novo número de estoque.
		setEstoqueVacina(novoEstoque);
		
		// A lista de ampolas vai receber novas instâncias de Ampola.
		// O número de loops vai corresponder com o parâmetro numNovasAmpola.
		// A lista vai receber ampolas iguas à aquela passada como parâmetro.
		for (int n = 0; n <= numNovasAmpola; n++) {
			adicionaAmpola(new Ampola(ampola.getLote(), ampola.getValidade(), ampola.getPrazo(), ampola.getFabricante()));
		}
	}

	/**
	 * Método que retira uma ampola do LocalVacinacao caso a ampola tenha acabado.
	 * @param ampola
	 * @author Cauany Nunes Rodrigues
	 */
	public void analisaAmpola() {
		
		// A lista ampolas possue várias ampolas que quando recém criadas tem 10 doses.
		// Quando o número de doses é igual a 0 implica que essa ampola acabou, então deve-se removê-la.
		if(getAmpolas().get(0).getDoses() == 0) {
			// Diminui o primeiro valor da lista ampolas de LocalVacinacao.
			retiraAmpola();
			// Diminui um valor também do estoque de vacina para manter atualizado.
			setEstoqueVacina(getEstoqueVacina() - 1);
		}
	}
	
	/**
	 * Método que retira a primeira Ampola da lista ampolas.
	 * @author Cauany Nunes Rodrigues
	 */
	public void retiraAmpola() {
		this.ampolas.remove(0);
	}
	
	/**
	 * Método que adiciona os elementos na lista de ampolas.
	 * @author Cauany Nunes Rodrigues
	 */
	public void adicionaAmpola(Ampola ampola) {
		this.ampolas.add(ampola);
	}

	/**
	 * Método que soma os elementos na lista de Médicos.
	 * @author Pedro Lobo Nascimento
	 */
	public void AdicionarMedico(Medico medico) {
		this.medicos.add(medico);
	}
	  
	/**
	 * Método que soma os elementos na lista de Enfermeiro.
	 * @author Pedro Lobo Nascimento
	 */
	public void AdicionarEnfermeiro(Enfermeiro enfermeiro) {
		this.enfermeiros.add(enfermeiro);
	}
	
	/**
	 * Método que soma a lista de Médicos e Enfermeiros.
	 * @author Pedro Lobo Nascimento
	 */
	public int CalcularProfissionaisSaude(){
		return medicos.size()+enfermeiros.size();
	}
	  
	/**
	 * Método que soma os elementos na lista de Médicos.
	 * @author Pedro Lobo Nascimento
	 */
	public void AdicionarPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
	
	/**
	 * Método que retorna o valor do nome do Local de Vacinação.
	 * @return O nome do Local de Vacinação.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que altera o valor do atributo nome.
	 * @param nome O novo nome do Local de Vacinação.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que retorna o valor do horario de atendimento do Local de Vacinação.
	 * @return O horario de atendimento do Local de Vacinação.
	 */
	public String getHorarioAtendimento() {
		return horarioAtendimento;
	}
	
	/**
	 * Método que altera o valor do atributo horarioAtendimento.
	 * @param horarioAtendimento O novo horario de atendimento do Local de Vacinação.
	 */
	public void setHorarioAtendimento(String horarioAtendimento) {
		this.horarioAtendimento = horarioAtendimento;
	}
	
	/**
	 * Método que retorna o número de profissionais de saúde do Local de Vacinação.
	 * @return O número de profissionais de saúde do Local de Vacinação.
	 */
	public int getProfissionaisSaude() {
		return profissionaisSaude;
	}
	
	/**
	 * Método que altera o valor do atributo profissionaisSaude.
	 * @param profissionaisSaude O novo número de profissionais de saude do Local de Vacinação.
	 */
	public void setProfissionaisSaude(int profissionaisSaude) {
		this.profissionaisSaude = profissionaisSaude;
	}

	/**
	 * Método que retorna o valor do estoque de vacinas no Local de Vacinação
	 * @return O valor do estoque de vacinas no Local de Vacinação.
	 */
	public int getEstoqueVacina() {
		return estoqueVacina;
	}

	/**
	 * Método que altera o valor do atributo estoqueVacina.
	 * @param estoqueVacina O novo número do estoque de vacinas do Local de Vacinação.
	 */
	public void setEstoqueVacina(int estoqueVacina) {
		this.estoqueVacina = estoqueVacina;
	}

	/**
	 * Método que retorna o valor da cidade do Local de Vacinação.
	 * @return A cidade do Local de Vacinação.
	 */
	public Cidade getCidade() {
		return cidade;
	}

	/**
	 * Método que altera o valor do atributo cidade.
	 * @param cidade A nova cidade do Local de Vacinação.
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	/**
	 * Método que retorna o valor da lista de médicos no Local de Vacinação.
	 * @return A lista de médicos no Local de Vacinação.
	 */
	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	/**
	 * Método que altera o valor do atributo medicos.
	 * @param medicos A nova lista de médicos no Local de Vacinação.
	 */
	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	/**
	 * Método que retorna o valor da lista de enfermeiros no Local de Vacinação.
	 * @return A lista de enfermeiros no Local de Vacinação.
	 */
	public ArrayList<Enfermeiro> getEnfermeiros() {
		return enfermeiros;
	}

	/**
	 * Método que altera o valor do atributo enfermeiros.
	 * @param enfermeiros A nova lista de enfermeiros no Local de Vacinação.
	 */
	public void setEnfermeiros(ArrayList<Enfermeiro> enfermeiros) {
		this.enfermeiros = enfermeiros;
	}

	/**
	 * Método que retorna as pessoas que fazem parte do Local de Vacinação.
	 * @return A lista de pessoas do Local de Vacinação.
	 */
	public ArrayList<Ampola> getAmpolas() {
		return ampolas;
	}

	/**
	 * Método que altera o valor das ampolas do Local de Vacinação.
	 * @param ampolas A nova lista de ampolas do Local de Vacinação.
	 */
	public void setAmpolas(ArrayList<Ampola> ampolas) {
		this.ampolas = ampolas;
	}
	
	/**
	 * Método que retorna as pessoas que fazem parte do Local de Vacinação.
	 * @return A lista de pessoas do Local de Vacinação.
	 */
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	/**
	 * Método que altera o valor das pessoas do Local de Vacinação.
	 * @param pessoas A nova lista de pessoas do Local de Vacinação.
	 */
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	/**
	 * Método que compara se o objeto passado como parâmetro é do tipo LocalVacinacao.
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
	 * Método que retorna o local de vacinação e o horário de atendimento em String.
	 */
	public String toString() {
		return "localizado em "+ getCidade() +"\nHorario de atendimento: "+getHorarioAtendimento();
	} 
  
}
