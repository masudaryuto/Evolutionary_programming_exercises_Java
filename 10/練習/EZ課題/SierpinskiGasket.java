import java.awt.Color;

public class SierpinskiGasket {

    static Integer WINDOWSIZE = 400;

    
    void run(String[] args) throws InterruptedException{
        Integer n = 3;
        if(args.length != 0){
            n = Integer.valueOf(args[0]);
        }
        
        EZ.initialize(WINDOWSIZE, WINDOWSIZE);
        
        this.draw(n);
        
        
    }
    
    void draw(Integer n){
        Integer xp[] = {10, 390, 200};
        Integer yp[] = {380, 380, 51};
        
        EZPolygon triangle = EZ.addPolygon(xp, yp, Color.BLACK, false);
        

        this.drawGasket(n, xp, yp);
    }

    void drawGasket(Integer n, Integer xp[], Integer yp[]){
        if(n == 0){
            return;
        }

        Integer x1 = (xp[0]+xp[1])/2;
        Integer x2 = (xp[0]+xp[2])/2;
        Integer x3 = (xp[1]+xp[2])/2;

        Integer y1 = (yp[0]+yp[1])/2;
        Integer y2 = (yp[0]+yp[2])/2;
        Integer y3 = (yp[1]+yp[2])/2;

        Integer[] xp1 = {x1, x2, x3};
        Integer[] yp1 = {y1, y2, y3};



        EZPolygon triangle = EZ.addPolygon(xp1, yp1, Color.RED, false);

        //左下
        Integer[] xp2 = {x1, x2, xp[0]};
        Integer[] yp2 = {y1, y2, yp[0]};
        this.drawGasket(n - 1, xp2, yp2);
        //右下
        Integer[] xp3 = {x1, x3, xp[1]};
        Integer[] yp3 = {y1, y3, yp[1]};
        this.drawGasket(n - 1, xp3, yp3);
        //左下
        Integer[] xp4 = {x2, x3, xp[2]};
        Integer[] yp4 = {y2, y3, yp[2]};
        this.drawGasket(n - 1, xp4, yp4);

    }



    public static void main(String[] args) throws InterruptedException{

        SierpinskiGasket sier = new SierpinskiGasket();

        sier.run(args);

    }
}