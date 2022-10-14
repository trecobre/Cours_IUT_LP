<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        class Ville
        {
            public $nom;
            public $departement;
            public function __construct($n, $dept){
                $this->nom = $n;
                $this->departement = $dept;
            }

            public function afficher(){
                return "<p>La ville ". $this->nom ." est dans le département ". $this->departement ."</p>";
            }
        }
        class Personne
        {
            public $nom;
            public $prenom;
            public $adresse;
            public function __construct($nom, $prenom, $adresse){
                $this->nom = $nom;
                $this->prenom = $prenom;
                $this->adresse = $adresse;
            }

            public function afficher(){
                return "<p>". $this->prenom ." ". $this->nom ." habite à ". $this->adresse ."</p>";
            }
        }

        $ville = new Ville("AAAA", 11);
        echo $ville->afficher();
        $paul = new Personne("Poule", "Paul", "AAAA");
        echo $paul->afficher();
    ?>
</body>
</html>