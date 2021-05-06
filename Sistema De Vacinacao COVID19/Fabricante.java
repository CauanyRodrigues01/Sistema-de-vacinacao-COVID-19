/**
 * <b>Fabricante</b> � a classe que cont�m os m�todos e atributos do Fabricante da vacina.
 * @author Pedro Lobo Nascimento
 * @date 26/04/2021
 */
public class Fabricante {

	/**
	 * <b>eficacia</b> � o atributo que cont�m a efic�cia (em porcentagem) do Fabricante.
	 */
	private double eficacia;

	/**
	 * <b>dosesPorAmpola</b> � o atributo que cont�m o n�mero de doses por Ampola do Fabricante.
	 */
	private int dosesPorAmpola;

	/**
	 * <b>Nome</b> � o atributo que cont�m o nome do Fabricante.
	 */
	private String nome;

	/**
	 * M�todo Construtor.
	 * @param eficacia O valor da efic�cia da vacina.
	 * @param dosesPorAmpola O valor das doses por Ampola da vacina.
	 * @param Nome O valor do nome do Fabricante da vacina.
	 */
	public Fabricante (double eficacia, int dosesPorAmpola, String nome) {
		this.eficacia = eficacia;
		this.dosesPorAmpola = dosesPorAmpola;
		this.nome = nome;
	}

	/**
	 * M�todo que retorna o valor da efic�cia do Fabricante.
	 * @return A efic�cia do Fabricante.
	 */
	public double getEficacia() {
		return eficacia;
	}

	/**
	 * M�todo que altera o valor do atributo eficacia.
	 * @param eficacia A nova eficacia do Fabricante.
	 */
	public void setEficacia(double eficacia) {
		this.eficacia = eficacia;
	}

	/**
	 * M�todo que retorna o n�mero de doses por ampola do Fabricante.
	 * @return O n�mero de doses por ampola do Faricante.
	 */
	public int getDosesPorAmpola() {
		return dosesPorAmpola;
	}

	/**
	 * M�todo que altera o valor do atributo dosesPorAmpola.
	 * @param dosesPorAmpola O novo n�mero de doses por ampola.
	 */
	public void setDosesPorAmpola(int dosesPorAmpola) {
		this.dosesPorAmpola = dosesPorAmpola;
	}

	/**
	 * M�todo que retorna o valor do nome do Fabricante.
	 * @return O nome do Fabricante.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * M�todo que altera o valor do atributo nome.
	 * @param nome O novo nome do Fabricante.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * M�todo que compara se o objeto passado como par�metro � do tipo Fabricante.
	 * Caso o seja, ele compara o nome de duas classe Fabricante.
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Fabricante))
			return false;
		Fabricante exemplo = (Fabricante) obj;
		if (this.nome.equals(exemplo.getNome()))
			return true;
		return false;
	}

	/**
	 * M�todo que retorna o nome, a efic�cia (em %) e o n�mero de doses por Ampola do Fabricante.
	 */
	public String toString() {
		return "Fabricante:\nNome: "+getNome()+"\nEfic�cia: "+getEficacia()+"%"+"\nDoses por Ampola: "+getDosesPorAmpola();
	}
}
