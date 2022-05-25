import java.awt.Color;

public class KochCurveAnimation {

    void run() throws InterruptedException{
        EZ.initialize(400, 400);

        Integer x1 = 0;
        Integer y1 = 100;
        Integer x5 = 400;
        Integer y5 = 100;

        Double t = 0.0;

        this.drawKoch(x1, y1, x5, y5, 5, 0.0);
        
    }
    
    
    void drawKoch(Integer x1, Integer y1, Integer x5, Integer y5, Integer dimension, Double angle) throws InterruptedException{
        
        if(dimension == 0){
            // (x1, y1)から(x5, y5)まで線を引く．
            EZLine line1 = EZ.addLine(x1, y1, x5, y5, Color.RED);
        }
        else{            
            Double length = Math.sqrt( (Math.pow(x5-x1,2) + Math.pow(y5-y1, 2))) / 3;// 長さlを求める．
            Integer il = length.intValue();
            Double delta = Math.PI / 3.0;
            
            // (x2, y2) を求める．
            Double dx2 = x1 + il * Math.cos(angle);
            Double dy2 = y1 + il * Math.sin(angle);
            Integer x2 = dx2.intValue();
            Integer y2 = dy2.intValue();
            // (x1, y1)から(x2, y2)まで線を引く．
            EZLine line2 = EZ.addLine(x1, y1, x2, y2, Color.RED);

            // (x3, y3) を求める（θ は angle + delta）．
            Double dx3 = x2 + length * Math.cos(angle + delta);
            Double dy3 = y2 + length * Math.sin(angle + delta);
            Integer x3 = dx3.intValue();
            Integer y3 = dy3.intValue();
            
            // (x2, y2)から(x3, y3)まで線を引く．
            this.drawKoch(dx2.intValue(), dy2.intValue(),
            dx3.intValue(), dy3.intValue(),
            dimension - 1, angle + delta);
            
            // (x4, y4) を求める（θ は angle - delta）．
            Double dx4 = x3 + length * Math.cos(angle - delta);
            Double dy4 = y3 + length * Math.sin(angle - delta);
            Integer x4 = dx4.intValue();
            Integer y4 = dy4.intValue();

            // (x3, y3)から(x4, y4)まで線を引く．
            this.drawKoch(dx3.intValue(), dy3.intValue(),
            dx4.intValue(), dy4.intValue(),
            dimension - 1, angle - delta);
            
            // (x4, y4)から(x5, y5)まで線を引く．
            EZLine line5 = EZ.addLine(x4, y4, x5, y5, Color.RED);
            //EZ.refreshScreen();


            EZ.refreshScreen();       // 画面を更新する．
            Thread.sleep(1000);        // 0.1秒間スリープする
        }
    }

    public static void main(String[] args) throws InterruptedException{

        KochCurveAnimation kock = new KochCurveAnimation();

        kock.run();
    }
    
}