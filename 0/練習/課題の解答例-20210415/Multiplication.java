/**
 * 練習問題5 https://ksuap.github.io/2020spring/lesson00/assignments/#3-九九を表示する
 * 
 * 出力例のように，九九を表示するプログラムを作成しましょう．
 * クラス名を Multiplication とします．
 *
 * @author Haruaki Tamada
 */
public class Multiplication{
    public static void main(String[] args){
        // １行目はこのように出力しても良い．
        System.out.println("    1  2  3  4  5  6  7  8  9");
        // 繰り返しを使って書くなら，次のようにする．
        // System.out.print("  ");
        // for(Integer i = 1; i <= 9; i++){
        //     System.out.print("  " + i);
        // }
        // System.out.println();

        for(Integer i = 1; i <= 9; i++){
            // 文字列は，+ 記号で連結できる．
            System.out.print(" " + i + " ");
            for(Integer j = 1; j <= 9; j++){
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }
    }
}
