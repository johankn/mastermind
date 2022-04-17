package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MasterMindGame {

    private int counter = -1;
    private int submitCounter = 0;
    private List<String> fasit = new ArrayList<String>();
    private List<String> tryList = new ArrayList<String>();
    private long startTime;
    private long endTime;
    private Player player;
    private boolean gameLost = false;
    private boolean gameWon = false;

    public MasterMindGame() {
        this.generateFasit();
        System.out.println(fasit);
        this.startTime = System.currentTimeMillis();
    }

    public boolean isGameWon() {
        return gameWon;
    }

    private void generateFasit() {
        List<String> validColors = Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE");
        int numberOfElements = 4;
        Random rand = new Random();
        
         for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt((validColors).size());
            fasit.add(validColors.get(randomIndex));
        }
    }

    //sammenligner fasiten med raden brukeren laget
    public String compareRows(){
        int sameColorAndPlace = 0;
        int sameColor = 0;
        //lager en kopi av raden til brukeren for å eventuelt fjerne duplikater
        List<String> newList = new ArrayList<>(this.tryList);

        //long y = row.stream().filter(yo -> x.contains(x)).count();

        //sjekker om lik farge og posisjon
        for (int i = 0; i < this.tryList.size(); i++) {
            if (this.tryList.get(i).equals(this.fasit.get(i))){
                sameColorAndPlace += 1;
            }
            
            //sjekker farge, men feil posisjon
            else{
                if (this.fasit.contains(this.tryList.get(i))){
                    /*hvis i oppstår flere ganger hos brukeren enn i fasiten, må den fjernes for å ikke si 
                    at brukeren har flere riktige brikker på feil pos enn det finnes av disse brikkene i fasiten*/
                    if (Collections.frequency(newList, this.tryList.get(i)) <= Collections.frequency(this.fasit, this.tryList.get(i))){
                        sameColor += 1;
                        }
                    else{
                        newList.remove(this.tryList.get(i));
                    
                    }
               } 
            } 
            }

        //her kan vi også bare ha en toString på slutten istedenfor 
        if (sameColorAndPlace != 4){
            return "Right color and place: "+ sameColorAndPlace + "\n"+
            "Right color but wrong place: " + sameColor + "";
        }
        else{
            this.gameWon = true;
            return "You won the game!";

        }
    }

    

    public List<String> getTryList() {
        return tryList;
    }

    public void setTryList(List<String> tryList) {
        this.tryList = tryList;
    }

    public void counterPlusOne() {
        this.counter += 1;
    }

    public void submitCounterPlusOne() {
        this.submitCounter += 1;
    }

    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getSubmitCounter() {
        return submitCounter;
    }

    public void setSubmitCounter(int submitCounter) {
        this.submitCounter = submitCounter;
    }

    public List<String> getFasit() {
        return this.fasit;
    }


    public boolean isGameLost() {
        return gameLost;
    }

    public void gameLost() {
        this.gameLost = true;
        
    }
    public void gameWon(){
        //this.gameOver = true;
        //this.endTime = System.currentTimeMillis();
        //player.setDiffTime((int)(endTime - startTime)/1000);
        //System.out.println(player.getDiffTime());
    }

    public void submit(){
        this.submitCounter += 1;
        this.counter = -1;
        this.compareRows();
        this.tryList = new ArrayList<>();
        if ((submitCounter == 6)&&(this.isGameWon()==false)){
            this.gameLost();
        }
        else if (this.gameWon==true){
            this.gameWon();
        }
    }

    
}
