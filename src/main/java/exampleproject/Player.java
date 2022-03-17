package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

public class Player implements Comparable<Player>{

    //enkel klasse som lagrer navn og poengsum

    private String name = "ukjent spiller";
    private int score = 0;

    public Player(){

    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }


    //Skal man ha illegalArgumentExeptions, hvordan ellers validerer man?

    public void setName(String name) {
        if (this.isValidName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Navn kan kun inneholde bokstaver og tall om må være kortere enn 26 bokstaver");
        }
    }


    public void setScore(int score) {
        this.score = score;
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

    @Override
    public int compareTo(Player o) {
        return this.getScore() - o.getScore();
    }

    

    @Override
    public String toString() {
        return name + " " + score;
    }

    public static void main(String[] args) {
        
        Player p1 = new Player("petter", 10);
        Player p2 = new Player("Jens69", 4);
        Player p3 = new Player("Drake", 17);
        Player p4 = new Player();
        Player p5 = new Player();

        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(p1,p2,p3,p4,p5));
        System.out.println(players);
        Collections.sort(players);
        System.out.println(players);
        





    }



 
    
}

    
