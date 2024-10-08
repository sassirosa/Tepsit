package sivaaballare_ingressosingolo;

import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Runnable {
	
	Porta porta;
	int numcas;

	public MyThread(Porta porta) {
		this.porta = porta;
	}
	
public int generatoreNumCas() {
		
		numcas = ThreadLocalRandom.current().nextInt(0, 1000 )+ 1;
		
		
		return numcas;
	}
	
	@Override
	public void run() {
		
		while(true) {
			numcas = generatoreNumCas();
			porta.Entra();
			/*try {
				Thread.sleep(numcas);
			} catch (InterruptedException e) {
				System.out.println("thread interrotto");
			}*/
			porta.Esci();
			
		}
		
		

	}

}
