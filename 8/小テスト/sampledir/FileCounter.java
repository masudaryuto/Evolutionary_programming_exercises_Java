import java.io.File;

public class FileCounter{

    Integer file_count = 0;
    Integer dir_count = 0;
    Boolean flag = false;

    void run(String[] args){

        if(args.length == 0){
            System.out.println("no argument");
        }
        else{
            File thisfile = new File(args[0]);
            File nowfile = new File(".");

            this.search(thisfile, nowfile);

            if(!flag){
                System.out.printf("%s: not found%n", thisfile);
            }
        }
    }
    
    void search(File thisfile, File nowfile){
        if(thisfile.getName().equals(nowfile.getName())){
            flag = true;
            if(thisfile.isDirectory()){
                File[] files = thisfile.listFiles();
                for(File f: files){
                    System.out.println(f.getName());
                    this.count(f);
                }
                System.out.printf("file: %d, dir: %d%n", file_count, dir_count);
            }
            else if(!thisfile.isDirectory()){
                System.out.printf("%s: not directory%n", thisfile.getName());
            }
        }
        
        if(nowfile.isDirectory()){
            File[] files = nowfile.listFiles();
            
            for(File f: files){
                this.search(thisfile, f);
            }
        }
    }
    
    void count(File thisfile){
        if(thisfile.isDirectory()){
            dir_count++;
        }
        else{
            file_count++;
        }
    }

    public static void main(String[] args){

        FileCounter file = new FileCounter();

        file.run(args);
    }
}