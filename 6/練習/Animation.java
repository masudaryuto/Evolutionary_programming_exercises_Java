import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Object;



public class Animation{

    void run() throws InterruptedException{
        EZ.initialize(400, 400);

        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();

        ArrayList<Integer> vx = new ArrayList<>();
        ArrayList<Integer> vy = new ArrayList<>();

        for(Integer i=0; i<5; i++){
            Random rand = new Random();
            x.add(rand.nextInt(200)+10);
            y.add(rand.nextInt(200)+10);
            r.add(rand.nextInt(100)+10);

            vx.add(rand.nextInt(5)+5);
            vy.add(rand.nextInt(5)+5);
            
        }


        
        this.circle(x, y, r, vx, vy);
    }
    

    void circle(ArrayList<Integer> x, ArrayList<Integer> y, ArrayList<Integer> r, ArrayList<Integer> vx, ArrayList<Integer> vy) throws InterruptedException{
        EZCircle circle1 = EZ.addCircle(x.get(0), y.get(0), r.get(0), r.get(0), Color.RED, true);
        EZCircle circle2 = EZ.addCircle(x.get(1), y.get(1), r.get(1), r.get(1), Color.RED, true);
        EZCircle circle3 = EZ.addCircle(x.get(2), y.get(2), r.get(2), r.get(2), Color.RED, true);
        EZCircle circle4 = EZ.addCircle(x.get(3), y.get(3), r.get(3), r.get(3), Color.RED, true);
        EZCircle circle5 = EZ.addCircle(x.get(4), y.get(4), r.get(4), r.get(4), Color.RED, true);
        
        while(true){

            for(Integer i = 0; i<5; i++){
                
                x.set(i, x.get(i) + vx.get(i));
                y.set(i, y.get(i) + vy.get(i));
                if(i == 0){
                    circle1.translateTo(x.get(i), y.get(i));
                }
                else if(i == 1){
                    circle2.translateTo(x.get(i), y.get(i));
                }
                else if(i == 2){
                    circle3.translateTo(x.get(i), y.get(i));
                }
                else if(i == 3){
                    circle4.translateTo(x.get(i), y.get(i));
                }
                else if(i == 4){
                    circle5.translateTo(x.get(i), y.get(i));
                }
                
                if(y.get(i) >= 400 - (r.get(i)/2)){
                    vy.set(i, -1*vy.get(i));
          
                    
                }
                else if(y.get(i) <= (r.get(i)/2)){
                    vy.set(i, -1*vy.get(i));
                  
                }
                
                if(x.get(i) >= 400 - (r.get(i)/2)){
                    vx.set(i, -1*vx.get(i));
                 
                }
                else if(x.get(i) <= (r.get(i)/2)){
                    vx.set(i, -1*vx.get(i));
     
                }
                
                EZ.refreshScreen();
                Thread.sleep(1);

         
            }
                
        }
        
    }
    
    
    
    public static void main(String[] args) throws InterruptedException{
        
        Animation anime = new Animation();

        anime.run();
    }
}