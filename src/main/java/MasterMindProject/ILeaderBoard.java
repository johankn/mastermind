package MasterMindProject;

import java.io.FileNotFoundException;
import java.util.List;

public interface ILeaderBoard {
    
    public void writePlayerToFile(Player p) throws FileNotFoundException;

    public List<Player> getListOfPlayers() throws FileNotFoundException;
}
