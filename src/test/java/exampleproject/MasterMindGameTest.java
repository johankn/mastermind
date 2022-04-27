package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MasterMindGameTest {

    private generateRandomFasit randomFasit = new generateRandomFasit();
    private generateConstantFasit constantFasit = new generateConstantFasit();

    @Test
    void testConstructor(){
        MasterMindGame game = new MasterMindGame(constantFasit);
        Assertions.assertEquals(Arrays.asList("BLUE","BLACK","YELLOW","RED"), game.getFasit()); //constantFasit er satt til å være ["BLUE","BLACK","YELLOW","RED"]. 
        Assertions.assertEquals((System.currentTimeMillis()/1000), (game.getStartTime()/1000), "sjekker om startid blir nåtid, deler på 1000 for å få sekunder");

    }

    @Test
    void testAddColor(){ 
        MasterMindGame game = new MasterMindGame(randomFasit);
        
        game.addColor("RED");
        game.addColor("GREEN");
        game.addColor("BLUE");
        game.addColor("BLACK");
        
        Assertions.assertEquals(3, game.getCounter());
		Assertions.assertEquals(Arrays.asList("RED", "GREEN", "BLUE", "BLACK"), game.getTryList());
        game.setTryList(new ArrayList<>());
        Assertions.assertEquals("[]", game.getTryList().toString());

        game.setCounter(-1);
        game.addColor("RED");
        game.addColor("GREEN");
        game.addColor("ORANGE");
        game.addColor("PINK");

        Assertions.assertEquals(2, game.getTryList().size());
        Assertions.assertFalse(game.getTryList().contains("ORANGE"));
        Assertions.assertFalse(game.getTryList().contains("PINK"));
        Assertions.assertEquals(1, game.getCounter());
        
		
    }
    @Test
    void testCompareRows(){
        MasterMindGame game = new MasterMindGame(constantFasit);
        //constantFasit er satt til å være ["BLUE","BLACK","YELLOW","RED"]. 
        game.setTryList(Arrays.asList("RED","GREEN","BLUE","PINK")); //kan ikke ha fargen PINK i setTrylist
        Assertions.assertEquals("[]", game.getTryList().toString());
        game.compareRows();
        Assertions.assertEquals("Right color and place: 0\nRight color but wrong place: 0", game.compareRows());
        Assertions.assertFalse(game.isGameWon());

        game.setTryList(Arrays.asList("RED","BLACK","YELLOW","BLACK"));
        game.compareRows();
        Assertions.assertEquals("Right color and place: 2\nRight color but wrong place: 1", game.compareRows());
        Assertions.assertFalse(game.isGameWon());
        
        game.setTryList(Arrays.asList("BLUE","BLACK","YELLOW","RED"));
        game.compareRows();
        Assertions.assertEquals("Correct!", game.compareRows());
        Assertions.assertTrue(game.isGameWon());
        Assertions.assertEquals((System.currentTimeMillis()/1000), (game.getEndTime()/1000));



    }

    @Test
    void testSubmit(){
        MasterMindGame game = new MasterMindGame(constantFasit);
        game.setTryList(Arrays.asList("BLUE","BLACK","BLACK","BLACK"));
        Assertions.assertEquals("[BLUE, BLACK, BLACK, BLACK]", game.getTryList().toString());
        game.submit();
        Assertions.assertEquals(1, game.getSubmitCounter());
        Assertions.assertEquals(-1, game.getCounter());
        Assertions.assertEquals("[]", game.getTryList().toString());
        game.submit();
        game.submit();
        game.submit();
        game.submit();
        game.submit();
        Assertions.assertEquals(6, game.getSubmitCounter());
        Assertions.assertEquals(-1, game.getCounter());
        Assertions.assertTrue(game.isGameLost());
    }
    
    @Test
    void testGenerateRandomFasit(){ //tester det vi kan for random fasit
        MasterMindGame game = new MasterMindGame(randomFasit);
        List<String> validColors = new ArrayList<String>(Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE"));
        Assertions.assertTrue(game.getFasit().stream().allMatch(x->validColors.contains(x)));
        Assertions.assertEquals(4, game.getFasit().size());
    }

    @Test
    void testGameWon(){
        MasterMindGame game = new MasterMindGame(constantFasit);
        game.setTryList(Arrays.asList("BLUE","BLACK","YELLOW","RED"));
        game.submit();
        Assertions.assertTrue(game.isGameWon());
        game.gameWon("Ola");
        Assertions.assertEquals("Ola", (game.getPlayer().getName()));
        Assertions.assertEquals(1, (game.getPlayer().getScore()));  
        Assertions.assertEquals(game.getSubmitCounter(), game.getPlayer().getScore());

    }
    @Test
    void testResetGame(){
        MasterMindGame game = new MasterMindGame(constantFasit);
        game.resetGame(constantFasit);
        Assertions.assertEquals(-1, game.getCounter());
        Assertions.assertEquals(0, game.getSubmitCounter());
        Assertions.assertFalse(game.isGameWon());
        Assertions.assertFalse(game.isGameLost());
        Assertions.assertEquals(Arrays.asList("BLUE","BLACK","YELLOW","RED"), game.getFasit());
        Assertions.assertEquals("[]", game.getTryList().toString());
        Assertions.assertEquals(0, game.getTryList().size());
        Assertions.assertEquals("null 0 0", game.getPlayer().toString());
        Assertions.assertEquals((System.currentTimeMillis()/1000), (game.getStartTime()/1000), "sjekker om startid blir nullstilt, deler på 1000 for å få sekunder");

    }

    


}
