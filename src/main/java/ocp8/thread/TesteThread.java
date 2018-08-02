package ocp8.thread;

public class TesteThread extends Thread {
	static Object obj = new Object();
	static int x, y;

	public void run() {
		synchronized (obj) {
			for (;;) {
				x++;
				y++;
				System.out.println(x + " " + y);
			}
		}
	}

	public static void main(String[] args) {
		new TesteThread().start();
		new TesteThread().start();
		new TesteThread().start();
		new TesteThread().start();
		new TesteThread().start();
		
	}
}
