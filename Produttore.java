package produttoreconsumatore;

import java.util.concurrent.ThreadLocalRandom;

public class Produttore implements Runnable {
	
	
	
	private int numcas;
	private int x;
	
	private int min = 0;
	private int max = 1023;
	
	private Buffer buffer;
	
	public Produttore(Buffer buffer) { // richiede il buffer nel costruttore in modo che possa usare lo stesso in condivisione con il consumatore
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
		
				while(true) { //all'inifinito il thread produttore
					//genera i numeri casuali
					int x = generatoreX();
					int numcas = generatoreNumCas();
					
					buffer.inserisci(numcas); //inserisce il valore casuale nel buffer (in comune con il consumatore)
					try {
						Thread.sleep(x); //"dorme" un tempo casuaòe prima di rifare tutto dall'inizio
					} catch (InterruptedException e) {
						//può essere vuoto o puoi scriverci un Sysout 
					}
				}
				
			}
			
		
	

}
