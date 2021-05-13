//Importa��o utilizada para formatar a data para an�lise da idade do Paciente.
import java.text.SimpleDateFormat;

//Importa��o utilizada para captar a data atual na ajuda do c�lculo da idade do Paciente.
import java.util.Date;

/**
* <b>Paciente</b> � a classe que armazena todos os atributos e m�todos do Paciente do SistemaCovid.
* @author Maria Eduarda Viana Cordeiro dos Santos
* @date 27/04/2021
*/
public class Paciente extends Pessoa {

	/**
	 * <b>sus</b> � o atributo que diz o SUS do Paciente. 
	 */
	private int sus;

	/**
	 * <b>institucionalizado</b> � o atributo que diz se o Paciente � institucionalizado. 
	 */
	private boolean institucionalizado = false;

	/**
	 * <b>comunidadeIndigena</b> � o atributo que diz se o Paciente pertence a uma comunidade ind�gena.
	 */
	private boolean comunidadeIndigena = false;

	/**
	 * <b>comunidadeRibeirinha</b> � o atributo que diz se o Paciente pertence a uma comunidade ribeirinha.
	 */
	private boolean comunidadeRibeirinha = false;

	/**
	 * <b>comunidadeQuilombola</b> � o atributo que diz se o Paciente pertence a uma comunidade quilombola.
	 */
	private boolean comunidadeQuilombola = false;

	/**
	 * <b>comorbidade</b> � o atributo que diz se o Paciente possui alguma comorbidade.
	 */
	private boolean comorbidade = false;

	/**
	 * <b>profissionalSaude</b> � o atributo que diz se o Paciente � um profissional de sa�de. 
	 */
	private boolean profissionalSaude = false;
	 
	/**
	 * <b>faixa_etaria_75_ou_mais</b> � o atributo que diz se o Paciente tem sua faixa et�ria acima de 75 anos. 
	 */
	private boolean faixa_etaria_75_ou_mais = false;
	
	/**
	 * <b>faixa_etaria_74_a_64</b> � o atributo que diz se o Paciente tem sua faixa et�ria entre 74 anos e 64 anos. 
	 */
	private boolean faixa_etaria_74_a_64 = false;
	
	/**
	 * <b>faixa_etaria_60_ou_mais</b> � o atributo que diz se o Paciente tem sua faixa de 60 anos ou mais. 
	 */
	private boolean faixa_etaria_60_ou_mais = false;
	
