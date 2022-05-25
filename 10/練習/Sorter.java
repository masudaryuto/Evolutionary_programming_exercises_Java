import java.io.*;//Reader
import java.util.*;//list

public class Sorter {

    void run(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));

        
        this.sort(in);
    }

    void sort(BufferedReader in) throws IOException{
        ArrayList<String> list = new ArrayList<>();
        String line;

        while( (line = in.readLine()) != null ){
            list.add(line);
        }
        in.close();

        this.output(list);
    }

    void output(ArrayList<String> list){

        Collections.sort(list);

        for(String line: list){
            System.out.println(line);
        }
    }
    
    public static void main(String[] args) throws IOException{

        Sorter sort = new Sorter();

        sort.run(args);
    }
}