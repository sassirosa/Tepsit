package produttoreconsumatore;

public class Conta implements Runnable {
	
	int n;
	
	public Conta(int n) {
		
		this.n = n;
	}
		@Override
	public void run() {
		
			
					while((!Thread.interrupted()) && (n>0)) {
						n--;
						
					}
					
				
				
			

	}
}


