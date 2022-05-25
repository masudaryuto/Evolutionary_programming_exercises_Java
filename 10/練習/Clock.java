import java.awt.Color;

public class Clock {
    void run(){
        EZ.initialize(400, 400);

        EZCircle circle = EZ.addCircle(100, 100, 100, 100, true);
    }
    
    public static void main(String[] args){
        Clock clc = new Clock();

        clc.run();
    }
}