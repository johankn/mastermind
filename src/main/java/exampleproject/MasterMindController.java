package exampleproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MasterMindController {
    @FXML Button BLUE;
    @FXML Label label;

//hvis man trykker på BLUE-knappen kommer det opp blue på første rute
    public void handleButtonClick(){
        System.out.println("halla");
        label.setText("BLUE");
    }
    
}
