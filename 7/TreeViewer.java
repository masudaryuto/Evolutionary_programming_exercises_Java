import java.io.File;

public class TreeViewer{
    Integer directoryCount = 0;
    Integer fileCount = 0;

    void run(String[] args){
        traverse(new File(args[0]), 0);
        System.out.printf("%d directories, and %d files%n", directoryCount, fileCount);
    }

    void traverse(File file, Integer indent){

        //System.out.println(indent);

        for(Integer i = 0; i < indent; i++){
            System.out.print("    ");
        }

        System.out.printf("%s%n", file.getName());

        if(file.isDirectory()){ // ディレクトリであれば，中身を確認する．
            File[] files = file.listFiles();
            //System.out.println(file.getPath() + " : " + file.getName());
            Integer newIndent = indent + 1;
            for(File f: files){
                this.traverse(f, newIndent);
            }
            directoryCount++;
        }
        else{
            fileCount++;
        }
    }
    public static void main(String[] args){
        TreeViewer tree = new TreeViewer();
        tree.run(args);
    }
}