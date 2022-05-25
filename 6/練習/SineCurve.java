import java.awt.Color;

public class SineCurve {

    void run() {
        Double v = 0.0;
        Double delta = 2*Math.PI / 400;
        Double s = 400 / (2*Math.PI);
        Integer x1 = 0;
        Integer x2 = 0;

        Integer y1 = 200;
        Integer y2 = 0;

        EZ.initialize(400, 400);
        //四角形の中心がx、y？
        EZLine line1 = EZ.addLine(200, 400, 200, 0, Color.GRAY);
        EZLine line2 = EZ.addLine(0, 200, 400, 200, Color.GRAY);

        
        for(Integer i=0; i<400; i++){
            
            x2 = i;
            v = Math.sin(i * delta) * s;
            y2 = v.intValue();
            EZLine curve = EZ.addLine(x1, y1+200, x2, y2+200, Color.RED);


            
            EZ.refreshScreen();
            x1 = x2;
            y1 = y2;       
        }
        
    }


    public static void main(String[] args){

        SineCurve draw = new SineCurve();

        draw.run();
    }
}