$(document).ready(function(){
    let dices = [0, 0, 0, 0, 0, 0];
    let dices_kept = [0, 0, 0, 0, 0, 0];
    let nb_keeped = 0;

    function setImage(){
        $(".1").attr("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Dice-1-b.svg/1024px-Dice-1-b.svg.png");
        $(".2").attr("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/Dice-2-b.svg/1200px-Dice-2-b.svg.png");
        $(".3").attr("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Dice-3-b.svg/1200px-Dice-3-b.svg.png");
        $(".4").attr("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Dice-4-b.svg/557px-Dice-4-b.svg.png" );
        $(".5").attr("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Dice-5-b.svg/2048px-Dice-5-b.svg.png");
        $(".6").attr("src", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Dice-6-b.svg/768px-Dice-6-b.svg.png" );    
    }
    setImage();
    function display_dice(num, dest){
        let img;
        switch (num){
            case 1:
                img = '<img class="1">';
                break;
            case 2:
                img = '<img class="2">';
                break;
            case 3:
                img = '<img class="3">';
                break;
            case 4:
                img = '<img class="4">';
                break;
            case 5:
                img = '<img class="5">';
                break;
            case 6:
                img = '<img class="6">';
                break;
        }
        $(dest).append(img);
        setImage();
    }
    
    function display_nb_dice(){
        let cpt = 0;
        let max_cpt = 0;
        let chance = 0;
        for(let i=0; i<6; i++){
            let name = "#nb_dice_"+(i+1);
            let score_single = dices[i]*(i+1);
            chance += score_single;
            $(name).text(score_single);
            if(dices[i]!=0){
                cpt ++;
            }
            else{
                max_cpt = cpt;
                cpt = 0;
            }
        }
        if(cpt > max_cpt){
            max_cpt = cpt;
        }

        if($("#brelan").hasClass("lockable") || $("#carre").hasClass("lockable") || $("#yahzee").hasClass("lockable")){
            let score = 0;
            let max = Math.max.apply(null, dices);
            let full = 0;
            if(max >= 3){
                for(let i=0; i<6; i++){
                    score += dices[i]*(i+1);
                }
                if(dices.indexOf(2)!=-1){
                    full = 25;
                }
            }
            if($("#full").hasClass("lockable")) $("#full").text(full);
            if($("#carre").hasClass("lockable")) $("#carre").text(0);
            if($("#brelan").hasClass("lockable")) $("#brelan").text(0);
            if($("#yahzee").hasClass("lockable")) $("#yahzee").text(0);
            switch(max){
                case 5:
                    if($("#yahzee").hasClass("lockable")) $("#yahzee").text(50);
                case 4:
                    if($("#carre").hasClass("lockable")) $("#carre").text(score);
                case 3:
                    if($("#brelan").hasClass("lockable")) $("#brelan").text(score);
                    break;
                default:
                    break;
            }
        }
        if($("#gsuite").hasClass("lockable") || $("#psuite").hasClass("lockable")){
            switch(max_cpt){
                case 5:
                    if($("#gsuite").hasClass("lockable")) $("#gsuite").text(40);
                    if($("#psuite").hasClass("lockable")) $("#psuite").text(30);
                    break;
                case 4:
                    if($("#psuite").hasClass("lockable")) $("#psuite").text(30);
                    if($("#gsuite").hasClass("lockable")) $("#gsuite").text(0);
                    break;
                default:
                    if($("#psuite").hasClass("lockable")) $("#psuite").text(0);
                    if($("#gsuite").hasClass("lockable")) $("#gsuite").text(0);
                    break;
            }
        }
        
        if($("#chance").hasClass("lockable")) $("#chance").text(chance);
        let score_sup = 0;
        let score_inf = 0;
        let score_total = 0;
        $('.s_sup').each(function() {
            score_sup += parseInt($(this).text(), 10);
        });

        $("#total_dice").text(score_sup)
        score_sup > 63 ? $("#prime").text(35) : $("#prime").text(0)
        score_sup += parseInt($("#prime").text(), 10);
        $("#total_s_sup").text(score_sup)
        $("#section_sup").text(score_sup)

        $('.s_inf').each(function() {
            score_inf += parseInt($(this).text(), 10);
        });
        
        score_total = score_inf + score_sup;
        $("#section_inf").text(score_inf)
        $("#total_general").text(score_total)

    }
    function clear(){
        for(let i=0; i<6; i++){
            if(dices_kept[i]==0){
                dices[i] = 0;
            }
            else{
                dices[i] = dices_kept[i];
            }
        }

        display_nb_dice();
    }
    display_nb_dice();
    $("#throw").on("click", function(){
        $("#result_dice").empty();
        clear();
        for(let i=0; i<(5-nb_keeped); i++){
            let rdm = Math.round(Math.random()*5)+1;
            dices[rdm-1] += 1;
            display_dice(rdm, "#result_dice");
        }
        display_nb_dice();
    });
    $("#result_dice").on("click", "img", function(){
        let temp = parseInt($(this).attr("class"));
        dices_kept[temp-1] += 1;
        console.log("ey")
        nb_keeped++;
        $(this).remove();
        
        display_dice(temp, "#keeped_dice");
        display_nb_dice();
    });

    $(".lockable").on("click", function(){
        if($(this).text()!= "" && $(this).text()!= "0"){
            $(this).removeClass("lockable");
            $(this).addClass("locked");
            $(this).css("background-color", "red");
        }
    });
});