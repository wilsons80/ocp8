package br.com.ocp.funcional;

import java.util.function.BiConsumer;

public class BiConsumerTest {

	
	private static void teste01() {
		BiConsumer<String, String> bc = (a,b) -> System.out.println(a.concat(b));
		bc.accept("a", "b");
	}
	
	
	public static void main(String[] args) {
		teste01();
	}

}
