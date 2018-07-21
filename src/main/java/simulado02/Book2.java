package simulado02;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

import org.apache.commons.lang.mutable.MutableBoolean;
import org.omg.CORBA.Request;

public class Book2 {
	private String title;
	private Double price;
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Book2(String title, Double price){ this.title = title; this.price = price; }
	// accessor methods not shown What will the following code print when compiled

	
	
	static String[] sa = {"a", "aa", "aaa", "aaaa"};
	//static String[] sa = { "ab", "abaaa", "ad", "ab", "acaa", "aa"}; 
	//"ab", "abaaa", "ad", "ab",  "acaa", "aa"
	static { Arrays.sort(sa); } 
	
	
	Queue<Request> container = new LinkedList<Request>();
	
	public static void main(String[] args) {
		// and run? 
		/*
		Book b1 = new Book("Java in 24 hrs", null); 
		DoubleSupplier ds1 = b1::getPrice; 
		double vlr = (Double) null;
		System.out.println(vlr);
		//System.out.println(b1.getTitle()+" "+ds1.getAsDouble());
		*/
		/*
		Queue<Request> fgh = new LinkedList<Request>();
		List<String> ttt = new ArrayList<>();
		Stream<String> aaa = ttt.stream()
							    .filter(s -> s.startsWith("a"))
							    .map(s -> s + "aaa");
		
		final MutableBoolean mb = new MutableBoolean(false);
		
		ttt.add("a");
		ttt.add("b");
		ttt.add("a");
		ttt.add("d");
		ttt.add("r");
		ttt.add("a");
		
		
		System.out.println(Arrays.asList(sa));
		
		//ttt.forEach(a -> {if ( a.equals("a") ) {mb.setValue(true); throw new RuntimeException();} });
		String[] arg = { " " };
		
		String search = ""; 
		if(arg.length != 0) 
			search = arg[0]; 
		
		System.out.println(Arrays.binarySearch(sa, search));
		*/
		Stack<String> sss = new Stack<>();
		
		Book2.teste04();
	}
	
	
	private static void teste03() {
		 Deque<Integer> d = new ArrayDeque<>(); 
		 d.add(1); 
		 d.push(2); 
		 d.pop(); 
		 d.offerFirst(3); 
		 d.remove(); 
		 System.out.println(d);
	}
	
	private static void teste04() {
		Period p = Period.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1)); 
		System.out.println(p); 
		
		Duration d = Duration.between(LocalDateTime.now(), LocalDateTime.of(2015, Month.SEPTEMBER, 2, 10, 10)); 
		System.out.println(d);
	}

}