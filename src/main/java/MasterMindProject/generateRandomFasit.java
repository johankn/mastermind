package MasterMindProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class generateRandomFasit implements IGenerateFasit {
    List<String> fasit = new ArrayList<String>();

    @Override
    public List<String> generateFasit() {
        this.fasit = new ArrayList<String>();
        List<String> validColors = Arrays.asList("BLUE","BLACK","YELLOW","RED","GREEN","PURPLE");
        int numberOfElements = 4;
        Random rand = new Random();
        
         for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt((validColors).size());
            fasit.add(validColors.get(randomIndex));
        }
        
    return new ArrayList<>(this.fasit);
    }
    
    
}
