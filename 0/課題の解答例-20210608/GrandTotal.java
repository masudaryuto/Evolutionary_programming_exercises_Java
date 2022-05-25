/**
 * 練習問題４ https://ksuap.github.io/2018autumn/lesson01/assignments/#4-総和を求める
 * 
 * ループを用いて，1から10までの総和(10を含む)を求めましょう．次の手順で作成していきましょう．
 * 1. クラス名をGrandTotal とする．
 * 2. main メソッドを用意する．
 * 3. main メソッド内で Integer 型の変数 result を宣言する．
 * 4. result は初期値として0を代入しておく．
 * 5. main メソッド内で Integer 型のループ制御変数 i を宣言する．
 * 6. ループ制御変数 i を用いて1から10までループを作成する．
 * 7. 繰り返しごとに，result に i の値を加算していく．
 * ループ終了後，result の値を出力する．
 * ループはC言語と同じように書けます． for，while のどちらも利用できますので，試してみましょう．
 *
 * @author Haruaki Tamada
 */
public class GrandTotal{
    public static void main(String[] args){
        Integer sum = 0;
        Integer start = 1;
        Integer end = 10;

        // forを使って書く方法
        for(Integer i = start; i <= end; i++){
            sum = sum + i;
        }
        System.out.printf("%dから%dまでの総和は%dです．%n", start, end, sum);

        // while を使って書く方法
        sum = 0;
        Integer currentNumber = start;
        while(currentNumber <= end){
            sum += currentNumber;
            // 次の文のように書いても良い．
            // sum = sum + currentNumber;
            currentNumber++;
        }
        System.out.printf("%dから%dまでの総和は%dです．%n", start, end, sum);
    }
}
