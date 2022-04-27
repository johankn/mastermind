package exampleproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaderBoardTest {
    private LeaderBoard testLeaderBoard = new LeaderBoard("testLeaderBoard.txt");
    
    
// @BeforeEach
// void new_LeaderBoard() throws Exception{
//     LeaderBoard testLeaderBoard = new LeaderBoard("testLeaderBoard.txt");
// }



@Test
void testConstructor() throws Exception {
    File file = new File("ConstructorTestLeaderBoard.txt");
    Files.deleteIfExists(file.toPath());
    Assertions.assertFalse(file.exists(), "Filen eksister ike");
    LeaderBoard constructorTestLeaderBoard = new LeaderBoard(file.getPath());
    Assertions.assertTrue(file.delete(), "Filen eksister etter å ha blitt laget i konstruktøren");
    Assertions.assertEquals(constructorTestLeaderBoard.getFilename(),file.getPath(), "Stien til filen er lik textFile-attributten til leaderBoard-objektet");
    constructorTestLeaderBoard = null;
    
}

// @Test
// void testInitializeLeaderboard() throws Exception {

//     try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(testLeaderBoard.getFilename(), false)))) {

//         players.stream().forEach(x->pw.println(x));
        
//         pw.close();

//     } catch (IOException e) {
//         e.printStackTrace();
//     }
    
// }




}






