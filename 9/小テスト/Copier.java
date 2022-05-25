import java.io.*;

public class Copier{

    void run(String[] args) throws IOException{

        if(args.length != 2){
            System.out.println("java Copier <from> <to>");
            return;
        }
        FileInputStream in = new FileInputStream(args[0]);

        FileOutputStream out = new FileOutputStream(args[1]);

        copy(in, out);

    }

    void copy(FileInputStream in, FileOutputStream out) throws IOException{

        Integer data;

        while( (data = in.read()) != -1 ){
            out.write(data);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException{

        Copier co = new Copier();

        co.run(args);
    }
}