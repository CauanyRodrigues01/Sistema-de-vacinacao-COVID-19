/**
 * <b>Ampola</b> é a classe que armazena os atributos e métodos da Ampola da Vacina.
 * @author Pedro Lôbo Nascimento
 * @date 26/04/2021
 */
public class Ampola {

	/**
	 * <b>lote</b> é o atributo que armazena o lote da Ampola.
	 */
	private int lote;

	/**
	 * <b>Validade</b> é o atibuto que armazena a Validade do lote de Ampolas.
	 */
	private String Validade;

	/**
	 * <b>fabricante</b> é o atributo que armazena o Fabricante da Ampola.
	 */
	private Fabricante fabricante;
	
	/**
	 * <b>Prazo</b> é o atributo que armazena o Prazo de Validade da Ampola após abertura do lote.
	 */
	private String Prazo;
	
	/**
	 * Construtor da classe Ampola.
	 * @param lote O valor do lote da Ampola.
	 * @param Validade O valor da Validade da Ampola.
	 * @param Prazo O valor da Validade do lote.
	 * @param fabricante O valor do fabricante da Ampola.
	 */
	public Ampola (int lote, String Validade, String Prazo, Fabricante fabricante) {
		this.lote = lote;
		this.Validade = Validade;
		this.fabricante = fabricante;
		this.Prazo = Prazo;
	}

	/**
	 * Método que retorna o valor do lote da Ampola.
	 * @return O valor do lote.
	 */
	public int getLote() {
		return lote;
	}

	/**
	 * Método que altera o atributo lote.
	 * @param lote O novo lote da Ampola.
	 */
	public void setLote(int lote) {
		this.lote = lote;
	}

	/**
	 * Método que retorna o valor da Validade do lote.
	 * @return A validade do lote.
	 */
	public String getValidade() {
		return Validade;
	}

	/**
	 * Método que altera o valor do atributo Validade.
	 * @param validade A nova Validade do lote.
	 */
	public void setValidade(String validade) {
		Validade = validade;
	}

	/**
	 * Método que retorna o valor do Fabricante da Ampola.
	 * @return O fabricante da Ampola.
	 */
	public Fabricante getFabricante() {
		return fabricante;
	}

	/**
	 * Método que altera o atributo fabricante.
	 * @param fabricante O novo fabricante da Ampola.
	 */
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * Método que retorna o Prazo de Validade da Ampola.
	 * @return O prazo de validade da Ampola.
	 */
	public String getPrazo() {
		return Prazo;
	}

	/**
	 * Método que altera o valor do atributo Prazo.
	 * @param prazo O novo prazo de validade da Ampola.
	 */
	public void setPrazo(String prazo) {
		Prazo = prazo;
	}

	/**
	 * Método que compara se o objeto passado como parâmetro é do tipo Ampola.
	 * Caso o seja, ele compara o fabricante de duas classes Ampola.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Ampola))
			return false;
		Ampola exemplo = (Ampola) obj;
		if (this.fabricante.equals(exemplo.getFabricante()))
			return true;
		return false;
	}

	/**
	 * Método que retorna o lote, data de validade e prazo de vencimento da Ampola em String.
	 */
	public String toString() {
		return "Ampola:\nLote: "+getLote()+"\nData de validade: "+getValidade()+"\nPrazo de vencimento: "+getPrazo();
	}
	
}
