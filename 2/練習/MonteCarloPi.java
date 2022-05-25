import java.util.Random;

public class MonteCarloPi {

    void run(String[] args){
        Integer n = 1000;
        if(args.length != 0){
            n = Integer.valueOf(args[0]);
        }

        Double hit = this.hitmath(n);
        
        
        System.out.printf("pi = %.5f%n", 4*hit/n);
        
    }
    Double hitmath(Integer n){
        Random rand = new Random();
        Double hit = 0.0;
        //System.out.println(n);
        for(Integer i=0; i<n; i++){
            Double x = rand.nextDouble();
            Double y = rand.nextDouble();
            //System.out.printf("%f, %f%n",x, y);
            Double mon_num = Math.sqrt(x*x + y*y);
            if(mon_num <= 1){
                hit++;
            }
        }
        return hit;
    }
    public static void main(String[] args){
        MonteCarloPi mon = new MonteCarloPi();
        
        mon.run(args);
    }
}