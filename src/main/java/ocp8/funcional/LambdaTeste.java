package ocp8.funcional;

import java.util.function.Consumer;

public class LambdaTeste {
	
	public static void testeSupllier01(){
		Consumer<LambdaTeste> consumer = LambdaTeste::teste01;
	}
	
	public static void main(String[] args) {
		
	}
	
	private void teste01() {
		// TODO Auto-generated method stub

	}
	
	public static String getConsummer(String valor) {
		return valor.toUpperCase();
	}

}
