import java.util.Objects;

public class PalindromeChecker{
    void run(String[] args){
        for(String arg: args){
            System.out.printf("%s: %s%n", arg, isPalindrome(arg));
        }
    }
    Boolean isPalindrome(String string){
        if(string.length() < 2){
            return true;
        }
        Character first = string.charAt(0);
        Character last = string.charAt(string.length() - 1);
        if(!Objects.equals(first, last)){
            return false;
        }
        String sub = string.substring(1, string.length() - 1);
        return isPalindrome(sub);
    }
    public static void main(String[] args){
        PalindromeChecker checker = new PalindromeChecker();
        checker.run(args);
    }
}
