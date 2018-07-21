package simulado02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class FileTeste {
	public interface A{
	  void m1();	
	}
	
	public void testeinterface(A a) {
		
	}

	public class B implements A{

		@Override
		public void m1() {
			// TODO Auto-generated method stub
			
		}
		
	}
    public void testeinterface2() {
    	B b = new B();
    	testeinterface(b);
    	testeinterface( () -> {} );
	}
    public static void copy(String records1, String records2)  {
        try (InputStream is = new FileInputStream(records1);
                OutputStream os = new FileOutputStream(records2);){
            
            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                System.out.println("Read and written bytes " + bytesRead);
            }
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        copy("c:\\temp\\test1.txt", "c:\\temp\\test2.txt");
    }


}
