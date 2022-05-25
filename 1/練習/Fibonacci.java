public class Fibonacci {

    void run(String[] args){
        
        Integer num = 20;
        if(args.length != 0){
            num = Integer.valueOf(args[0]);
            //num = new Integer(args[0])
        }
        Integer ans = 1;
        Integer t = 1;
        Integer tmp;

        System.out.printf("%d ", ans);

        for(Integer i=1; i<num; i++){
            tmp = t;
            System.out.printf("%d ", ans);

            t = ans;
            ans += tmp;

        }
        System.out.printf("%n");

    }
    public static void main(String[] args){
        Fibonacci fib = new Fibonacci();

        fib.run(args);
    }
}