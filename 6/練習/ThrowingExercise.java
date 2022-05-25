import java.awt.Color;
public class ThrowingExercise {

    void run() throws InterruptedException{
        EZ.initialize(400, 400);
        EZCircle circle = EZ.addCircle(100, 5, 5, 5, Color.BLUE, true);

        Double t = 0.0;
        Double v0 = 85.0;
        Double y0 = 10.0;
        Double g = 9.8;
        Double v = v0;
        Integer x = 100;
        Double y = y0;

        Boolean nageage = true;

        EZCircle bound = EZ.addCircle(x, y.intValue(), 5, 5, Color.RED, true);

        EZCircle green_circle = EZ.addCircle(100, y.intValue(), 5, 5, Color.GREEN, true);

        Integer deltaX = 10;

        while(true){
        //this.roundTrip(circle);
            Integer newX = circle.getXCenter() + deltaX;
            circle.translateTo(newX, circle.getYCenter());
            if(newX >= 400 || newX <= 0){
                deltaX = deltaX * -1;
            }


            v = v0 - g*t;
            y = y0 + (v0 * t - (g/2 * t * t));

            if(isSwitch(nageage, v, y)){
                t = 0.0;
                v0 = -1*v;
                y0 = y;
                nageage = !nageage;
            }
            t += 0.1;
        
            bound.translateTo(x, y); // 位置を更新する．

            green_circle.translateTo(newX, y);
            EZ.refreshScreen();
            Thread.sleep(100);
        
        }
    }

    Boolean isSwitch(boolean nageage, Double v, Double y){
        if(nageage && v < 0){ // 投げ上げ時，最高点に達した．
            return true;
        }
        else if(!nageage && y < 10.0){ // 自由落下時，地面に達した．
            return true;
        }
        return false;
    }
    /*
    void roundTrip(EZCircle circle) throws InterruptedException{
    //スリープ処理を行うには例外処理が必要
    }
    */
    public static void main(String[] args) throws InterruptedException{

        ThrowingExercise th = new ThrowingExercise();

        th.run();
    }

}
