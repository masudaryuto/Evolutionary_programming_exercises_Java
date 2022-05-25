import java.awt.Color;

public class DrawShapes {

    void run(){
        EZ.initialize(400, 400); // 画面の大きさを決める．
        // 円を描く．(中心座標x, y, 幅，高さ，色，塗りつぶし)
        EZCircle circle1 = EZ.addCircle(
            130, 100, 20, 20, Color.YELLOW, true);
        EZCircle circle2 = EZ.addCircle(
            200, 200, 200, 200, Color.BLUE,  true);

        
        EZLine line = EZ.addLine(10, 10, 100, 100, Color.BLACK);
    }
    

    public static void main(String[] args){

        DrawShapes draw = new DrawShapes();

        draw.run();
    }    
}