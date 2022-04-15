package exampleproject;

public class MasterMindGame {

    private int counter = -1;
    private int submitCounter = 0;
    private Row fasit;
    private Row tryList;
    private long startTime;
    private long endTime;
    private Player player;

    public MasterMindGame() {
        this.fasit = new Row();
        this.tryList = new Row();
        fasit.random();
        System.out.println(fasit);
        this.startTime = System.currentTimeMillis();
    }

    public void counterPlusOne() {
        this.counter += 1;
    }

    public void submitCounterPlusOne() {
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

    public void gameOver() {
        this.endTime = System.currentTimeMillis();
        player.setDiffTime((int)(endTime - startTime)/1000);
        System.out.println(player.getDiffTime());
    }

    public void submit(){
        this.submitCounter += 1;
        this.counter = -1;
        this.tryList = new Row();
        if (submitCounter == 6){
            gameOver();
        }
    }

    
}
