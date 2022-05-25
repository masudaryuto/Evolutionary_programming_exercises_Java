/**
 * 練習問題4
 * https://ksuap.github.io/2020spring/lesson02/assignments/#4-モンテカルロ法によるpiの計算
 * 
 * @author Haruaki Tamada
 */
public class MonteCarloPi{
    void run(String[] args){
        // ループ回数のデフォルト値
        Integer loop = 1000;
        // コマンドライン引数で値が指定されたとき．
        if(args.length > 0){
            loop = new Integer(args[0]);
        }

        Double pi = this.computePi(loop);
        System.out.printf("pi = %f%n", pi);
    }

    Double computePi(Integer loop){
        Integer hit = 0;
        for(Integer i = 0; i < loop; i++){
            Double x = Math.random();
            Double y = Math.random();

            Double length = Math.sqrt(x * x + y * y);
            if(length < 1.0){
                hit = hit + 1;
            }
        }
        return hit * 4.0 / loop;
    }

    public static void main(String[] args){
        MonteCarloPi pi = new MonteCarloPi();
        pi.run(args);
    }
}
