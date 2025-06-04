Creazione di Web Service per la gestione utenti (Login - Register - Logout)
Obiettivo:
Realizzare 3 Web Service PHP (login, register, logout) che interagiscono con un database MySQL contenente una sola tabella `users`. I servizi devono essere testabili tramite Postman e restituire le risposte in formato JSON.
1. Database
Creare un database chiamato `webservice_users` e una tabella `users` con la seguente struttura:

CREATE DATABASE IF NOT EXISTS webservice_users;
USE webservice_users;
CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
email VARCHAR(100) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

2. Web Service da creare
Realizzare tre file PHP distinti:
A. register.php
- Metodo: POST
- JSON input:
{
"username": "esempio",
"password": "esempio123",
"email": "esempio@email.com"
}

B. login.php
- Metodo: POST
- JSON input:
{
"username": "esempio",
"password": "esempio123"
}

C. logout.php
- Metodo: POST
- Nessun input richiesto
- Restituzione JSON di conferma logout

Basarsi sulla guida:
https://www.html.it/articoli/api-restful-con-php-e-json/
