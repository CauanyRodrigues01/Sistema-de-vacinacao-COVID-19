/**
 * <b>ProfissionalSaude</b> é a classe que define os métodos que todo profissional de saúde do sistema deve implementar no SistemaCovid.
 * @author Cauany Nunes Rodrigues
 */
public interface ProfissionalSaude {

  /**
   * Método que altera o valor do atributo Matricula.
	 * @param A nova matricula do ProfissionalSaude.
	 */
	public void setMatricula(int matricula);

  /**
   * Método que altera o valor do atributo Senha.
	 * @param A nova senha do ProfissionalSaude.
	 */
	public void setSenha(String senha);

}
