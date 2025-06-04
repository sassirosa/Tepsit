<?php
// Imposta l'intestazione della risposta come JSON
header('Content-type: application/json');

// Verifica che la richiesta sia di tipo POST
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    // Avvia la sessione se non è già stata avviata
    if (session_status() === PHP_SESSION_NONE) {
        session_start();
    }

    // Distrugge tutti i dati di sessione
    session_unset();
    session_destroy();

    // Conferma del logout
    http_response_code(200); // OK
    echo json_encode([
        "code" => 200,
        "status" => true,
        "message" => "Logout effettuato con successo."
    ]);

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
