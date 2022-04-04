package exampleproject;

import java.util.ArrayList;
import java.util.Arrays;
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

    @FXML Circle labelFive_1;
    @FXML Circle labelFive_2;
    @FXML Circle labelFive_3;
    @FXML Circle labelFive_4;

    @FXML Circle labelSix_1;
    @FXML Circle labelSix_2;
    @FXML Circle labelSix_3;
    @FXML Circle labelSix_4;

    @FXML Circle labelSeven_1;
    @FXML Circle labelSeven_2;
    @FXML Circle labelSeven_3;
    @FXML Circle labelSeven_4;

    @FXML Label choose4;

    @FXML Label FB1;
    @FXML Label FB2;
    @FXML Label FB3;
    @FXML Label FB4;
    @FXML Label FB5;
    @FXML Label FB6;
    private ArrayList<Circle> circles = new ArrayList<>();
    
    private ArrayList<Circle> rowTwo = new ArrayList<>();
    private ArrayList<Circle> rowThree = new ArrayList<>();
    private ArrayList<Circle> rowFour = new ArrayList<>();
    private ArrayList<Circle> rowFive = new ArrayList<>();
    private ArrayList<Circle> rowSix = new ArrayList<>();
    private ArrayList<Circle> rowSeven = new ArrayList<>();

    private ArrayList<ArrayList<Circle>> listOfRows = new ArrayList<ArrayList<Circle>>();

    private ArrayList<Label> feedBacks = new ArrayList<>();

    private int counter = -1;
    private int submitCounter = 0;
    private Row fasit = new Row();
    private Row tryList = new Row();
    
    

//initialiserer det som skjer når man starter appen
    @FXML
    public void initialize(){
        
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);

        rowTwo.add(labelTwo_1);
        rowTwo.add(labelTwo_2);
        rowTwo.add(labelTwo_3);
        rowTwo.add(labelTwo_4);

        rowThree.add(labelThree_1);
        rowThree.add(labelThree_2);
        rowThree.add(labelThree_3);
        rowThree.add(labelThree_4);

        rowFour.add(labelFour_1);
        rowFour.add(labelFour_2);
        rowFour.add(labelFour_3);
        rowFour.add(labelFour_4);

        rowFive.add(labelFive_1);
        rowFive.add(labelFive_2);
        rowFive.add(labelFive_3);
        rowFive.add(labelFive_4);

        rowSix.add(labelSix_1);
        rowSix.add(labelSix_2);
        rowSix.add(labelSix_3);
        rowSix.add(labelSix_4);

        rowSeven.add(labelSeven_1);
        rowSeven.add(labelSeven_2);
        rowSeven.add(labelSeven_3);
        rowSeven.add(labelSeven_4);

        listOfRows.add(rowTwo);
        listOfRows.add(rowThree);
        listOfRows.add(rowFour);
        listOfRows.add(rowFive);
        listOfRows.add(rowSix);
        listOfRows.add(rowSeven);

         feedBacks.add(FB1);
         feedBacks.add(FB2);
         feedBacks.add(FB3);
         feedBacks.add(FB4);
         feedBacks.add(FB5);
         feedBacks.add(FB6);


        fasit.random();
        System.out.println(fasit.getRow());
    }
//hva som skjer når man trykker på fargene

    public void handleButtonClickColor(ActionEvent event){
    choose4.setText("");
        if (counter<3){
        Button activatedButton = (Button) event.getSource();
        Button clicked = (Button) activatedButton;
        String colour = clicked.getId();

        this.tryList.addColor(colour);

        Color x = Color.web(colour);

        //dette er åpenbart tatt fra stackOverflow^^^


        counter += 1;
        (circles.get(counter)).setFill(x);
        
    }
    else{
        choose4.setText("Click submit");
    } 
    }

    public void handleButtonClickSubmit(){
        choose4.setText("");
        if ((counter==3)){

            feedBacks.get(submitCounter).setText(fasit.compare(tryList.getRow()));
            updateRow(listOfRows.get(submitCounter));
            submitCounter += 1;
            counter = -1;
            this.tryList = new Row();
        }
        else{
            choose4.setText("You have to pick four!");
        }
    }
    public void handleButtonClickUndo(){
        choose4.setText("");
        if (counter>-1){
            counter = -1;
        for (Circle circle : circles) {
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }
        this.tryList = new Row();
        //(tryList.getRow()).subList(tryList.getRow().size() - 4, tryList.getRow().size()).clear();
        
    }
    }
    private void updateRow(ArrayList<Circle> x){
        for (int i = 0; i < x.size(); i++) {
            x.get(i).setFill(circles.get(i).getFill());
        }

        for (Circle circle : circles) {
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }
    }

    
    

    
}