	/**
	 * M�todo que constr�i um objeto do tipo Paciente.
	 * @param nome O valor do nome do Paciente herdado de Pessoa.
	 * @param cpf O valor do cpf do Paciente herdade de Pessoa. 
	 * @param dataNascimento O valor da data de nascimento do Paciente herdado de Pessoa.
	 * @param cidade O valor da cidade do Paciente herdado de Pessoa.
	 * @param status O valor do status do Paciente herdado de Pessoa que indica se est� vacinado.
	 * @param tipoPrioridade O valor do tipo de prioridade do Paciente herdado de Pessoa.
	 * @param sus O valor do sus do Paciente.
	 */
	public Paciente(String nome, String cpf, String dataNascimento, Cidade cidade, LocalVacinacao localVacinacao, int tipoPrioridade, int sus) {
	    super(nome, cpf, dataNascimento, cidade, localVacinacao, tipoPrioridade);
	    this.sus = sus;
	}
	
	
	/**M�todo para definir qual prioridade o Paciente tem.
	 * Os valores que prioridade pode ter � os n�meros de 0 � 8: 
	 * O valor 1 indica pacientes com 60 anos ou mais que s�o institucionalizadas;
	 * O valor 2 indica pacientes que s�o ind�genas vivendo em terras ind�genas;
	 * O valor 3 indica pacientes que s�o profissionais da sa�de;
	 * O valor 4 indica pacientes com 75 anos ou mais;
	 * O valor 5 indica pacientes que faz parte de comunidades tradicionais ribeirinhas;
	 * O valor 6 indica pacientes que faz parte de comunidades tradicionais quilombolas;
	 * O valor 7 indica pacientes com idade entre 74 e 64;
	 * O valor 8 indica pacientes com comorbidades;
	 * O valor 0 indica pacientes que n�o possuem nenhuma das prioridades acima.
	 * @author Cauany Nunes Rodrigues
	 * @return int - N�mero que indica a prioridade do Paciente.
	 */
	public int analisaPrioridade() {
		
		// Tratando as informa��es do Paciente
		modificaAtributosPrioridades();
		calculaFaixaEtaria();
		
		// As seguintes condi��es verificam os atributos e ent�o definem as prioridades (de 0 � 8) que o Paciente vai usar na fila.
		int prioridade_fila = 0;
		if (isFaixa_etaria_60_ou_mais() == true && isInstitucionalizado() == true) {
			prioridade_fila = 1;
		} else if (isComunidadeIndigena() == true) {
			prioridade_fila = 2;
		} else if (isProfissionalSaude() ==  true) {
			prioridade_fila = 3;
		} else if (isFaixa_etaria_75_ou_mais() == true) {
			prioridade_fila = 4;
		} else if (isComunidadeRibeirinha() == true) {
			prioridade_fila = 5;
		} else if (isComunidadeQuilombola() == true) {
			prioridade_fila = 6;
		} else if (isFaixa_etaria_74_a_64() == true) {
			prioridade_fila = 7;
		} else if (isComorbidade() == true) {
			prioridade_fila = 8;
		}
		
		return prioridade_fila;
	}
	
	/**M�todo que modifica os atributos booleanos que indicam uma prioridade do Paciente.
	 * @author Cauany Nunes Rodrigues
	 */
	public void modificaAtributosPrioridades() {
		
		/* tipo prioridade � indicado no contrutor do Paciente e pode ter 6 valores:
		 * O valor 1 indica que o Paciente � Institucionalizado;
		 * O valor 2 indica que o Paciente � um Ind�gena vivendo em terras ind�genas;
		 * O valor 3 indica que o Paciente � um Profissional da sa�de;
		 * O valor 4 indica que o Paciente � uma Pessoa de comunidade tradicional ribeirinha;
		 * O valor 5 indica que o Paciente � uma Pessoa de comunidade tradicional quilombola;
		 * O valor 0 indica que o Paciente n�o possui nenhuma das prioridades acima.
		 */
		int tipoPrioridade = getTipoPrioridade();
		
		// As seguintes condi��es verificam qual tipoPrioridade foi especificado no construtor.
		// Caso o tipoPrioridade seja igual a algum n�mero entre 1 e 5 o m�todo modifica o atributo referente � prioridade para verdadeiro.
		if (tipoPrioridade == 1) {
			setInstitucionalizado(true);
		}
		if (tipoPrioridade == 2) {
			setComunidadeIndigena(true);
		} 
		if (tipoPrioridade == 3) {
			setProfissionalSaude(true);
		}
		if (tipoPrioridade == 4) {
			setComunidadeRibeirinha(true);
		}
		if (tipoPrioridade == 5) {
			setComunidadeQuilombola(true);
		}
		
	}
	
	/**M�todo que utiliza analisa em qual faixa et�ria o Paciente pertence.
	 * @author Cauany Nunes Rodrigues
	 */
	public void calculaFaixaEtaria() {
		
		int idade = calculaIdade();
		
		//Verifica qual das tr�s faixas et�rias o Paciente faz parte, caso sim, o atributo referente � faixa et�ria recebe true.
		if (idade >= 75) {
			setFaixa_etaria_75_ou_mais(true);
		} else if (idade >= 60) {
			setFaixa_etaria_60_ou_mais(true);
			if (idade >= 74 && idade <= 64) {
				setFaixa_etaria_74_a_64(true);
			}
		}
	}

