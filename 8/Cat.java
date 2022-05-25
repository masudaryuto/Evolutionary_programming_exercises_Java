import java.io.File;
import java.io.IOException;

import java.io.Reader;
import java.io.Writer;

import java.io.BufferedReader;
import java.io.FileReader;

public class Cat{

    void run(String[] args) throws IOException{
        File thisfile = new File(args[0]);

        this.readMethod(thisfile);
    }

    void readMethod(File file) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file)); // (1)
        // 上記の(1)の処理を区別して書くと，次のような処理になる．
        //     FileReader freader = new FileReader(file);
        //     BufferedReader in = new BufferedReader(freader);
        String line;
        while((line = in.readLine()) != null){
            // １行ずつ処理を行う．
            System.out.println(line);
        }
        in.close();
    }
    public static void main(String[] args) throws IOException{

        Cat cat = new Cat();

        cat.run(args);
    }
}