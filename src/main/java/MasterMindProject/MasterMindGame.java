package MasterMindProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MasterMindGame {

    private int counter = -1; //må starte på -1 for at første indeks blir null når man trykker på en knapp
    private int submitCounter = 0; //antall forsøk, og hvilken label som skal få tilbakemld
    private List<String> fasit = new ArrayList<String>();
    private List<String> tryList = new ArrayList<String>();
    private long startTime;
    private long endTime;
    private Player player = new Player();
    private boolean gameLost = false;
    private boolean gameWon = false;
    private LeaderBoard LeaderBoard = new LeaderBoard("LeaderBoard.txt");
    private IGenerateFasit fasitGenerator;
    

    public MasterMindGame(IGenerateFasit fasitGenerator) {
        this.fasitGenerator = fasitGenerator;
        this.fasit = this.fasitGenerator.generateFasit();
        this.startTime = System.currentTimeMillis(); //når bruker starter appen starter tiden
        System.out.println(fasit);
    }

    public boolean isGameWon() {
        return gameWon;
    }

    

    //sammenligner fasiten med raden brukeren laget
    public String compareRows(){
        int sameColorAndPlace = 0;
        int sameColor = 0;
        //lager en kopi av raden til brukeren for å eventuelt fjerne duplikater
        List<String> newList = new ArrayList<>(this.tryList);

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
            this.endTime = System.currentTimeMillis();
            return "Correct!";
        }
    }

    

    public List<String> getTryList() {
        return new ArrayList<String>(this.tryList);
    
    }

    public void setTryList(List<String> tryList) {
        List<String> validColors = Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE");
        if ((tryList.size()<=4)&&(validColors.containsAll(tryList))){
        this.tryList = tryList;}
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

    public List<String> getFasit() {
        return new ArrayList<String>(this.fasit);
    }

    public long getStartTime() {
        return this.startTime;
    }
    public long getEndTime() {
        return this.endTime;
    }

    public void addColor(String color){
        List<String> validColors = Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE");
        if ((this.tryList.size()<4)&&(validColors.contains(color))){
        this.tryList.add(color);
        this.counter += 1;
    }
    }


    public boolean isGameLost() {
        return gameLost;
    }

    public Player getPlayer() {
        return player;
    }

    public LeaderBoard getLeaderBoard() {
        return LeaderBoard;
    }

    public String printLeaderBoard() {
        return this.LeaderBoard.printLeaderboard();
    }
    
    public void writePlayerToFile(){
        this.LeaderBoard.writePlayerToFile(this.player);
    }

    public void gameWon(String name) {
        this.player.setDiffTime((int)(endTime - startTime)/1000);
        this.player.setScore(this.submitCounter);
        this.player.setName(name);
        
    }

    public void submit(){
        this.submitCounter += 1;
        this.counter = -1;
        this.compareRows();
        this.tryList = new ArrayList<>();
        if ((submitCounter == 6)&&(this.isGameWon()==false)){
            this.gameLost = true;
        }
        
    }
    public void resetGame(IGenerateFasit fasitGenerator){
        
    this.counter = -1; //må starte på -1 for at første indeks blir null når man trykker på en knapp
    this.submitCounter = 0; //antall forsøk, og hvilken label som skal få tilbakemld
    this.fasit = new ArrayList<String>();
    this.tryList = new ArrayList<String>();
    this.fasit = fasitGenerator.generateFasit();
        this.startTime = System.currentTimeMillis(); //når bruker starter appen starter tiden
        System.out.println(fasit);
    
    this.player = new Player();
    this.gameLost = false;
    this.gameWon = false;
    }

    public static void main(String[] args) {
        Player p1 = new Player();
        p1.setName("Jonny");
        System.out.println(p1);
    }
}
