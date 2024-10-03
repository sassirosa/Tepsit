package produttoreconsumatore;

import java.util.concurrent.ThreadLocalRandom;

public class Produttore implements Runnable {
	
	
	
	private int numcas;
	private int x;
	
	private int min = 1;
	private int max = 1023;
	
	private Buffer buffer;
	
	public Produttore(Buffer buffer) {
		this.buffer = buffer;
	}
	
	
	public int generatoreNumCas() {
		
		numcas = ThreadLocalRandom.current().nextInt(min, max )+ 1;
		
		
		return numcas;
	}
	
	public int generatoreX() {
		
		x= ThreadLocalRandom.current().nextInt(100, 1000) + 1;
		
		return x;
	}
	
	
	public void run() {
		
		
			try {
				while(!Thread.interrupted()) {
					Thread.sleep(x);
					Integer numeroprodotto = buffer.ProduciNumero(numcas);
					System.out.println("Funzione produttore");
					if(numeroprodotto == null) break;
				}
				
			}catch(InterruptedException e){
				System.out.println("il thread è stato interrotto");
			}
			
		
	}

}
