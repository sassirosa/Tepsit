<?php 
require_once 'config.php';

// Create connection
$con = new mysqli($DATABASE_SERVER_IP, $DATABASE_USER_NAME, $DATABASE_USER_PASSWORD, $DATABASE_NAME);

// Check connection
if ($con->connect_error) {
    die("Connection failed: " . $con->connect_error);
}

// echo "Connected successfully";
?>
