package ocp8.assertion;

public class TesteAssertion {

	private static void teste01(){
		assert (31>2);
		System.out.println("Teste 01");
	}
	private static void teste02(){
		assert (111>20);
		System.out.println("Teste 02");
	}
	
	private static void teste03(){
		assert "a".equals("b") : "Não é igual";
		System.out.println("Teste 03");
	}
	
	public static void main(String[] args) {
		teste01();
		teste02();
		teste03();
	}

	private static void teste(){
		System.out.println("teste");
	}
}
