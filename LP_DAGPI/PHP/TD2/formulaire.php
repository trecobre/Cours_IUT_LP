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
        require_once('config_bdd.php');
        
        function display_form($wrong_value = NULL, $valid = TRUE){
            if($_SERVER["REQUEST_METHOD"] != "POST"){
                echo('<form method="post">
                    <input type="text" name="Prenom" placeholder="Prénom">
                    <input type="text" name="Nom" placeholder="Nom">
                    <input type="number" name="Age" placeholder="Age">
                    <input type="text" name="Adresse" placeholder="Adresse">
                    <input type="number" name="Code_Postal" placeholder="Code_Postal">
                    <input type="text" name="Ville" placeholder="Ville">
                    <input type="text" name="Telephone" placeholder="Telephone">
                    <input type="text" name="Mail" placeholder="Mail">
                    <input type="hidden" value="aaaa">
                    <input type="submit" value="Valider">
                </form>');
            }
            else{
                if(!$valid){
                    $champs = "";
                    foreach($wrong_value as $champ => $value){
                        if($value){
                            $champs.=", $champ";
                        }
                    }
                    $champs_str = substr($champs, 2);
                    echo("<p>L'ajout de personne a échoué. $champs_str manquant(s) ou non valide</p>");
                }
                $info =[];
                foreach($_POST as $name => $content){
                    if($content){
                        array_push($info, $content);
                    }
                    else{
                        array_push($info, "");
                    }
                }
                echo('<form method="post">
                    <input type="text" name="Prenom" placeholder="Prénom" value="'.$info[0].'">
                    <input type="text" name="Nom" placeholder="Nom" value="'.$info[1].'">
                    <input type="number" name="Age" placeholder="Age" value="'.$info[2].'">
                    <input type="text" name="Adresse" placeholder="Adresse" value="'.$info[3].'">
                    <input type="number" name="Code_Postal" placeholder="Code_Postal" value="'.$info[4].'">
                    <input type="text" name="Ville" placeholder="Ville" value="'.$info[5].'">
                    <input type="text" name="Telephone" placeholder="Telephone" value="'.$info[6].'">
                    <input type="text" name="Mail" placeholder="Mail" value="'.$info[7].'">
                    <input type="hidden" value="aaaa">
                    <input type="submit" value="Valider">
                </form>');
            }
        }

        
        if($_SERVER["REQUEST_METHOD"] == "POST"){
            $info = [];
            $wrong_value = [];
            $validate = TRUE;
            foreach($_POST as $name => $content){
                $wrong_value[$name] = 0;
                if($name == "Prenom" or $name == "Nom" or $name == "Mail"){
                    if($name == "Nom" and $content == $info["Prenom"]){
                        $validate = FALSE;
                        $wrong_value[$name] = 1;
                        $wrong_value["Prenom"] = 1;
                    }
                    else if($name == "Mail" and !filter_var($content, FILTER_VALIDATE_EMAIL)) {
                        $validate = FALSE;
                        $wrong_value[$name] = 1;
                    }
                    else if(!$content){
                        $validate = FALSE;
                        $wrong_value[$name] = 1;
                    }
                }
                $info[$name] = htmlentities($content);
            }
            if($validate){
                $sql = $myDB->prepare('INSERT INTO `personnes`(`Prenom`, `Nom`, `Age`, `Adresse`, `Code_Postal`, `Ville`, `Telephone`, `email`) VALUES (:PRENOM, :NOM, :AGE, :ADRESSE, :CP, :VILLE, :TELEPHONE, :EMAIL)');
                $sql->execute(array(
                    ':NOM' => $info["Nom"], 
                    ':PRENOM' => $info["Prenom"], 
                    ':AGE' => $info["Age"], 
                    ':ADRESSE' => $info["Adresse"], 
                    ':CP' => $info["Code_Postal"], 
                    ':VILLE' => $info["Ville"], 
                    ':TELEPHONE' => $info["Telephone"], 
                    ':EMAIL' => $info["Mail"] 
                ));
                echo("<p>".$info['Nom']." ".$info['Prenom']." a été ajouté à la base de donnée avec succès.</p>");
                display_form($validate);
            }
            else{
                display_form($wrong_value);
            }

        }
        else{
            display_form();
        }
        
    ?>
</body>
</html>