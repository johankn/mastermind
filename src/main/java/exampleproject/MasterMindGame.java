package exampleproject;

import java.util.ArrayList;

public class MasterMindGame {

    private int counter = -1;
    private int submitCounter = 0;
    private Row fasit = new Row();
    private Row tryList = new Row();

    public MasterMindGame() {
        fasit.random();

    }

    public void updateCounter() {
        this.counter += 1;
    }

    public void updateSubmitCounter() {
        this.submitCounter += 1;
    }

    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getSubmitCounter() {
        return submitCounter;
    }
    public void setSubmitCounter(int submitCounter) {
        this.submitCounter = submitCounter;
    }
    public Row getFasit() {
        return this.fasit;
    }
    public void setFasit(Row fasit) {
        this.fasit = fasit;
    }
    public Row getTryList() {
        return this.tryList;
    }
    public void setTryList(Row tryList) {
        this.tryList = tryList;
    }
        

    public static void gameOver() {
        

    }

    
}
