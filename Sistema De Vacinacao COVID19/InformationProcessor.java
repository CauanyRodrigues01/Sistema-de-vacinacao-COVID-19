/**
* <b>InformationProcessor</b> � a classe que define os m�todos que toda Cidade e Local de Vacina��o devem implementar no SistemaCovid.
* @author Cauany Nunes Rodrigues
*/
public interface InformationProcessor {
	
	/**
	 * M�todo que calcula o total de Pessoas, sejam elas m�dicos, enfermeiros e pacientes.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas.
	 */
	public int calculaPessoas();
	
	/**
	 * M�todo que calcula o n�mero de pessoas totalmente imunizadas.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas imunizadas.
	 */
	public int calculaPessoasImunizadas();
	
	/**
	 * M�todo que calcula o n�mero de pessoas parcialmente imunizadas.
	 * Parcialmente imunizadas � quando s� tomou uma dose.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas parcialmente imunizadas.
	 */
	public int calculaPessoasParcialmenteImunizadas();
	
	/**
	 * M�todo que calcula o n�mero de pessoas n�o imunizadas.
	 * @author Cauany Nunes Rodrigues
	 * @return o n�mero total de pessoas n�o imunizadas.
	 */
	public int calculaPessoasNaoImunizadas();

}