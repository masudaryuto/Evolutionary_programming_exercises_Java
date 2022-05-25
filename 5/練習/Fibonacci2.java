public class Fibonacci2 {

    void run(String[] args){
        
        Integer num = 10;
        if(args.length != 0){

            for(Integer i=0; i<args.length; i++){
                num = Integer.valueOf(args[i]);
                Integer sum = this.fib_math(num);
                System.out.printf("fibonacci(%d) = %d%n", num, sum);
            }
        }
        else{
            Integer sum = this.fib_math(num);
            System.out.println(sum);
        }
        
    }
    
    //再起関数
    Integer fib_math(Integer n){

        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }

        return fib_math(n-1) + fib_math(n-2);

    }
    

    public static void main(String[] args){

        Fibonacci2 fib = new Fibonacci2();

        fib.run(args);
    }
}