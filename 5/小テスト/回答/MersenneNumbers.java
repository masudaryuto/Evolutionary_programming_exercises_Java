/**
 * MersenneNumbers
 * ===============
 *
 * 問題文
 * ------
 *
 * 指定されたnまでのメルセンヌ数を求めるプログラムを作成してください．
 * クラス名は，MersenneNumbers_学生証番号 としてください．
 * n番目のメルセンヌ数は 2^n - 1（2のべき乗よりも1だけ小さい自然数）で求められます．
 *
 * また，次の条件を満たすよう，段階を踏んでプログラムを作成してください．
 * 1. Integer 型でメルセンヌ数を求める．
 *     * 32以上はInteger型の範囲を超える．
 *     * 2^n（2のn乗）を求めるために powerOfTwo メソッドを作成する．
 * 2. BigInteger 型を用いてメルセンヌ数を求める．
 *     * 2のべき乗を求めるには，BigInteger型のpowメソッドを利用できる．
 *         * 2を表すBigInteger型に対して，pow メソッドに n を渡すことで，2のn乗が求められる．
 * 3. BigInteger型の isProbablePrime メソッドを用いて，求めたメルセンヌ数が素数かどうかを判定する．
 *     * 引数には n を渡せば良い．
 *           BigInteger result = mersenne(n); // n番目のメルセンヌ数を求める．
 *           if(result.isProbablePrime(n)){
 *               System.out.print(" probable prime");
 *           }
 * 
 * 実行例
 * ------
 * 
 * 途中をいくつか飛ばして表示しています．
 * 
 * $ java MersenneNumbers
 * 2^ 1 - 1 = 1 (1)
 * 2^ 2 - 1 = 3 (3) probable prime
 * // 途中省略
 * 2^ 9 - 1 = 511 (511)
 * 2^10 - 1 = 1023 (1023)
 * $ java MersenneNumbers 127
 * 2^ 1 - 1 = 1 (1)
 * // 途中省略
 * 2^31 - 1 = 2147483647 (2147483647) probable prime # <- Integer 型の限界
 * 2^32 - 1 = 4294967295 (-1)
 * // 途中省略
 * 2^89 - 1 = 618970019642690137449562111 (-1) probable prime
 * // 途中省略
 * 2^107 - 1 = 162259276829213363391578010288127 (-1) probable prime
 * // 途中省略
 * 2^127 - 1 = 170141183460469231731687303715884105727 (-1) probable prime
 * 
 * これ以上の素数を確認したい場合は，Wikipedia のメルセンヌ数のページを参照してください．
 * https://ja.wikipedia.org/wiki/%E3%83%A1%E3%83%AB%E3%82%BB%E3%83%B3%E3%83%8C%E6%95%B0
 *
 * 解説
 * ----
 *
 * 1. BigInteger が利用できるか．
 *     * 通常の +, - が利用できない．
 *     * https://ksuap.github.io/2020autumn/lesson04/biginteger
 */
import java.math.BigInteger;

public class MersenneNumbers{
    void run(String[] args){
        Integer count = 10;
        if(args.length != 0){
            count = new Integer(args[0]);
        }
        calculate(count);
    }

    void calculate(Integer max){
        for(Integer i = 1; i <= max; i++){
            Integer v1 = this.powerOfTwo(i) - 1;
            BigInteger v2 = this.mersenne(i);
            printValue(i, v1, v2);
        }
    }

    void printValue(Integer i, Integer v1, BigInteger v2){
        System.out.printf("2^%2d - 1 = %s (%d)", i, v2, v1);
        if(v2.isProbablePrime(i)){
            System.out.print(" probable prime");
        }
        System.out.println();
    }

    BigInteger mersenne(Integer n){
        BigInteger two = BigInteger.valueOf(2);
        BigInteger one = BigInteger.ONE;

        return two.pow(n).subtract(one);
    }

    Integer powerOfTwo(Integer max){
        Integer result = 1;
        for(Integer i = 0; i < max; i++){
            result = 2 * result;
        }
        return result;
    }

    Integer powerOfTwoRecursive(Integer max){
        if(max == 0){
            return 1;
        }
        return 2 * powerOfTwo(max - 1);
    }

    public static void main(String[] args){
        MersenneNumbers primes = new MersenneNumbers();
        primes.run(args);
    }
}
