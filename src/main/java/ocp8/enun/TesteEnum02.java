package ocp8.enun;

public enum TesteEnum02 {

	UM{
		@Override public void metodo(){}
	}, 
	DOIS{
		@Override public void metodo(){}
	}, 
	TRES{
		@Override public void metodo(){}
	};
	
	private TesteEnum02(){
		
	}
	
	abstract void metodo();
}
