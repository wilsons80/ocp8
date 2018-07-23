package ocp8.colecao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class TesteList{
	private Integer numero;
	
	
	
	private void teste01(){
		List<Integer> lista = new ArrayList<>(); //não pode conter primitivos
		lista.add(0);
		lista.add(1);
		lista.add(2);
		
		//Esse caso dá erro de compilação, pois não é possível converter de int[] para Integer[] 
		//int[] array = (Integer[])lista.toArray(); //retorna um Object[]
		
		
		Integer[] array = (Integer[])lista.toArray(); //retorna um Object[]
		Map<Integer, Integer> map = new HashMap<>(10);
		map.get(4);
	}
	
	private static void teste02(){
		int[] array = {8,6,4,1,3,2};
		for (int i : array) {
			System.out.print(i + " - ");
		}
		
		System.out.println();
		System.out.println(Arrays.binarySearch(array, 6)); // 1
		
		
		System.out.println();
		Arrays.sort(array);
		
		System.out.println();
		System.out.println(Arrays.binarySearch(array, 6)); // 1
		
		for (int i : array) {
			System.out.print(i + " - ");
		}
		
	}
	
	private static void teste03(){
		List<Integer> lista = Arrays.asList(1,5,7,2,3,9,4);
		Collections.sort(lista);
		
		lista.forEach(l -> System.out.print(l + " "));
		
		System.out.println();
		System.out.println(Collections.binarySearch(lista, 3));

		System.out.println();
		System.out.println(Collections.binarySearch(lista, 6));
		
	}
	
	private static void teste04() {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(new Integer(3));
		numbers.add(new Integer(5));
		numbers.remove(1);               //remove o index
		numbers.remove(new Integer(5));  //remove o objeto
		System.out.println(numbers);
		
	}
	
	private static void teste05(){
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(4);
		lista.add(5);
		lista.add(1);
		lista.add(1);
//		lista.add(null);
//		lista.add(null);
		
		Boolean retorno = lista.stream().anyMatch(grau -> Collections.frequency(lista, grau) > 1);
		
		System.out.println(retorno);
		
	}

	private static void extracted() throws IOException {
		byte[] conteudo = null;
		ByteArrayInputStream bis = new ByteArrayInputStream(conteudo);
		Path destino = Paths.get(System.getProperty("java.io.tmpdir"), "arquivo_temp.txt");
		Files.write(destino, conteudo, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE_NEW);
	}
	private static void testeDeque01(){

		//Deque possui todos os métodos da interface Queue, 
		//porém possui para cada método outros dois métodos para *First() e *Last()

		//O método push() é o único que não existe na interface Queue
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		//Adiciona o elemento
		deque.add(1);
		deque.addFirst(2);
		deque.addLast(5);

		//Adiciona o elemento
		deque.offer(4); //adiciona no TOP da lista
		deque.offerFirst(3);
		deque.offerLast(6);

		//Adiciona o elemento
		deque.push(8);
		deque.pop();
		deque.stream().forEach(System.out::println);
		
		//Recupera e remove
		deque.remove(); //remove o primeiro elemento
		deque.remove(new Integer(7));
		deque.removeFirst();
		deque.removeLast();
		
		//Recupera e remove
		deque.poll(); //remove o primeiro elemento
		deque.pollFirst();
		deque.pollLast();
		
		//Recupera sem remover
		deque.getLast();
		deque.getFirst();
		
		//Recupera sem remover
		deque.peek();
		deque.peekFirst();
		deque.peekLast();
	}
	
	private static void testeArrayDeque01(){
		ArrayDeque<Integer> array = new ArrayDeque<>();
		array.add(1);
		array.addFirst(2);
		array.addLast(3);
		
		array.offer(4);
		array.offerFirst(5);
		array.offerLast(6);
		
		array.peek();
		array.peekFirst();
		array.peekLast();
		
		array.remove();
		array.removeFirst();
		array.removeLast();
		
		array.push(8);
		array.pop();
		
		array.poll();
		array.pollFirst();
		array.pollLast();
		
		array.getFirst();
		array.getLast();

		array.stream().forEach(System.out::println);
	}
	
	private static void testeQueue01(){
		Queue<Integer> queue = new ArrayDeque<>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(3);   // pode lançar exceção
		queue.offer(5); // não lança exceção
		
		queue.peek();
		queue.poll();
		queue.remove();
		queue.remove(new Integer(2));
		
		
		System.out.println("peek: " + queue.peek()); //recupera, sem remover, o elemento do top, ou seja, o primeiro elemento da fila
		System.out.println("remove: " + queue.remove()); //remove o elemento do top, ou seja, o primeiro elemento da fila
		System.out.println("poll: " + queue.poll()); //recupera e remove o elemento do top

		queue.stream().forEach(System.out::println);
	}
	
	private static void testeStack01(){
		Stack<Integer> pilha = new Stack<>();
		pilha.add(2);
		pilha.add(4);
		pilha.add(1);
		pilha.add(8);
		pilha.add(6);

		Comparator<Integer> ordem = Comparator.naturalOrder();
		pilha.sort(ordem);
		pilha.stream().forEach(System.out::println);

		
		pilha.pop();
		pilha.push(1);
		pilha.peek();
		pilha.add(1);
		pilha.add(0, 2);
		pilha.addElement(new Integer(3));
		pilha.capacity();
		pilha.ensureCapacity(2);
		pilha.firstElement();
		pilha.lastElement();
		pilha.get(1);
		pilha.remove(1);
		pilha.remove(new Integer(2));
		pilha.subList(1, 3);
		
	}
	
	
	private static void teste(){
		List<Pessoa> lista = new ArrayList<>();
		
		lista.add(new Pessoa(20, "wilson"));
		lista.add(new Pessoa(10, "beltrano"));
		lista.add(new Pessoa(15, "fulano"));
		lista.add(new Pessoa(15, "caloro"));
		
		lista.stream().forEach(System.out::println);
		
		System.out.println();
		Collections.sort(lista, Comparator.comparingInt(Pessoa::getIdade)
				                          .thenComparing(s-> s.getNome()));
		
		lista.stream().forEach(System.out::println);
		
		List<Integer> lista01 = new ArrayList<>();
		lista01.add(3);
		lista01.add(2);
		lista01.add(5);
		lista01.add(1);
		
		Comparator<Integer> ordem01 = Comparator.reverseOrder();
		Collections.sort(lista01, ordem01);
		
		lista01.stream().forEach(System.out::println);
		
	}
	
	private static void testeMap01(){
		Map<Integer, String> mapa = new HashMap<>();
		
		mapa.put(8, "v8");
		mapa.put(5, "v5");
		mapa.put(3, "v3");
		mapa.put(1, "v1");
		
		//KeySet() retorna todas as keys
		for(Integer key :mapa.keySet()){
			System.out.print(key + " ");
		}
		System.out.println();
		for(String value :mapa.values()){
			System.out.print(value + " ");
		}

	}
	
	private static void testeSupplier01(){
		//List<String> lista = Arrays.asList("1","2","3");
		
		Supplier<List<Integer>> lista = ArrayList::new;
		List<Integer> l = lista.get();
		l.add(2);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
		
		l.stream().forEach(System.out::print);
		
		//Recebe um parametro e retorna um resultado do mesmo tipo do parametro.
		UnaryOperator<Integer> unary = (x) -> x*2;
		l.replaceAll(unary);
		
		System.out.println("");
		l.stream().forEach(System.out::print);
	}
	
	private static void testeMerge01(){
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Tram");
		
		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1: v2;
		
		String jenny = favorites.merge("Jenny", "Skyride", mapper);
		String tom = favorites.merge("Tom", "Skyride", mapper);
		
		System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
		System.out.println(jenny); // Bus Tour
		System.out.println(tom); // Skyride
	}
	
	private static void testeLambda01(){
		Consumer<Integer>  consumer;  // void accept(T t);
		Supplier<Integer>  supplier;  // T get();
		Predicate<Integer> predicate; // boolean test(T t);
		
		UnaryOperator<Integer> unary = (x) -> x*2;
		BinaryOperator<Integer> binary = (a,b) -> a+b;
		
		Supplier<List<Integer>> lista = ArrayList::new;
		List<Integer> l = lista.get();
		l.add(2);
		l.add(3);
		l.add(1);
		
		
		
		
		System.out.println(  );
		
		
		Predicate<String> p1 = String::isEmpty;
		
		//Consumer<Integer>  c1 = Integer::intValue;  // void accept(T t);
		//Consumer<Integer>  c2 = l -> Integer.getInteger(l.toString());  // void accept(T t);
		
		if(p1.test("")){
			System.out.println("vazio");
		}else{
			System.out.println("não vazio");
		}
		
	}
	
	private static void  testeTreeSet01(){
		Map<String, Double> map = new HashMap<>();
		map.put("pi", 3.14159);
		map.put("log(1)", new Double(0.0));
		
		TreeSet<String> tree = new TreeSet<String>();
		tree.add("ONE");
		tree.add("one");
		//tree.add("One");
		System.out.println(tree.ceiling("On")); //retorna <= 
		System.out.println(tree.ceiling("on")); //retorna <= 
	}
	
	
	public static void main(String[] args) {
		//TesteList.teste02();
		//TesteList.teste03();
		TesteList.testeTreeSet01();
	}


}
