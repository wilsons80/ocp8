package br.com.ocp.data;

import java.time.Duration;
import java.time.LocalDateTime;

public class LocaDateTeste {

	
	private static void teste01(){
	    LocalDateTime now = LocalDateTime.now();
	    LocalDateTime amanha = now.minusDays(6);
	 
	    Duration duration = Duration.between(now, amanha);
	    long diff = Math.abs(duration.toDays());
	    
	    System.out.println(diff);
	}
	public static void main(String[] args) {
		teste01();
	}

}
