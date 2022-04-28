package MasterMindProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MasterMindProject.LeaderBoard;
import MasterMindProject.Player;

public class LeaderBoardTest {
    private LeaderBoard testLeaderBoard = new LeaderBoard("testLeaderBoard.txt");
    
    
@BeforeEach
@DisplayName("Setter opp en testfil som inneholder to spillere")
public void new_LeaderBoard() throws Exception{
    File file = new File("testLeaderBoard.txt");
    try {
        file.createNewFile();
    }
    catch (IOException e) {
        e.printStackTrace();
    } 
    List<String> players = new ArrayList<String>();
    String lineOne = "Heisenberg 3 49";
    String lineTwo = "NielsBohr 2 97";
    players.add(lineOne);
    players.add(lineTwo);
    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)))) {

        players.stream().forEach(x->pw.println(x));
        
        pw.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}



@Test
@DisplayName("tester konstruktøren, om en fil lages, og sletter den etterpå")
public void testConstructor() throws Exception {
    File file = new File("ConstructorTestLeaderBoard.txt");
    Files.deleteIfExists(file.toPath());
    Assertions.assertFalse(file.exists(), "Filen eksisterer ikke");
    LeaderBoard constructorTestLeaderBoard = new LeaderBoard(file.getPath());
    Assertions.assertTrue(file.delete(), "Filen eksisterer etter å ha blitt laget i konstruktøren");
    Assertions.assertEquals(constructorTestLeaderBoard.getFilename(),file.getPath(), "Stien til filen er lik filename-attributten til leaderBoard-objektet");
    constructorTestLeaderBoard = null;
    
}

@Test
@DisplayName("tester om getlistofplayers returenerer en liste av spillerne i filen") 
public void testGetListOfPlayers() {
    Assertions.assertEquals("[Heisenberg 3 49, NielsBohr 2 97]", testLeaderBoard.getListOfPlayers().toString());
    Assertions.assertEquals(2, testLeaderBoard.getListOfPlayers().size());
    try (PrintWriter writer = new PrintWriter("testLeaderBoard.txt")) {
        writer.print("");
        writer.close();
    } 
    catch (IOException e) {
        e.printStackTrace();
    }
    Assertions.assertEquals("[]", testLeaderBoard.getListOfPlayers().toString());
    Assertions.assertEquals(0, testLeaderBoard.getListOfPlayers().size());
}

@Test
@DisplayName("tester om writePlayerToFile legger til spillere til filen")
public void testwritePlayerToFile() {

    try(Stream<String> liste = Files.lines(Paths.get("testLeaderBoard.txt"));){
        String players = liste.collect(Collectors.joining(" "));
        Assertions.assertEquals("Heisenberg 3 49 NielsBohr 2 97", players);
    }

    catch (IOException e) {
        e.printStackTrace();
    }

    Player player = new Player("Oppenheimer", 2, 48);
    testLeaderBoard.writePlayerToFile(player);


    try(Stream<String> liste = Files.lines(Paths.get("testLeaderBoard.txt"));){
                String players = liste.collect(Collectors.joining(" "));        
                Assertions.assertEquals("Oppenheimer 2 48 NielsBohr 2 97 Heisenberg 3 49" , players); //ny player blir addet og liste blir sortert i writePlayerToFile

    }

    catch (IOException e) {
        e.printStackTrace();
    }

}
    @Test
    @DisplayName("tester om printleaderboard returnerer innholdet i filen på det formatet vi ønsker ")
    public void testPrintLeaderboard() throws Exception {
        Assertions.assertEquals("""
-----------LEADERBOARD-----------

Heisenberg
 - Guesses: 3
 - Time: 49s

NielsBohr
 - Guesses: 2
 - Time: 97s
         """, testLeaderBoard.printLeaderboard());
    }


}






