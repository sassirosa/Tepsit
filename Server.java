package colpito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
	
	
	public static final int CLIENT_DELAY = 200;

	public static void attendi(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
		}
	}
	
	
	static class NClients {
		int i = 0;
		
		synchronized void inc() {
			i++;
		}
		
		synchronized void dec() {
			i--;
		}
		
		synchronized int get() {
			return i;
		}
	}
	
	static class ClientHandler implements Runnable {

		Socket link;
		NClients counter;
		
		public ClientHandler(Socket s, NClients v) {
			this.link = s;
			this.counter = v;
		}
		
		public void cleanup() {
			try {
				link.close();
			} catch (IOException e) {
			}
			counter.dec();
		}
		
		public boolean ValidaMessaggio(String message) {
		    // Verifica che il messaggio sia lungo esattamente 3 caratteri
		    if (message.length() != 3) {
		        return false;
		    }

		    // Verifica che il primo carattere sia una lettera maiuscola
		    char firstChar = message.charAt(0);
		    if (!Character.isUpperCase(firstChar)) {
		        return false;
		    }

		    // Verifica che il secondo carattere sia uno spazio
		    char secondChar = message.charAt(1);
		    if (secondChar != ' ') {
		        return false;
		    }

		    // Verifica che l'ultimo carattere sia un numero da 1 a 9
		    char thirdChar = message.charAt(2);
		    if (!Character.isDigit(thirdChar) || thirdChar < '1' || thirdChar > '9') {
		        return false;
		    }

		    // Se tutte le condizioni sono soddisfatte
		    return true;
		}
		
		@Override
		public void run() {
			BufferedReader reader = null; 
			PrintWriter writer = null;
			String message = null;
			Random rand = new Random();
			try {
				reader = new BufferedReader(new InputStreamReader(link.getInputStream()));
				writer = new PrintWriter(link.getOutputStream(), true);
			}catch(IOException ex) {
				ex.printStackTrace();
				System.out.println("Client died too early, cleaning up the mess!");
				cleanup();
				return;
			}
			
			while("".equalsIgnoreCase(message) == false) {
	            try {
					message = reader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
	            // Legge il messaggio dal client
	            System.out.println("Messaggio ricevuto dal client: " + message);
	
	            //Verifico se il messaggio è valido e rispondo solo in quel caso
	            if(ValidaMessaggio(message) ) {
	                
	                // Invia la risposta al client
	            	int numero = rand.nextInt(10);
	            	if(numero > 5) {
	            		writer.println("Colpito!");
		                System.out.println("Risposta inviata al client: Colpito!!");
	            	}else {
	            		writer.println("Mancato,ritenta!");
		                System.out.println("Risposta inviata al client: Mancato,ritenta!");
	            	}
	                
	            } else {
	            	writer.println("");
	            	System.out.println("Ho inviato una stringa vuota al clien perchè nn rispetta il formato del messaggio");
	            }
			}
        	try {
				reader.close();
	        	writer.close();
			} catch (IOException e) {
			}
        	cleanup();
        	
		}
	}
	
    public static void main(String[] args) {
        int port = 12345; // Porta su cui il server ascolta
        NClients clients = new NClients();

        try {
        	ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server avviato. In attesa di connessioni...");
        	
            while (true) {
                // Accetta e aspetta la connessione di un client una nuova connessione dal client
                Socket client = serverSocket.accept();
                System.out.println("Nuovo client connesso.");
                clients.inc();
                Thread handler = new Thread(new ClientHandler(client,clients));
                handler.start();
            }
        
        } catch (Exception e) {
            System.err.println("Errore del server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