	/**M�todo que utiliza o atributo dataNascimento para calcular a idade do Paciente.
	 * @author Cauany Nunes Rodrigues
	 * @return int - idade do Paciente.
	 */
	public int calculaIdade() {
		
		// A vari�vel data_nascimento vai armazenar uma string com o atributo dataNascimento.
		String data_nascimento = getDataNascimento();
		// A vari�vel tem a seguinte estrutura: "dd/MM/yyyy"
		// Para pegar s� o ano precisamos pegar somente os �ltimos 4 caracteres da string utilizando o m�todo substring().
		String string_ano_nascimento = data_nascimento.substring(6);
		// Precisaremos ter o ano como n�mero para utiliz�-lo nos futuros c�lculos.
		int num_ano_nascimento = Integer.parseInt(string_ano_nascimento);
		
		// Esse comando capta a data atual do PC.
		Date dataAtual = new Date();
		// Com o SimpleDateFormat declaramos o formato que queremos da data, que no caso � s� o ano ==> "yyyy".
		SimpleDateFormat anoFormat = new SimpleDateFormat("yyyy");
		// A vari�vel string_ano_atual vai armazenar a dataAtual formatada, ou seja, somento com o ano.
		String string_ano_atual = anoFormat.format(dataAtual);
		// Precisaremos ter o ano como n�mero para utiliz�-lo nos futuros c�lculos.
		int num_ano_atual = Integer.parseInt(string_ano_atual);
		 
     int idade = num_ano_atual - num_ano_nascimento;
     
		return idade;
	}
	
	/**
	 * M�todo que retorna o sus do Paciente.
	 * @return sus O sus do Paciente.
	 */
	public int getSus() {
		return sus;
	}
	
	/**
	 * M�todo que altera o valor do sus.
	 * @param sus O novo sus do paciente.
	 */
	public void setSus(int sus) {
		this.sus = sus;
	}
	
	/**
	 * M�todo que retorna o valor da institucionaliza��o do Paciente.
	 * @return institucionalizado A institucionaliza��o do Paciente.
	 */
	public boolean isInstitucionalizado() {
		return institucionalizado;
	}
	
	/**
	 * M�todo que altera o valor do atributo institucionalizado.
	 * @param institucionalizado A nova institucionaliza��o do Paciente.
	 */
	public void setInstitucionalizado(boolean institucionalizado) {
		this.institucionalizado = institucionalizado;
	}
	
	/**
	 * M�todo que retorna se o Paciente pertence a uma comunidade ind�gena.
	 * @return comunidadeIndigena O pertencimento � comunidade ind�gena do Paciente.
	 */
	public boolean isComunidadeIndigena() {
		return comunidadeIndigena;
	}

	/**
	 * M�todo que altera o valor do atributo comunidadeIndigena.
	 * @param comunidadeIndigena O novo pertencimento do Paciente a uma comunidade indigena.
	 */
	public void setComunidadeIndigena(boolean comunidadeIndigena) {
		this.comunidadeIndigena = comunidadeIndigena;
	}

	/**
	 * M�todo que retorna se o Paciente pertence a uma comunidade ribeirinha. 
	 * @return comunidadeRibeirinha O pertencimento do Paciente a uma comunidade ribeirinha.
	 */
	public boolean isComunidadeRibeirinha() {
		return comunidadeRibeirinha;
	}
	
	/**
	 * M�todo que altera o valor do atributo comunidadeRibeirinha.
	 * @param comunidadeRibeirinha O novo pertencimento do Paciente a uma comunidade ribeirinha.
	 */
	public void setComunidadeRibeirinha(boolean comunidadeRibeirinha) {
		this.comunidadeRibeirinha = comunidadeRibeirinha;
	}

