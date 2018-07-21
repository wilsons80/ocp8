package simulado03;

public class Excecoes {
	class TaskBase {
		int getStatusCode(Object obj) {
			if (obj != null)
				return 1;
			else
				return 0;
		}
	}

	class ParallelTask extends TaskBase {    
		char getStatusCode2(Object obj)  {return 0;}
		
		long getStatusCode2(int obj)  {return 0;}
	}
}
