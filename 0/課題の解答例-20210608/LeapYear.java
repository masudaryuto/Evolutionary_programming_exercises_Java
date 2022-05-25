/**
 * 練習問題3 https://ksuap.github.io/2020spring/lesson00/assignments/#2-うるう年の判定
 * 
 * 与えられた年がうるう年であるか否かを判定しましょう． うるう年は，次のように判定します．
 * - 西暦で表される年が 4 で割り切れたらうるう年である．
 * - ただし，そのうち，100で割り切れる年はうるう年ではない．
 * - ただし，さらに，400で割り切れる年はうるう年である．
 * 2000, 2004, 2016年はうるう年，2100，2015, 1900年はうるう年ではありません．
 *
 * @author Haruaki Tamada
 */
public class LeapYear{
    public static void main(String[] args){
        Integer year = 2016;
        Boolean leapYear = false;
        // ここに判定処理を書いていく．

        // 正攻法
        if(year % 4 == 0){
            if(year % 100 != 0){
                leapYear = true;
            }
            else{
                if(year % 400 == 0){
                    leapYear = true;
                }
                else{
                    leapYear = false;
                }
            }
        }

        // 別解1
        // if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
        //     leapYear = true;
        // }
        // 別解2
        // leapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
 
        if(leapYear){ // leapYearがtrueの場合．
            System.out.printf("%d年はうるう年です．%n", year);
        }
        else{
            System.out.printf("%d年はうるう年ではありません．%n", year);
        }
    }
}
