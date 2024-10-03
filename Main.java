package produttoreconsumatore;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
	
	
public static int generatoreNumCas(int n) {
		
		int numcas = ThreadLocalRandom.current().nextInt(0, n )+ 1;
		
		
		return numcas;
	}

	public static void main(String[] args) {
		
		int x;
		
		System.out.println("Inserisci il numero di thread: ");
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		System.out.println("Inserisci il numero massimo: ");
		int n = input.nextInt();
		
		input.close();
		
		x = generatoreNumCas(n);
		
		Buffer buffer = new Buffer();
		
		
		Thread ProduttoreThread = new Thread(new Produttore(buffer));
		Thread ConsumatoreThread = new Thread(new Consumatore(buffer));
		
		
		Thread[] threads = new Thread[t];
		
		for (int i= 0; i<t; i++) {
			Conta conta = new Conta(x);
			threads[i] = new Thread(conta);
		}
		
		for (int i= 0; i<t; i++) {
			
			threads[i].start();
			
			try {
				threads[i].sleep(120);
				ProduttoreThread.start();
				ConsumatoreThread.start();
				
				
				
			}catch(InterruptedException e){
				System.out.println("il thread è stato interrotto");
			}
			
			
		}
		
	
			
			
			
		
			
			
		
		
		
	}

}
