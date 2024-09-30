package statodeithread;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

	
		int n;
		int t;
		int x;
		
		
		public int generatoreNumCas() {
			
			x = ThreadLocalRandom.current().nextInt(0, n + 1);
			
			
			return x;
		}
		
	 
		public static void main(String[] args) {
			
			System.out.println("Inserisci il numero di thread: ");
			Scanner input = new Scanner(System.in);
			int t = input.nextInt();
			
			System.out.println("Inserisci il numero massimo: ");
			int n = input.nextInt();
			
			input.close();
			
			
			
			ThreadConta [] contatore = new ThreadConta[t];
			Thread [] threads = new Thread [t];
			
			for (int i = 0; i<t ; i++) {
			
				ThreadConta c = new ThreadConta();
				c.setMax(n);
				contatore[i] = c;
				threads[i] = new Thread(c);
		
			}
			
			for (int i = 0; i < threads.length; i++) { //avvio i thread
				threads[i].start();			
			}
			
			
			boolean finito = false;
			int num;
			while(!finito) {
				finito = true; // si presuppone che siano finiti
				for (int i = 0; i < contatore.length; i++) { //controllo i thread
						
					if(threads[i].isAlive()) {
						
						num = contatore[i].getNum();
						finito = false;
						 System.out.println("Thread " + i + ": " + num);
					}else {
						System.out.println("Thread " + i + ": COMPLETATO");
					}
				}
				
				try {
                    Thread.sleep(1000); // Aspetta 1 secondo prima di controllare di nuovo
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
				
			}
			
			if (finito) { // quando arriverà qui finito sarà true
				
				System.out.println("TUTTI I THREAD COMPLETATI");
				
			}
			
			
			
			
			
	
	

	}

}
