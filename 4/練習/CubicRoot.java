public class CubicRoot {

    void run(String[] args){
        for(Integer i=0; i<args.length; i++){
            Double value = new Double(args[i]);
            Double result = calculate(value);
            System.out.printf("cubic_root(%7.6f) = %7.6f%n", value, result);
        }
    }

    Double calculate(Double n){
        Double threshold = 0.00001;

        Double x = 30.0;
        Double y = function(n, x);

        while(Math.abs(y) > threshold){
            Double slant = 3 * x * x;

            Double b = y - slant * x;
            x = -1 * b / slant;
            y = function(n, x);
        }

        return x;
    }
    Double function(Double n, Double x){
        return x * x * x - n;
    }
    
    public static void main(String[] args){
        CubicRoot cubic = new CubicRoot();

        cubic.run(args);
    }
}