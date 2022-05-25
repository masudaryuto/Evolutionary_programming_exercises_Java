import java.awt.Color;

public class DrawOval {

    void run(){
        EZ.initialize(400, 400); // 画面の大きさを決める．
        // 円を描く．(中心座標x, y, 幅，高さ，色，塗りつぶし)
        EZCircle circle1 = EZ.addCircle(
            130, 100, 20, 20, Color.YELLOW, true);
        EZCircle circle2 = EZ.addCircle(
            200, 200, 200, 200, Color.BLUE,  true);
    }
    

    public static void main(String[] args){

        DrawOval draw = new DrawOval();

        draw.run();
    }
}