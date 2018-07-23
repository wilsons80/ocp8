package br.com.ocp.comparacao;

public class Comparacao {

	private static void teste01() {
		System.out.println("Comparando com int...");
		
		int v1 = 127;
		int v2 = 127;
		System.out.println( v1 +"=="+ v2 +": " + (v1 == v2) );
		System.out.println();
	}
	
	private static void teste02() {
		System.out.println("Comparando com Integer...");
		Integer v1 = 128;
		Integer v2 = 128;
		
		System.out.println( v1 +"=="+ v2 +": " + (v1 == v2) );
		System.out.println( v1 +".equals("+v2+") : " + (v1.equals(v2)) );
		System.out.println();
	}
	
	private static void teste03() {
		System.out.println("Comparando com String...");
		
		String v1 = "128";
		String v2 = "128";
		
		System.out.println( v1 +"=="+ v2 +": " + (v1 == v2) );
		System.out.println( v1 +".equals("+v2+") : " + (v1.equals(v2)) );
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		teste01();
		teste02();
		teste03();
	}

}
