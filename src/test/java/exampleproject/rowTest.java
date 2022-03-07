package exampleproject;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class rowTest {

    private Row newRow;
    private Row fasit;

    @Test
    void testContructors(){
        fasit = new Row("GREEN", "BLUE", "RED", "RED");
        newRow = new Row("BLUE", "RED", "BLACK", "GREEN");
		Assertions.assertEquals(Arrays.asList("BLUE","RED","BLACK","GREEN"), newRow.getRow());
        Assertions.assertEquals("You got 0 balls with the right color and at the right place, and 3 balls with the right color, but in the wrong place", fasit.compare(newRow.getRow()));
		
    }
}
