import java.awt.Color;

public class Reversi {

    void run(){

        draw_ground();

        EZCircle w_circle1 = EZ.addCircle(160+(50/2), 160+(50/2), 40, 40, Color.WHITE, true);
        EZCircle w_circle2 = EZ.addCircle(210+(50/2), 210+(50/2), 40, 40, Color.WHITE, true);

        EZCircle b_circle1 = EZ.addCircle(160+(50/2), 210+(50/2), 40, 40, Color.BLACK, true);
        EZCircle b_circle2 = EZ.addCircle(210+(50/2), 160+(50/2), 40, 40, Color.BLACK, true);




    }

    void draw_ground(){
        EZ.initialize(420, 420);

        EZRectangle rectangle = EZ.addRectangle(210, 210, 420, 420, Color.GREEN, true);

        Integer w = 10;

        for(Integer i=0; i<9; i++){

            EZ.addLine(w + (50*i), w, w + (50*i), 420-w, Color.GRAY);
            EZ.addLine(w, w + (50*i), 420 - w, w + (50*i), Color.GRAY);
        }


    }
    

    public static void main(String[] args){

        Reversi re = new Reversi();

        re.run();
    }
}