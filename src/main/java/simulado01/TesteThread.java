package simulado01;

public class TesteThread extends Thread {

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Dentro do run....");
	}

	
	public static void main(String[] args) {
		TesteThread t = new TesteThread();
		t.start();
		System.out.println("Fora do run....");
	}
}
