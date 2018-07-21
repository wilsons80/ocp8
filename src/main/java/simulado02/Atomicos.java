package simulado02;

import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomicos {
	AtomicInteger count =new AtomicInteger(0);
	
	public void increment() {
		count.incrementAndGet();
	}
}
