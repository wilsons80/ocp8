package simulado03;

import java.io.FileNotFoundException;
import java.io.IOException;

interface I1 {
	void m1() throws java.io.IOException;
}

interface I2 {
	void m1() throws java.io.FileNotFoundException;
}

public class Interfaces implements I1, I2 {

	@Override
	public void m1() throws FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	public void ttt() throws IOException{
		I1 i1 = new Interfaces();
		i1.m1();
		
		I2 i2 = new Interfaces();
		i2.m1();
	}

}
