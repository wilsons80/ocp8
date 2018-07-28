package ocp8.funcional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;

import java.io.ByteArrayInputStream;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Transasao{
	int id;
	String tipo;
	Double valor;
	
	public Transasao(int id, String tipo, Double valor) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
public class StreamTeste {

	
	public List<Transasao> getTransacoes(){
		List<Transasao> transacoes = Arrays.asList(
				new Transasao(1, "A", 1.3),
				new Transasao(2, "A", 4.6),
				new Transasao(3, "A", 3.1),
				new Transasao(4, "B", 5.5),
				new Transasao(5, "C", 7.9),
				new Transasao(6, "B", 2.4),
				new Transasao(7, "C", 5.5));
		return transacoes;
	}
	
	private static void teste01() {
		Stream<Double> randon = Stream.generate(Math::random).limit(10);
		randon.forEach(System.out::println);

		
		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2).limit(10);
		oddNumbers.forEach(System.out::println);
		
	}
	
	
	private static void teste02() {
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		
		Stream<String> infinite = Stream.generate(() -> "chimp");
		
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		
		System.out.println(list.stream().anyMatch(pred)); // true
		System.out.println(list.stream().allMatch(pred)); // false
		System.out.println(list.stream().noneMatch(pred)); // false
		System.out.println(infinite.anyMatch(pred)); // true

		List<String> valor = Arrays.asList("Wilson".split(""));
		Predicate<String> lower = x -> Character.isLowerCase(x.charAt(0));
		System.out.println(valor.stream().allMatch(lower));
	}	
	
	
	public static void teste03() {
		List<Transasao> lista = new StreamTeste().getTransacoes();
		
		int qtd = lista.stream().map(t -> t.getId()).reduce(0, Integer::sum);
		System.out.println("qtd: " + qtd);

		qtd = lista.stream().collect(reducing(0, Transasao::getId, Integer::sum));
		System.out.println("qtd: " + qtd);

		Double media = lista.stream().collect(averagingDouble(Transasao::getValor));
		System.out.println("media: " + media);

		Optional<Transasao> max = lista.stream().collect(maxBy( Comparator.comparing(Transasao::getValor)));
		System.out.println("max: " + max.orElse(null).getValor());
		
		Map<String, List<Transasao>> ll = lista.stream().collect(groupingBy(Transasao::getTipo));
		ll.forEach( (k,v) -> {
			System.out.println(k);
			v.stream().map(Transasao::getValor).forEach(System.out::println);
		});

		
		Map<String, Double> lll = lista.stream().collect(groupingBy(Transasao::getTipo, summingDouble(Transasao::getValor)));
		lll.forEach( (k,v) -> System.out.println(k + " - " + v)  );

	}
	
	public static void teste04() {
		List<Transasao> lista = new StreamTeste().getTransacoes();
		
		DoubleBinaryOperator total = (a,b) -> a + b;
		
		Optional<Double> valor = lista.stream().map(Transasao::getValor).reduce(total::applyAsDouble);
		System.out.println(valor.get());
		
	}

	public static void teste05() {
		Byte[] buffer = {1,52,98,47,50};
		byte[] buffer1 = {1,52,98,47,50};
		
		String v1 = Stream.of(buffer).map(String::valueOf).reduce("",String::concat);
		String v2 = Arrays.stream(buffer).map(String::valueOf).reduce("",String::concat);
		String v3 = Arrays.stream(buffer).collect(Collectors.reducing("",String::valueOf,String::concat));
		String v4 = Arrays.asList(buffer).stream().map(String::valueOf).reduce("", String::concat);
		
		Optional<String> v5 = Arrays.asList(buffer).stream()
				                    .flatMapToInt(x -> IntStream.of(x))
				                    .mapToObj(String::valueOf)
				                    .reduce(String::concat); //reduce com apenas um parametro retorna um Optional
		
		String v6 = Arrays.asList(buffer).stream().map(String::valueOf).collect(Collectors.joining(""));
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5.orElse("erro"));
		System.out.println(v6);
		
		
	}

	
	public static void main(String[] args) {
		teste05();
	}

}
