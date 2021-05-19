/**
 * <b>DateErrorException</b> Classe que define uma exceção criada para o próprio sistema com o intuito de acusar algum erro para as datas.
 * @author Cauany Nunes Rodrigues
 */

public class DateErrorException extends Exception {
	
	public DateErrorException() {
		super();
	}
	
	@Override
	public String toString() {
		
		return "|                DATA DE NASCIMENTO REJEITADA!                 |\n|             POR FAVOR, USE O FORMATO DD/MM/AAAA              |";
		
	}

}
