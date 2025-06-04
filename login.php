<?php
// Imposta l'intestazione della risposta come JSON
header('Content-type: application/json');

// Verifica che la richiesta sia di tipo POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $data = json_decode(file_get_contents("php://input"), true);

    // Verifica che tutti i parametri necessari siano presenti e non vuoti
    if (isset($data["username"]) && isset($data["password"])) {
        // Importa le costanti e la connessione al database
        require_once 'config.php';
        require_once 'database.php'; // qui ci si aspetta che venga creata la variabile $con (connessione MySQLi)

        // Recupera i dati dalla richiesta POST
        $username = $data["username"];
        $password = $data["password"];

        // Controlla se l'utente esiste
        $checkQuery = "SELECT * FROM users WHERE username = ?";
        $stmt = $con->prepare($checkQuery);
        $stmt->bind_param("s", $username);
        $stmt->execute();
        $result = $stmt->get_result();

        if ($result->num_rows === 1) {
            $user = $result->fetch_assoc();
            // Verifica la password
            if (password_verify($password, $user['password'])) {
                session_start();
                $_SESSION['username'] = $username;
                
                http_response_code(200); // OK
                echo json_encode([
                    "code" => 200,
                    "status" => true,
                    "message" => "Login effettuato con successo."
                ]);
            } else {
                // Password errata
                http_response_code(401); // Unauthorized
                echo json_encode([
                    "code" => 401,
                    "status" => false,
                    "message" => "Password errata."
                ]);
            }
        } else {
            // Utente non trovato
            http_response_code(404); // Not Found
            echo json_encode([
                "code" => 404,
                "status" => false,
                "message" => "Utente non trovato."
            ]);
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
            "message" => "Parametri mancanti. Assicurati di fornire username e password."
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
