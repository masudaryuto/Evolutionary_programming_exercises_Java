import java.io.File;

public class Remover {
    
    void run(String[] args){
        File file1 = new File(args[0]);
        //System.out.println(file1.getName());

        this.func(file1);
 
    }

    void func(File file1){

        if(file1.isDirectory()){
            File[] files = file1.listFiles();
            for(File f: files){
                
                this.func(f);
            }
        }

        //System.out.println(file1);
        if(!file1.delete()){
            System.out.printf("ls: %s: No such file or directory.%n", file1);
        }

    }


    public static void main(String[] args){

        Remover re = new Remover();

        re.run(args);
    }
}