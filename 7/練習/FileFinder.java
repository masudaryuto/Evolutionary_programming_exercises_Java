import java.io.File;

public class FileFinder{


boolean flag = true;
    
    void run(String[] args){
        
        String ans = "";
        File thisfile = new File(args[0]);
        File direct = new File(args[1]);
        traverse(direct, thisfile, ans);
        if(flag){
            System.out.printf("%s: Not found.%n", thisfile);
        }
    }

    void traverse(File direct, File thisfile, String ans){
        
        //System.out.println(goal_file.getName());
    
        if(direct.getName().equals(thisfile.getName())){
            ans += direct.getName();
            System.out.println(ans);
            flag = false;
        }
        else{
            ans = ans + direct.getName() + "/";
        }
        
        if(direct.isDirectory()){
            //System.out.println(thisfile.getName());
            
            //System.out.println(ans);

            File[] files = direct.listFiles();
            for(File f: files){
                
                this.traverse(f, thisfile, ans);
            }
        }

    }

    public static void main(String[] args){

        FileFinder file = new FileFinder();

        file.run(args);
    }
}