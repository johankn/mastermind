package exampleproject;

import java.util.ArrayList;

public class Calculator {
    private String operator;
    public ArrayList<String> yolo = new ArrayList<String>();

    public Calculator(String operator) {
        if (!checkValidOperator(operator))
            throw new IllegalArgumentException("Invalid operator");

        this.operator = operator;
    }

    private boolean checkValidOperator(String operator) {
        return "+-/*".indexOf(operator) != -1 && operator.length() == 1;
    }

    public String getOperator() {
        return operator;
    }

    public int calculate(int a, int b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    public void compare(ArrayList<String> x) {
        for (String farge : yolo) {
            if((x.contains(farge)) && (x.indexOf(farge) == yolo.indexOf(farge))) {

            }
            
        }
    }
}
