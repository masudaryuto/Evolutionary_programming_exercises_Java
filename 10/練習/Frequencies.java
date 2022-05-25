import java.io.*;
import java.util.*;


public class Frequencies {

    HashMap<String, Integer> map = new HashMap<>();

    void run(String[] args) throws IOException{

        File file = new File(args[0]);


        this.read(file);
    }

    void read(File file) throws IOException{

        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while( (line = in.readLine()) != null ){

            this.initialize(line);

        }
        in.close();

        this.output();
    }

    void initialize(String line){

        String[] str = line.split(" ");

        for(Integer i=0; i<str.length; i++){

            if(map.get(str[i]) != null){

                map.put(str[i], map.get(str[i])+1);
            }
            else{
                map.put(str[i], 1);
            }
        }
    }

    void output(){

        for(Map.Entry<String, Integer> entry: map.entrySet()){

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
    

    public static void main(String[] args) throws IOException{
        Frequencies fre = new Frequencies();

        fre.run(args);
    }
}