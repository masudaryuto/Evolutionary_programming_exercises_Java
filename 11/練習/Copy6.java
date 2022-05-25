import java.io.*;
import java.util.*;

public class Copy6 {

    void run(String[] args) throws IOException{
        Arguments arguments = new Arguments();
        arguments.parse(args);

        if(arguments.help){
            this.printHelp();
        }
        else{
            this.performCopy(arguments);
        }

    }

    void printHelp(){
        System.out.println("Usage: java Copy3 [OPTIONS] from_file to_file");
        System.out.println("       java Copy3 [OPTIONS] from_file ... to_directory");
        System.out.println("OPTIONS");
        System.out.println("     -h: このメッセージを表示して終了する（help）．");
        System.out.println("     -i: コピー先のファイルが存在していた時，ユーザに上書き確認を求める（interactive）．");
        System.out.println("     -r: ディレクトリを再帰的にコピーする（recursive）．");
        System.out.println("     -u: コピー先のファイルが存在しない場合，もしくはコピー元のファイルの方が新しい場合のみコピーする（update）．");
        System.out.println("     -v: 実行内容を表示する（verbose）．");

    }

///////////////////////////
    void performCopy(Arguments args) throws IOException{
        
        // コマンドライン引数に必要な文のファイルが指定されているか確認する．
        // 出力先は，コマンドライン引数の一番最後の要素である．
        File to = new File(args.list.get(args.list.size() - 1));
        if(!to.exists() || to.isFile()){    // toが存在しない，もしくはファイルの場合．
            //System.out.println("A");
            this.copyToFile(args, to);
        }
        
        else if(to.isDirectory()){ // toがディレクトリの場合．
            this.copyToDirectory(args, to);
        }
        
        
    }

    void copyToDirectory(Arguments args, File to) throws IOException{
        for(Integer i=0; i<args.list.size() - 1; i++){ // argsを必要なだけ繰り返す．一番後ろの要素は省くことを忘れない．
            File from = new File(args.list.get(i));
            // fromがファイルの場合
            if(from.isFile()){
                File toFile = new File(to, from.getName());
                // copyメソッドを呼び出し，コピーする．
                this.copy(from, to, args);
            }
            // コマンドライン引数に recursive が指定された場合．
            if(args.recursive){
                // copyRecursiveメソッドを呼び出す．
                this.copyRecursive(from, from, to, args);
            }
            else{  // その他の場合
                System.out.printf("cp: %sはディレクトリです（コピーしません）%n", from.getName());
            }
        }
    }
    void copyToFile(Arguments args, File to) throws IOException{
        // args.list.size() が 2 より大きい場合，
        //     複数ファイルを１つのファイルにコピーできない旨を出力し，終了する．
        if(args.list.size() > 2){
            System.out.println("cp: 複数ファイルを一つのファイルにコピーできません．");
            return;
            
        }
        // そうでない場合，fromがディレクトリか否かを調べる．
        else{
            File from = new File(args.list.get(0));
            if(from.isDirectory()){  // from がディレクトリの場合．
                // toがファイルの場合
                if(to.isFile()){
                    System.out.println("cp: ディレクトリをファイルにコピーできません．");
                }
                // コマンドライン引数に recursive が指定された場合．
                if(args.recursive){
                    // copyRecursiveメソッドを呼び出す．
                    this.copyRecursive(from, from, to, args);
                }
                else{  // その他の場合
                    System.out.printf("cp: %sはディレクトリです（コピーしません）%n", from.getName());
                }
            }
            else{  // fromがファイルの場合．
                this.copy(from, to, args);
            }
        }
    }
    void copyRecursive(File base, File from, File to, Arguments args) throws IOException{
        for(File file: from.listFiles()){
            //System.out.println(file.getName());
            if(file.isDirectory()){
                // copyRecursiveメソッドを再帰呼び出し．
                this.copyRecursive(base, file, to, args);
            }
            else{
                File toFile = this.createToFile(base, file, to);
                // toFile の親ディレクトリ（File型）を取得する（toFile.getParentFile()）．
                File parent = toFile.getParentFile();

                // toFile の親ディレクトリが存在しない場合作成する（parent.mkdirs()）．
                if(!parent.exists()){
                    //dir2を作成。
                    parent.mkdirs();
                }

                this.copy(file, toFile, args);
            }
        }
    }
    File createToFile(File base, File from, File to) throws IOException{
        String basePath = base.getPath();
        String fromPath = from.getPath();
        String newPath = fromPath.substring(basePath.length() + 1);
        return new File(to, newPath);
    }
/////////////////

    Boolean isOverwriteAskToUser(File to) throws IOException{
        SimpleConsole console = new SimpleConsole();
        while(true){
            System.out.printf("%sを上書きしますか? (y/n [n]) ", to.getName());
            String line = console.readLine();
            line = line.trim();  // 入力された前後の空白を取り除く．
            if(Objects.equals(line, "y")){
                return true;
            }
            else if(Objects.equals(line, "") || Objects.equals(line, "n")){
                // nもしくは単に改行された場合
                System.out.println("上書きしません．");
                return false;
            }
            else{ // その他の値が入力された場合．
                System.out.println("yかnを入力してください．");
            }
        }
    }
    Boolean isOverwrite(File from, File to, Arguments args) throws IOException{
        //通常のファイルの時、
        if(to.exists() && to.isFile()){
            Boolean overwriteFlag = true;
            if(args.update){
                // toの方が新しい場合、上書きしない。
                //fromが更新が新しい場合、from > toとして、もし、そうなら1が返す。false=-1, equal = 0;
                if(new Date(from.lastModified()).compareTo(new Date(to.lastModified())) == -1){

                    overwriteFlag = false;
                }
            }
            
            //-iの指定があり、返信がnoの時、falseを返す。また、コピー先の方が新しい場合。
            if(overwriteFlag && args.interactive && !isOverwriteAskToUser(to)){
                overwriteFlag = false;
            }
            return overwriteFlag;
        }
        return true;
    }

    
    void copy(File from, File to, Arguments arguments) throws IOException{

        
        if(isOverwrite(from, to, arguments)){
            this.doCopy(from, to);
            //-vの時
            if(arguments.verbose){
                System.out.printf("%s -> %s%n", from.getPath(), to.getPath() );
            }
        }
        
        
    }
    
    void doCopy(File from, File to) throws IOException{
        
        //コピー処理
        BufferedReader in = new BufferedReader(new FileReader(from));
    
        PrintWriter out = new PrintWriter(new FileWriter(to));
    
        String line;
        while( (line = in.readLine()) != null ){
    
            out.print(line);
        }
        out.close();
        
    }

    public static void main(String[] args) throws IOException{

        Copy6 copy = new Copy6();

        copy.run(args);

    }

}