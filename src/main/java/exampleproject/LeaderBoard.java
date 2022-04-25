package exampleproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeaderBoard implements ILeaderBoard{

    private int numberOfPlayers; //skal vi ha denne?
    private List<Player> players;

    public LeaderBoard(){
        File lb = new File("LeaderBoard.txt");
        try {
            lb.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        
    }

    private void initializeLeaderboard(){ //hvis man vil slette og starte på nytt leaderboard
        try (PrintWriter writer = new PrintWriter("LeaderBoard.txt")) {
            writer.print("");
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String printLeaderboard(){
        try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){ 
            String topPlayers = liste.map(x -> x.split(" ")[0] + "\n" + " - Guesses: " + x.split(" ")[1] +"\n" +" - Time: " + x.split(" ")[2]+"s" + "\n").
            collect(Collectors.joining("\n"));
            return topPlayers;
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return("could not load leaderboard");
    }


    @Override
    public List<Player> getListOfPlayers(){
        try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){
            this.players = liste.map(p -> new Player(p.split(" ")[0], Integer.parseInt(p.split(" ")[1]), 
            Integer.parseInt(p.split(" ")[2]))).collect(Collectors.toList());

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(players);

    }
    @Override
    public void write2file(Player p) {

        players = this.getListOfPlayers();
        players.add(p);
        Collections.sort(players);


        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("LeaderBoard.txt", false)))) {

            players.stream().forEach(x->pw.println(x));
            
            pw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LeaderBoard lb = new LeaderBoard();
        Player p1 = new Player("jonny", 10, 120);
        Player p2 = new Player("peter", 6, 24);
        lb.write2file(p1);
        lb.write2file(p2);
        System.out.println(lb.getListOfPlayers());
        //lb.initializeLeaderboard();
        // Player p3 = new Player("Trine", 2, 9);
        // lb.write2file(p3);
        // Player p4 = new Player("Osvald", 2, 8);
        // lb.write2file(p4);
        // lb.printLeaderboard();

        
        
        
        
        
        
        
       

        
        
        

        
        
    }

    




    
}
