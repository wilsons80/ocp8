package simulado02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Teste {

	Set<Integer> i;
	List<Integer> i2;
	Map<Integer,Integer> i3;
	
	private static void main() {
		Pai p = new Filho();
		p.metodoComIOException();

	}
	
	
	private void teste() {
		List lista = null;
		String[] p = {"1", "2", "3" };
		Integer[] s = {1, 2, 3 };
		List<?> list2;
		list2 = new ArrayList<>(Arrays.asList(p));
		list2 = new ArrayList<>(Arrays.asList(s));
		
		List<Integer> list = new ArrayList<>(Arrays.asList(s));
		Thread
	}
	
}
