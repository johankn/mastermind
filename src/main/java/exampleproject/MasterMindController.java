package exampleproject;

import java.util.ArrayList;

import javafx.fxml.FXML;

import javafx.scene.shape.Circle;

public class MasterMindController {
    @FXML Circle labelOne_1;
    @FXML Circle labelOne_2;
    @FXML Circle labelOne_3;
    @FXML Circle labelOne_4;
    private ArrayList<Circle> circles = new ArrayList<>();
    
    int counter = -1;
    

//hvis man trykker på BLUE-knappen kommer det opp blue på første rute osv, føler man kan bruke for løkke bedre her
    public void handleButtonClickBlue(){
        counter += 1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        (circles.get(counter)).setFill(javafx.scene.paint.Color.BLUE);
         
    }

    public void handleButtonClickBlack(){
        counter += 1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        (circles.get(counter)).setFill(javafx.scene.paint.Color.BLACK);

    }
    public void handleButtonClickYellow(){
        counter += 1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        (circles.get(counter)).setFill(javafx.scene.paint.Color.YELLOW);
    }
    public void handleButtonClickGreen(){
        counter += 1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        (circles.get(counter)).setFill(javafx.scene.paint.Color.GREEN);
    }
    public void handleButtonClickRed(){
        counter += 1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        (circles.get(counter)).setFill(javafx.scene.paint.Color.RED);
    }
    public void handleButtonClickPurple(){
        counter += 1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        (circles.get(counter)).setFill(javafx.scene.paint.Color.PURPLE);
    }

    public void handleButtonClickSubmit(){
        if (counter>1){
            
        }
        else{

        }
    }

    
}
