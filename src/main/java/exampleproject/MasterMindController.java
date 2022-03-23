package exampleproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MasterMindController {
    @FXML Circle labelOne_1;
    @FXML Circle labelOne_2;
    @FXML Circle labelOne_3;
    @FXML Circle labelOne_4;
    @FXML Label choose4;
    @FXML Label feedBack;
    private ArrayList<Circle> circles = new ArrayList<>();
    
    int counter = -1;
    Row fasit = new Row();
    

//hvis man trykker på BLUE-knappen kommer det opp blue på første rute osv, føler man kan bruke for løkke bedre her
    @FXML
    public void initialize(){
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
        fasit.random();
    }

    public void handleButtonClickBlue(){
        counter += 1;
        
        (circles.get(counter)).setFill(javafx.scene.paint.Color.BLUE);
         
    }

    public void handleButtonClickBlack(){
        counter += 1;
        
        (circles.get(counter)).setFill(javafx.scene.paint.Color.BLACK);

    }
    public void handleButtonClickYellow(){
        counter += 1;
        
        (circles.get(counter)).setFill(javafx.scene.paint.Color.YELLOW);
    }
    public void handleButtonClickGreen(){
        counter += 1;
        
        (circles.get(counter)).setFill(javafx.scene.paint.Color.GREEN);
    }
    public void handleButtonClickRed(){
        counter += 1;
       
        (circles.get(counter)).setFill(javafx.scene.paint.Color.RED);
    }
    public void handleButtonClickPurple(){
        counter += 1;
        
        (circles.get(counter)).setFill(javafx.scene.paint.Color.PURPLE);
    }

    public void handleButtonClickSubmit(){
        choose4.setText("");
        if (counter>2){
            List<Paint> colors = circles.stream().map(Circle::getFill).collect(Collectors.toList());
            List<String> newList = new ArrayList<>();
            for (Paint paint : colors) {
                String gg = String.valueOf(paint);
                newList.add(gg);
            }
            for (int i = 0; i < newList.size(); i++) {
                if (newList.get(i).equals("0x0000ffff")){
                    newList.set(i, "BLUE");
                }
                if (newList.get(i).equals("0x000000ff")){
                    newList.set(i, "BLACK");
                }
                if (newList.get(i).equals("0xffff00ff")){
                    newList.set(i, "YELLOW");
                }
                if (newList.get(i).equals("0xff0000ff")){
                    newList.set(i, "RED");
                }
                if (newList.get(i).equals("0x008000ff")){
                    newList.set(i, "GREEN");
                }
                if (newList.get(i).equals("0x800080ff")){
                    newList.set(i, "PURPLE");
                }
            }
            Row tester = new Row();
            tester.addColor(newList.get(0));
            tester.addColor(newList.get(1));
            tester.addColor(newList.get(2));
            tester.addColor(newList.get(3));

            feedBack.setText(fasit.compare(tester.getRow()));
            
        }
        else{
            choose4.setText("You have to pick four!");
        }
    }
    public void handleButtonClickUndo(){
        for (Circle circle : circles) {
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }
        this.circles.removeAll(circles);
        counter = -1;
        circles.add(labelOne_1);
        circles.add(labelOne_2);
        circles.add(labelOne_3);
        circles.add(labelOne_4);
    }

    
    

    
}
