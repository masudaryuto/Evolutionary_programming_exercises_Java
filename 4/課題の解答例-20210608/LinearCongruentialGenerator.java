/**
 * LinearCongruentialGenerator
 * =========
 *
 * 問題文
 * ------
 * 
 * 線形合同法（Linear Congruential Generators）により，乱数を求めるプログラムを作成してください．
 * 線形合同法は，擬似乱数を発生させるアルゴリズムです．以下の漸化式で求めます．
 * コマンドライン引数で与えられた回数だけ再帰呼び出しで繰り返して，値を返してください．
 * コマンドライン引数で値が
 *
 * X_{n+1}=(A X_n + B) mod M
 * 
 * A，B，Mは定数です．次の値を入れて乱数を生成してください．
 * A: 自分の誕生日（月日．3桁もしくは4桁．）
 * B: 1
 * M: 65535
 * X_0: 自分の年齢
 *
 * 完成すれば，A, B, M, X_0の値を変更して結果がどのように変わるかを確認しましょう．
 *
 * 実行結果
 * -------
 * 
 * 実際の出力結果は，各自で異なる値となります．
 *
 * $ java LinearCongruentialGenerator
 * [0.07386892500190738, 0.9381551842526894, 0.5167925535973145, 0.5319142442969406, 0.3616388189517052, 0.7583123521782253, 0.7558098725871671, 0.45300984206912337, 0.8142061493858244, 0.5189593347066453]
 * $ java LinearCongruentialGenerator 2
 * [0.07386892500190738, 0.9381551842526894]
 * $ java LinearCongruentialGenerator 5
 * [0.07386892500190738, 0.9381551842526894, 0.5167925535973145, 0.5319142442969406, 0.3616388189517052]
 * 
 * 注意点　
 * ------
 *
 * 求める乱数値の範囲は[0, 1)であることに注意しましょう．
 * 0.0は含み，1.0は含めません．
 * そのために，上記の漸化式で出力される値の範囲に注意してください．
 * また，Integer 型同士で割り算を行っても小数点以下は切り捨てられます．
 * Double型に変換してから計算してください．
 */
import java.util.ArrayList;

public class LinearCongruentialGenerator{
    void run(String[] args){
        Integer count = 10;
        if(args.length > 0){
            count = new Integer(args[0]);
        }

        ArrayList<Double> randomValues = generate(count);
        System.out.println(randomValues);
    }

    ArrayList<Double> generate(Integer length){
        ArrayList<Double> list = new ArrayList<>();
        Integer a = 121;
        Integer b = 1;
        Integer m = 65535;
        Integer value = 40;

        for(int i = 0; i < length; i++){
            value = (value * a + b) % m;
            list.add(new Double(value) / m);
        }
        return list;
    }

    public static void main(String[] args){
        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator();
        lcg.run(args);
    }
}
