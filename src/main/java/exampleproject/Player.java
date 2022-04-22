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


    
    public void setName(String name) {
        if (this.isValidName(name)) {
            this.name = name;
        }
        else {
            throw new IllegalArgumentException("Navn kan kun inneholde bokstaver og tall og må være kortere enn 26 bokstaver");
        }
    }


    public void setScore(int score) {
        this.score = score;
    }


    private boolean isValidName(String name) {
        if ((name.length() > 26)||(name.length() < 1)) {
            return false;
        }
        
        return name.matches("[A-Za-z0-9]*");
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
       Player p1 = new Player();
       p1.setName("Jonny");
    //    p1.setDiffTime(23);
    //    p1.setScore(3);
    System.out.println(p1);
       
        

        
        
        





    }



 
    
}

    
