/**
 * 練習問題1 https://ksuap.github.io/2020spring/lesson01/assignments/#1-helloworld-改
 * 
 * コマンドライン引数で与えられた人に，挨拶しましょう． 
 * もし，誰も指定されない場合は，"Hello, World"と出力してください．
 * クラス名は，HelloWorld2 とし，クラス定義の基本形に従ってプログラムを書いてください．
 * コマンドライン引数も参考になるでしょう．
 *
 * @author Haruaki Tamada
 */
public class HelloWorld2{
    void run(String[] args){
        if(args.length == 0){
            System.out.println("Hello, World");
        }
        else{
            System.out.println("Hello, " + args[0]);
        }
    }
    public static void main(String[] args){
        HelloWorld2 hello = new HelloWorld2();
        hello.run(args);
    }
}
