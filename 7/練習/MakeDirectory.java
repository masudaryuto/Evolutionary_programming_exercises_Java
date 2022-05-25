import java.io.File;

public class MakeDirectory {

    void run(String[] args){

        File file1 = new File(args[0]);

        if(!file1.mkdir()){
            System.out.printf("%s: could not make directory.%n", file1);
        }
        
            //System.out.printf("fa%n");
    
    }

    public static void main(String[] args){

        MakeDirectory make = new MakeDirectory();

        make.run(args);
    }
    
}