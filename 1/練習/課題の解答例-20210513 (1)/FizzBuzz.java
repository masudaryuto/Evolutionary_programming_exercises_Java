/**
 * 練習問題4. FizzBuzz https://ksuap.github.io/2020spring/lesson01/assignments/#4-fizzbuzz
 * 
 * FizzBuzz は1から特定の値までの数値を順に出力します． 
 * ただし，3の倍数の時は，数値の代わりに Fizz という文字列を，
 * 5の倍数の時は，数値の代わりに Buzz という文字列を， 
 * 3と5の公倍数の時は，数値の代わりに FizzBuzz という文字列を出力します．
 * クラス名は，FizzBuzzとしてください．
 *
 * @author Haruaki Tamada
 */
public class FizzBuzz{
    void run(String[] args){
        Integer to = 15;
        if(args.length != 0){
            to = new Integer(args[0]);
        }

        for(Integer i = 1; i <= to; i++){
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(i % 3 == 0){
                System.out.println("Fizz");
            }
            else if(i % 5 == 0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
        }
    }
    public static void main(String[] args){
        FizzBuzz fizzbuzz = new FizzBuzz();
        fizzbuzz.run(args);
    }
}
