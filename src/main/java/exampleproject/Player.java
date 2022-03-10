package exampleproject;

import java.util.regex.Pattern;

public class Player {

    //enkel klasse som lagrer navn og poengsum

    private String name = "ukjent spiller";
    private int score = 0;


    //Skal man ha illegalArgumentExeptions, hvordan ellers validerer man?

    public void setName(String name) {
        if (this.isValidName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Navn kan kun inneholde bokstaver og tall om må være kortere enn 26 bokstaver");
        }
        
    }

    private boolean isValidName(String name) {
        if (name.length() > 26) {
            return false;
        }
        if (!(Pattern.matches("[a-zA-Z0-9]", name))) {
            return false;
        }
        else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
}
