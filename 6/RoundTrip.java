import java.awt.Color;

public class RoundTrip {
    
    void run() throws InterruptedException{
        EZ.initialize(400, 400);
        EZCircle circle = EZ.addCircle(
            100, 100, 5, 5, Color.BLUE, true);
        this.roundTrip(circle);
    }
    
    void roundTrip(EZCircle circle) throws InterruptedException{
        Integer deltaX = 10;
        while(true){ // 無限ループ
            Integer newX = circle.getXCenter() + deltaX;
            circle.translateTo(newX, circle.getYCenter());
            if(newX >= 400 || newX <= 0){
                deltaX = deltaX * -1;
            }
            EZ.refreshScreen();
            //スリープ処理を行うには例外処理が必要
            Thread.sleep(100);
        }
    }

    public static void main(String[] args) throws InterruptedException{

        RoundTrip trip = new RoundTrip();

        trip.run();
    }

}