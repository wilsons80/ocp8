package br.com.ocp.heranca;

public class TesteHeranca {
	
	

	public void testeMainFilho(){
		FilhoTO filho = new FilhoTO();
		filho.setIdade(10);
		filho.setNome("filho");
		filho.setJogaBola(true);
		
		testaFilho(filho);
		
		FilhaTO filha = new FilhaTO();
		filha.setIdade(10);
		filha.setNome("filha");
		filha.setBrincaBoneca(true);
		
		testaFilha(filha);
	}
	

	private void testaFilho(PaiTO to){
		
	}

	private void testaFilha(PaiTO to){
		
	}


}
