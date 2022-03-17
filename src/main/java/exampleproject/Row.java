package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Row {
    public List <String> row = new ArrayList<String>();
    private List<String> validColors = Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE");
    public boolean isFull = false;
    

    //brukeren lager en rad med en og en farge om gangen
    public void addColor(String a){
        if (row.size()<4){
        row.add(a);}

        if (row.size()==4){
            isFull = true;
        }
    }

    //generer tilfeldig fasit
    public void random(){
        int numberOfElements = 4;
        Random rand = new Random();
        

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

        //long y = row.stream().filter(yo -> x.contains(x)).count();
        

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
        //her kan vi også bare ha en toString på slutten istedenfor 
        if (sameColorAndPlace != 4){
            return "You got "+ sameColorAndPlace + " balls with the right color and at the right place, and " + 
            sameColor + " balls with the right color, but in the wrong place";
        }
        else{
            return "You won the game!";
        }

    }
    
    public List<String> getRow() {
        return new ArrayList<>(row);
    }


    @Override
    public String toString() {
        return ""+row+"";
    }

    public static void main(String[] args) {
        Row fasit = new Row();
        fasit.random();
        System.out.println(fasit);
        Row tester = new Row();
        tester.addColor("BLUE");
        tester.addColor("RED");
        tester.addColor("GREEN");
        tester.addColor("RED");
        tester.addColor("BLACK");
        System.out.println(tester);
        System.out.println(fasit.compare(tester.getRow()));

        
    }
}
