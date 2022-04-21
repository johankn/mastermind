package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MasterMindGameTest {

    private MasterMindGame game = new MasterMindGame();

    

    // @BeforeEach
    // void initialize(){
        
    // }

    @Test
    void testCompare(){
        // this.fasit.addAll(Arrays.asList("BLUE","RED","BLACK","GREEN"));
        game.setTryList(Arrays.asList("RED", "GREEN", "BLUE", "BLACK"));
        System.out.println(game.getFasit());
        
        
		Assertions.assertEquals(Arrays.asList("RED", "GREEN", "BLUE", "BLACK"), game.getTryList());
        // Assertions.assertEquals("Right color and place: 0\nRight color but wrong place: 2", game.compareRows());
		
    }
    @Test
    void testSubmit(){
        game.submit();
        Assertions.assertEquals(1, game.getSubmitCounter());
        Assertions.assertEquals(-1, game.getCounter());

    }
    
    @Test
    void testGenerateFasit(){
        
    }

}
