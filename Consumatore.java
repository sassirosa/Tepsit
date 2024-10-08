package produttoreconsumatore;



public class Consumatore implements Runnable{
	
	
	private Buffer buffer; 
	
	int pari;
	int dispari;
	int totale;
	
	public Consumatore(Buffer buffer) { // il costruttore prende il buffer in modo che questo possa essere condiviso per entrabi i thread
		this.buffer = buffer;
	}
	
	
	public void Calcola(int n) { // calcolo quanti pari e quanti dispari trovo sul totale di numeri che vengono prodotti e letti
		
		totale++;
		if(n%2 == 0) {
			pari++;
		}else {
			dispari++;
		}
		
	}
	
	public int StatisticaPari() { // percentuale pari
		
		return (pari * 100)/totale;
	}
	
public int StatisticaDispari() { // percentuale dispari
		
		return (dispari * 100)/totale;
	}
	
	public void run() {
		
			while(true) { // il thread all'infinito
				int numero = buffer.rimuovi(); // legge il valore rimosso dal buffer
				Calcola(numero); //controlla se è pari o dispari e poi stampa
				System.out.println("Numero letto: " + numero);
				System.out.println("La percentuale di numeri pari è: " +  StatisticaPari());
				System.out.println("La percentuale di numeri dispari è: " +  StatisticaDispari());
			}
			
		
		
	}

}