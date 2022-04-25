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
    void testAddColor(){ //vanskelig å teste en random fasit som genererer ny hver gang game kjøres
        
        // this.fasit.addAll(Arrays.asList("BLUE","RED","BLACK","GREEN"));
        // game.setTryList(Arrays.asList("RED", "GREEN", "BLUE", "BLACK"));
        
        game.addColor("RED");
        game.addColor("GREEN");
        game.addColor("BLUE");
        game.addColor("BLACK");
        
		Assertions.assertEquals(Arrays.asList("RED", "GREEN", "BLUE", "BLACK"), game.getTryList());
        game.setTryList(new ArrayList<>());
        Assertions.assertEquals("[]", game.getTryList().toString());
        // Assertions.assertEquals("Right color and place: 0\nRight color but wrong place: 2", game.compareRows());
		
    }
    @Test
    void testCompareRows(){
        
    }

    @Test
    void testSubmit(){
        game.submit();
        Assertions.assertEquals(1, game.getSubmitCounter());
        Assertions.assertEquals(-1, game.getCounter());
        game.setSubmitCounter(5);
        game.submit();
        Assertions.assertTrue(game.isGameLost());
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
    @Test
    void testResetGame(){
        game.resetGame();
        Assertions.assertEquals(-1, game.getCounter());
        Assertions.assertEquals(0, game.getSubmitCounter());
        Assertions.assertFalse(game.isGameWon());
        Assertions.assertFalse(game.isGameLost());
        Assertions.assertEquals(0, game.getTryList().size());
        testGenerateFasit();
        Assertions.assertEquals("ukjent spiller 0 0", game.getPlayer().toString());

    }

    


}
