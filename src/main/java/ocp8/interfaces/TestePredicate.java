package br.com.ocp.interfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TestePredicate {
	
	private String testar(Pessoa p, Predicate<Pessoa> a){
		return "Idoso: " + a.test(p) ;
	}
	
	private static void teste01(){
		Predicate<String> s1 = s -> s.startsWith("a");
		Predicate<String> s2 = s -> s.contains("b");
		
		System.out.println(s1.and(s2));
		System.out.println(s1.and(s2).test("fora"));
		System.out.println(s1.and(s2).test("a bola"));
		
		
		BiPredicate<String, Integer> bi01 = (s,i) -> s.contains("a") && s.length() > i;
		
		System.out.println(bi01.test("a bola", 5));
	}
	
	
	public static void main(String[] args) {
		System.out.println(new TestePredicate().testar(new Pessoa(false, true), p -> p.isIdoso()));
		teste01();
	}

}


class Pessoa{
	private boolean idoso;
	private boolean mulher;
	
	public Pessoa(boolean idoso, boolean mulher) {
		super();
		this.idoso = idoso;
		this.mulher = mulher;
	}
	
	public boolean isIdoso() {
		return idoso;
	}
	public void setIdoso(boolean idoso) {
		this.idoso = idoso;
	}
	public boolean isMulher() {
		return mulher;
	}
	public void setMulher(boolean mulher) {
		this.mulher = mulher;
	}
}