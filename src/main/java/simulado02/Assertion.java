package simulado02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class Assertion {

	public static boolean isGoodnumber(int n) {
		assert n > 5;
		return true;
	}

	public static void main(String[] args) {
		int i = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);
		do {
			i--;
			if (i < 5)
				break;
		} while (isGoodnumber(j--));
		System.out.println(i);

	}

	private void teste() {
		try {
			throw new FileNotFoundException();
		} catch (IOException e) {
			// TODO: handle exception
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
	}
}

// java -ea TestClass 8 7 8
