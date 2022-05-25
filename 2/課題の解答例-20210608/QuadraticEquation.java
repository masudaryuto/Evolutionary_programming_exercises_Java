/**
 * 練習問題3
 * https://ksuap.github.io/2020spring/lesson02/assignments/#3-二次方程式の解
 *
 * @author Haruaki Tamada
 */
public class QuadraticEquation{
    void run(String[] args){
        Double a = new Double(args[0]);
        Double b = new Double(args[1]);
        Double c = new Double(args[2]);

        this.solve(a, b, c);
    }

    void solve(Double a, Double b, Double c){
        Double d = this.discriminant(a, b, c);
        if(d > 0){
            this.printRealAnswers(a, b, c, d);
        }
        else if(d < 0){
            this.printImagAnswers(a, b, c, d);
        }
        else{
            this.printDoubleRoot(a, b, c, d);
        }
    }

    void printRealAnswers(Double a, Double b, Double c, Double d){
        Double answer1 = -1 * b / (2 * a);
        Double answer2 = Math.sqrt(d) / (2 * a);
        System.out.printf("answer = %g, %g%n", answer1 + answer2, answer1 - answer2);
    }

    void printImagAnswers(Double a, Double b, Double c, Double d){
        Double real = -1 * b / (2 * a);
        Double imag = Math.sqrt(-1 * d) / (2 * a);
        System.out.printf("answer = %g + %g i, %g - %g i%n", real, imag, real, imag);
    }

    void printDoubleRoot(Double a, Double b, Double c, Double d){
        System.out.printf("answer = %g%n", -1 * b / (2 * a));
    }

    Double discriminant(Double a, Double b, Double c){
        return b * b - 4 * a * c;
    }

    public static void main(String[] args){
        QuadraticEquation qe = new QuadraticEquation();
        qe.run(args);
    }
}
