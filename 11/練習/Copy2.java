import java.io.*;

public class Copy2 {

    void run(String[] args) throws IOException{

        File to = new File(args[args.length - 1]);

        //ファイルの場合。
        if(!to.isDirectory() || !to.exists()){
            if(args.length > 2){
                System.out.println("cp: 複数ファイルを一つのファイルにコピーできません．");
            }
            else{
                File from = new File(args[0]);
                this.copy(from, to);
            }
            
        }
        //ディレクトリの場合(フォルダ)
        else if(to.isDirectory()){

            for(Integer i=0; i<args.length - 1; i++){

                File from = new File(args[i]);

                //File(File parent, String child)、to/from.getName() -> directory/from_file1?
                File toFile = new File(to, from.getName());

                this.copy(from, toFile);
            }
        }
    }

    void copy(File from, File to) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(from));

        PrintWriter out = new PrintWriter(new FileWriter(to));

        String line;
        while( (line = in.readLine()) != null ){

            out.print(line);
        }
        out.close();
    }


    public static void main(String[] args) throws IOException{

        Copy2 copy = new Copy2();

        copy.run(args);
    }
    
}