	/**
	 * M�todo que retorna se o Paciente pertence a uma comunidade quilombola.
	 * @return comunidadeQuilombola O pertencimento do Paciente a uma comunidade quilombola.
	 */
	public boolean isComunidadeQuilombola() {
		return comunidadeQuilombola;
	}
	
	/**
	 * M�todo que altera o valor do atributo comunidadeQuilombola.
	 * @param comunidadeQuilombola O novo pertencimento do Paciente a uma comunidade quilombola.
	 */
	public void setComunidadeQuilombola(boolean comunidadeQuilombola) {
		this.comunidadeQuilombola = comunidadeQuilombola;
	}
	
	/**
	 * M�todo que retorna se o Paciente tem alguma comorbidade.
	 * @return comorbidade A comorbidade do Paciente.
	 */
	public boolean isComorbidade() {
		return comorbidade;
	}
	
	/**
	 * M�todo que altera o valor do atributo comorbidade.
	 * @param comorbidade A nova comorbidade do Paciente.
	 */
	public void setComorbidade(boolean comorbidade) {
		this.comorbidade = comorbidade;
	}

	/**
	 * M�todo que retorna se o Paciente � um profissional de sa�de.
	 * @return profissionalSaude A profiss�o do Paciente.
	 */
	public boolean isProfissionalSaude() {
		return profissionalSaude;
	}
	
	/**
	 * M�todo que altera o valor do atributo profissionalSaude.
	 * @param profissao A nova profiss�o do Paciente.
	 */
	public void setProfissionalSaude(boolean profissao) {
		this.profissionalSaude = profissao;
	}

	/**
	 * M�todo que retorna se o paciente tem faixa_etaria_75_ou_mais.
	 * @return A nova faixa_etaria_75_ou_mais do paciente.
	 */
	public boolean isFaixa_etaria_75_ou_mais() {
		return faixa_etaria_75_ou_mais;
	}

	/**
	 * M�todo que altera o valor do atributo faixa_etaria_75_ou_mais.
	 * @param faixa_etaria_75_ou_mais A nova faixa_etaria_75_ou_mais do paciente.
	 */
	public void setFaixa_etaria_75_ou_mais(boolean faixa_etaria_75_ou_mais) {
		this.faixa_etaria_75_ou_mais = faixa_etaria_75_ou_mais;
	}

	/**
	 * M�todo que retorna se o paciente tem faixa_etaria_70_a_64.
	 * @return A nova faixa_etaria_70_a_64 do paciente.
	 */
	public boolean isFaixa_etaria_74_a_64() {
		return faixa_etaria_74_a_64;
	}

	/**
	 * M�todo que altera o valor do atributo faixa_etaria_70_a_64.
	 * @param faixa_etaria_70_a_64 A nova faixa_etaria_70_a_64 do paciente.
	 */
	public void setFaixa_etaria_74_a_64(boolean faixa_etaria_70_a_64) {
		this.faixa_etaria_74_a_64 = faixa_etaria_70_a_64;
	}
	
	/**
	 * M�todo que retorna se o paciente tem faixa_etaria_60_ou_mais.
	 * @return A nova faixa_etaria_60_ou_mais do paciente.
	 */
	public boolean isFaixa_etaria_60_ou_mais() {
		return faixa_etaria_60_ou_mais;
	}

	/**
	 * M�todo que altera o valor do atributo faixa_etaria_60_ou_mais.
	 * @param faixa_etaria_60_ou_mais A nova faixa_etaria_60_ou_mais do paciente.
	 */
	public void setFaixa_etaria_60_ou_mais(boolean faixa_etaria_60_ou_mais) {
		this.faixa_etaria_60_ou_mais = faixa_etaria_60_ou_mais;
	}

	/**
	 * M�todo que compara se o objeto passado como par�metro � do tipo Paciente.
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
	 * M�todo que retorna o nome e cpf do Paciente em String.
	 */
	public String toString() {
		return  getNome();
	}
	
}
