/**
 * 練習問題3. https://ksuap.github.io/2020spring/lesson01/assignments/#3-階乗
 * 
 * コマンドライン引数であたえられた数値の階乗を計算するプログラムを作成してください．
 * nの階乗は，n!=n×(n−1)×(n−2)...2×1 で求められます．
 *
 * @author Haruaki Tamada
 */
public class Factorial{
    void run(String[] args){
        // String型の値をInteger型に変換する．
        Integer number = new Integer(args[0]);
        Integer factorial;
        // number の階乗を計算する．
        // 初期値を代入する．
        factorial = 1;
        for(Integer i = 1; i <= number; i++){
            factorial = factorial * i;
        }

        System.out.printf("%d! = %d%n", number, factorial);
    }
    public static void main(String[] args){
        Factorial factorial = new Factorial();
        factorial.run(args);
    }
}
