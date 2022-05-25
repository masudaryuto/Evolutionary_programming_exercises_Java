public class Lcm{
    void run(String[] args){
        Gcd gcd = new Gcd();
        Integer result = Integer.valueOf(args[0]);
        for(Integer i = 1; i < args.length; i++){
            result = lcm(gcd, result, Integer.valueOf(args[i]));
        }
        printResult(args, result);
    }

    Integer lcm(Gcd gcd, Integer a, Integer b){
        return Math.abs(a * b) / gcd.gcd(a, b);
    }

    void printResult(String[] args, Integer result){
        System.out.printf("lcm(%s)=%d%n", String.join(", ", args), result);
    }

    public static void main(String[] args){
        Lcm lcm = new Lcm();
        lcm.run(args);
    }
}
