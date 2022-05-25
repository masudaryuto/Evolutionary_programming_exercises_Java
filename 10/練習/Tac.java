import java.io.*;//Reader
import java.util.*;//list

public class Tac {

    void run(String[] args) throws IOException{

        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));

        this.r_cat(in);
    }

    void r_cat(BufferedReader in) throws IOException{

        ArrayList<String> list = new ArrayList<>();
        String line;

        while( (line = in.readLine()) != null ){
            list.add(line);
        }
        in.close();

        this.output(list);
    }

    void output(ArrayList<String> list){

        for(Integer i=0; i<list.size(); i++){

            System.out.println(list.get(list.size() -i -1));
        }
    }

    public static void main(String[] args) throws IOException{

        Tac tac = new Tac();

        tac.run(args);
    }
}