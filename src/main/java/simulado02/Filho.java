package simulado02;

import java.io.IOException;

public class Filho extends Pai {

	
	@Override
	public void metodoComArithmeticException() throws ArithmeticException {
	}
	
	@Override
	public void metodoComIOException() throws IOException{
		
	}
	
	@Override
	public void metodoCSemException() throws ArithmeticException{
		
	}

	@Override
	public Integer getInteger() {
		return 1;
	}
}
