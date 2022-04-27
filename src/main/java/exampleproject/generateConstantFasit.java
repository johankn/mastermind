package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateConstantFasit implements IGenerateFasit {
    List<String> fasit = new ArrayList<String>();
    @Override
    public List<String> generateFasit() {
        this.fasit.addAll(Arrays.asList("BLUE","BLACK","YELLOW","RED"));
        return new ArrayList<>(this.fasit);
        
    }
    
}
