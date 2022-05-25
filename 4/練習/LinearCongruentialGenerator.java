import java.util.ArrayList;

public class LinearCongruentialGenerator{

    void run(String[] args){
        Integer n = 10;
        if(args.length != 0){
            n = Integer.valueOf(args[0]);
        }

        ArrayList<Double> list = this.random(n);

        System.out.println(list);
    }
    
    ArrayList<Double> random(Integer max){
        ArrayList<Double> results = new ArrayList<>();
        Integer a = 107;
        Integer xn = 19;
        Integer b = 1;
        Integer m = 65535;

        // a, b, m にも初期値を代入する．
        // 以下の2行を指定回数繰り返す．
        for(Integer i=0; i<max; i++){
            // 線形合同法の計算式に従い，X_n+1 を求める．
            xn = (a*xn + b) % m;

            // xnを0.0〜1.0の範囲に変換してリストに追加する．
            results.add(1.0 * xn / m);
        }
        return results;
      }
    

    public static void main(String[] args){

        LinearCongruentialGenerator line = new LinearCongruentialGenerator();

        line.run(args);
    }
}