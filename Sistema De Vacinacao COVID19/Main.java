class Main {
	
	public static void main(String[] args) {
        
		//Teste cidade
	    Cidade soledade = new Cidade("Soledade", "PB", 10, 3, 12);
	    System.out.println(soledade.toString());
	
	    Cidade campinaGrande = new Cidade("Campina Grande","PB", 15, 3, 15);
	    System.out.println(campinaGrande.toString());
	
	    System.out.println("Soledade é igual a Campina Grande?");
	    System.out.println(soledade.equals(campinaGrande));
	
	    //Teste LocalVacinacao
	    System.out.println();
	    LocalVacinacao postinhoDoCentro = new LocalVacinacao("Escolinha do Bairro", "07:00 até 12:00", 15, soledade);
	    System.out.println(postinhoDoCentro.toString());
	    
	    LocalVacinacao clinica = new LocalVacinacao("Clinica Santa Clara", "09:00 até 15:00", 15, campinaGrande);
	    System.out.println(clinica.toString());
	
	    System.out.println("Postinho do centro é igual a clinica?");
	    System.out.println(postinhoDoCentro.equals(clinica));
	
	    //Teste pessoa
	    System.out.println();
		Pessoa cauany = new Pessoa("cauany", 156094480, "29/06/1960", soledade, 0, 1);
		System.out.println(cauany.toString());
			
		Pessoa lobo = new Pessoa("lobo", 213343480, "29/06/1960", campinaGrande, 0, 2);
		System.out.println(lobo.toString());
			
	    System.out.println("Cauany é igual a Lobo?");
		System.out.println(cauany.equals(lobo));
		
	    //Teste paciente
	    System.out.println();
		Paciente juliana = new Paciente("juliana", 847365748, "17/06/2013", soledade, 3, 8, 23873);
		System.out.println(juliana.toString());
	
		Paciente vitoria = new Paciente("vitoria", 2122220, "29/06/1978", campinaGrande, 0, 8, 87446);
		System.out.println(vitoria.toString());
			
	    System.out.println("Juliana é igual a vitoria?");
		System.out.println(vitoria.equals(juliana));
			
		//Teste Medico
	    System.out.println();
		Medico eduarda = new Medico("Eduarda", 13456789, "23/09/1990", soledade, 0, 4, 857463625, postinhoDoCentro, 354627, "123dofrau");
		System.out.println(eduarda.toString());
			
		Medico josefa = new Medico("Josefa", 987654321,  "06/06/1992", campinaGrande, 0, 4, 123456789, clinica, 12121, "quatro00dois");
		System.out.println(josefa.toString());
			
	    System.out.println("eduarda é igual a josefa?");
			System.out.println(eduarda.equals(josefa));
	
	    //Teste enfermeiro
	    System.out.println();
	
	    Enfermeiro marileide = new Enfermeiro("Marileide", 948576364, "04/12/2000", soledade, 0, 4, 98765, postinhoDoCentro, 12344, "4321dois");
	    System.out.println(marileide.toString());
	    
	    Enfermeiro carlos = new Enfermeiro("Carlos", 2536478, "23/02/1995", campinaGrande, 0, 4, 1236, clinica, 12345,"123vrau");
	    System.out.println(carlos.toString());
	
	    System.out.println("marileide é igual a carlos?");
		System.out.println(marileide.equals(carlos));
	
	    //Fabricante
	    System.out.println();
	    
	    Fabricante butantan = new Fabricante(50.0, 1, "Instituto Butantan");
	    System.out.println(butantan.toString());
	
	    Fabricante oxford = new Fabricante(27.0, 2, "Universidade de Oxford");
	    System.out.println(oxford.toString());
	
	    System.out.println("A vacina do Butantan é igual a de Oxford?");
	    System.out.println(butantan.equals(oxford));
	    
	    //Ampola
	    System.out.println();
	    
	    Ampola coronavac = new Ampola(10, "28/04/2021", "30 dias", butantan);
	    System.out.println(coronavac.toString());
	
	    Ampola pfizer = new Ampola(15, "28/04/2021","30 dias", oxford);
	    System.out.println(pfizer.toString());
	
	    System.out.println("A ampola da coronavac é igual a pfizer?");
	    System.out.println(coronavac.equals(pfizer));
	
	    // Teste Paciente
	    Cidade joaoPessoa = new Cidade("Joao Pessoa", "PB", 10, 3, 12);
	  	
	  	Cidade saoPaulo = new Cidade("Sao Paulo","PB", 15, 3, 15);
	  		
	  	//Teste de uma pessoa nova que é indígena (4)	
	  	Paciente luana = new Paciente("\nluana", 847365748, "17/06/2000", joaoPessoa, 0, 4, 23873);
	  		
	  	luana.analisaPrioridade();
	  	System.out.println("\nluana\nidade: " + luana.calculaIdade());
	  	
	  	System.out.println("faixa_etaria_75_ou_mais? "+luana.isFaixa_etaria_75_ou_mais());
	  	System.out.println("faixa_etaria_74_a_64? "+luana.isFaixa_etaria_74_a_64());
	  	System.out.println("faixa_etaria_60_ou_mais? "+luana.isFaixa_etaria_60_ou_mais());
	  	System.out.println("prioridade_fila = "+luana.analisaPrioridade());
	  		
	  	//Teste de uma pessoa velha e institucionalizada (1)	
	  	Paciente joana = new Paciente("joana", 2122220, "29/06/1940", saoPaulo, 0, 1, 87446);
	  		
	  	joana.analisaPrioridade();
	  	System.out.println("\njoana\nidade: " + joana.calculaIdade());
	  	
	  		
	  	System.out.println("faixa_etaria_75_ou_mais? "+joana.isFaixa_etaria_75_ou_mais());
	  	System.out.println("faixa_etaria_74_a_64? "+joana.isFaixa_etaria_74_a_64());
	  	System.out.println("faixa_etaria_60_ou_mais? "+joana.isFaixa_etaria_60_ou_mais());
	  	System.out.println("prioridade_fila = "+joana.analisaPrioridade());
	  }
} 