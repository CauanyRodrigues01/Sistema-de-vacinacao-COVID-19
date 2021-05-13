/**
 * <b>ProfissionalSaude</b> � a classe que define os m�todos que todo profissional de sa�de do sistema deve implementar no SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
public interface ProfissionalSaude {

  /**
   * M�todo que altera o valor do atributo Matricula.
	 * @param A nova matricula do ProfissionalSaude.
	 */
	public void setMatricula(int matricula);

  /**
   * M�todo que altera o valor do atributo Senha.
	 * @param A nova senha do ProfissionalSaude.
	 */
	public void setSenha(String senha);

}
