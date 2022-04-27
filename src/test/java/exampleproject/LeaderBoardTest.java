package exampleproject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeaderBoardTest {
    

    @Test
    void testConstructor(){
        //LeaderBoard leaderBoard = new LeaderBoard();
        File lb = new File("LeaderBoard.txt");
        Assertions.assertTrue(lb.exists());
    }


}


