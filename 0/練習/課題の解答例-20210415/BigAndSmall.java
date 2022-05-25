/**
 * 練習問題1 https://ksuap.github.io/2020spring/lesson00/assignments/#1-big-small
 *
 * 0から1までの Double 型の乱数を発生させ，その値が0.5より小さければ Small，
 * 0.5以上であれば Big と出力するプログラムを作成してください．
 * 0から1までの Double 型の乱数は，次のコードで得られます．
 *
 *     Double value = Math.random();
 *
 * @author Haruaki Tamada
 */
public class BigAndSmall{
    public static void main(String[] args){
        Double value = Math.random();
        // valueには0から1の乱数が代入されている．
        System.out.printf("value: %f: ", value);

        if(value < 0.5){
            System.out.println("Small");
        }
        else{
            System.out.println("Big");
        }
    }
}
