Fare un programma che chiede all'utente due valori T ed N, dove T indica quanti Thread creare ed ogni Thread conta i valori (SENZA STAMPARE) da 0 fino ad X dove X è un numero compreso tra 0 e N.
Ogni Thread dopo che ha stampato un valore aspetta 120ms.
Il thread principaòe stampa periodicamente (al massimo una volta al secondo) lo stato dei Thread e per i Thread attivi stampa il valore a cui è arrivato a contare,
menre per quelli terminati stampa "COMPLETATO", quando tutti i Thread hanno raggiunto ol loro valore X il programma deve stampare "TUTTI I THREAD COMPLETATI" e terminare.
//SUGGERIMENTI
Per vedere se un THread è attivo esiste il metodo isAlive(), mentre per aspettare il completamento di un Thread esiste il metodo join().
