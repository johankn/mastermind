package exampleproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

public class Player implements Comparable<Player>{

    //enkel klasse som lagrer navn og poengsum

    private String name = "ukjent spiller";
    private int score = 0;
    private int diffTime = 0;

    public Player(){

    }

    public Player(String name, int score, int diffTime) {
        this.name = name;
        this.score = score;
        this.diffTime = diffTime;
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

    public int getDiffTime() {
        return diffTime;
    }

    public void setDiffTime(int diffTime) {
        this.diffTime = diffTime;
    }


    @Override
    public int compareTo(Player o) {
        if (this.getScore()-o.getScore()==0) {
            return (this.getDiffTime()-o.getDiffTime());
            
        }
        return this.getScore() - o.getScore();
    }

    @Override
    public String toString() {
        return name + " " + score + " " + diffTime;
    }

    public static void main(String[] args) {
       Player p1 = new Player("Per", 10, 120);
       Player p2 = new Player("Pål", 15, 18);
       Player p3 = new Player("Line", 2, 12);
       ArrayList<Player> X = new ArrayList<Player>(Arrays.asList(p1, p2, p3));
       System.out.println(X);
       Collections.sort(X);
       System.out.println(X);
    
        

        
        
        





    }



 
    
}

    
