public class ComparingString{

    void run(String[] args){

        for(Integer i=0; i<args.length; i++){

            this.compare(args[i]);
        }
    }

    void compare(String arg){

        if(arg.equals("KSU_AP")){

            System.out.printf("渡された文字列は \"%s\" です.%n", arg);
        }
        else{
            System.out.printf("渡された文字列は \"KSU_AP\"ではなく\"%s\"です.%n", arg);
        }
    }


    public static void main(String[] args){


        ComparingString com = new ComparingString();

        com.run(args);
    }
}