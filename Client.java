package colpito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author Stefano Lenzi &lt; stefano@lenzi.pro &gt;
 * 
 */
public class Client {

	private static final int MAX_TRY = 3;
	
	public static void attendi(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		// Configura l'indirizzo IP e la porta del server
		String serverAddress = "127.0.0.1"; // IP del server (localhost)
		int port = 12345; // Porta del server

		Socket link = null;
		int i = 0;
		
		while( link == null && i < MAX_TRY ) {
			try {
				// Crea una connessione al server
				link = new Socket(serverAddress, port);
			}catch(IOException ex) {
				ex.printStackTrace();
				attendi((long) (1000*Math.pow(2, i)));
			}
			i++;
		}
		
		if( link == null ) {
			System.out.println("Impossibile collegarsi al server");
			return;
		}
		
		try {
				BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

				// Ottiene l'output stream per inviare dati
				OutputStream out = link.getOutputStream();

				// Ottiene l'output stream per ricevere dati
				InputStream in = link.getInputStream();
				
				// Usa un PrintWriter per inviare RIGHE di testo al server
				PrintWriter writer = new PrintWriter(out, true);
				// Usa un BufferReader per leggere RIGHE di testo al server
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));

				String userMessage;
				
				 while (true) {
		                System.out.print("Inserisci una posizione (es. C 6) o premi solo invio per terminare: ");
		                userMessage = userInput.readLine();
		                writer.println(userMessage);
		                
		                // Se l'utente non scrive niente, termina il ciclo
		                if ("".equals(userMessage)) {
		                    break;
		                }
		                
		             // Riceve la risposta dal server
			            String serverResponse;
			            if((serverResponse = reader.readLine()) != null) {
			                System.out.println("Risposta dal server: " + serverResponse);
			            }
		            }
				
		            
		            // Chiude la connessione
		            link.close();
		            System.out.println("Connessione con il server chiusa.");
				
		} catch (Exception e) {
			// Gestisce eventuali errori
			System.err.println("Errore: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
