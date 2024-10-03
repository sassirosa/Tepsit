package produttoreconsumatore;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class Buffer {
	
	private ArrayList<Integer> ListaValori;
	private int ultimoProdotto;
	private int ultimoConsumato;
	private int limite;
	myArray numero;
	
	int numeri [];
	
	
	public Buffer() {
		ListaValori = new ArrayList<Integer>();
		numeri = new int[10000];
		ultimoProdotto = 0;
		ultimoConsumato = 0;
		limite = 10000;
	}
	
	public synchronized Integer ConsumaNumero() throws InterruptedException{
		
		while (ultimoConsumato>=ultimoProdotto) {
			wait();
		}
		ultimoConsumato++;
		
		return numeri[ultimoConsumato];
		
	}
	
	public synchronized Integer ProduciNumero(int n) {
		if(ultimoProdotto<limite) {
			ultimoProdotto++;
			ListaValori.add(ultimoProdotto);
			notifyAll();
			int i = ultimoProdotto;
			numeri[i] = n;
			System.out.println("fatta la funzione produci numero");
			
			return ultimoProdotto;
		}
		return null;
	}
	
	

}
