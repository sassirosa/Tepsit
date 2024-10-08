package produttoreconsumatore;


public class Buffer {
	
	private int [] a; // array del buffer
	private int coda;
	private int testa;
	private int size; //grandezza array
	private int numero;// indice per tenere traccia del riempimento dell'array
	
	//questo è un buffer dinamico con uso degli array
	
	
	
	public Buffer(int dim) { // nel costruttore decido quanto grande voglio il buffer
		size = dim;
		numero  =0;
		a = new int [size];
		testa = 0; //primo posto occupato
		coda = 0; // primo posto libero
	}
	
	public synchronized void inserisci(int val){
		
		if (size == numero) { // è pieno
			try {
				wait();// il produttore aspetta
			} catch (InterruptedException e) {
				System.out.println("il thread è stato interrotto");
				
			} 
		}else { //altrimenti il produttore riempe l'array
			a[coda]= val;
			coda = (coda+1)%size;
			numero++;
			notify(); // e notifica il consumatore
		}
		
	}
	
	public synchronized int rimuovi() {
		int val = 0;
		if (size == numero) { // se è pieno chiama il consumatore
			notify(); 
		}
		while (numero == 0) { // È vuoto ,, viene utilizzato un while in modo che sia controllato periodicamente che la condizione venga rispettata
            try {
                wait(); // Il consumatore aspetta
            } catch (InterruptedException e) {
                System.out.println("Il thread è stato interrotto");
            }
        }
		// quando il buffer non è più vuoto il consumatore può svuotarlo
		val = a[testa];
		testa = (testa+1)%size;
		numero--;
		notify(); // e notifica al produttore che può produrre
	
		return val; // restituisce il valore consumato
	}
	
	

}
