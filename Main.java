package ateatro;

import java.util.Scanner;

public class Main {
	
	
	//public static void CalcoloDistanza(DistanzaEuclidea[] Distanza) {
	
	//}
	
	public static void InizializzazioneMatrice(boolean Posti[][]) {
		
		for (int i = 0; i<15 ; i++) {
			for (int j = 0; j<46;j++) {
				
				Posti[i][j]= true;
				
			}
		}
	}
	
	

	public static void main(String[] args) {
		

		

		
		
		
		final int R = 15;
		final int C = 46;
		
		
		DistanzaEuclidea [] Distanza  = new DistanzaEuclidea [R*C]; //array dove inserisco tutti i valori della distanza dei posti partendo dal centro
		//calcolo le distanze
		
			int k = 0;
					
					for (int i = 0; i<15 ; i++) {
						for (int j = 0; j<46;j++) {
							
							Distanza[k] = new DistanzaEuclidea();
							Distanza[k].calcolaDistanza(i,j);
							k++;
							
							
							
						}
					}
					
					//ordinamento
					
					for (int i =0; i< 15*46;i++) {
						for (int j=0; j< 15*16;j++) {
							if(Distanza[j].getDistanza()> Distanza[j+1].getDistanza()) {
								DistanzaEuclidea t = Distanza[j];
								Distanza[j]= Distanza[j+1];
								Distanza[j+1] = t;
							}
						}
					}
					
				
				
				
		
		
		
		//thread
		Thread[] threads = new Thread[7];	//array threads di 7 elementi
		ThreadOccupante[] prenotazioni = new ThreadOccupante[7];	//array prenotazioni di 7 elementi
		
		
		boolean Posti[][]= new boolean [R][C]; // matrice dei posti del teatro
		
		InizializzazioneMatrice(Posti);
		//CalcoloDistanza(Distanza);
		
		System.out.println("Inserisci il numero di biglietti che vuoi: ");
		Scanner input = new Scanner(System.in);
		int biglietti = input.nextInt();
		
		for (int i = 0; i<15; i++) {
			for (int j = 0; j<46; j++) {
				System.out.print(Posti[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		for (int i = 0; i < 7; i++) { //creao i thread e gli assegno l'oggetto threadoccupante
			
			Prenota PrEnOtA = new Prenota();
			ThreadOccupante c = new ThreadOccupante();
			prenotazioni[i] = c;
			c.setMatrice(Posti);
			c.setCalcola(Distanza);
			c.setIndex(0);
			PrEnOtA.setBiglietto(biglietti);
			threads[i] = new Thread(c);
		
		}
		

		for (int i = 0; i < 7; i++) { // avvio i thread
			threads[i].start();
		}
		
		
		System.out.println("La sala dopo la tua prenotazione: ");
		
		
		for (int i = 0; i<15; i++) {
			for (int j = 0; j<46; j++) {
				System.out.print(Posti[i][j] + " ");
			}
		}
		
		
		
		
		
		input.close();
	}

}
