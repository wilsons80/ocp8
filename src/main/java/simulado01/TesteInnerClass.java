package simulado01;

import java.util.ArrayList;
import java.util.List;

public class TesteInnerClass {

	static int bbb = 0;

	static class Aaa extends TesteInnerClass {
		static int bbb1 = 0;
		final int bbb2 = 0;
		static final int bbb3 = 0;

		public static void teste() {
			System.out.println("alguma coisa");
		}

		class zzz1 {
		}
	}

	public static void main(String[] args) {
		TesteInnerClass.Aaa a = new Aaa();
		List<Object> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(1L);
		a.teste();
	}

	/*
	 * class Aaa2{ static int bbb1 = 0; final int bbb2 = 0; static final int bbb3 =
	 * 0;
	 * 
	 * public static void teste() {} class zzz2{} }
	 * 
	 * public void teste2() {
	 * 
	 * class Aaa2{ static int bbb1 = 0; final int bbb2 = 0; static final int bbb3 =
	 * 0;
	 * 
	 * public static void teste() {} class zzz2{} } }
	 * 
	 * public static void teste3() {
	 * 
	 * class Aaa2{ static int bbb1 = 0; final int bbb2 = 0; static final int bbb3 =
	 * 0;
	 * 
	 * public static void teste() {} class zzz2{} } }
	 */
}
