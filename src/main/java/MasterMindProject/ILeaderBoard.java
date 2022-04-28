package MasterMindProject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface ILeaderBoard {
    
    public void write2file(Player p) throws FileNotFoundException;

    public List<Player> getListOfPlayers() throws FileNotFoundException;
}
