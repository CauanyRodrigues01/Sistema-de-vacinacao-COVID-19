import java.util.ArrayList;

/**
 * <b>LocalVacinacao</b> é a classe que armazena os atributos e métodos do Local de Vacinação do SistemaCovid.
 * Ela implementa a interface InformationProcessor, assim recebendo todos os metodos dessa interface.
 * @author Pedro Lobo Nascimento
 * @date 26/04/2021
 */
public class LocalVacinacao implements InformationProcessor{

	/**
	 * <b>nome</b> é o atributo que armazena o nome do Local de Vacinação
	 */
	private String nome;
	
	/**
	 * <b>horarioAtendimento</b> é o atributo que armazena o horario de atendimento do Local de Vacinação.
	 */
	private String horarioAtendimento;

	/**
	 * <b>estoqueVacina</b> é o atributo que armazena o estoque de vacinas do Local de Vacinação.
	 */
	private int estoqueVacina = 0;

	/**
	 * <b>Cidade<b> é o atributo que armazena a cidade do Local de Vacinação.
	 */
	private Cidade cidade;
	
	/**
	 * <b>pessoas</b> é o atributo que armazena a lista de pessoas do Local de Vacinação.
	 */
	private ArrayList<Pessoa> pessoas;
	
	/**
	 * <b>ampolas</b> é o atributo que armazena a lista de ampolas do Local de Vacinação.
	 */
	private ArrayList<Ampola> ampolas;
	
	/**
	 * Método que constrói um objeto do tipo LocalVacinacao.
	 * @param nome O valor do nome do Local de Vacinação.
	 * @param horarioAtendimento O valor do horario de atendimento do Local de Vacinação.
	 * @param cidade O valor da cidade do Local de Vacinação.
	 */
	public LocalVacinacao (String nome, String horarioAtendimento, Cidade cidade) {
		this.nome = nome;
		this.horarioAtendimento = horarioAtendimento;
		this.cidade = cidade;
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
		for (int n = 0; n < numNovasAmpola; n++) {
			adicionaAmpola(new Ampola(ampola.getFabricante(), ampola.getEficacia(), ampola.getLote(), ampola.getValidade(), ampola.getPrazo()));
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
	 * Método que adiciona pessoas, sejam elas pacientes, medicos e enfermeiros na lista de pessoas.
	 * @author Pedro Lobo Nascimento
	 */
	public void AdicionarPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
	
	/**
	 * Método que calcula o total de Pessoas, sejam elas médicos, enfermeiros e pacientes.
	 * @author Cauany Nunes Rodrigues
	 * @return tamanho da lista de Pessoas.
	 */
	public int calculaPessoas() {
		return getPessoas().size();
	}
	
	/**
	 * Método que calcula o número de pessoas totalmente imunizadas do local.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas imunizadas.
	 */
	public int calculaPessoasImunizadas() {
		int numPessoas = 0;
		for (int i = 0; i < getPessoas().size(); i++) {
			if (getPessoas().get(i).getStatus() == 0) {
				numPessoas += 1;
			}
		}
		return numPessoas;
	}
	
	/**
	 * Método que calcula o número de pessoas parcialmente imunizadas do local.
	 * parcialmente imunizadas é quando só tomou uma dose.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas parcialmente imunizadas.
	 */
	public int calculaPessoasParcialmenteImunizadas() {
		int numPessoas = 0;
		for (int i = 0; i < getPessoas().size(); i++) {
			if (getPessoas().get(i).getStatus() == 1) {
				numPessoas += 1;
			}
		}
		return numPessoas;
	}
	
	/**
	 * Método que calcula o número de pessoas não imunizadas do Local.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas não imunizadas.
	 */
	public int calculaPessoasNaoImunizadas() {
		int numPessoas = 0;
		for (int i = 0; i < getPessoas().size(); i++) {
			if (getPessoas().get(i).getStatus() == 2) {
				numPessoas += 1;
			}
		}
		return numPessoas;
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
	 * Método que retorna as ampolas que fazem parte do Local de Vacinação.
	 * @return A lista de ampolas do Local de Vacinação.
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
	 * Método que retorna o nome do local de vacinação em String.
	 */
	public String toString() {
		return  getNome() ;
	} 
  
}