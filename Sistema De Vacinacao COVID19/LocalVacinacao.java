import java.util.ArrayList;

/**
 * <b>LocalVacinacao</b> � a classe que armazena os atributos e m�todos do Local de Vacina��o do SistemaCovid.
 * Ela implementa a interface InformationProcessor, assim recebendo todos os metodos dessa interface.
 * @author Pedro Lobo Nascimento
 * @date 26/04/2021
 */
public class LocalVacinacao implements InformationProcessor{

	/**
	 * <b>nome</b> � o atributo que armazena o nome do Local de Vacina��o
	 */
	private String nome;
	
	/**
	 * <b>horarioAtendimento</b> � o atributo que armazena o horario de atendimento do Local de Vacina��o.
	 */
	private String horarioAtendimento;

	/**
	 * <b>estoqueVacina</b> � o atributo que armazena o estoque de vacinas do Local de Vacina��o.
	 */
	private int estoqueVacina = 0;

	/**
	 * <b>Cidade<b> � o atributo que armazena a cidade do Local de Vacina��o.
	 */
	private Cidade cidade;
	
	/**
	 * <b>pessoas</b> � o atributo que armazena a lista de pessoas do Local de Vacina��o.
	 */
	private ArrayList<Pessoa> pessoas;
	
	/**
	 * <b>ampolas</b> � o atributo que armazena a lista de ampolas do Local de Vacina��o.
	 */
	private ArrayList<Ampola> ampolas;
	
	/**
	 * M�todo que constr�i um objeto do tipo LocalVacinacao.
	 * @param nome O valor do nome do Local de Vacina��o.
	 * @param horarioAtendimento O valor do horario de atendimento do Local de Vacina��o.
	 * @param cidade O valor da cidade do Local de Vacina��o.
	 */
	public LocalVacinacao (String nome, String horarioAtendimento, Cidade cidade) {
		this.nome = nome;
		this.horarioAtendimento = horarioAtendimento;
		this.cidade = cidade;
		this.pessoas = new ArrayList<Pessoa>();
		this.ampolas = new ArrayList<Ampola>();
	}
	
	/**
	 * M�todo que rep�e o estoque e preenche a lista de ampolas com a quantidade correspondente ao n�mero do estoque.
	 * @param numNovasAmpola - n�mero que ser� somado com o n�mero de ampolas j� existentes. 
	 * @param ampola - a lista de ampolas vai ter N ampolas do mesmo tipo da ampola passada como par�metro.
	 * @author Cauany Nunes Rodrigues
	 */
	public void calculaEstoque(int numNovasAmpola, Ampola ampola) {
		
		// novoEstoque ser� o resultado do n�mero de estoque j� existente mais o n�mero de ampolas adicionais.
		int novoEstoque = getEstoqueVacina() + numNovasAmpola;
		// estoqueVacina recebe o novo n�mero de estoque.
		setEstoqueVacina(novoEstoque);
		
		// A lista de ampolas vai receber novas inst�ncias de Ampola.
		// O n�mero de loops vai corresponder com o par�metro numNovasAmpola.
		// A lista vai receber ampolas iguas � aquela passada como par�metro.
		for (int n = 0; n < numNovasAmpola; n++) {
			adicionaAmpola(new Ampola(ampola.getFabricante(), ampola.getEficacia(), ampola.getLote(), ampola.getValidade(), ampola.getPrazo()));
		}
	}

	/**
	 * M�todo que retira uma ampola do LocalVacinacao caso a ampola tenha acabado.
	 * @param ampola
	 * @author Cauany Nunes Rodrigues
	 */
	public void analisaAmpola() {
		
		// A lista ampolas possue v�rias ampolas que quando rec�m criadas tem 10 doses.
		// Quando o n�mero de doses � igual a 0 implica que essa ampola acabou, ent�o deve-se remov�-la.
		if(getAmpolas().get(0).getDoses() == 0) {
			// Diminui o primeiro valor da lista ampolas de LocalVacinacao.
			retiraAmpola();
			// Diminui um valor tamb�m do estoque de vacina para manter atualizado.
			setEstoqueVacina(getEstoqueVacina() - 1);
		}
	}
	
	/**
	 * M�todo que retira a primeira Ampola da lista ampolas.
	 * @author Cauany Nunes Rodrigues
	 */
	public void retiraAmpola() {
		this.ampolas.remove(0);
	}
	
	/**
	 * M�todo que adiciona os elementos na lista de ampolas.
	 * @author Cauany Nunes Rodrigues
	 */
	public void adicionaAmpola(Ampola ampola) {
		this.ampolas.add(ampola);
	}
	  
	/**
	 * M�todo que adiciona pessoas, sejam elas pacientes, medicos e enfermeiros na lista de pessoas.
	 * @author Pedro Lobo Nascimento
	 */
	public void AdicionarPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
	
	/**
	 * M�todo que calcula o total de Pessoas, sejam elas m�dicos, enfermeiros e pacientes.
	 * @author Cauany Nunes Rodrigues
	 * @return tamanho da lista de Pessoas.
	 */
	public int calculaPessoas() {
		return getPessoas().size();
	}
	
	/**
	 * M�todo que calcula o n�mero de pessoas totalmente imunizadas do local.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas imunizadas.
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
	 * M�todo que calcula o n�mero de pessoas parcialmente imunizadas do local.
	 * parcialmente imunizadas � quando s� tomou uma dose.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas parcialmente imunizadas.
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
	 * M�todo que calcula o n�mero de pessoas n�o imunizadas do Local.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas n�o imunizadas.
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
	 * M�todo que retorna as ampolas que fazem parte do Local de Vacina��o.
	 * @return A lista de ampolas do Local de Vacina��o.
	 */
	public ArrayList<Ampola> getAmpolas() {
		return ampolas;
	}

	/**
	 * M�todo que altera o valor das ampolas do Local de Vacina��o.
	 * @param ampolas A nova lista de ampolas do Local de Vacina��o.
	 */
	public void setAmpolas(ArrayList<Ampola> ampolas) {
		this.ampolas = ampolas;
	}
	
	/**
	 * M�todo que retorna as pessoas que fazem parte do Local de Vacina��o.
	 * @return A lista de pessoas do Local de Vacina��o.
	 */
	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	/**
	 * M�todo que altera o valor das pessoas do Local de Vacina��o.
	 * @param pessoas A nova lista de pessoas do Local de Vacina��o.
	 */
	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
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
	 * M�todo que retorna o nome do local de vacina��o em String.
	 */
	public String toString() {
		return  getNome() ;
	} 
  
}