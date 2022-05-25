public class CubicRoot{
    void run(String[] args){
        for(Integer i = 0; i < args.length; i++){
            Double value = new Double(args[i]);
            Double result = calculate(value);
            System.out.printf("cubic_root(%f) = %f%n", value, result);
        }
    }
    Double calculate(Double n){
        Double threshold = 0.00001;

        Double x = 10.0; // 初期値 x0
        Double y = function(n, x);

        // ここにニュートン法のプログラムを書きましょう．
        while(y > threshold){
            Double slant = 3 * x * x;
            // y = a x + b が接線の式．傾きaは3x * xとなる．
            // bを求める．
            Double b = y - slant * x;
            // y = 0 の時のx座標を求める．
            x = -1 * b / slant;
            y = function(n, x);
        }

        return x;
    }
    // x^3 - n を計算するメソッド．
    Double function(Double n, Double x){
        return x * x * x - n;
    }

    public static void main(String[] args){
        CubicRoot curt = new CubicRoot();
        curt.run(args);
    }
}
