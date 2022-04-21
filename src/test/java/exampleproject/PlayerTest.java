package exampleproject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player p1 = new Player();
    @Test
    public void testValidUserName(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> p1.setName("Bob 98 v"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> p1.setName("ijhkdshsdkldkjahflkadjhlakdjfjfhdskjf"));
        Assertions.assertDoesNotThrow(()->p1.setName("ijhkdshs"));
    }

    
}
