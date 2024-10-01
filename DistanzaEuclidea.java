package ateatro;

public class DistanzaEuclidea {
	
	private double x;
	private double y;
	private double distanza;
	
	
	DistanzaEuclidea(){
		
		
	}
	
	
	public double calcolaDistanza(int colonne, int righe) {
		
		x = (double)righe;
		y = (double)colonne;
		
		return distanza = Math.sqrt( Math.pow((23-x),2)  +  Math.pow((8-y),2));
		
		
		
	}
	
	public double getDistanza() {
		
		return distanza;
	}
	
	public double getColonna() {
		return y;
	}
	public double getRiga() {
		return x;
	}

}
