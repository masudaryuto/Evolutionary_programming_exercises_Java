import java.io.*;

public class Grep {

    void run(String[] args) throws IOException{
        String word = new String(args[0]);

        for(Integer i=1; i<args.length; i++){

            File file = new File(args[i]);

            this.read(word, file);
        }
    }

    void read(String word, File file) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file));

        String line;

        while((line = in.readLine()) != null){
            if(line.contains(word)){
                System.out.printf("%s:  %s%n", file.getName(), line);
            }
        }
        in.close();
    }


    public static void main(String[] args) throws IOException{

        Grep g = new Grep();

        g.run(args);
    }
    
}