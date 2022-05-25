import java.util.Arrays;

public class ArgsSorter{
    void run(String[] args){
        System.out.printf("before: ");
        this.printArray(args);
        Arrays.sort(args);
        System.out.printf("after: ");
        this.printArray(args);
    }
    void printArray(String[] args){

        for(Integer i=0; i<args.length; i++){
            System.out.printf("%s, ", args[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){

        ArgsSorter sort = new ArgsSorter();

        sort.run(args);
    }
}