import java.io.File;


public class MakeDirectories {

    void run(String[] args){

        File file1 = new File(args[0]);

        if(!file1.mkdirs()){
            System.out.printf("%s: could not make directory.%n", file1);
        }
        
            //System.out.printf("fa%n");
    
    }

    public static void main(String[] args){

        MakeDirectories make = new MakeDirectories();

        make.run(args);
    }
    
}