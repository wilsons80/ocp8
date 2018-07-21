package ocp8.funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FuncionalTeste {

	private static void teste01() {
		Predicate<String> pred = x -> x.startsWith("g");
		
		//Cria dois Stream infinito (desordenado)
		Stream<String> stream1 = Stream.generate(() -> "grom1 "); //generate cria um Stream infinito
		Stream<String> stream2 = Stream.generate(() -> "grom2 "); //generate cria um Stream infinito
		
		System.out.println(stream1.peek(System.out::println).anyMatch(pred)); //true, porém ainda tem correspondencias para o fluxo
		System.out.println(stream2.peek(System.out::println).allMatch(pred)); //trava
	}
	
	private static void teste02() {
		Predicate<? super String> predicate = (x) -> x.length() > 3;
		
		//Cria apenas um Stream infinito (ordenado) que será validado duas vezes
		Stream<String> stream = Stream.iterate("-", (s) -> s + s); //Stream infinito (ordenado), só pode ser usado apenas uma vez
		//"-"
		//"--"
		//"----"  b1 = false
		//"--------"
		
		//usa o mesmo stream duas vezes.
		boolean b1 = stream.noneMatch(predicate); //false
		boolean b2 = stream.anyMatch(predicate);  //lança exceção 'Stream já foi operado ou fechado'
		
		System.out.println(b1 + " - "+ b2);
		
	}
	
	private static void teste03() {
		Predicate<String> pred = x -> x.startsWith("g");
		
		//Cria dois Stream
		Stream<String> stream1 = Stream.generate(() -> "grom1 ").limit(1); //generate cria um Stream de tamanho 1
		Stream<String> stream2 = Stream.generate(() -> "grom2 ").limit(1); //generate cria um Stream de tamanho 1
		
		//Isso faria o Stream ser usado e fechado, logo não poderia ser usado novamente
		//System.out.println(stream1.count());
		
		System.out.println(stream1.peek(System.out::print).anyMatch(pred)); //true e finaliza o Stream, não podendo ser usado novamente
		System.out.println(stream2.peek(System.out::print).allMatch(pred)); //true e finaliza o Stream, não podendo ser usado novamente
	}	
	
	
	private static void teste04() {
		List<String> lista = new ArrayList<>();
		
		lista.stream().sorted().collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		teste03();
	}

}
