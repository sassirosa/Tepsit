package ateatro;

public class Prenota {
	
	boolean posto = true;
	int biglietto;
	
	
	public synchronized void setPosto() {
		
		
		posto = false;
		
	}
	
	public synchronized int Nbiglietti() {
		int x = biglietto;
		biglietto --;
		return x;
	}
	
	public boolean getPosto() {
		return posto;
	}
	
	public void setBiglietto(int x) {
		biglietto = x;
	}

	
	
	
	

}
