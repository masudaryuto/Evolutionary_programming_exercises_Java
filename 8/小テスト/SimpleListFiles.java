import java.io.File;
import java.io.IOException;


public class SimpleListFiles{
    void run(String[] args){
    for(String targetFileName: args){
    File target = new File(targetFileName);
    listFiles(target);
    }
    }
    void listFiles(File file){
    System.out.printf("Target: %s%n", file.getPath());
    if(file.isDirectory()){
    for(File subfile: file.listFiles()){
    System.out.printf(" %s%n", subfile.getPath());
    }
    }
    }
    public static void main(String[] args){
    SimpleListFiles slf = new SimpleListFiles();
    slf.run(args);
    }
    }