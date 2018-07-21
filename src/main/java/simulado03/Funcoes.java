package simulado03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Funcoes {

	public static void main(String[] args) {
		List<String> vowels = new ArrayList<String>();
		vowels.add("a");
		vowels.add("e");
		vowels.add("i");
		vowels.add("o");
		vowels.add("u");
		Function<List<String>, List<String>> f = list -> {System.out.println("MERDA"); return list.subList(2, 4);};
		System.out.println(f.apply(vowels));
		vowels.forEach(System.out::print);
	}

}
