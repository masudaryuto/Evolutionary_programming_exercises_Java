import java.util.*;

public class Arguments {
    boolean help = false;
    boolean interactive = false;
    boolean recursive = false;
    boolean update = false;
    boolean verbose = false;
    ArrayList<String> list = new ArrayList<>();


    void parse(String[] args){
        for(String arg: args){
            if(Objects.equals(arg, "-h")){
                this.help = true;
            }
            else if(Objects.equals(arg, "-i")){
                this.interactive = true;
            }
            else if(Objects.equals(arg, "-r")){
                this.recursive = true;
            }
            else if(Objects.equals(arg, "-u")){
                this.update = true;
            }
            else if(Objects.equals(arg, "-v")){
                this.verbose = true;
            }
            else{
                this.list.add(arg);
            }
        }
    }
}