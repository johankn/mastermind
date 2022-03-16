package exampleproject;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class rowTest {

    private Row newRow;
    private Row fasit;

    @BeforeEach
    void twoRows(){
        fasit = new Row();
        newRow = new Row();
    }

    @Test
    void testContructors(){
        fasit.addColor("YELLOW");
        fasit.addColor("GREEN");
        fasit.addColor("RED");
        fasit.addColor("BLUE");
        newRow.addColor("BLUE");
        newRow.addColor("RED");
        newRow.addColor("BLACK");
        newRow.addColor("GREEN");
        
		Assertions.assertEquals(Arrays.asList("BLUE","RED","BLACK","GREEN"), newRow.getRow());
        Assertions.assertEquals("You got 0 balls with the right color and at the right place, and 3 balls with the right color, but in the wrong place", fasit.compare(newRow.getRow()));
		
    }
}
