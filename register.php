<?php
// Imposta l'intestazione della risposta come JSON
header('Content-type: application/json');

// Verifica che la richiesta sia di tipo POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $data = json_decode(file_get_contents("php://input"), true);
    // Verifica che tutti i parametri necessari siano presenti e non vuoti
    if (isset($data["username"]) && isset($data["password"]) && isset($data["email"]))  {
        // Importa le costanti e la connessione al database
        require_once 'config.php';
        require_once 'database.php'; // qui ci si aspetta che venga creata la variabile $con (connessione MySQLi)

        // Recupera i dati dalla richiesta POST
        $username = $data["username"];
        $password = $data["password"];
        $email = $data["email"];

        // Crittografa la password
        $passwordHash = password_hash($password, PASSWORD_DEFAULT);

        // Controlla se l'utente esiste già (in base all'email)
        $checkQuery = "SELECT * FROM users WHERE email = ?";
        $stmt = $con->prepare($checkQuery);
        $stmt->bind_param("s", $email);
        $stmt->execute();
        $result = $stmt->get_result();

        if ($result->num_rows > 0) {
            // L'email è già registrata
            http_response_code(409); // Conflict
            echo json_encode([
                "code" => 409,
                "status" => false,
                "message" => "Utente già registrato con questa email."
            ]);
        } else {
            // Query per inserire un nuovo utente
            $insertQuery = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            $stmt = $con->prepare($insertQuery);
            $stmt->bind_param("sss", $username, $passwordHash, $email);

            if ($stmt->execute()) {
                // Registrazione riuscita
                http_response_code(201); // Created
                echo json_encode([
                    "code" => 201,
                    "status" => true,
                    "message" => "Utente registrato con successo."
                ]);
            } else {
                // Errore durante l'inserimento
                http_response_code(500); // Internal Server Error
                echo json_encode([
                    "code" => 500,
                    "status" => false,
                    "message" => "Errore durante la registrazione dell'utente."
                ]);
            }
        }

        // Chiudi lo statement e la connessione
        $stmt->close();
        $con->close();
    } else {
        // Parametri mancanti nella richiesta
        http_response_code(400); // Bad Request
        echo json_encode([
            "code" => 400,
            "status" => false,
            "message" => "Parametri mancanti. Assicurati di fornire username, email e password."
        ]);
    }
} else {
    // Metodo HTTP non supportato
    http_response_code(405); // Method Not Allowed
    echo json_encode([
        "code" => 405,
        "status" => false,
        "message" => "Metodo non consentito. Usa POST."
    ]);
}
?>
