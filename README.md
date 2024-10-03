Fare un programma che crea un Produttore ed un Consumatore con il seguente ruolo:
Fare un programma che chiede all'utente due valori Ted N, dove T indica quanti Thread creare ed ogni Thread conta i valori (SENZA STAMPARLI) da 0 fino ad X dove X è un numero compreso tra 0 e N.
Ogni Thread dopo aspetta 120ms ogni volta che incrementa il valore
﻿﻿Produttore: genera all'infinito un numero casuale tra 0 e 1023 ogni Xms, dove X è un numero casuale tra 100 e 1000.
﻿﻿Consumatore: deve consumare i numeri generati dal Produttore e ogni volta che li consuma stampa il numero letto e stampa una statistica dei numeri pari e dei numeri dispari letti
Il programma deve grantire che i dati prodotti vengo consumati in ordine FIFO e che non vi devono essere perdite dei dati prodotti dal Consumatore.
Suggerimenti
Utilizzare quattro classi una per Produttore, una per Consumatore, una classe Buffer ed il Main per aviare tutto il sistema
