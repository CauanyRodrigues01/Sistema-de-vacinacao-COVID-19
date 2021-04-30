/**
 * <b>Paciente</b> é a classe que armazena todos os atributos e métodos do Paciente do SistemaCovid.
 * @author Maria Eduarda Viana Cordeiro dos Santos
 * @date 27/04/2021
 */

 /*
  prioridade_1 (Pessoas com 60 anos ou mais institucionalizadas)
  prioridade_2 (Povos indígenas vivendo em terras indígenas)
  prioridade_3 (Profissional da saúde)
  prioridade_4 (Pessoas de 75 ou mais)
  prioridade_5 (Povos e comunidades tradicionais ribeirinhas)
  prioridade_6 (Povos e comunidades tradicionais quilombolas)
  prioridade_7 (Pessoas de 70 a 64 anos)
  prioridade_8 (Indivíduos com comorbidades) 
 */
public class Paciente extends Pessoa {

  private int sus;

	/**
	 * <b>institucionalizado</b> é o atributo que diz se o Paciente é institucionalizado. 
	 */
	private boolean institucionalizado;

	/**
	 * <b>comunidadeIndigena</b> é o atributo que diz se o Paciente pertence a uma comunidade indígena.
	 */
	private boolean comunidadeIndigena;

	/**
	 * <b>comunidadeRibeirinha</b> é o atributo que diz se o Paciente pertence a uma comunidade indígena.
	 */
	private boolean comunidadeRibeirinha;

	/**
	 * <b>comunidadeQuilombola</b> é o atributo que diz se o Paciente pertence a uma comunidade quilombola.
	 */
	private boolean comunidadeQuilombola;

	/**
	 * <b>comorbidade</b> é o atributo que diz se o Paciente possui alguma comorbidade.
	 */
	private boolean comorbidade;

	/**
	 * <b>profissao</b> é o atributo que diz se o Paciente possui alguma profissão. 
	 */
	private boolean profissao;
	
	/**
	 * Método que constrói um objeto do tipo Paciente.
	 * @param institucionalizado O valor da institucionalização do Paciente.
	 * @param comunidadeIndigena O valor da pertença do Paciente à comunidade indigena. 
	 * @param comunidadeRibeirinha O valor da pertença do Paciente à comunidade ribeirinha.
	 * @param comunidadeQuilombola O valor da pertença do Paciente à comunidade quilombola
	 * @param comorbidade O valor da comorbidade do Paciente.
	 * @param profissao O valor da profissão do Paciente.
	 */
	public Paciente(String nome, int cpf, String dataNascimento, Cidade cidade, int status, int tipoPrioridade, int sus) {
    super(nome, cpf, dataNascimento, cidade, status, tipoPrioridade);
    this.sus = sus;
	}
	
	/**
	 * Método que retorna o valor da institucionalização do Paciente.
	 * @return A institucionalização do Paciente.
	 */
	public boolean isInstitucionalizado() {
		return institucionalizado;
	}
	
	/**
	 * Método que altera o valor do atributo institucionalizado.
	 * @param institucionalizado A nova institucionalização do Paciente.
	 */
	public void setInstitucionalizado(boolean institucionalizado) {
		this.institucionalizado = institucionalizado;
	}
	
	/**
	 * Método que retorna a pertença do Paciente a uma comunidade indígena.
	 * @return A pertença do Paciente a uma comunidade indígena.
	 */
   	/**
	 * @return the sus
	 */
	public int getSus() {
		return sus;
	}
	/**
	 * @param sus the sus to set
	 */
	public void setSus(int sus) {
		this.sus = sus;
	}
	public boolean isComunidadeIndigena() {
		return comunidadeIndigena;
	}

	/**
	 * Método que altera o valor do atributo comunidadeIndigena.
	 * @param comunidadeIndigena A nova pertença do Paciente a uma comunidade indigena.
	 */
	public void setComunidadeIndigena(boolean comunidadeIndigena) {
		this.comunidadeIndigena = comunidadeIndigena;
	}

	/**
	 * Método que retorna a pertença do Paciente a uma comunidade ribeirinha. 
	 * @return A pertença do Paciente a uma comunidade ribeirinha.
	 */
	public boolean isComunidadeRibeirinha() {
		return comunidadeRibeirinha;
	}
	
	/**
	 * Método que altera o valor do atributo comunidadeRibeirinha.
	 * @param comunidadeRibeirinha A nova pertença do Paciente a uma comunidade ribeirinha.
	 */
	public void setComunidadeRibeirinha(boolean comunidadeRibeirinha) {
		this.comunidadeRibeirinha = comunidadeRibeirinha;
	}

	/**
	 * Método que retorna a pertença do Paciente a uma comunidade quilombola.
	 * @return A pertença do Paciente a uma comunidade quilombola.
	 */
	public boolean isComunidadeQuilombola() {
		return comunidadeQuilombola;
	}
	
	/**
	 * Método que altera o valor do atributo comunidadeQuilombola.
	 * @param comunidadeQuilombola A nova pertença do Paciente a uma comunidade quilombola.
	 */
	public void setComunidadeQuilombola(boolean comunidadeQuilombola) {
		this.comunidadeQuilombola = comunidadeQuilombola;
	}
	
	/**
	 * Método que retorna a comorbidade do Paciente.
	 * @return A comorbidade do Paciente.
	 */
	public boolean isComorbidade() {
		return comorbidade;
	}
	
	/**
	 * Método que altera o valor do atributo comorbidade.
	 * @param comorbidade A nova comorbidade do Paciente.
	 */
	public void setComorbidade(boolean comorbidade) {
		this.comorbidade = comorbidade;
	}

	/**
	 * Método que retorna a profissão do Paciente.
	 * @return A profissão do Paciente.
	 */
	public boolean isProfissao() {
		return profissao;
	}
	
	/**
	 * Método que altera o valor do atributo profissao.
	 * @param profissao A nova profissão do Paciente.
	 */
	public void setProfissao(boolean profissao) {
		this.profissao = profissao;
	}

	/**
	 * Método que compara se o objeto passado como parâmetro é do tipo Paciente.
	 * Caso o seja, ele compara o sus de dois Pacientes.
	 */
  public boolean equals(Object obj) {
		if (!(obj instanceof Paciente))
			return false;
		Paciente obj2 = (Paciente) obj;
		if (obj2.getSus() == this.getSus())
			return true;
		return false;
	}
  
	/**
	 * Método que retorna o nome e cpf do Paciente em String.
	 */
	public String toString() {
		return "Paciente:\nNome: " + getNome() + ", Cpf: " + getCpf();
	}
	
}
