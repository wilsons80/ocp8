package simulado03;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestNIO {

	public static void main(String[] args) throws Exception {
		try (FileInputStream fis = new FileInputStream("/home/wilson.souza/tmp/test.txt");
				InputStreamReader isr = new InputStreamReader(fis)) {
			while (isr.ready()) {
				isr.skip(1);
				int i = isr.read();
				char c = (char) i;
				System.out.print(c);
			}
		}
	}

}
