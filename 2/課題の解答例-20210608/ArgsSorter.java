import java.util.Arrays;

/**
 * 練習問題1
 * https://ksuap.github.io/2020spring/lesson02/assignments/#1-与えられた文字列のソート
 *
 * @author Haruaki Tamada
 */
public class ArgsSorter{
    void run(String[] args){
        this.printArray("before", args);
        Arrays.sort(args);
        this.printArray("after", args);

        // 以下のように書いても良い．
        //     System.out.print("before: ");
        //     this.printArray2(args);
        //     Arrays.sort(args);
        //     System.out.print("after: ");
        //     this.printArray2(args);
    }

    void printArray(String prefix, String[] array){
        System.out.print(prefix + ": ");
        for(Integer i = 0; i < array.length; i++){
            System.out.print(array[i]);
            System.out.print(", ");
        }
        System.out.println();
    }

    // void printArray2(String[] array){
    //     for(Integer i = 0; i < array.length; i++){
    //         System.out.print(array[i]);
    //         System.out.print(", ");
    //     }
    //     System.out.println();
    // }

    public static void main(String[] args){
        ArgsSorter sorter = new ArgsSorter();
        sorter.run(args);
    }
}
