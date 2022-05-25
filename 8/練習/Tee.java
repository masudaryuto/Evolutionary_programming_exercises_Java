import java.io.*;


public class Tee {

    void run(String[] args) throws IOException{

        //FileOutputStream out = new FileOutputStream(args[0]);これで、out.write(line.bytes)だと改行されない。
        PrintWriter out = new PrintWriter(new FileWriter(args[0]));

        //cat xxxx | java Tee hoge これで、xxxxのファイルを読み込める。
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        this.copy(out, in);

    }

    void copy(PrintWriter out, BufferedReader in) throws IOException{

        
        String line;

        while( (line = in.readLine()) != null ){

            System.out.println(line);
            //1行ずつ文字列入力
            out.println(line);
            
        }
        out.close();

    }

    public static void main(String[] args) throws IOException{

        Tee t = new Tee();

        t.run(args);
    }
    
}