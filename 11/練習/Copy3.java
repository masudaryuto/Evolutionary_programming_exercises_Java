//Arguments.java

import java.io.*;
import java.util.*;


public class Copy3 {

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

    void copy(File from, File to, Arguments arguments) throws IOException{
        
        //コピー処理
        BufferedReader in = new BufferedReader(new FileReader(from));

        PrintWriter out = new PrintWriter(new FileWriter(to));

        String line;
        while( (line = in.readLine()) != null ){

            out.print(line);
        }
        out.close();

        //-vの時
        if(arguments.verbose){
            System.out.printf("%s -> %s%n", from.getPath(), to.getPath() );
        }
        
    }


    public static void main(String[] args) throws IOException{

        Copy3 copy = new Copy3();

        copy.run(args);
    }
}