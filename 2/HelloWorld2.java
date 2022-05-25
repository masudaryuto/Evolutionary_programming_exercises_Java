public class HelloWorld2{

    void run(String[] args){
        if(args.length == 0){
            this.greet("World");
            //System.out.println("Hello, World");
            
        }
        else{
            this.greet(args[0]);
        }
    }
    void greet(String str){
        System.out.printf("Hello, %s%n", str);
    }
    public static void main(String[] args){
        HelloWorld2 hello = new HelloWorld2();

        hello.run(args);
    }
}