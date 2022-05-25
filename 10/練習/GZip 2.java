import java.io.*;
import java.util.*;
import java.util.zip.*;



public class GZip{

    void run(String[] args) throws IOException {

        for(Integer i=0; i < args.length; i++){

            this.process(args[i]);
        }
    }

    void process(String arg) throws IOException{
        FileInputStream in = new FileInputStream(new File(arg));
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(new File(arg+".gz")));

        Integer data;

        while((data = in.read()) != -1){

            out.write(data);
        }
        in.close();
        out.close();

        File in_file = new File(arg);
        File out_file = new File(arg+".gz");


        System.out.printf("%s: %s bytes -> %s bytes (%.5s%%) %n", arg, in_file.length(), out_file.length(), 100.0*out_file.length()/in_file.length());
    }

    public static void main(String[] args) throws IOException{

        GZip g = new GZip();

        g.run(args);
    }
}