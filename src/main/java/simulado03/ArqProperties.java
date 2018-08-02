package simulado03;

import java.io.FileReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ArqProperties {
	public static void main(String[] args) {

		Locale.setDefault(new Locale("FR", "ca")); // Set default to French Canada
		Locale l = new Locale("jp", "JP");
		ResourceBundle rb = ResourceBundle.getBundle("appmessages", l);
		String msg = rb.getString("greetings");
		System.out.println(msg);

		// #In appmessages.properties:
		// greetings=Hello
		//
		// #In appmessages_fr_FR.properties:
		// greetings=bonjour

	}
}
