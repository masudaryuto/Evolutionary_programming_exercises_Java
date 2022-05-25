import java.io.*;

public class Head {

    void run(String[] args) throws IOException{
        
        Integer num = Integer.valueOf(args[0]);

        BufferedReader in;
        if(args.length == 1){
            in = new BufferedReader(new InputStreamReader(System.in));
            //System.out.println(System.in);
        }
        else {
            File file = new File(args[1]);
            in = new BufferedReader(new FileReader(args[1]));
        }
        this.read(num, in);

    }

    void read(Integer num, BufferedReader in) throws IOException{

        String line;

        for(Integer i=0; i<num; i++){
            line = in.readLine();
            System.out.println(line);

        }
        
        in.close();
    }
    
    public static void main(String[] args) throws IOException{
        Head hd = new Head();

        hd.run(args);
    }
}