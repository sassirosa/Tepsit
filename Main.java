package produttoreconsumatore;

public class Main {
	

	public static void main(String[] args) {
		
		
		Buffer buffer = new Buffer(100); // creo l'oggetto della classe del buffer in comune
		
		
		Thread ProduttoreThread = new Thread(new Produttore(buffer)); // creo l'oggetto thread che prende nel costruttore un oggetto della classe produttore
																		// che a sua volta prende nel costruttore l'oggetto in comune della classe buffer
		
		Thread ConsumatoreThread = new Thread(new Consumatore(buffer)); // creo l'oggetto thread che prende nel costruttore un oggetto della classe consumatore
																		// che a sua volta prende nel costruttore l'oggetto in comune della classe buffer
		
		ProduttoreThread.start(); // porto allo stato di pronto il thread produttore
		ConsumatoreThread.start(); //porto allo stato di pronto il thread consumatore
		
			
			
		
		
	
			
			
			
		
			
			
		
		
		
	}

}
