package ocp8.colecao;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class TesteCollection implements Comparable<TesteCollection> {

	private Integer id;

	public static void testeLinkedList01() {
		List<String> lista = new ArrayList<>();

		lista.add("wilson");
		lista.add("daniel");
		lista.add("paula");
		lista.stream().forEach(System.out::println);
		System.out.println("");

		// Necessário pois a lista foi criada como ArrayList e não LinkedList
		LinkedList<String> link = new LinkedList<String>(lista);
		link.removeLast();

		String elemento = null;
		elemento = link.peek(); // recupera o primeiro elemento, mas não remove
		System.out.println(elemento);

		elemento = link.peekFirst(); // recupera o primeiro elemento, mas não remove
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

		LinkedList<String> link = (LinkedList<String>) lista; // Usa a mesma referencia da lista (ArrayList)
		link.removeLast();

		String elemento = null;
		elemento = link.peek(); // recupera o primeiro elemento, mas não remove
		System.out.println(elemento);

		elemento = link.peekFirst(); // recupera o primeiro elemento, mas não remove
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

		fila.remove(); // lança exceção se a lista estiver vazia
		fila.poll(); // não lança exceção

		fila.stream().forEach(System.out::println);
	}

	public static void testeQueue02() {
		System.out.println("----- Pilha -----");

		Deque<String> pilha = new ArrayDeque<>();
		pilha.add("wilson"); // adiciona no back da pilha
		pilha.push("daniel"); // adiciona no front da pilha
		pilha.offer("paula"); // adiciona no back da pilha

		// pilha.remove(); //remove o elemento no front
		// pilha.pop(); //remove o elemento no front
		// System.out.println(pilha.peek()); //retorna o elemento, mas não remove

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

		mapa.put("w", "wilson");
		mapa.put("p", "paula");
		mapa.put("d", "daniel");
		mapa.put("d1", "daniel");

		for (String key : mapa.keySet()) {
			System.out.println(key + " - " + key.hashCode());
		}

		mapa.clear();

		mapa.put("wilson", "wilson");
		mapa.put("paula", "paula");
		mapa.put("daniel", "daniel");

		for (String key : mapa.keySet()) {
			System.out.println(key + " - " + key.hashCode());
		}

		// Outra forma de criar um Comparator para ordenação
		Comparator<TesteCollection> sortClasse = new Comparator<TesteCollection>() {
			@Override
			public int compare(TesteCollection o1, TesteCollection o2) {
				return o1.hashCode() - o2.hashCode();
			}
		};

	}

	// Outra forma de criar um Comparator para ordenação
	Comparator<TesteCollection> sortClasse02 = (c1, c2) -> c1.hashCode() - c2.hashCode();

	public static void testeComparator01() {
		ArrayList<String> lista = new ArrayList<>();
		lista.add("wilson");
		lista.add("WILSON");
		lista.add("daniel souza");
		lista.add("paula duo");

		lista.stream().forEach(System.out::println);

		System.out.println();
		Comparator<String> ordem = Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER);

		Collections.sort(lista, ordem);
		lista.stream().forEach(System.out::println);

	}

	private static void testeCopyOnWriteList() {
		//List<String> lista = new CopyOnWriteArrayList<String>(); // não lança java.util.ConcurrentModificationException
		List<String> lista = new ArrayList<String>();  //Exception in thread "main" java.util.ConcurrentModificationException
		lista.add("a");
		lista.add("b");
		lista.add("c");
		
		for (String s : lista) {
			System.out.println(s);
			lista.remove(s);
		}

		for (String s : lista) {
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		testeTreeSet();
	}

	@Override
	public int compareTo(TesteCollection o) {
		return this.id - o.id; // ordem crescente
		// return o.id - this.id; // ordem decrescente
	}
	
	enum TESTE{JUMBO("3j"), TALL("2t"), GRANDE("1g"); String d; TESTE(String s){this.d=s;}};
	public static class Teste2 implements Comparable<Teste2>{
		public Integer id;
		public String texto;
		public Teste2(Integer id, String texto) {
			super();
			this.id = id;
			this.texto = texto;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Teste2 other = (Teste2) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		@Override
		public int compareTo(Teste2 o) {
			return this.id - o.id;
		}
		
	};
	public static class Teste3{
		public Integer id;
		public String texto;
		public Teste3(Integer id, String texto) {
			super();
			this.id = id;
			this.texto = texto;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Teste3 other = (Teste3) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	};	
	
	private void teste() {
		// TODO Auto-generated method stub
		TesteCollection.Teste2 t = new TesteCollection.Teste2(1, "t1");

	}
	private static void testeTreeSet() {
		Set<TESTE> lista = new TreeSet<>();
		lista.add(TESTE.TALL); lista.add(TESTE.JUMBO); lista.add(TESTE.GRANDE);
		lista.add(TESTE.TALL); lista.add(TESTE.TALL); lista.add(TESTE.JUMBO);
		lista.forEach(System.out::println);
		
		Set<Teste2> lista2 = new TreeSet<>();
		lista2.add(new Teste2(1, "t1")); //para TreeSet, Teste2 PRECISA implementar Comparable
		lista2.add(new Teste2(1, "t2")); //Não será inserido
		lista2.add(new Teste2(1, "t3")); //Não será inserido
		lista2.add(new Teste2(1, "t4")); //Não será inserido
		lista2.add(new Teste2(1, "t5")); //Não será inserido
		lista2.forEach(v-> System.out.println(v.texto));
		
		System.out.println("===================");
		Set<Teste3> lista4 = new HashSet<>(); //para HashSet, Teste3 NÃO precisa implementar Comparable 
		lista4.add(new Teste3(1, "t1")); 
		lista4.add(new Teste3(1, "t2")); //Não será inserido
		lista4.add(new Teste3(1, "t3")); //Não será inserido
		lista4.add(new Teste3(1, "t4")); //Não será inserido
		lista4.add(new Teste3(1, "t5")); //Não será inserido
		lista4.forEach(v-> System.out.println(v.texto));		
		
		Set<String> lista3 = new TreeSet<>();
		lista3.add("f");
		lista3.add("b");
		lista3.add("d");
		
		lista3.forEach(v-> System.out.println(v));
	}
	

}
