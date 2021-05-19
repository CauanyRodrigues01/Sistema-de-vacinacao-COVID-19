/**
 * <b>DateErrorException</b> Classe que define uma exce��o criada para o pr�prio sistema com o intuito de acusar algum erro para as datas.
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
