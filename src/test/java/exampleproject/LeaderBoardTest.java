package exampleproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
    Assertions.assertEquals(constructorTestLeaderBoard.getFilename(),file.getPath(), "Stien til filen er lik textFile-attributten til leaderBoard-objektet");
    constructorTestLeaderBoard = null;
    
}

// @Test
// void testInitializeLeaderboard() throws Exception {

//     // try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(testLeaderBoard.getFilename(), false)))) {

//     //     players.stream().forEach(x->pw.println(x));
        
//     //     pw.close();

//     // } catch (IOException e) {
//     //     e.printStackTrace();
//     // }
//     testLeaderBoard.initializeLeaderboard();

    
// }
@Test 
void testGetListOfPlayers(){
    Assertions.assertEquals("[Heisenberg 3 49, NielsBohr 2 97]", testLeaderBoard.getListOfPlayers().toString());

}
@Test
void testWrite2File(){
    Player player = new Player("Gutta", 5, 79);
    testLeaderBoard.write2file(player);
    try (BufferedReader br = new BufferedReader(new FileReader("testLeaderBoard.txt"))) {
        String line;
        while (line = br.readLine()) {
        Assertions.assertEquals("NielsBohr 2 97 Heisenberg 3 49 Gutta 5 79", br.readLine());}
     }
     catch (IOException e) {
        e.printStackTrace();
     }
}



}






