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
        for (String string : x) {
            if (this.row.contains(string) && x.indexOf(string)==this.row.indexOf(string)){
                sameColorAndPlace += 1;
            }
            //feil validering, frequency var bare noe jeg prøvde...
            if (this.row.contains(string) && !(x.indexOf(string)==this.row.indexOf(string))
             && (Collections.frequency(x, string) <= Collections.frequency(this.row, string))){
                sameColor += 1;
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
        Row tester = new Row("RED", "RED", "RED", "RED");
        System.out.println(fasit.compare(tester.getRow())); 
        
    }
}
