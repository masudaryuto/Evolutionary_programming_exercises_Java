import java.io.*;
import java.util.*; //array

public class Tail{

    void run(String[] args) throws IOException{

        Integer num = Integer.valueOf(args[0]);
        File file = new File(args[1]);

        this.read(num, file);

    }

    void read(Integer num, File file) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file));

        ArrayList<String> list = new ArrayList<String>();

        String line;

        while( (line = in.readLine()) != null){

            list.add(line);
        }
        in.close();

        this.output(list, num);

    }

    void output(ArrayList<String> list, Integer num){

        if(num <= list.size()){
            for(Integer i=list.size() - num; i<list.size(); i++){
    
                System.out.println(list.get(i));
            }
        }
        else{
            for(Integer i=0; i<list.size(); i++){
                System.out.println(list.get(i));
                
            }
        }
    }

    public static void main(String[] args) throws IOException{

        Tail t = new Tail();

        t.run(args);
    }
}