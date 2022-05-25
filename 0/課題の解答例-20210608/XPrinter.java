/**
 * 練習問題7. https://ksuap.github.io/2020spring/lesson00/assignments/#4-xの描画
 *
 * 繰り返しを利用し，出力例の模様を出力してください．
 * クラス名は XPrinter としてください．
 *
 * @author Haruaki Tamada
 */
public class XPrinter{
    public static void main(String[] args){
        for(Integer i = 0; i < 10; i++){
            for(Integer j = 0; j < 10; j++){
                // i と j が一致するとき，もしくは，(i + j) が 9のときに出力する．
                if(i == j || (i + j) == 9){
                    System.out.print("X");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
