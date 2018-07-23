package br.com.ocp.casting;

public class Capybara extends Rodent {
	
	private void teste01(){
		System.out.println("Inicio teste01...");
		Rodent rodent = new Rodent();
		if(rodent instanceof Capybara){
			Capybara capybara = (Capybara) rodent; // Throws ClassCastException at runtime
		}
		System.out.println("Fim teste01...");
	}

	private void teste02(){
		System.out.println("Inicio teste02...");
		Rodent rodent = new Capybara();
		Capybara capybara = (Capybara) rodent;
		System.out.println("Fim teste02...");
	}

	private void teste03(){
		System.out.println("Inicio teste03...");
		Rodent rodent = new Capybara();
		Capybara capybara = rodent; // Cast é obrigatório...
		System.out.println("Fim teste03...");
	}

	public static void main(String[] args) {
		new Capybara().teste01();
		new Capybara().teste02();
	}
}


