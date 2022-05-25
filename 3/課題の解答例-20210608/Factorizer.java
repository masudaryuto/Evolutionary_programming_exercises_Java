import java.util.ArrayList;

/**
 * 練習問題3
 * https://ksuap.github.io/2020spring/lesson03/assignments/#3-素因数分解
 */
public class Factorizer{
    void run(String[] args){
        for(String arg: args){
            Integer value = new Integer(arg);
            ArrayList<Integer> list = this.factorize(value);
            this.printList(value, list);
        }
    }

    ArrayList<Integer> factorize(Integer value){
        Primes primesObject = new Primes();
        // 指定された値までの素数を求める．
        ArrayList<Integer> primes = primesObject.generatePrimes(value);
        // 結果を格納するリスト．
        ArrayList<Integer> factorials = new ArrayList<>();

        int index = 0;
        while(value != 1){
            Integer prime = primes.get(index);
            if(value % prime == 0){
                factorials.add(prime);
                value = value / prime;
            }
            else{
                index++;
            }
        }
        return factorials;
    }

    void printList(Integer value, ArrayList<Integer> list){
        System.out.printf("%5d: ", value);
        for(Integer i = 0; i < list.size(); i++){
            if(i != 0){
                System.out.print(" x ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        Factorizer factorizer = new Factorizer();
        factorizer.run(args);
    }
}
   
