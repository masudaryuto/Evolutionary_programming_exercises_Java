// 7/29臨時テスト 7/24補講

public class ArgsReverser {

    void run(String[] args){

        for(Integer i = 0; i<args.length; i++){

            this.reverse(args[i]);
        }
    }

    void reverse(String str){

        String reverse_str = "";

        for(Integer i=0; i<str.length(); i++){
            reverse_str += str.charAt(str.length() - 1 - i);
        }

        System.out.printf("%s, %s%n", str, reverse_str);
    }

    public static void main(String[] args){

        ArgsReverser arg = new ArgsReverser();

        arg.run(args);
    }
    
}