package sincronizzazione;
 
public class GeneraNumero {
	
	int valore;
	
	public GeneraNumero() {
		valore = 0;
	}
	
	public synchronized int numero() {
		int x = valore;
		valore ++;
		return x;
	}
 
}