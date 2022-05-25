public class Yes {

    void run(String[] args){
        String data = "y";

        if(args.length != 0){
            data = args[0];
        }

        for(Integer i=0; ;i++){

            System.out.println(data);
        }
    }

    public static void main(String[] args){

        Yes yes = new Yes();
        yes.run(args);
    }
}