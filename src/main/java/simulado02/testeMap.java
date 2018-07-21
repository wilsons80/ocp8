package simulado02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testeMap {

	public static void main(String[] args) {

		Map<String, List<String>> stateCitiesMap = new HashMap<>();
		//Map<String, List<String>> stateCitiesMap = new HashMap<String, List<String>>();
		//Map<String, ArrayList<String>> stateCitiesMap = new HashMap<>();
		//Map<String, List<String>> stateCitiesMap = new HashMap<String, List<>>();
		//Map<String, List<String>> stateCitiesMap = new HashMap<String, ArrayList<String>>();
		
        List<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Albany");
        stateCitiesMap.put("NY", cities);

	}
}
