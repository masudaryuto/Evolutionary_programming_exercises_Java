import java.math.BigInteger;


public class MersenneNumbers {
    void run(String[] args){
        Integer n = 10;
        if(args.length != 0){

            n = Integer.valueOf(args[0]);
        }

        this.print_mersenne(n);
    }
    
    void print_mersenne(Integer n){
        for(Integer i=1; i<=n; i++){
    
            BigInteger result = mersenne(i);
    
            if(result.isProbablePrime(n)){
                System.out.printf(" probably prime");
            }
    
            System.out.println();
    
        }

    }

    BigInteger mersenne(Integer i){
        

        Integer Int_result = powerOfTwo(i) - 1;

        BigInteger result = Big_powerOfTwo(i).subtract(BigInteger.ONE);

        System.out.printf("2^ %d - 1 = %s (%s)", i, result, Int_result);

        return result;

    }

    Integer powerOfTwo(Integer n){

        Integer sum = 1;


        for(Integer i=0; i<n; i++){
            sum *= 2;
        }

        return sum;
    }

    BigInteger Big_powerOfTwo(Integer n){

        
        BigInteger sum = BigInteger.TWO.pow(n);

        return sum;
    }


    public static void main(String[] args){

        MersenneNumbers mers = new MersenneNumbers();

        mers.run(args);
    }
}