import java.io.*;


public class Copy1{

    void run(String[] args) throws IOException{

        if(args.length <= 1){
            System.out.println("cp: コマンドライン引数には，少なくとも，コピー元，コピー先を指定する必要があります．");
        }
        else{
            File file1 = new File(args[0]);
            File file2 = new File(args[1]);

            this.copy(file1, file2);
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

        Copy1 copy = new Copy1();

        copy.run(args);
    }
}