import java.io.File;

public class ListFiles{

    void run(String[] args){

        for(String arg: args){
            File thisFile = new File(arg);
            this.listFile(thisFile);

        }
        //入力がないなら、「ディレクトリ」
        if(args.length == 0){
            this.listFile(new File("."));
        }
        
    }

    void listFile(File target){
        //指定されたディレクトリが存在するか？
        if(this.isExist(target)){
            if(target.isDirectory()){ // 引数のファイルがディレクトリの場合
                this.listFilesInDirectory(target);
            }
            else{
                System.out.printf("%s%n", target.getName()); // 引数のファイルの名前を出力する．
            }
        }
    }
    void listFilesInDirectory(File dir){
        // 引数に受け取ったディレクトリが持つファイル，ディレクトリの一覧を取得する．
        File[] files = dir.listFiles();// 配列？
        // for文で files を繰り返す．
        for(File file: files){
            System.out.printf("%s%n", file.getName()); //.getName()ディレクトリの名前を取得
            // 配列の各要素であるファイルの名前を出力する．
        }
    }
    Boolean isExist(File target){
        if(!target.exists()){ // ファイルが存在しない場合
            // 指定されたファイル名は存在しない旨を出力する．
            System.out.printf("ListFiles: %s: No such file or directory%n", target.getName());
        }
        return target.exists(); // ファイルが存在するかを返す（if文の条件の反転）．
    }

    public static void main(String[] args){

        ListFiles list = new ListFiles();

        list.run(args);
    }
}