//Importação utilizada para formatar a data para análise da idade do Paciente.
import java.text.SimpleDateFormat;

//Importação utilizada para captar a data atual na ajuda do cálculo da idade do Paciente.
import java.util.Date;

/**
* <b>Paciente</b> é a classe que armazena todos os atributos e métodos do Paciente do SistemaCovid.
* @author Maria Eduarda Viana Cordeiro dos Santos
* @date 27/04/2021
*/
public class Paciente extends Pessoa {

	/**
	 * <b>sus</b> é o atributo que diz o SUS do Paciente. 
	 */
	private int sus;

	/**
	 * <b>institucionalizado</b> é o atributo que diz se o Paciente é institucionalizado. 
	 */
	private boolean institucionalizado = false;

	/**
	 * <b>comunidadeIndigena</b> é o atributo que diz se o Paciente pertence a uma comunidade indígena.
	 */
	private boolean comunidadeIndigena = false;

	/**
	 * <b>comunidadeRibeirinha</b> é o atributo que diz se o Paciente pertence a uma comunidade ribeirinha.
	 */
	private boolean comunidadeRibeirinha = false;

	/**
	 * <b>comunidadeQuilombola</b> é o atributo que diz se o Paciente pertence a uma comunidade quilombola.
	 */
	private boolean comunidadeQuilombola = false;

	/**
	 * <b>comorbidade</b> é o atributo que diz se o Paciente possui alguma comorbidade.
	 */
	private boolean comorbidade = false;

	/**
	 * <b>profissionalSaude</b> é o atributo que diz se o Paciente é um profissional de saúde. 
	 */
	private boolean profissionalSaude = false;
	 
	/**
	 * <b>faixa_etaria_75_ou_mais</b> é o atributo que diz se o Paciente tem sua faixa etária acima de 75 anos. 
	 */
	private boolean faixa_etaria_75_ou_mais = false;
	
	/**
	 * <b>faixa_etaria_74_a_64</b> é o atributo que diz se o Paciente tem sua faixa etária entre 74 anos e 64 anos. 
	 */
	private boolean faixa_etaria_74_a_64 = false;
	
	/**
	 * <b>faixa_etaria_60_ou_mais</b> é o atributo que diz se o Paciente tem sua faixa de 60 anos ou mais. 
	 */
	private boolean faixa_etaria_60_ou_mais = false;
	
