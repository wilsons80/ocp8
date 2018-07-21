package simulado02;

abstract class Widget {
	String data = "data";

	public void doWidgetStuff() {
		System.out.println(data);
	}
}

class GoodWidget extends Widget {
	String data = "big data";


}

public class TesteHeranca {
	public static void main(String[] args) {
		Widget w = new GoodWidget();
		w.doWidgetStuff();
	}
}
