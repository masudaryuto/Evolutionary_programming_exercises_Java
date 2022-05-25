import java.util.ArrayList;

public class Factorizer {
    void run(String[] args){
        Integer num = 0;

        
        for(Integer i=0; i<args.length; i++){
            
            num = Integer.valueOf(args[i]);
            System.out.printf("%d: ", num);
            
            //因数分解と表示
            this.fact_cal(num);
        }
    }
    
    //因数分解と表示
    void fact_cal(Integer num){
        Primes primes = new Primes();
        ArrayList<Integer> list = primes.generatePrimes(200);

        for(Integer j=0; j<list.size(); j++){
            
            if(num % list.get(j) == 0){
                
                System.out.printf("%d ", list.get(j));
                
                if(num / list.get(j) == 1){
                    System.out.println();
                    break;
                }
                System.out.printf("x ");
    
                num /= list.get(j);
                j--;
            }
    
        }

    }


    public static void main(String[] args){
        Factorizer fac = new Factorizer();

        fac.run(args);
    }
}