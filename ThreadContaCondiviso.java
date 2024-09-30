package sincronizzazione;
 
public class ThreadContaCondiviso implements Runnable{
	
	GeneraNumero valore;
	int max;
	
	public ThreadContaCondiviso(GeneraNumero generatore) {
		this.valore = generatore;
	}
	
	public void setMax(int lim) {
		max = lim;
	}
	
	
	public void run() {
		int numero = valore.numero();
		while(numero < max) {
			System.out.println("Numero: " + numero);
			numero = valore.numero();
		}
		
	}
 
}