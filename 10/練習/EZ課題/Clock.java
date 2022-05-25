import java.awt.Color;
import java.util.Date;

public class Clock {

    static Integer WINDOWSIZE = 400;
    void run() throws InterruptedException{
        EZ.initialize(WINDOWSIZE, WINDOWSIZE);
        
        
        
        
        this.math_date();
    }
    
    void math_date() throws InterruptedException{
        
        Double degreeOfSeconds;
        Double degreeOfMinutes;
        Double degreeOfHours;
        while(true){
    
            EZCircle circle1 = EZ.addCircle(WINDOWSIZE/2, WINDOWSIZE/2, 300, 300, Color.BLACK, false);
            EZCircle circle2 = EZ.addCircle(WINDOWSIZE/2, WINDOWSIZE/2, 10, 10, Color.BLACK, true);
            Date date = new Date();
            degreeOfSeconds = date.getSeconds() * 6.0 - 90;
            degreeOfMinutes = date.getMinutes() * 6.0 - 90;
            degreeOfHours = (date.getHours() * 5 + date.getMinutes() / 12.0) * 6.0 - 90;
            
            this.move_watch(degreeOfHours, degreeOfMinutes, degreeOfSeconds);
            
            EZ.removeAllEZElements();
            Thread.sleep(100);
            EZ.refreshScreen();
        }
    }
    
    void move_watch(Double hour, Double min, Double sec){
        Double radian_hour = Math.toRadians(hour);
        Double radian_min = Math.toRadians(min);
        Double radian_sec = Math.toRadians(sec);


        //時間
        Double x1_hour = 100*Math.cos(radian_hour);
        Double y1_hour = 100*Math.sin(radian_hour);
        Integer x_hour = (int)Math.round(x1_hour);
        Integer y_hour = (int)Math.round(y1_hour);
        EZLine line_hour = EZ.addLine(WINDOWSIZE/2, WINDOWSIZE/2, x_hour+(WINDOWSIZE/2), y_hour+(WINDOWSIZE/2), Color.RED);
        
        //分はり
        Double x1_min = 140*Math.cos(radian_min);
        Double y1_min = 140*Math.sin(radian_min);
        Integer x_min = (int)Math.round(x1_min);
        Integer y_min = (int)Math.round(y1_min);
        EZLine line_min = EZ.addLine(WINDOWSIZE/2, WINDOWSIZE/2, x_min+(WINDOWSIZE/2), y_min+(WINDOWSIZE/2), Color.BLUE);
        
        //秒はり
        Double x1_sec = 150*Math.cos(radian_sec);
        Double y1_sec = 150*Math.sin(radian_sec);
        Integer x_sec = (int)Math.round(x1_sec);
        Integer y_sec = (int)Math.round(y1_sec);
        EZLine line_sec = EZ.addLine(WINDOWSIZE/2, WINDOWSIZE/2, x_sec+(WINDOWSIZE/2), y_sec+(WINDOWSIZE/2), Color.GREEN);

    }
    
    public static void main(String[] args) throws InterruptedException{
        Clock clc = new Clock();

        clc.run();
    }
}