package statodeithread;



public class ThreadConta implements Runnable{
	
	
	int max;
	int numero = 0;
	
	public ThreadConta() {
		
	}
	
	public void setMax(int lim) {
		max = lim;
	}
	
	public int getNum() {
		return numero;
	}
	
	
	
	public void run() {  // il thread conta i valori e dopo averne contato uno aspetta 120 ms
		
		for(int i=0; i < max ; i++) {
			numero++;
			try {
				Thread.sleep(120);
			}catch(InterruptedException e){
				System.out.println("il thread è stato interrotto");
			}
			
		}
		
	
		
	}
		/*
		int numero = valore.numero();
		while(numero < max) {
			System.out.println("Numero: " + numero);
			numero = valore.numero();
			try {
				Thread.sleep(120);
			}catch(InterruptedException e){
				System.out.println("il thread è stato interrotto");
			}
		}
		
	}*/

}
