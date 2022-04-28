package MasterMindProject;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class MasterMindController {
    @FXML private Pane masterPane;

    @FXML private Pane popUp;
    @FXML private TextField textfield;
    @FXML private Button submitName;
    @FXML private Label validname;

    @FXML private Circle labelOne_1, labelOne_2, labelOne_3, labelOne_4;

    @FXML private Circle labelTwo_1, labelTwo_2, labelTwo_3, labelTwo_4;

    @FXML private Circle labelThree_1, labelThree_2, labelThree_3, labelThree_4;

    @FXML private Circle labelFour_1, labelFour_2, labelFour_3, labelFour_4;

    @FXML private Circle labelFive_1, labelFive_2, labelFive_3, labelFive_4;

    @FXML private Circle labelSix_1, labelSix_2, labelSix_3, labelSix_4;

    @FXML private Circle labelSeven_1, labelSeven_2, labelSeven_3, labelSeven_4;

    @FXML private Label choose4;

    @FXML private Label FB1, FB2, FB3, FB4, FB5, FB6;

    @FXML private ScrollPane leaderBoard;

    @FXML private Label lostGame;

    private ArrayList<Circle> circles = new ArrayList<>();

    private ArrayList<Circle> rowTwo = new ArrayList<>();
    private ArrayList<Circle> rowThree = new ArrayList<>();
    private ArrayList<Circle> rowFour = new ArrayList<>();
    private ArrayList<Circle> rowFive = new ArrayList<>();
    private ArrayList<Circle> rowSix = new ArrayList<>();
    private ArrayList<Circle> rowSeven = new ArrayList<>();

    private ArrayList<ArrayList<Circle>> listOfRows = new ArrayList<ArrayList<Circle>>();

    private ArrayList<Label> feedBacks = new ArrayList<>();

    private MasterMindGame game;

    private generateRandomFasit randomFasit = new generateRandomFasit();


    @FXML
    private void initialize(){
        this.game = new MasterMindGame(randomFasit);

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

    }
    @FXML
    private void handleButtonClickColor(ActionEvent event){
    choose4.setText("");
        if (game.getCounter()<3){
        Button activatedButton = (Button) event.getSource();
        Button clicked = (Button) activatedButton;
        String color = clicked.getId();

        game.addColor(color);
        //System.out.println(game.getTryList());

        Color x = Color.web(color);

        //dette er åpenbart tatt fra stackOverflow^^^

        (circles.get(game.getCounter())).setFill(x);
    }
    else{
        choose4.setText("Click submit");
    }
    }
    @FXML
    private void handleButtonClickSubmit(){
        choose4.setText("");
        if ((game.getCounter()==3)){

            feedBacks.get(game.getSubmitCounter()).setText(game.compareRows());
            updateRow(listOfRows.get(game.getSubmitCounter()));
            game.submit();
            if (game.isGameWon()==true){
                popUp.setVisible(true);
                popUp.setDisable(false);
                submitName.setVisible(true);

            }
            else if (game.isGameLost()==true){
                masterPane.setVisible(false);
                lostGame.setVisible(true);
                lostGame.setText("You lost the game!");
            }
            
        }
        else{
            choose4.setText("You have to pick four!");
        }
    }
    @FXML
    private void handleButtonClickUndo(){
        choose4.setText("");
        if (game.getCounter()>-1){
            game.setCounter(-1);
        for (Circle circle : circles) {
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }
        game.setTryList(new ArrayList<>());

    }
    }
    @FXML
    private void handleButtonClickSubmitName(){
        try{
            String name = textfield.getText();
            //System.out.println(name);
            game.gameWon(name);
            game.getLeaderBoard().write2file(game.getPlayer()); //kan enten ha denne i gameWon() eller her, hvis den er i gameWon blir players addet hver gang vi tester
            leaderBoard.setVisible(true);
            Text text = new Text(game.getLeaderBoard().printLeaderboard());
            leaderBoard.setContent(text);
            submitName.setVisible(false);
            System.out.println(game.getPlayer());
            validname.setText("");
        }
         catch(Exception e){
             validname.setText("The username must be less than 26 letters long, and must not contain spaces or special characters!");
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
    @FXML
    private void handleButtonClickReset(){
        game.resetGame(randomFasit);
        leaderBoard.setVisible(false);
        masterPane.setVisible(true);
        lostGame.setVisible(false);
        popUp.setVisible(false);
        textfield.setText("");
        textfield.setPromptText("Enter a username"); 
                popUp.setDisable(true);
        for (int i = 0; i < listOfRows.size(); i++) {
            for (int j = 0; j < rowSeven.size(); j++) {
                listOfRows.get(i).get(j).setFill(javafx.scene.paint.Color.WHITE);
            }
        }
        for (int i = 0; i < feedBacks.size(); i++) {
            feedBacks.get(i).setText("");
        }
        for (Circle circle : circles) {
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }
    }
   
}
