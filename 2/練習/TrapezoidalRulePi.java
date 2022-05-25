public class TrapezoidalRulePi {

    void run(String[] args){
        Double wide = 0.0001;
        if(args.length != 0){
            wide = Double.valueOf(args[0]);
        }

        Double sum = this.aremath(wide);

        System.out.printf("pi = %.16f%n", sum*4);
    }

    Double aremath(Double wide){
        Double sum = 0.0;
        Double y = 1.0;
        Double tmp = y;
        
        for(Double x=wide; x<=1.0; x+=wide){
            y = Math.sqrt(1 - x*x);
            sum += wide*(y+tmp)/2;
            tmp = y;
        }

        return sum;
    }
    public static void main(String[] args){
       TrapezoidalRulePi  trape = new TrapezoidalRulePi();

       trape.run(args);
    }
}