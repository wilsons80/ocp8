package simulado02;

public class Conexoes implements AutoCloseable {
	public static void main(String[] args) {
		
	}

	public static void teste1() throws Exception {
		try(Conexoes c = new Conexoes();) //try com resource
		
		try{ Conexoes d = new Conexoes();} //try SEM resource
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
