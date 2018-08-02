package ocp8.funcional;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingDouble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Transasao {
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

	public List<Transasao> getTransacoes() {
		List<Transasao> transacoes = Arrays.asList(new Transasao(1, "A", 1.3), new Transasao(2, "A", 4.6),
				new Transasao(3, "A", 3.1), new Transasao(4, "B", 5.5), new Transasao(5, "C", 7.9),
				new Transasao(6, "B", 2.4), new Transasao(7, "C", 5.5));
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

		Optional<Transasao> max = lista.stream().collect(maxBy(Comparator.comparing(Transasao::getValor)));
		System.out.println("max: " + max.orElse(null).getValor());

		Map<String, List<Transasao>> ll = lista.stream().collect(groupingBy(Transasao::getTipo));
		ll.forEach((k, v) -> {
			System.out.println(k);
			v.stream().map(Transasao::getValor).forEach(System.out::println);
		});

		Map<String, Double> lll = lista.stream()
				.collect(groupingBy(Transasao::getTipo, summingDouble(Transasao::getValor)));
		lll.forEach((k, v) -> System.out.println(k + " - " + v));

	}

	public static void teste04() {
		List<Transasao> lista = new StreamTeste().getTransacoes();

		DoubleBinaryOperator total = (a, b) -> a + b;

		Optional<Double> valor = lista.stream().map(Transasao::getValor).reduce(total::applyAsDouble);
		System.out.println(valor.get());

	}

	public static void teste05() {
		byte[] buffer1 = { 1, 52, 98, 47, 50 }; // com tipo primitivo NÃO funciona
		Byte[] buffer = { 1, 52, 98, 47, 50 };

		String v1 = Stream.of(buffer).map(String::valueOf).reduce("", String::concat);
		String v2 = Arrays.stream(buffer).map(String::valueOf).reduce("", String::concat);
		String v3 = Arrays.stream(buffer).collect(Collectors.reducing("", String::valueOf, String::concat));
		String v4 = Arrays.asList(buffer).stream().map(String::valueOf).reduce("", String::concat);

		Optional<String> v5 = Arrays.asList(buffer).stream().flatMapToInt(x -> IntStream.of(x))
				.mapToObj(String::valueOf).reduce(String::concat); // reduce com apenas um parametro retorna um Optional

		String v6 = Arrays.asList(buffer).stream().map(String::valueOf).collect(Collectors.joining());

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		System.out.println(v5.orElse("erro"));
		System.out.println(v6);
	}

	public static void teste06() {
		LongStream ls = LongStream.of(1, 2, 3);
		OptionalLong op = ls.map(x -> x * 10).filter(x -> x < 5).findFirst();
		op.getAsLong();
	}

	public static void teste07() {
		// !!! Não fará nada, pois não tem operação terminal
		Stream.generate(() -> "1").limit(10).peek(System.out::println);
	}

	public static void teste08() {
		System.out.println(Stream.iterate(1, x -> x++) // primeiro retorna depois soma, logo o resultado sempre será 1
				.limit(5).map(x -> "" + x) // converte int para string para ser usado com o método joining
				.collect(Collectors.joining()) // joining sempre retorna uma string
		);

		System.out.println(Stream.iterate(1, x -> ++x).limit(5).map(x -> "" + x).collect(Collectors.joining()));
	}

	public static void teste09() {
		Supplier<String> x = String::new;
		BiConsumer<String, String> y = (a, b) -> System.out.println();
		UnaryOperator<String> z = a -> a + a;

		List<Integer> lista = Arrays.asList();
		System.out.println(lista);
	}

	public static void teste10() {
		Stream<Integer> s = Stream.of(1);
		IntStream is = s.mapToInt(x -> x);
		DoubleStream ds = s.mapToDouble(x -> x);

		LongStream ls2 = is.mapToLong(x -> x);

		LongStream ls1 = LongStream.of(1);
		IntStream is2 = ls1.mapToInt(x -> {
			return (int) x;
		}); // Cast de Long para int

		// Stream<Integer> s2 = ds.mapToObj(x -> x); //não consegue converter double
		// para Integer

		// Stream<Long> s3 = Stream.of(1); //não consegue converter Stream<Integer> para
		// Stream<Long>

		Stream<Long> s4 = Stream.of(1L);
		// LongStream is1 = s4.mapToInt(x -> x); //não consegue converter long para int

	}

	public static void teste11() {
		List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);

		AtomicInteger valor = new AtomicInteger(0);
		valor.set(0);
		valor.set(1);

		IntBinaryOperator add = (a, b) -> a + b;
		IntBinaryOperator mult = (a, b) -> a * b;

		int r = valor.accumulateAndGet(1, add);
		System.out.println(r);

		r = valor.accumulateAndGet(1, mult);
		System.out.println(r);

		r = valor.incrementAndGet();
		System.out.println(r);

		r = valor.getAndIncrement();
		System.out.println(r);

		lista.forEach(x -> {
			valor.accumulateAndGet(x, add);
		}); // add::applyAsInt não pode ser usado, pois não é static
		lista.forEach(x -> {
			valor.accumulateAndGet(x, (a, b) -> a + b);
		});

		System.out.println(valor.get());
	}

	public static void teste12() {
		List<String> lista = Arrays.asList("daniel", "wilson", "paula", "carvalho", "souza", "duo");

		Predicate<String> pred = x -> x.length() < 6;
		Map<Boolean, List<String>> mapa = lista.stream().collect(Collectors.partitioningBy(pred));

		mapa.keySet().forEach((k) -> {
			System.out.print("\n" + k + ": ");
			mapa.get(k).stream().forEach(x -> System.out.print(x + " - "));
		});

		Map<Boolean, Map<Integer, List<String>>> mapa2 = lista.stream()
				.collect(Collectors.partitioningBy(pred, Collectors.groupingBy(String::length)));
		mapa2.keySet().forEach(k -> {
			System.out.print("\n" + k + ": ");
			mapa2.get(k).keySet().forEach(t -> {
				System.out.print("\n\t" + t + ": ");
				mapa2.get(k).get(t).forEach(p -> System.out.print(p + " - "));
			});
		});

	}

	public static void teste13() {

		IntStream is1 = IntStream.range(1, 3);
		IntStream is2 = IntStream.rangeClosed(1, 3);
		IntStream is3 = IntStream.concat(is1, is2);
		Object val = is3.boxed().collect(Collectors.groupingBy(k -> k)).get(2);
		System.out.println(val);

	}

	public static void teste14() {
		IntStream is1 = IntStream.range(1, 3);
		IntStream is2 = IntStream.rangeClosed(1, 3);
		IntStream is3 = IntStream.concat(is1, is2);
		Object val = is3.boxed().collect(Collectors.groupingBy(k -> k));
		System.out.println(val);
	}

	private static void teste15() {

		Object v1 = IntStream.rangeClosed(10, 15).boxed().filter(x -> x > 12).parallel().findAny();

		Object v2 = IntStream.range(10, 15).boxed().filter(x -> x > 14).sequential().findAny();

		System.out.println(v1 + ":" + v2);

	}

	public static void main(String[] args) {
		teste17();
	}

	private static void teste16() {
		IntStream.of(1, 2, 3, 4).sum();

	}

	private static void teste17() {

		class Item {
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getCategory() {
				return category;
			}

			public void setCategory(String category) {
				this.category = category;
			}

			public double getPrice() {
				return price;
			}

			public void setPrice(double price) {
				this.price = price;
			}

			private String name;
			private String category;
			private double price;

			public Item(String name, String category, double price) {
				this.name = name;
				this.category = category;
				this.price = price;
			}

			
		}

		List<Item> items = Arrays.asList(new Item("Pen", "Stationery", 3.0), new Item("Pencil", "Stationery", 2.0),
				new Item("Eraser", "Stationery", 1.0), new Item("Milk", "Food", 2.0), new Item("Eggs", "Food", 3.0));

		ToDoubleFunction<Item> priceF = Item::getPrice; // 1

		items.stream().collect(Collectors.groupingBy(Item::getCategory)) // 2
				.forEach((a, b) -> {
					double av = b.stream().collect(Collectors.averagingDouble(priceF)); // 3
					System.out.println(a + " : " + av);
				});

	}

}
