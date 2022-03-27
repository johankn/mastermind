package exampleproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MasterMindController {
    @FXML Circle labelOne_1;
    @FXML Circle labelOne_2;
    @FXML Circle labelOne_3;
    @FXML Circle labelOne_4;

    @FXML Circle labelTwo_1;
    @FXML Circle labelTwo_2;
    @FXML Circle labelTwo_3;
    @FXML Circle labelTwo_4;

    @FXML Circle labelThree_1;
    @FXML Circle labelThree_2;
    @FXML Circle labelThree_3;
    @FXML Circle labelThree_4;

    @FXML Circle labelFour_1;
    @FXML Circle labelFour_2;
    @FXML Circle labelFour_3;
    @FXML Circle labelFour_4;

    @FXML Label choose4;
    @FXML Label feedBack;
    public ArrayList<Circle> circles = new ArrayList<>();
    
    /*private ArrayList<Circle> rowTwo = new ArrayList<>()
    private ArrayList<Circle> rowThree = new ArrayList<>();
    private ArrayList<Circle> rowFour = new ArrayList<>();*/
    //private ArrayList<Circle> rowFive = new ArrayList<>();
    
    int counter = -1;
    Row fasit = new Row();
    Row tryList = new Row();
    
    

//initialiserer det som skjer når man starter appen
    @FXML
    public void initialize(){
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);

        /*circles.add(labelTwo_1);
        circles.add(labelTwo_2);
        circles.add(labelTwo_3);
        circles.add(labelTwo_4);

        circles.add(labelThree_1);
        circles.add(labelThree_2);
        circles.add(labelThree_3);
        circles.add(labelThree_4);

        circles.add(labelFour_1);
        circles.add(labelFour_2);
        circles.add(labelFour_3);
        circles.add(labelFour_4);*/
    
        fasit.random();
        System.out.println(fasit.getRow());
    }
//hva som skjer når man trykker på fargene

    public void handleButtonClickColor(ActionEvent event){

        if (counter<4){
        Button activatedButton = (Button) event.getSource();
        Button clicked = (Button) activatedButton;
        String colour = clicked.getId();

        this.tryList.addColor(colour);

        Color x = Color.web(colour);

        //for løkke her om hvilken rad man er på, kan prøve counter, en liste for hver rad osv

        counter += 1;
        (circles.get(counter)).setFill(x);
        
    } 
    }

    public void handleButtonClickSubmit(){
        choose4.setText("");
        if (((counter==3)||(counter==7)||(counter==11)||(counter==15))){
            feedBack.setText("");

            feedBack.setText(fasit.compare(tryList.getRow()));
           
        }
        else{
            choose4.setText("You have to pick four!");
        }
    }
    public void handleButtonClickUndo(){
        if (counter>-1){
            counter = -1;
        for (Circle circle : circles) {
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }
        this.tryList = new Row();
        //(tryList.getRow()).subList(tryList.getRow().size() - 4, tryList.getRow().size()).clear();
        
    }
    }

    
    

    
}
