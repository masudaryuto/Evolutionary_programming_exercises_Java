// コマンド引数 コマンドで入力
public class ArgsPrinter{
    void run(String[] args){
        //配列を扱う場合は、length
        //文字列の長さを取得するには、length()
        for(Integer i = 0; i < args.length; i++) {
            // 何番目の要素として，何が配列の要素として格納されているかを確認しましょう．
            System.out.printf("%d: %s%n", i, args[i]);
        }
    }
    public static void main(String[] args){
        ArgsPrinter printer = new ArgsPrinter();
        printer.run(args);
    }
}
