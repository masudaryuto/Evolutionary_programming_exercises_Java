public class GrandTotal2{

    void run(String[] args){
        Integer n = 10;

        if(args.length != 0){
            n = Integer.valueOf(args[0]);
        }

        Integer sum = this.sum(n);

        System.out.printf("%dから%dまでの総和は%dです.%n", 1, n, sum);
    }

    Integer sum(Integer value){

        if(value == 1){
            return 1;
        }

        return value + sum(value - 1);
    }

    public static void main(String[] args){

        GrandTotal2 grand = new GrandTotal2();

        grand.run(args);
    }
}