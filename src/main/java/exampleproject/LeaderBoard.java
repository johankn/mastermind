package exampleproject;

import java.io.BufferedWriter;
import java.io.File;
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

    private List<Player> players;
    private String filename;

    public LeaderBoard(String filename){
        this.filename = filename;
        File lb = new File(filename);
        try {
            lb.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        } 
    }

    void initializeLeaderboard(){ //hvis man vil slette og starte på nytt leaderboard
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.filename)))) {
            writer.print("");
            writer.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String printLeaderboard() { 
    
            String topPlayers = this.getListOfPlayers().stream().map(x-> x.getName() + "\n" + " - Guesses: " + x.getScore() +"\n" +" - Time: " + x.getDiffTime()+"s" + "\n").
            collect(Collectors.joining("\n"));

            return "                LEADERBOARD\n\n" +topPlayers;
    }
    


    @Override
    public List<Player> getListOfPlayers(){
        try(Stream<String> liste = Files.lines(Paths.get(this.filename));){
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


        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(this.filename, false)))) {

            players.stream().forEach(x->pw.println(x));
            
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public static void main(String[] args) {
        LeaderBoard lb = new LeaderBoard("LeaderBoard.txt");
        Player p1 = new Player("jonny", 10, 120);
        Player p2 = new Player("peter", 6, 24);
        lb.write2file(p1);
        lb.write2file(p2);
        System.out.println(lb.getListOfPlayers());
        System.out.println(lb.printLeaderboard());
        

        
        
        
    
    }
}
