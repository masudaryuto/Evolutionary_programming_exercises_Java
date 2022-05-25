public class Factorial{

    void run(String[] args){
        Integer number = Integer.valueOf(args[0]);
        Integer factorial = this.factorial(number);
        
        System.out.printf("%d! = %d%n", number, factorial);
    }
    
    Integer factorial(Integer number){
        Integer factorial = 1;
        for(Integer i=1; i <= number; i++){
            factorial *= i;
            // number の階乗を計算する．
        }

        return factorial;
    }
    // mainメソッドは省略
    public static void main(String[] args){
        
        Factorial fact = new Factorial();

        fact.run(args);
    }
}
