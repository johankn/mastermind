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
    void testCompare(){ //vanskelig å teste en random fasit som genererer ny hver gang game kjøres
        
        // this.fasit.addAll(Arrays.asList("BLUE","RED","BLACK","GREEN"));
        game.setTryList(Arrays.asList("RED", "GREEN", "BLUE", "BLACK"));
        
        
        
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
        List<String> validColors = new ArrayList<String>(Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE"));
        Assertions.assertTrue(game.getFasit().stream().allMatch(x->validColors.contains(x)));
        Assertions.assertEquals(4, game.getFasit().size());
    }

    @Test
    void testGameWon(){
        game.gameWon("Ola");
        Assertions.assertEquals("Ola", (game.getPlayer().getName()));
        Assertions.assertEquals(0, (game.getPlayer().getScore()));  
    }

    


}
