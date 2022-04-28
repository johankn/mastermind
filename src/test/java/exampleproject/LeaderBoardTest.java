package exampleproject;

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
import org.junit.jupiter.api.Test;

public class LeaderBoardTest {
    private LeaderBoard testLeaderBoard = new LeaderBoard("testLeaderBoard.txt");
    
    
@BeforeEach
void new_LeaderBoard() throws Exception{
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
void testConstructor() throws Exception {
    File file = new File("ConstructorTestLeaderBoard.txt");
    Files.deleteIfExists(file.toPath());
    Assertions.assertFalse(file.exists(), "Filen eksisterer ikke");
    LeaderBoard constructorTestLeaderBoard = new LeaderBoard(file.getPath());
    Assertions.assertTrue(file.delete(), "Filen eksisterer etter å ha blitt laget i konstruktøren");
    Assertions.assertEquals(constructorTestLeaderBoard.getFilename(),file.getPath(), "Stien til filen er lik filename-attributten til leaderBoard-objektet");
    constructorTestLeaderBoard = null;
    
}

@Test
void testInitializeLeaderboard() {
    try(Stream<String> liste = Files.lines(Paths.get("testLeaderBoard.txt"));){
        String players = liste.collect(Collectors.joining(" "));
        Assertions.assertEquals("Heisenberg 3 49 NielsBohr 2 97", players);
    }

    catch (IOException e) {
        e.printStackTrace();
    }

    testLeaderBoard.initializeLeaderboard();

    try(Stream<String> liste = Files.lines(Paths.get("testLeaderBoard.txt"));){
                String players = liste.collect(Collectors.joining(" "));        
                Assertions.assertEquals("" , players); 

    }

    catch (IOException e) {
        e.printStackTrace();
    }
    
    
}
@Test 
void testGetListOfPlayers() {
    Assertions.assertEquals("[Heisenberg 3 49, NielsBohr 2 97]", testLeaderBoard.getListOfPlayers().toString());
    try (PrintWriter writer = new PrintWriter("testLeaderBoard.txt")) {
        writer.print("");
    } 
    catch (IOException e) {
        e.printStackTrace();
    }
    Assertions.assertEquals("[]", testLeaderBoard.getListOfPlayers().toString());
}

@Test
void testWrite2File() {

    try(Stream<String> liste = Files.lines(Paths.get("testLeaderBoard.txt"));){
        String players = liste.collect(Collectors.joining(" "));
        Assertions.assertEquals("Heisenberg 3 49 NielsBohr 2 97", players);
    }

    catch (IOException e) {
        e.printStackTrace();
    }

    Player player = new Player("Oppenheimer", 2, 48);
    testLeaderBoard.write2file(player);


    try(Stream<String> liste = Files.lines(Paths.get("testLeaderBoard.txt"));){
                String players = liste.collect(Collectors.joining(" "));        
                Assertions.assertEquals("Oppenheimer 2 48 NielsBohr 2 97 Heisenberg 3 49" , players); //ny player blir addet og liste blir sortert i write2file

    }

    catch (IOException e) {
        e.printStackTrace();
    }

}
    @Test
    void testPrintLeaderboard() throws Exception {
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