	/**
	 * Método que constrói um objeto do tipo Paciente.
	 * @param nome O valor do nome do Paciente herdado de Pessoa.
	 * @param cpf O valor do cpf do Paciente herdade de Pessoa. 
	 * @param dataNascimento O valor da data de nascimento do Paciente herdado de Pessoa.
	 * @param cidade O valor da cidade do Paciente herdado de Pessoa.
	 * @param status O valor do status do Paciente herdado de Pessoa que indica se está vacinado.
	 * @param tipoPrioridade O valor do tipo de prioridade do Paciente herdado de Pessoa.
	 * @param sus O valor do sus do Paciente.
	 */
	public Paciente(String nome, String cpf, String dataNascimento, Cidade cidade, LocalVacinacao localVacinacao, int tipoPrioridade, int sus) {
	    super(nome, cpf, dataNascimento, cidade, localVacinacao, tipoPrioridade);
	    this.sus = sus;
	}
	
	
	/**Método para definir qual prioridade o Paciente tem.
	 * Os valores que prioridade pode ter é os números de 0 à 8: 
	 * O valor 1 indica pacientes com 60 anos ou mais que são institucionalizadas;
	 * O valor 2 indica pacientes que são indígenas vivendo em terras indígenas;
	 * O valor 3 indica pacientes que são profissionais da saúde;
	 * O valor 4 indica pacientes com 75 anos ou mais;
	 * O valor 5 indica pacientes que faz parte de comunidades tradicionais ribeirinhas;
	 * O valor 6 indica pacientes que faz parte de comunidades tradicionais quilombolas;
	 * O valor 7 indica pacientes com idade entre 74 e 64;
	 * O valor 8 indica pacientes com comorbidades;
	 * O valor 0 indica pacientes que não possuem nenhuma das prioridades acima.
	 * @author Cauany Nunes Rodrigues
	 * @return int - Número que indica a prioridade do Paciente.
	 */
	public int analisaPrioridade() {
		
		// Tratando as informações do Paciente
		modificaAtributosPrioridades();
		calculaFaixaEtaria();
		
		// As seguintes condições verificam os atributos e então definem as prioridades (de 0 à 8) que o Paciente vai usar na fila.
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
	
	/**Método que modifica os atributos booleanos que indicam uma prioridade do Paciente.
	 * @author Cauany Nunes Rodrigues
	 */
	public void modificaAtributosPrioridades() {
		
		/* tipo prioridade é indicado no contrutor do Paciente e pode ter 6 valores:
		 * O valor 1 indica que o Paciente é Institucionalizado;
		 * O valor 2 indica que o Paciente é um Indígena vivendo em terras indígenas;
		 * O valor 3 indica que o Paciente é um Profissional da saúde;
		 * O valor 4 indica que o Paciente é uma Pessoa de comunidade tradicional ribeirinha;
		 * O valor 5 indica que o Paciente é uma Pessoa de comunidade tradicional quilombola;
		 * O valor 0 indica que o Paciente não possui nenhuma das prioridades acima.
		 */
		int tipoPrioridade = getTipoPrioridade();
		
		// As seguintes condições verificam qual tipoPrioridade foi especificado no construtor.
		// Caso o tipoPrioridade seja igual a algum número entre 1 e 5 o método modifica o atributo referente à prioridade para verdadeiro.
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
	
	/**Método que utiliza analisa em qual faixa etária o Paciente pertence.
	 * @author Cauany Nunes Rodrigues
	 */
	public void calculaFaixaEtaria() {
		
		int idade = calculaIdade();
		
		//Verifica qual das três faixas etárias o Paciente faz parte, caso sim, o atributo referente à faixa etária recebe true.
		if (idade >= 75) {
			setFaixa_etaria_75_ou_mais(true);
		} else if (idade >= 60) {
			setFaixa_etaria_60_ou_mais(true);
			if (idade >= 74 && idade <= 64) {
				setFaixa_etaria_74_a_64(true);
			}
		}
	}

	/**Método que utiliza o atributo dataNascimento para calcular a idade do Paciente.
	 * @author Cauany Nunes Rodrigues
	 * @return int - idade do Paciente.
	 */
	public int calculaIdade() {
		
		// A variável data_nascimento vai armazenar uma string com o atributo dataNascimento.
		String data_nascimento = getDataNascimento();
		// A variável tem a seguinte estrutura: "dd/MM/yyyy"
		// Para pegar só o ano precisamos pegar somente os últimos 4 caracteres da string utilizando o método substring().
		String string_ano_nascimento = data_nascimento.substring(6);
		// Precisaremos ter o ano como número para utilizá-lo nos futuros cálculos.
		int num_ano_nascimento = Integer.parseInt(string_ano_nascimento);
		
		// Esse comando capta a data atual do PC.
		Date dataAtual = new Date();
		// Com o SimpleDateFormat declaramos o formato que queremos da data, que no caso é só o ano ==> "yyyy".
		SimpleDateFormat anoFormat = new SimpleDateFormat("yyyy");
		// A variável string_ano_atual vai armazenar a dataAtual formatada, ou seja, somento com o ano.
		String string_ano_atual = anoFormat.format(dataAtual);
		// Precisaremos ter o ano como número para utilizá-lo nos futuros cálculos.
		int num_ano_atual = Integer.parseInt(string_ano_atual);
		 
     int idade = num_ano_atual - num_ano_nascimento;
     
		return idade;
	}
	
	/**
	 * Método que retorna o sus do Paciente.
	 * @return sus O sus do Paciente.
	 */
	public int getSus() {
		return sus;
	}
	
	/**
	 * Método que altera o valor do sus.
	 * @param sus O novo sus do paciente.
	 */
	public void setSus(int sus) {
		this.sus = sus;
	}
	
	/**
	 * Método que retorna o valor da institucionalização do Paciente.
	 * @return institucionalizado A institucionalização do Paciente.
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
	 * Método que retorna se o Paciente pertence a uma comunidade indígena.
	 * @return comunidadeIndigena O pertencimento à comunidade indígena do Paciente.
	 */
	public boolean isComunidadeIndigena() {
		return comunidadeIndigena;
	}

	/**
	 * Método que altera o valor do atributo comunidadeIndigena.
	 * @param comunidadeIndigena O novo pertencimento do Paciente a uma comunidade indigena.
	 */
	public void setComunidadeIndigena(boolean comunidadeIndigena) {
		this.comunidadeIndigena = comunidadeIndigena;
	}

	/**
	 * Método que retorna se o Paciente pertence a uma comunidade ribeirinha. 
	 * @return comunidadeRibeirinha O pertencimento do Paciente a uma comunidade ribeirinha.
	 */
	public boolean isComunidadeRibeirinha() {
		return comunidadeRibeirinha;
	}
	
	/**
	 * Método que altera o valor do atributo comunidadeRibeirinha.
	 * @param comunidadeRibeirinha O novo pertencimento do Paciente a uma comunidade ribeirinha.
	 */
	public void setComunidadeRibeirinha(boolean comunidadeRibeirinha) {
		this.comunidadeRibeirinha = comunidadeRibeirinha;
	}

	/**
	 * Método que retorna se o Paciente pertence a uma comunidade quilombola.
	 * @return comunidadeQuilombola O pertencimento do Paciente a uma comunidade quilombola.
	 */
	public boolean isComunidadeQuilombola() {
		return comunidadeQuilombola;
	}
	
	/**
	 * Método que altera o valor do atributo comunidadeQuilombola.
	 * @param comunidadeQuilombola O novo pertencimento do Paciente a uma comunidade quilombola.
	 */
	public void setComunidadeQuilombola(boolean comunidadeQuilombola) {
		this.comunidadeQuilombola = comunidadeQuilombola;
	}
	
	/**
	 * Método que retorna se o Paciente tem alguma comorbidade.
	 * @return comorbidade A comorbidade do Paciente.
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
	 * Método que retorna se o Paciente é um profissional de saúde.
	 * @return profissionalSaude A profissão do Paciente.
	 */
	public boolean isProfissionalSaude() {
		return profissionalSaude;
	}
	
	/**
	 * Método que altera o valor do atributo profissionalSaude.
	 * @param profissao A nova profissão do Paciente.
	 */
	public void setProfissionalSaude(boolean profissao) {
		this.profissionalSaude = profissao;
	}

	/**
	 * Método que retorna se o paciente tem faixa_etaria_75_ou_mais.
	 * @return A nova faixa_etaria_75_ou_mais do paciente.
	 */
	public boolean isFaixa_etaria_75_ou_mais() {
		return faixa_etaria_75_ou_mais;
	}

	/**
	 * Método que altera o valor do atributo faixa_etaria_75_ou_mais.
	 * @param faixa_etaria_75_ou_mais A nova faixa_etaria_75_ou_mais do paciente.
	 */
	public void setFaixa_etaria_75_ou_mais(boolean faixa_etaria_75_ou_mais) {
		this.faixa_etaria_75_ou_mais = faixa_etaria_75_ou_mais;
	}

	/**
	 * Método que retorna se o paciente tem faixa_etaria_70_a_64.
	 * @return A nova faixa_etaria_70_a_64 do paciente.
	 */
	public boolean isFaixa_etaria_74_a_64() {
		return faixa_etaria_74_a_64;
	}

	/**
	 * Método que altera o valor do atributo faixa_etaria_70_a_64.
	 * @param faixa_etaria_70_a_64 A nova faixa_etaria_70_a_64 do paciente.
	 */
	public void setFaixa_etaria_74_a_64(boolean faixa_etaria_70_a_64) {
		this.faixa_etaria_74_a_64 = faixa_etaria_70_a_64;
	}
	
	/**
	 * Método que retorna se o paciente tem faixa_etaria_60_ou_mais.
	 * @return A nova faixa_etaria_60_ou_mais do paciente.
	 */
	public boolean isFaixa_etaria_60_ou_mais() {
		return faixa_etaria_60_ou_mais;
	}

	/**
	 * Método que altera o valor do atributo faixa_etaria_60_ou_mais.
	 * @param faixa_etaria_60_ou_mais A nova faixa_etaria_60_ou_mais do paciente.
	 */
	public void setFaixa_etaria_60_ou_mais(boolean faixa_etaria_60_ou_mais) {
		this.faixa_etaria_60_ou_mais = faixa_etaria_60_ou_mais;
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
		return  getNome();
	}
	
}
