package simulado02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class TestLambda {
	
	private void teste01() {
		IntSupplier valor = () -> 1 + 15;
		
		int numero = 1;
		
		List<String> lista = Arrays.asList("a","b");
		
		lista.stream().forEach( (a) -> {
			System.out.println(a + valor.getAsInt());
		});
		
		
	}
	
	private void testeSupplier(IntSupplier fabricaMinha) {
		System.out.println(fabricaMinha.getAsInt());
	}

	public static void main(String[] args) {
		//new TestLambda().testeSupplier(() -> 1 + 15);
		new TestLambda().geraListaInteiros(() -> Math.random());
		
		AtomicInteger ai = new AtomicInteger(5);
		//2 INSERT CODE HERE   
		int x = ai.addAndGet(1);
		System.out.println(x);
	}
	
	public List<Double> geraListaInteiros(DoubleSupplier funcaoDoubleAleatorio){
		List<Double> retorno = new ArrayList<>();
		retorno.add(funcaoDoubleAleatorio.getAsDouble());
		retorno.add(funcaoDoubleAleatorio.getAsDouble());
		retorno.add(funcaoDoubleAleatorio.getAsDouble());
		retorno.add(funcaoDoubleAleatorio.getAsDouble());
		return retorno;
	}
	
	public List<Double> geraListaInteiros(){
		List<Double> retorno = new ArrayList<>();
		retorno.add(Math.random());
		retorno.add(Math.random());
		retorno.add(Math.random());
		retorno.add(Math.random());
		return retorno;
	}
}
