import java.util.Objects;

public class Combination{

    void run(String[] args){
        Integer ans = 0;
        if(args.length == 1){
            System.out.printf("java Combination n k%n");
        }
        else{
            ans = this.com_math(args);

            System.out.printf("%sC%s = %d%n", args[0], args[1], ans);
        }
        
    }
    
    Integer com_math(String[] args){
        Integer ans = 0;
        Integer n=0;
        Integer k=0;
        n = Integer.valueOf(args[0]);
        k = Integer.valueOf(args[1]);
        if(n < k || k==0 || Objects.equals(n, k) ){
            ans = 1;
        }
        else{
            ans = this.combination(n, k);
        }

        return ans;

    }


    Integer combination(Integer n, Integer k){
        
        if(Objects.equals(k, 0) || Objects.equals(k, n)){
            return 1;
        }
        if( n < k){
            return 0;
        }
        
        return combination(n-1, k-1) + combination(n-1, k);
    }


    public static void main(String[] args){

        Combination com = new Combination();

        com.run(args);
    }
}