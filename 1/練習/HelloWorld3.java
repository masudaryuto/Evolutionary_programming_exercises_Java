public class HelloWorld3 {
    void run(String[] args){

        // 「==」では、メモリ上で格納されている場所が一緒かどうかという比較になる。

        if(args.length == 0){
            System.out.println("Hello, World");
        }
        //else if(Obfects.equals(args[0], "World"))の判定でもOK
        else if(args[0].equals("World")){
            System.out.println("Hi, " + args[0]);
        }
        else{
            System.out.println("Hello, " + args[0]);
        }
    }
    public static void main(String[] args){
        HelloWorld3 hello = new HelloWorld3();

        hello.run(args);
    }
}