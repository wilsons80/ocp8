package simulado02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Names {
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void printNames(String a) {
		//System.out.println(getList());
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Bob Hope", "Bob Dole", "Bob Brown");
		Names n = new Names();
		n.setList(list.stream().collect(Collectors.toList()));
		n.getList().forEach(n::printNames);
	}
}
