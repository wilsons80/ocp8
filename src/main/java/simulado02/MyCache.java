package simulado02;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
public class MyCache {
    
    public static void main(String args[]) {
    	List<String> cal = new ArrayList<>();
		cal.add("a");
		cal.add("b");
		cal.add("c");
		System.out.println("lista antes: " + cal);
		if(cal.iterator().hasNext()) {
			String v = (String) cal.iterator().next();
			System.out.println(v);
			cal.iterator().remove();
		}
		System.out.println("lista depois: " + cal);

	}
}
