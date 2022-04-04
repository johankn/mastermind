package exampleproject;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeaderBoard {


    int numberOfPlayers;
    private List<Player> players;

     void initializeLeaderboard(){
        try (PrintWriter writer = new PrintWriter("LeaderBoard.txt")) {
            writer.print("");
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void printLeaderboard(){
        try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){ 
            liste.forEach(p -> System.out.println(p));
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getListOfPlayers(){

        try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){ 
            players = liste
            .map(x -> new Player(x.split(" ")[0], Integer.parseInt(x.split(" ")[1])))
            .collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(players);

    }

    public LeaderBoard() {
    }

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
        Player p1 = new Player("jonny", 10);
        Player p2 = new Player("peter", 6);
        lb.write2file(p1);
        lb.write2file(p2);
        lb.printLeaderboard();
        Player p3 = new Player("Trine", 2);
        lb.write2file(p3);
        Player p4 = new Player("Osvald", 20);
        lb.write2file(p4);
        lb.printLeaderboard();
        
        
        
        
       

        
        
        

        
        
    }




    
}
