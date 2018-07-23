package ocp8.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamTeste {

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
	
	public static void main(String[] args) {
		teste02();
	}

}
