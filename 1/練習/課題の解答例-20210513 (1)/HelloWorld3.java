import java.util.Objects;
/**
 * 練習問題1 https://ksuap.github.io/2020spring/lesson01/assignments/#2-helloworld-改2
 * 
 * コマンドライン引数で与えられた人に，挨拶しましょう． 
 * 基本的には，HelloWorld 改と同じですが，もし， "World"が指定されたら，"Hi, World"と気さくに挨拶してください．
 * クラス名は，HelloWorld3 とし，クラス定義の基本形に従ってプログラムを書いてください．
 * コマンドライン引数も参考になるでしょう．
 *
 * @author Haruaki Tamada
 */
public class HelloWorld3{
    void run(String[] args){
        if(args.length == 0){
            System.out.println("Hello, World");
        }
        else{
            if(Objects.equals(args[0], "World")){
                System.out.println("Hi, World");
            }
            else{
                System.out.println("Hello, " + args[0]);
            }
        }
    }
    public static void main(String[] args){
        HelloWorld3 hello = new HelloWorld3();
        hello.run(args);
    }
}
