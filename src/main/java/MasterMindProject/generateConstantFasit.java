package MasterMindProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generateConstantFasit implements IGenerateFasit {
    private List<String> fasit = new ArrayList<String>();
    
    @Override
    public List<String> generateFasit() {
        this.fasit = new ArrayList<String>();
        this.fasit.addAll(Arrays.asList("BLUE","BLACK","YELLOW","RED"));
        return new ArrayList<>(this.fasit);
        
    }
    
}
