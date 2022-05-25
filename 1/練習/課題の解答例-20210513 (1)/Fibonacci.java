/**
 * 練習問題5. Fibonacci数列 https://ksuap.github.io/2020spring/lesson01/assignments/#5-fibonacci数列
 * 
 * Fibonacci数列とは，次の漸化式で表される数列です． 
 *
 * このFibonacci数列を初項からコマンドライン引数で指定された項まで出力してみましょう．
 * コマンドライン引数が指定されなかった場合は，20項目（20項も出力結果に含む）までを出力するようにしてください．
 * クラス名は，Fibonacciとします．
 *
 * @author Haruaki Tamada
 */
public class Fibonacci{
    void run(String[] args){
        Integer to = 20;
        if(args.length > 0){
            to = new Integer(args[0]);
        }
        Integer prev1 = 1;
        Integer prev2 = 1;
        for(Integer i = 1; i <= to; i++){
            if(i == 1 || i == 2){
                System.out.print(1);
            }
            else{
                Integer item = prev1 + prev2;
                prev2 = prev1;
                prev1 = item;
                System.out.print(item);
            }
            System.out.print(" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.run(args);
    }
}
