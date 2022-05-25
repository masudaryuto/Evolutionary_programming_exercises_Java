public class Lcm {

    void run(String[] args){
        Integer result = 0;

        for(Integer i=0; i<args.length; i++){

            if(i==0){
                result = lcm(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
            }
            else{
                result = lcm(result, Integer.valueOf(args[i]));
            }

        }
        
        String joined = String.join(", ", args);
        
        System.out.printf("lcm(%s) = %d%n", joined, result);
        
    }
    Integer lcm(Integer a, Integer b){
        
        return Math.abs(a*b) / gcd(a, b);
    }
    Integer gcd(Integer a, Integer b){
        
        if(b == 0){
            return a;
        }
        else{
            return gcd(b, a % b);
        }
    }
    
    
    public static void main(String[] args){
        Lcm lc = new Lcm();
        
        lc.run(args);
    }
}
/*
Integer fff(String[] args, Integer a){
    if(a >= args.length) return lcm(Integer.valueOf(args[0]), Integer.valueOf(args[1]))
    else return lcm(sameLcm(args, a+1), Integer.valueOf(args[a]));
}
*/
//sameLDcm(args, 0);