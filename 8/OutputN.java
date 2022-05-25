import java.io.File;
import java.io.IOException;

import java.io.Reader;
import java.io.Writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import java.io.FileWriter;

public class OutputN {

    void run(String[] args) throws IOException{

        String message = args[0];
        File file1 = new File(args[1]);

        this.writeWithWriter(file1, message);

    }

    void writeWithWriter(File file, String message) throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter(file)); // (2)
        // 上記の(2)の処理を区別して書くと次のような処理になる．
        //     FileWriter fwriter = new FileWriter(file);
        //     PrintWriter out = new PrintWriter(fwriter);

        Integer max = Integer.valueOf(message);
        for(Integer i=0; i<max; i++){
            out.println(i);
        }
        out.close();
    }

    public static void main(String[] args) throws IOException{

        OutputN out = new OutputN();

        out.run(args);
    }
}