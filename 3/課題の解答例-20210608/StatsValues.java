import java.util.ArrayList;
import java.util.Random;

/**
 * 練習問題1
 * https://ksuap.github.io/2020spring/lesson03/assignments/#1-乱数値100個の統計
 */
public class StatsValues{
    void run(){
        ArrayList<Integer> values = this.generateRandomValues(100);
        this.printStats(values);
        this.printList(values);
    }

    void printList(ArrayList<Integer> list){
        Integer count = 0;
        for(Integer value: list){
            System.out.printf("%4d ", value);
            count++;
            if(count % 10 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    void printStats(ArrayList<Integer> list){
        Integer max = 0;
        Integer min = 1000;
        Integer sum = 0;

        for(Integer value: list){
            if(max < value){
                max = value;
            }
            if(min > value){
                min = value;
            }
            sum = sum + value;
        }

        System.out.printf("合計: %d, 最大値: %d, 最小値: %d, 平均値: %f%n",
                          sum, max, min, (1.0 * sum) / list.size());
    }

    ArrayList<Integer> generateRandomValues(Integer max){
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i = 0; i < max; i++){
            list.add(random.nextInt(1000));
        }
        return list;
    }
    
    public static void main(String[] args){
        StatsValues sv = new StatsValues();
        sv.run();
    }
}
