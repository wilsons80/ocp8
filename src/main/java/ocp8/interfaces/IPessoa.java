package br.com.ocp.interfaces;

import java.io.IOException;

public interface IPessoa {
	
	// only public, static & final are permitted
	public static final String nome = "WILSON";
	
	
	public void testeExcecao() throws IOException;
	
	public static String nomeCaixaBaixa(){
		return nome.concat(" CARVALHO SOUZA").toLowerCase();
	}
	
	public default String nomeCompleto(){
		return nome.concat(" CARVALHO SOUZA");
	}

}
