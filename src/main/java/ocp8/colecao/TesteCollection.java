package ocp8.colecao;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class TesteCollection  implements Comparable<TesteCollection>{
	
	private Integer id;
	
	public static void testeLinkedList01() {
		List<String> lista = new ArrayList<>();
		
		lista.add("wilson");
		lista.add("daniel");
		lista.add("paula");
		lista.stream().forEach(System.out::println);
		System.out.println("");
		
		//Necessário pois a lista foi criada como ArrayList e não LinkedList
		LinkedList<String> link = new LinkedList<String>(lista);
		link.removeLast();
		
		String elemento = null;
		elemento = link.peek(); //recupera o primeiro elemento, mas não remove
		System.out.println(elemento);

		elemento = link.peekFirst(); //recupera o primeiro elemento, mas não remove
		System.out.println(elemento);
		
		System.out.println("\nArrayList");
		lista.stream().forEach(System.out::println);
		
		System.out.println("\nLinkedList");
		link.stream().forEach(System.out::println);
		
	}

	
	public static void testeLinkedList02() {
		List<String> lista = new LinkedList<>();
		
		lista.add("wilson");
		lista.add("daniel");
		lista.add("paula");
		lista.stream().forEach(System.out::println);
		System.out.println("");
		
		LinkedList<String> link = (LinkedList<String>)lista; //Usa a mesma referencia da lista (ArrayList)
		link.removeLast();
		
		String elemento = null;
		elemento = link.peek(); //recupera o primeiro elemento, mas não remove
		System.out.println(elemento);

		elemento = link.peekFirst(); //recupera o primeiro elemento, mas não remove
		System.out.println(elemento);
		
		System.out.println("\nArrayList");
		lista.stream().forEach(System.out::println);
		
		System.out.println("\nLinkedList");
		link.stream().forEach(System.out::println);
		
	}

	public static void testeLinkedList03() {
		LinkedList<String> lista = new LinkedList<>();
		
		lista.add("wilson");
		lista.add("daniel");
		lista.add("paula");
		lista.add("joão");
		lista.add("jose");
		lista.add("jose");
		
		lista.stream().forEach(System.out::println);
		System.out.println("");
		Collections.sort(lista);
		

		lista.stream().forEach(System.out::println);
		System.out.println("");
	}

	public static void testeArrayList01() {
		ArrayList<String> lista = new ArrayList<>();
		
		lista.add("B");
		lista.add("b");
		lista.add("2");
		lista.add("1");
		lista.add("R");
		
		lista.stream().forEach(System.out::print);
		
		System.out.println();
		Collections.sort(lista);
		
		lista.stream().forEach(System.out::print);
	}
	
	
	public static void testeQueue01() {
		Queue<String> fila = new ArrayDeque<String>();
		fila.add("wilson");
		fila.offer("daniel");
		
		fila.remove(); //lança exceção se a lista estiver vazia
		fila.poll(); //não lança exceção
		
		fila.stream().forEach(System.out::println);
	}

	public static void testeQueue02() {
		System.out.println("----- Pilha -----");

		Deque<String> pilha = new ArrayDeque<>();
		pilha.add("wilson");  //adiciona no back da pilha
		pilha.push("daniel"); //adiciona no front da pilha
		pilha.offer("paula"); //adiciona no back da pilha
		
		//pilha.remove(); //remove o elemento no front
		//pilha.pop(); //remove o elemento no front
		//System.out.println(pilha.peek()); //retorna o elemento, mas não remove
		
		pilha.stream().forEach(System.out::println);
	}
	
	public static void testeQueue03() {
		System.out.println("----- Pilha -----");

		Queue<Integer> fila = new ArrayDeque<>();
		System.out.println(fila.offer(10));
		System.out.println(fila.offer(4));
		System.out.println(fila.peek());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.peek());
		
		
		fila.stream().forEach(System.out::println);
	}
	
	public static void testeMap01() {
		Map<String, String> mapa = new HashMap<>();
		
		mapa.put("w","wilson");
		mapa.put("p","paula");
		mapa.put("d","daniel");
		mapa.put("d1","daniel");
		
		
		for(String key : mapa.keySet()) {
			System.out.println(key + " - " +key.hashCode());
		}
		
		mapa.clear();
		
		mapa.put("wilson","wilson");
		mapa.put("paula","paula");
		mapa.put("daniel","daniel");
		
		for(String key : mapa.keySet()) {
			System.out.println(key + " - " +key.hashCode());
		}

		//Outra forma de criar um Comparator para ordenação
		Comparator<TesteCollection> sortClasse = new Comparator<TesteCollection>() {
			@Override
			public int compare(TesteCollection o1, TesteCollection o2) {
				return o1.hashCode() - o2.hashCode();
			}
		};
		
	}
	
	
	//Outra forma de criar um Comparator para ordenação
	Comparator<TesteCollection> sortClasse02 = (c1,c2) -> c1.hashCode() - c2.hashCode();
	
	
	public static void testeComparator01() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("wilson");
		lista.add("WILSON");
		lista.add("daniel souza");
		lista.add("paula duo");
		
		lista.stream().forEach(System.out::println);

		System.out.println();
		Comparator<String> ordem = Comparator.comparingInt(String::length)
				                             .thenComparing(String.CASE_INSENSITIVE_ORDER);

		Collections.sort(lista,ordem);
		lista.stream().forEach(System.out::println);
		
	}
	
	public static void main(String[] args) {
		TesteCollection.testeComparator01();
			
		
	}


	@Override
	public int compareTo(TesteCollection o) {
		return this.id - o.id; // ordem crescente
		//return o.id - this.id; // ordem decrescente
	}

	
}
