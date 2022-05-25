public class QuadraticEquation {

    void run(String[] abc){
        //判別式
        Double a = Double.valueOf(abc[0]);
        Double b = Double.valueOf(abc[1]);
        Double c = Double.valueOf(abc[2]);
        Double d = this.discriminant(a, b, c);

        if(d > 0){
            System.out.printf("answer = %f, %f%n", (-b + Math.sqrt(d))/2*a, (-b - Math.sqrt(d)/2*a));
        }
        else if(d == 0){
            System.out.printf("answer = %f%n", (-b)/(2*a));
    
        }
        else if(d < 0){
            System.out.printf("answer = %f + %f i, %f - %f i%n", -b/2*a, Math.sqrt(-d)/2*a, -b/2*a, Math.sqrt(-d)/2*a);
        }
    }
    Double discriminant(Double a, Double b, Double c){

        return Double.valueOf((b*b) - (4*a*c));
        

    }
    public static void main(String[] args){
        QuadraticEquation math = new QuadraticEquation();

        math.run(args);
    }
}