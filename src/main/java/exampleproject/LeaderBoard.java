package exampleproject;

import java.io.BufferedWriter;
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

    public String printLeaderboard(){
        try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){ 
            String topPlayers = liste.collect(Collectors.joining("\n"));
            return topPlayers;
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return("could not load leaderboard");
    }

    public List<Player> getListOfPlayers(){
        try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){
            this.players = liste.map(p -> new Player(p.split(" ")[0], Integer.parseInt(p.split(" ")[1]), 
            Integer.parseInt(p.split(" ")[2]))).collect(Collectors.toList());

        }

        // try(Stream<String> liste = Files.lines(Paths.get("LeaderBoard.txt"));){ 
        //     players = liste.map(x -> new Player(x.split(" ")[0], Integer.parseInt(x.split(" ")[1], Integer.parseInt(x.split(" ")[2]))
        //     .collect(Collectors.toList());
        // }
        catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(players);

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
        Player p1 = new Player("jonny", 10, 120);
        Player p2 = new Player("peter", 6, 24);
        lb.write2file(p1);
        lb.write2file(p2);
        Player p3 = new Player("Trine", 2, 9);
        lb.write2file(p3);
        Player p4 = new Player("Osvald", 2, 8);
        lb.write2file(p4);
        lb.printLeaderboard();
        
        
        
        
        
        
       

        
        
        

        
        
    }




    
}
