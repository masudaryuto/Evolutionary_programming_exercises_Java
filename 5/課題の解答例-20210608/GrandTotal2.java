public class GrandTotal2{
    void run(String[] args){
        Integer max = 10;
        if(args.length > 0){
            max = new Integer(args[0]);
        }

        Integer total = grandTotal(max);
        System.out.printf("1から%dまでの総和は%dです．%n", max, total);
    }
    Integer grandTotal(Integer value){
        if(value == 1){
            return 1;
        }
        return value + grandTotal(value - 1);
    }
    public static void main(String[] args){
        GrandTotal2 total = new GrandTotal2();
        total.run(args);
    }
}
