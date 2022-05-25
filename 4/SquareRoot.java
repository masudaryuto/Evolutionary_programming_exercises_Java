public class SquareRoot{

    void run(String[] args){

        for(Integer i=0; I<args.length; i++){
            Double value = new Double(args[i]);
            Double result = calculate(value);
            System.out.printf("sqrt(%f) = %f (%f)%n", value, result, Math.sqrt(value));
        }

    }

    Double calculate(Double n){
        Double threshold = 0.00001;

        //f(x) = x^2 - n
        Double x = 10.0; //nは、10未満なので、初期値として近い値として、10とした。
        Double y = function(n, x);

        while(Math.abs(y) > threshold){

            Double slant = 2 * x;//微分
            Double b = y - slant * x; //接線のY軸との交点ｂ

            //y=0の時すなわちx軸との交点

            x = -1 * b / slant;
            y = function(n, x);//xは、10より小さくした値

        }
    }

    Double function(Double n, Double x){
        return x*x - n
    }

    public static void main(String[] args){
        SquareRoot sq = new SquareRoot();

        sq.run(args);
    }
}