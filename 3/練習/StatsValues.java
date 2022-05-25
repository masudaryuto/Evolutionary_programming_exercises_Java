import java.util.ArrayList;
import java.util.Random;

public class StatsValues{

    void run(){
        ArrayList<Integer> list = this.buildList();
        Integer sum = this.sum(list);
        Double average = Double.valueOf(sum) / list.size();
        Integer max = this.max(list);
        Integer min = this.min(list);



        System.out.printf("合計: %d, 最大値: %d, 最小値: %d, 平均値: %.6f%n", sum, max, min, average);

        this.print_list(list);

    }

    ArrayList<Integer> buildList(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for(Integer i = 0; i < 100; i++){
            Integer randomValue = random.nextInt(1000);
            arrayList.add(randomValue);
        }
        return arrayList;
    }

    Integer sum(ArrayList<Integer> list){
        Integer sum = 0;

        for(Integer c : list){
            sum += c;
        }

        return sum;
    }
    Integer max(ArrayList<Integer> list){
        Integer max = 0;
        for(Integer c : list){
            if(max < c){
                max = c;
            }

        }

        return max;
    }
    Integer min(ArrayList<Integer> list){
        Integer min = 1000;
        for(Integer c : list){
            if(min > c){
                min = c;
            }

        }

        return min;
    }

    void print_list(ArrayList<Integer> list){
        Integer count = 1;
        for(Integer c : list){

            System.out.printf("%3d ", c);
            
            if(count % 10 == 0){
                System.out.println();
            }

            count++;
        }
    }

    public static void main(String[] args){

        StatsValues state = new StatsValues();

        state.run();
    }
}