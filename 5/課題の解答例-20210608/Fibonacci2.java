public class Fibonacci2{
    void run(String[] args){
        for(Integer i = 0; i < args.length; i++){
            calculate(new Integer(args[i]));
        }
        if(args.length == 0){
            calculate(10);
        }
    }
    void calculate(Integer index){
        Integer answer = fibonacci(index);
        System.out.printf("fibonacci(%d) = %d%n", index, answer);
    }
    Integer fibonacci(Integer index){
        if(index == 0 || index == 1){
            return index;
        }
        return fibonacci(index - 1) + fibonacci(index - 2);
    }
    
    public static void main(String[] args){
        Fibonacci2 fibonacci = new Fibonacci2();
        fibonacci.run(args);
    }
}
