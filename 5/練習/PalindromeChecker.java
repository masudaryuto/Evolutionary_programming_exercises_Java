public class PalindromeChecker {

    
    void run(String[] args){
        boolean flag = false;

        for(Integer i=0; i<args.length; i++){
            flag = this.isPalindrome(args[i]);
            System.out.printf("%s: ", args[i]);
            System.out.println(flag);
        }
    }

    Boolean isPalindrome(String str){
        if(str.length() <= 1){
            return true;
        }
        else{

            Character first = str.charAt(0);
            Character last = str.charAt(str.length() - 1);

            if( !first.equals(last) ){
                return false;
            }
            else{
                String sub = str.substring(1, str.length() - 1);
                
                return isPalindrome(sub);
            }
        }
    }
    

    public static void main(String[] args){
        PalindromeChecker pa = new PalindromeChecker();

        pa.run(args);
    }
}