import java.util.ArrayList;
import java.io.*;

public class ReversePolishNotationCalculator {
    
    void run(String[] args){
        
        for(Integer i=0; i<args.length; i++){
            
            String[] str = args[i].split(" ");

            
            ArrayList<String> list = this.process(str);
            
            
            //??args[i]は""ついてんのになんで、なしで表示されたのか
            System.out.printf("%.6f (%s)%n",Double.parseDouble(list.get(0)), args[i]);
        }



    }
    
    ArrayList<String> process(String[] args){
        ArrayList<String> list = new ArrayList<>();
        


        for(Integer i=0; i<args.length; i++){

            if(args[i].equals("+")){
                
                Double value = Double.parseDouble(list.get(list.size() - 1)) + Double.parseDouble(list.get(list.size() - 2)); 
                list.remove(list.get(list.size()-2));
                list.remove(list.get(list.size() - 1));
                list.add(String.valueOf(value));
                
            }
            
            else if(args[i].equals("-")){
                Double value = Double.parseDouble(list.get(list.size() - 2)) - Double.parseDouble(list.get(list.size() - 1)); 
                list.remove(list.get(list.size() - 2));
                list.remove(list.get(list.size() - 1));
                list.add(String.valueOf(value));
            }
            else if(args[i].equals("*")){
                Double value = Double.parseDouble(list.get(list.size() - 2)) * Double.parseDouble(list.get(list.size() - 1)); 
                list.remove(list.get(list.size() - 2));
                list.remove(list.get(list.size() - 1));
                list.add(String.valueOf(value));
            }
            else if(args[i].equals( "/")){
                Double value = Double.parseDouble(list.get(list.size() - 2)) / Double.parseDouble(list.get(list.size() - 1)); 
                list.remove(list.get(list.size() - 2));
                list.remove(list.get(list.size() - 1));
                list.add(String.valueOf(value));
            }
            
            else{

                list.add(args[i]);
            }

        }

        return list;


    }
    

    public static void main(String[] args){

        ReversePolishNotationCalculator reverse = new ReversePolishNotationCalculator();

        reverse.run(args);
    }
}