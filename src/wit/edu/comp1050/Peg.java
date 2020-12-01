package wit.edu.comp1050;

public class Peg {

    String color;
    char id;
    boolean tested;

    public Peg(String c, char i, boolean t){
        color = c;
        id = i;
        tested = t;
    }
    public String getColor() {
        return color;
    }
    public char getId() {
        return id;
    }
    public boolean getT(){
        return tested;
    }
    public void setT(boolean newT){
        tested = newT;
    }
}
