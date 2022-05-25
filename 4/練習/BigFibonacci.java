import java.math.BigInteger;

public class BigFibonacci {

    void run(String[] args){
        
        Integer num = 10;
        if(args.length != 0){
            
            for(Integer i=0; i<args.length; i++){
                num = Integer.valueOf(args[i]);
                this.fib_math(num);
            }
        }
        else{
            this.fib_math(num);
        }
        
    }
    
    void fib_math(Integer num){
        BigInteger ans = new BigInteger("1");
        BigInteger t = new BigInteger("1");
        BigInteger tmp = new BigInteger("0");
    
        for(Integer i=1; i<num; i++){
            tmp = t;
    
            t = ans;
            ans = ans.add(tmp);
        }
        System.out.printf("fibonacci(%d) = %s%n", num, t);
        
    }
    
    public static void main(String[] args){

        BigFibonacci fib = new BigFibonacci();

        fib.run(args);
    }
}