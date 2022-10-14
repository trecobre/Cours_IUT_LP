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
        
        $sql = "SELECT * FROM `personnes`";
        $content = "<table>
                        <tr>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Age</th>
                            <th>Adresse</th>
                            <th>Code postal</th>
                            <th>Ville</th>
                            <th>Téléphone</th>
                            <th>Email</th>
                        </tr>";
        $query = $myDB->prepare($sql);
        $query->execute();
        while ($row = $query->fetch()) {
           $content.="<tr>
                        <td>".$row['Nom']."</td>
                        <td>".$row['Prenom']."</td>
                        <td>".$row['Age']."</td>
                        <td>".$row['Adresse']."</td>
                        <td>".$row['Code_Postal']."</td>
                        <td>".$row['Ville']."</td>
                        <td>".$row['Telephone']."</td>
                        <td>".$row['email']."</td>
                    </tr>";
        }
        $content.="</table>";
        echo $content;

    ?>
</body>
</html>