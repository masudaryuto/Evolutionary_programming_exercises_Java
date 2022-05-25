/**
 * 練習問題5
 * https://ksuap.github.io/2020spring/lesson02/assignments/#5-台形公式による積分計算を利用したpiの計算
 *
 * 台形公式による積分計算を利用したPIの計算．
 *
 * Example
 * * $ java TrapezoidalRulePi 
 * pi = 3.141591477698228
 * $ java TrapezoidalRulePi 0.01
 * pi = 3.1375956845831103
 * $ java TrapezoidalRulePi 0.001
 * pi = 3.1414660465553967
 * $ java TrapezoidalRulePi 0.0000001
 * pi = 3.141592654152668
 *
 * @author Haruaki Tamada
 */
public class TrapezoidalRulePi{
    void run(String[] args){
        Double width = this.getWidth(args);
        Double pi = this.computePi(width);
        System.out.println("pi = " + pi);
    }

    Double computePi(Double width){
        Double sum = 0.0;
        for(Double i = width; i < 1.0; i += width){
            Double left = this.calculateHeight(i - width);
            Double right = this.calculateHeight(i);

            // 面積を求める．
            Double area = (left + right) * width / 2;
            // 面積を総和に追加する．
            sum += area;
        }
        // 総和は，pi/4 であるため，4を掛ける．
        return sum * 4;
    }

    Double getWidth(String[] args){
        Double width = 0.0001;
        if(args.length > 0){
            width = new Double(args[0]);
        }
        return width;
    }

    // xが与えられた時，yの値を返す．
    Double calculateHeight(Double x){
        return Math.sqrt(1 - x * x);
    }

    public static void main(String[] args){
        TrapezoidalRulePi pi = new TrapezoidalRulePi();
        pi.run(args);
    }
}
