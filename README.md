# HelloWeb - Progetto Maven

Questo progetto è stato creato seguendo le prime tre lezioni della guida ( https://www.html.it/guide/restful-web-services-in-java-con-jersey/) per imparare a sviluppare applicazioni web con Java e JSP. Il progetto si chiama **HelloWeb** e include una pagina JSP (`index.jsp`) che visualizza un messaggio di benvenuto, un link ad una pagina che mostra le informazioni dell'autore, e una API REST che risponde a una richiesta HTTP.

## Descrizione del Progetto

Il progetto **HelloWeb** ha le seguenti funzionalità principali:

1. **Pagina di Benvenuto (index.jsp)**:
   - Quando un utente visita la pagina principale (`index.jsp`), viene visualizzato il messaggio:
     ```
     Benvenuto Utente Curioso, questo è la mia prima JSP. Oggi è il giorno <data>
     Autore: <link>
     ```
     Dove:
     - `<data>` è la data corrente (data di visita).
     - `<link>` è un collegamento a una pagina chiamata `author.jsp` che mostra i dettagli dell'autore.
   
2. **Pagina dell'Autore (author.jsp)**:
   - La pagina `author.jsp` visualizza le informazioni dell'autore, incluse:
     - Nome
     - Cognome
     - Classe dell'autore

3. **API REST**:
   - È presente una API REST che risponde alla richiesta `/api/test/eleonora` con un messaggio predefinito.
   
   
## Componenti Utilizzati

1. **Maven**:
   - **Maven** è stato utilizzato come sistema di gestione dei progetti. Tutte le dipendenze sono state gestite tramite il file `pom.xml`.

2. **JSP (JavaServer Pages)**:
   - La pagina `index.jsp` è una JSP che genera il contenuto dinamico (data corrente e messaggio di benvenuto).

3. **API REST**:
   - L'API REST `/api/test/eleonora` è implementata come una servlet che gestisce le richieste GET.




