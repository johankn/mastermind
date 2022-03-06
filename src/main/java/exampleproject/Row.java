package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Row {
    public List <String> row = new ArrayList<String>();
    private List<String> validColors = Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE");
    

    //brukeren lager en rad med 4 baller
    public Row(String a, String b, String c, String d){
        row.add(a);
        row.add(b);
        row.add(c);
        row.add(d);
    }

    //generer tilfeldig fasit
    public Row(){
        Random rand = new Random();
        int numberOfElements = 4;


        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt((validColors).size());
            row.add(validColors.get(randomIndex));
        }
    }


    //sammenligner fasiten med raden brukeren laget
    public String compare(List<String> x){
        int sameColorAndPlace = 0;
        int sameColor = 0;
        //lager en kopi av raden til brukeren for å eventuelt fjerne duplikater
        List<String> newList = new ArrayList<>(x);

        //sjekker om lik farge og posisjon
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i)==this.row.get(i)){
                sameColorAndPlace += 1;
            }
            
            //sjekker farge, men feil posisjon
            else{
                if (this.row.contains(x.get(i))){
                    /*hvis i oppstår flere ganger hos brukeren enn i fasiten, må den fjernes for å ikke si 
                    at brukeren har flere riktige brikker på feil pos enn det finnes av disse brikkene i fasiten*/
                    if (Collections.frequency(newList, x.get(i)) <= Collections.frequency(this.row, x.get(i))){
                        sameColor += 1;
                        }
                    else{
                        newList.remove(x.get(i));
                    
                    }
               } 
            } 
            }

        if (sameColorAndPlace != 4){
            return "You got "+ sameColorAndPlace + " balls with the right color and at the right place, and " + 
            sameColor + " balls with the right color, but in the wrong place";
        }
        else{
            return "You won the game!";
        }

    }
    
    public List<String> getRow() {
        return row;
    }




    public static void main(String[] args) {
        Row fasit = new Row();
        System.out.println(fasit.getRow());
        Row tester = new Row("RED", "RED", "BLUE", "BLUE");
        System.out.println(fasit.compare(tester.getRow())); 
        
    }
}
