package sincronizzazione;
 
import java.util.Scanner;

//NOTA: non capisco perchè i thread contando in condivisione a coppie saltino il numero 1
 
public class Main {
	
	int n;
	int t;
	
 
	public static void main(String[] args) {
		
		System.out.println("Inserisci il numero di thread: ");
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		System.out.println("Inserisci il numero massimo: ");
		int n = input.nextInt();
		
		input.close();
		
		Thread [] contatore = new Thread[t];
		
		
		int j = 0;
		for (int i = 0; i<t/2 ; i++) {
			
			GeneraNumero generatore = new GeneraNumero();
			ThreadContaCondiviso c = new ThreadContaCondiviso(generatore);
			c.setMax(n);
			contatore[j] = new Thread(c) ;
			j++;
			ThreadContaCondiviso d = new ThreadContaCondiviso(generatore);
			c.setMax(n);
			contatore[j] = new Thread(d) ;
			j++;
			
		}
		
		for (int i = 0; i < contatore.length; i++) { //avvio i thread
			contatore[i].start();			
		}
}
}