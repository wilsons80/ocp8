package br.com.ocp.innerclass;

public class Teste {
	
	class Teste01{
		class Teste02{
			void teste02(){
				System.out.println("inner class: método teste02()");
			}
		}
	}
	
	interface Inter{
		void metodoInterface();
	}
	
	public void teste(){
		Inter inter = new Inter(){
			public void metodoInterface(){
				System.out.println("metodoInterface");
			}
		};
		Teste.Teste01 t01 = new Teste.Teste01();
		Teste01       t02 = new Teste.Teste01();
		Teste01       t03 = new Teste01();
		
		Teste01.Teste02 t2 = t03.new  Teste02();
		t2.teste02();
		
		br.com.ocp.innerclass.Teste.Teste01.Teste02 t = t2;
		t.teste02();
		
		inter.metodoInterface();
	}
	
	public void teste02(){
		Inter inter = new Inter(){
			public void metodoInterface(){
				System.out.println("teste02");
			}
		};
		inter.metodoInterface();
	}
	
	
	public static void main(String[] args) {
		
		Teste.Teste01 teste1 = new Teste().new Teste01();
		Teste01 t1           = new Teste().new Teste01();
		
		
		
		new Teste().teste();
		new Teste().teste02();
	}
}


class Outra {
	
	public void teste02(){
		Teste TESTE                   = new Teste();
		//Teste.Teste01 teste01         = TESTE.new Teste01(); 
		//Teste.Teste01.Teste02 teste02 = teste01.new Teste02();
	}
	
}