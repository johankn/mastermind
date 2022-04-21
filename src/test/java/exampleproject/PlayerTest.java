package exampleproject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    Player p1 = new Player();
    
    @Test
    void testValidUserName(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> p1.setName("Bob 98 v"));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> p1.setName("ijhkdshsdkldkjahflkadjhlakdjfjfhdskjf"));
        Assertions.assertDoesNotThrow(()->p1.setName("ijhkdshs"));
    }
    @Test
    void testComparePlayers(){
        Player p2 = new Player("Hanne", 3, 134);
        Player p3 = new Player("Georg", 3, 102);
        Player p4 = new Player("Ponny", 2, 178);
        Player p5 = new Player("Skengh", 3,134);
        Assertions.assertEquals(0, p2.compareTo(p5), "Likt antall forsøk og tid skal gi null");
        Assertions.assertTrue(p3.compareTo(p4)>0, "p3 minus p4 skal gi over null siden p3 har brukt flere forsøk");
        Assertions.assertEquals(32, p2.compareTo(p3), "p2 og p3 har likt antall forsøk, da blir tiden til p2 minus tid til p3 32");
        
        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(p1,p2,p3,p4,p5));
        Assertions.assertFalse((players).stream().sorted().collect(Collectors.toList()).equals(players), "liste ikke sortert");
        Collections.sort(players);
        Assertions.assertTrue((players).stream().sorted().collect(Collectors.toList()).equals(players), "liste sortert etter å ha brukt collections.sort()");
        

    }



}
