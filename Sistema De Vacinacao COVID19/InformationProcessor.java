/**
* <b>InformationProcessor</b> é a classe que define os métodos que toda Cidade e Local de Vacinação devem implementar no SistemaCovid.
* @author Cauany Nunes Rodrigues
*/
public interface InformationProcessor {
	
	/**
	 * Método que calcula o total de Pessoas, sejam elas médicos, enfermeiros e pacientes.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas.
	 */
	public int calculaPessoas();
	
	/**
	 * Método que calcula o número de pessoas totalmente imunizadas.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas imunizadas.
	 */
	public int calculaPessoasImunizadas();
	
	/**
	 * Método que calcula o número de pessoas parcialmente imunizadas.
	 * Parcialmente imunizadas é quando só tomou uma dose.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas parcialmente imunizadas.
	 */
	public int calculaPessoasParcialmenteImunizadas();
	
	/**
	 * Método que calcula o número de pessoas não imunizadas.
	 * @author Cauany Nunes Rodrigues
	 * @return o número total de pessoas não imunizadas.
	 */
	public int calculaPessoasNaoImunizadas();

}