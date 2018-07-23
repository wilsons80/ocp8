package ocp8.collections;

public class Pessoa {
	
	private Integer idade;
	private String nome;

	
	public Pessoa(Integer idade, String nome) {
		super();
		this.idade = idade;
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Pessoa [idade=" + idade + ", nome=" + nome + "]";
	}
	
	
	

}
