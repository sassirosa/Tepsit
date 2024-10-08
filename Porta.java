package sivaaballare_ingressosingolo;

public class Porta {
	
	int numeropersone;
	
	public Porta() {
		numeropersone = 0;
	}

	public synchronized void Entra() {
		numeropersone++;
	}
	
	public synchronized void Esci() {
		numeropersone--;
	}

}

	