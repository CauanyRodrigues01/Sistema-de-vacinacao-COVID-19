/**
 * <b>Ampola</b> � a classe que armazena os atributos e m�todos da Ampola da Vacina.
 * @author Pedro L�bo Nascimento
 * @date 26/04/2021
 */
public class Ampola {

  /**
	 * <b>fabricante</b> � o atributo que armazena o nome do fabricante da Ampola.
	 */
  private String fabricante;

  /**
	 * <b>eficacia</b> � o atributo que cont�m a efic�cia (em porcentagem) da dose da ampola.
	 */
	private String eficacia;
		
	/**
	 * <b>lote</b> � o atributo que armazena o lote da Ampola.
	 */
	private int lote;

	/**
	 * <b>Validade</b> � o atibuto que armazena a Validade do lote de Ampolas.
	 */
	private String Validade;

	
	/**
	 * <b>Prazo</b> � o atributo que armazena o Prazo de Validade da Ampola ap�s abertura do lote.
	 */
	private String Prazo;
	
	/**
	 * <b>doses</b> � o atributo que armazena a quantidade de doses que a Ampola tem.
	 * Inicialmente uma Ampola tem 10 doses.
	 */
	private int doses = 10;
	
	/**
	 * Construtor da classe Ampola.
	 * @param lote O valor do lote da Ampola.
	 * @param Validade O valor da Validade da Ampola.
	 * @param Prazo O valor da Validade do lote.
	 * @param fabricante O valor do fabricante da Ampola.
	 */
	public Ampola (String fabricante, String eficacia, int lote, String Validade, String Prazo) {
    this.fabricante = fabricante;
    this.eficacia = eficacia;
		this.lote = lote;
		this.Validade = Validade;
		this.Prazo = Prazo;
	}
	
	/**
	 * M�todo que diminui a dosa da Ampola.
	 * @author Cauany Nunes Rodrigues.
	 */
	public void diminuiDose() {
		int doses = getDoses();
		// Diminui uma dose da ampola
		setDoses(doses - 1);
	}

	/**
	 * M�todo que retorna o valor do lote da Ampola.
	 * @return O valor do lote.
	 */
	public int getLote() {
		return lote;
	}

	/**
	 * M�todo que altera o atributo lote.
	 * @param lote O novo lote da Ampola.
	 */
	public void setLote(int lote) {
		this.lote = lote;
	}

	/**
	 * M�todo que retorna o valor da Validade do lote.
	 * @return A validade do lote.
	 */
	public String getValidade() {
		return Validade;
	}

	/**
	 * M�todo que altera o valor do atributo Validade.
	 * @param validade A nova Validade do lote.
	 */
	public void setValidade(String validade) {
		Validade = validade;
	}

	/**
	 * M�todo que retorna o valor do Fabricante da Ampola.
	 * @return O fabricante da Ampola.
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * M�todo que altera o atributo fabricante.
	 * @param fabricante O novo fabricante da Ampola.
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

  /**
	 * M�todo que retorna o valor da efic�cia do Fabricante.
	 * @return A efic�cia do Fabricante.
	 */
	public String getEficacia() {
		return eficacia;
	}

	/**
	 * M�todo que altera o valor do atributo eficacia.
	 * @param eficacia A nova eficacia do Fabricante.
	 */
	public void setEficacia(String eficacia) {
		this.eficacia = eficacia;
	}

	/**
	 * M�todo que retorna o Prazo de Validade da Ampola.
	 * @return O prazo de validade da Ampola.
	 */
	public String getPrazo() {
		return Prazo;
	}

	/**
	 * M�todo que altera o valor do atributo Prazo.
	 * @param prazo O novo prazo de validade da Ampola.
	 */
	public void setPrazo(String prazo) {
		Prazo = prazo;
	}

	/**
	 * M�todo que retorna a quantidade de doses da Ampola.
	 * @return doses As doses da Ampola.
	 */
	public int getDoses() {
		return doses;
	}

	/**
	 * M�todo que altera o valor dasc doses da Ampola.
	 * @param doses As novas doses da Ampola.
	 */
	public void setDoses(int doses) {
		this.doses = doses;
	}
	

	/**
	 * M�todo que compara se o objeto passado como par�metro � do tipo Ampola.
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


	
}
