package br.com.ocp.enun;

public class TesteEnum {
	
	public enum Ordem{
		PRIMEIRO, SEGUNDO, TERCEIRO;
	}
	
	public enum Numero{
		UM, DOIS, TRES
	}

	public static void main(String[] args) {
		System.out.println(Ordem.PRIMEIRO.ordinal());
	}
}
