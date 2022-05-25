public class NameReverser{
    public static void main(String[] args){

        String name = "Masuda Ryuto";
        System.out.printf("%s%n",name);

        Integer len = name.length();

        for(Integer i=len-1; i >= 0; i--){

            System.out.printf("%c", name.charAt(i));
        }
        System.out.printf("%n");

    }
}