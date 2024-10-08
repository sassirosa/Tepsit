package sivaaballare_ingressosingolo;

public class Main {

	public static void main(String[] args) {
		
		Porta porta = new Porta();
		
		Thread [] t= new Thread[10];
		
		for(int i=0; i<10; i++) {
			  MyThread h = new MyThread(porta); //🫢🫢🫢
			 t[i]= new Thread(h) ;
		}
		
		for(int i=0; i<10; i++) {
			 t[i].start();
		}
		
		while(true) {
			
			int n = porta.numeropersone;
			System.out.println("Le persone dentro il locale sono: " + n);
			
			try {
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) {
	            System.out.println("Il thread è stato interrotto");
	        }

		}

	}

}
