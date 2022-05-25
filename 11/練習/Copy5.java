import java.io.*;
import java.util.*;

public class Copy5 {

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

    void performCopy(Arguments arguments) throws IOException{
        //this.isOverwrite(new File(arguments.list.get(0)), arguments);


       // File to = new File(args[args.length - 1]);

       File to = new File( arguments.list.get(arguments.list.size() - 1 ) );

        //ファイルの場合。
        if(!to.isDirectory() || !to.exists()){
            if(arguments.list.size() > 2){
                System.out.println("cp: 複数ファイルを一つのファイルにコピーできません．");
            }
            else{
                File from = new File( arguments.list.get(0));
                this.copy(from, to, arguments);
            }
            
        }
        //ディレクトリの場合(フォルダ)
        else if(to.isDirectory()){

            for(Integer i=0; i< arguments.list.size() - 1; i++){

                File from = new File(arguments.list.get(i));

                //File(File parent, String child)、to/from.getName() -> directory/from_file1?
                File toFile = new File(to, from.getName());

                this.copy(from, toFile, arguments);
            }
        }
    }
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

        Copy5 copy = new Copy5();

        copy.run(args);

    }

    
}