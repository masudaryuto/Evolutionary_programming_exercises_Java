public class Multiplication {
    public static void main(String[] args) {

        System.out.printf("  ");
        for(Integer i=1; i<=9; i++){
            System.out.printf("%2d ", i);
        }
        System.out.printf("%n");

        for(Integer y=1; y<=9; y++){
            System.out.printf("%d ", y);
            for(Integer x=1; x<=9; x++){
                ///System.out.print

                System.out.printf("%2d ", x*y);
            }
            System.out.printf("%n");
        }

    }
    
}