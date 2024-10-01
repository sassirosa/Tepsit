package ateatro;

public class ThreadOccupante implements Runnable {
	
	Prenota posto;
	int biglietti;
	boolean [][] Matrice;
	int x;
	int y;
	DistanzaEuclidea[] calcola;
	int i; // indice dell'array delle distanze
	
	

	
	public void setMatrice(boolean [][]m) {
		
		Matrice = m;
		
	}
	
	public void setIndex(int z) {
		i = z;
	}
	

	public void setCalcola(DistanzaEuclidea[] x) {
		calcola = x;
	}
	
	@Override
	public void run() {
		boolean check=false;
		
		while(posto.Nbiglietti() > 0) {
		
			while(!check) {
				
				x = (int)calcola[i].getRiga();
				y = (int)calcola[i].getColonna();
				
				if(Matrice[x][y] == true) {
					posto.setPosto();
					posto.Nbiglietti();
					check = true;
				}else {
					i++;
					;
				}
			}
		}

	}

}
