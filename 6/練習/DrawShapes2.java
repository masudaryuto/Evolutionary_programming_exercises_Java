import java.awt.Color;

public class DrawShapes2 {

    void run() {

        EZ.initialize(400, 400);
        //四角形の中心がx、y？
        EZRectangle rectangle = EZ.addRectangle(200, 200, 200, 200, Color.BLUE, true);
        EZCircle circle = EZ.addCircle(200, 200, 200, 200, Color.WHITE, true);

        EZLine line1 = EZ.addLine(200, 200-(141), 200-(141), 200, Color.RED);
        EZLine line2 = EZ.addLine(200, 200-(141), 200+(141), 200, Color.YELLOW);
        EZLine line3 = EZ.addLine(200, 200+(141), 200-(141), 200, Color.GREEN);
        EZLine line4 = EZ.addLine(200, 200+(141), 200+(141), 200, Color.GRAY);
    }


    public static void main(String[] args){

        DrawShapes2 draw = new DrawShapes2();

        draw.run();
    }
}