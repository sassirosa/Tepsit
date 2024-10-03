package produttoreconsumatore;

import java.util.ArrayList;

public class Consumatore implements Runnable{
	
	private ArrayList <Integer> Numeri;
	private Buffer buffer;
	
	int pari;
	int dispari;
	int totale;
	
	public Consumatore(Buffer buffer) {
		this.buffer = buffer;
	}
	
	
	public void Calcola(int n) {
		
		totale++;
		if(n%2 == 0) {
			pari++;
		}else {
			dispari++;
		}
		
	}
	
	public int StatisticaPari() {
		
		return (pari * 100)/totale;
	}
	
public int StatisticaDispari() {
		
		return (dispari * 100)/totale;
	}
	
	public void run() {
		
		try {
			
			while(!Thread.interrupted()) {
				Integer numero = buffer.ConsumaNumero();
				Calcola(numero);
				System.out.println("Numero letto: " + numero);
				System.out.println("La percentuale di numeri pari è: " +  StatisticaPari());
				System.out.println("La percentuale di numeri dispari è: " +  StatisticaDispari());
			}
			
		}catch(InterruptedException e){
			System.out.println("il thread è stato interrotto");
		}
		
	}

}