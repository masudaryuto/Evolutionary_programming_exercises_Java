import java.util.HashMap;
import java.io.*;
import java.util.Map;
import java.util.Iterator;

public class PhoneBook {

    HashMap<String, String> info = new HashMap<String, String>();

    void run(String[] args) throws IOException{
        SimpleConsole console = new SimpleConsole();
        
        while(true){
            
            System.out.printf("> ");
            String line = console.readLine();
            
            String[] items = line.split(" ");

            if(items[0].equals("exit")){
                console.close();
                break;
            }
            else if(items[0].equals("find")){
                if(this.info.get(items[1]) != null){
                    System.out.printf("%s %s%n", items[1], this.info.get(items[1]));
                }
            }
            else if(items[0].equals("list")){
                this.output();
            }
            else if(items[0].equals("add")){
                this.input(items);
            }
            
            else if(items[0].equals("remove")){
                this.remove(items);
            }
        } 
    }

    void output(){
        for(Map.Entry<String, String> entry: info.entrySet()){

            System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
        }
    }

    void input(String[] items){

        this.info.put(items[1], items[2]);
    }

    void remove(String[] items){

        if(this.info.get(items[1]) != null){
            this.info.remove(items[1]);
        }
    }


    public static void main(String[] args) throws IOException{

        PhoneBook phone = new PhoneBook();

        phone.run(args);
    }
}