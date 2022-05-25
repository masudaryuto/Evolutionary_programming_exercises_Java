public class HelloWorld2{

    void run(String[] args){
        if(args.length == 0){
            System.out.println("Hello, World");
            
        }
        else{

            System.out.println("Hello, " + args[0]);
        }
    }
    public static void main(String[] args){
        HelloWorld2 hello = new HelloWorld2();

        hello.run(args);
    }
}