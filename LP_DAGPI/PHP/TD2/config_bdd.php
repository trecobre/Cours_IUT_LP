<?php
    define( 'DBUSER' , 'root' );
    define( 'DBPWD' , '' );
    define( 'DBDSN' , 'mysql:host=localhost;dbname=exercice_php' );
    try {
        $myDB = new PDO ( DBDSN , DBUSER, DBPWD );
    } catch (PDOException $e) {
        print ('<p>Erreur ! :'. $e->getMessage() . '</p>');
        die();
    }
?>