/**
 * <b>Fabricante</b> é a classe que contém os métodos e atributos do Fabricante da vacina.
 * @author Pedro Lobo Nascimento
 * @date 26/04/2021
 */
public class Fabricante {

	/**
	 * <b>eficacia</b> é o atributo que contém a eficácia (em porcentagem) do Fabricante.
	 */
	private double eficacia;

	/**
	 * <b>dosesPorAmpola</b> é o atributo que contém o número de doses por Ampola do Fabricante.
	 */
	private int dosesPorAmpola;

	/**
	 * <b>Nome</b> é o atributo que contém o nome do Fabricante.
	 */
	private String nome;

	/**
	 * Método Construtor.
	 * @param eficacia O valor da eficácia da vacina.
	 * @param dosesPorAmpola O valor das doses por Ampola da vacina.
	 * @param Nome O valor do nome do Fabricante da vacina.
	 */
	public Fabricante (double eficacia, int dosesPorAmpola, String nome) {
		this.eficacia = eficacia;
		this.dosesPorAmpola = dosesPorAmpola;
		this.nome = nome;
	}

	/**
	 * Método que retorna o valor da eficácia do Fabricante.
	 * @return A eficácia do Fabricante.
	 */
	public double getEficacia() {
		return eficacia;
	}

	/**
	 * Método que altera o valor do atributo eficacia.
	 * @param eficacia A nova eficacia do Fabricante.
	 */
	public void setEficacia(double eficacia) {
		this.eficacia = eficacia;
	}

	/**
	 * Método que retorna o número de doses por ampola do Fabricante.
	 * @return O número de doses por ampola do Faricante.
	 */
	public int getDosesPorAmpola() {
		return dosesPorAmpola;
	}

	/**
	 * Método que altera o valor do atributo dosesPorAmpola.
	 * @param dosesPorAmpola O novo número de doses por ampola.
	 */
	public void setDosesPorAmpola(int dosesPorAmpola) {
		this.dosesPorAmpola = dosesPorAmpola;
	}

	/**
	 * Método que retorna o valor do nome do Fabricante.
	 * @return O nome do Fabricante.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Método que altera o valor do atributo nome.
	 * @param nome O novo nome do Fabricante.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Método que compara se o objeto passado como parâmetro é do tipo Fabricante.
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
	 * Método que retorna o nome, a eficácia (em %) e o número de doses por Ampola do Fabricante.
	 */
	public String toString() {
		return "Fabricante:\nNome: "+getNome()+"\nEfic�cia: "+getEficacia()+"%"+"\nDoses por Ampola: "+getDosesPorAmpola();
	}
}
