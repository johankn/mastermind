package exampleproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MasterMindController {
    @FXML Label label;

//hvis man trykker på BLUE-knappen kommer det opp blue på første rute
    public void handleButtonClick(){
        label.setText("BLUE");
    }
    
}
