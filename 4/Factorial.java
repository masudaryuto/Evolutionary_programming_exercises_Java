import java.math.BigInteger;

public class Factorial {

    void run(String[] args){
        Integer n = 0;

        for(Integer i=0; i<args.length; i++){
            n = Integer.valueOf(args[i]);

            fac_print(n);
        }
    }

    void fac_print(Integer n){
        BigInteger sum = new BigInteger("1");

        BigInteger tmp = new BigInteger("0");

        for(Integer i=n; i>0; i--){

            tmp = BigInteger.valueOf(i);

            sum = sum.multiply(tmp);
            
        }
        System.out.printf("%d! = %s%n", n, sum);

    }
    

    public static void main(String[] args){

        Factorial fac = new Factorial();

        fac.run(args);
    }
}