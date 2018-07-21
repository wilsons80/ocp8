package simulado02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;

public class Device implements AutoCloseable{
    String header = null;
    public Device(String name) throws IOException{
        header = name;
//        if("D2".equals(name)) throw new IOException("Unknown");
        System.out.println(header + " Opened");        
    }

    public String read() throws IOException{
        return "";
    }
    
    public void close() throws IOException{
        System.out.println("Closing device "+header);
        throw new IOException("RTE while closing "+header);
    }
    
    public static void main(String[] args) throws Exception {
        try(Device d1 = new Device("D1");
        	Device d2 = new Device("D2");
        	Device d3 = new Device("D3")){
            throw new FileNotFoundException("test");
        }
        finally {
			throw new Exception("ultima");
		}
    }
    
}
