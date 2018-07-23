package br.com.ocp.interfaces;

public class Classe01 implements IPessoa {

	@Override
	public String nomeCompleto() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Meu nome é: " + IPessoa.super.nomeCompleto());
		
		sb.append("\n");
		
		sb.append("Meu nome é: " + IPessoa.nomeCaixaBaixa());
		return sb.toString();
	}
	
	/*
	 * Não pode ter a annotation @Override
	 */
	public String nomeCaixaBaixa() {
		return "Wilson de Carvalho Souza - MPDFT";
	}
	
	public static void main(String[] args) {
		System.out.println("Processando....");
		System.out.println(new Classe01().nomeCompleto());
		System.out.println(new Classe01().nomeCaixaBaixa());
	}

	
	@Override
	public void testeExcecao() {
	}

}
