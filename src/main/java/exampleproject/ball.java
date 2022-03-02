package exampleproject;

import java.util.Arrays;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {
    private Circle ball = new Circle();

    //gir ballen farge, hentet fra scene paint biblioteket
    public void colorBall(Color x){
        ball.setFill(x);
        //størrelse på ballen, ift brukergrensesnittet
    }


    public Circle getBall() {
        return ball;
    }

    
    


    
}
