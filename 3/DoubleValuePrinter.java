import java.util.ArrayList;

public class DoubleValuePrinter {
    void run(String[] args){
        Integer n = 50;
        if(args.length != 0){
            n = Integer.valueOf(args[0]);
        }
        ArrayList<Double> list = this.buildList(n);
        this.printList(list);
    }

    ArrayList<Double> buildList(Integer n){
        ArrayList<Double> arrayList = new ArrayList<>();
        for(Integer i = 0; i < n; i++){
            Double value = Math.random();
            arrayList.add(value);
        }
        return arrayList;
    }

    void printList(ArrayList<Double> arrayList){
        Integer i=1;
        for(Double item: arrayList){
            System.out.printf("%d: %.16f%n", i++, item);
        }
    }
    
    public static void main(String[] args){
        DoubleValuePrinter pr = new DoubleValuePrinter();

        pr.run(args);
    }
}