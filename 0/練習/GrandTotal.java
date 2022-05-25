public class GrandTotal {
    public static void main(String[] args){
        Integer result = 0;

        for(Integer i=1; i<=10; i++){

            result += i;
        }
        System.out.printf("1から10までの総和は%dです.%n", result);
    }
}