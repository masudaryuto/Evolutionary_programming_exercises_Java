public class XPrinter{
    public static void main(String[] args){

        for(Integer y=1; y<=10; y++){
            for(Integer x=1; x<=10; x++){
                if( x == y || x + y == 11 ){
                    System.out.printf("X");
                }
                else{
                    System.out.printf(".");
                }
            }
            System.out.printf("%n");
        }
    }
}