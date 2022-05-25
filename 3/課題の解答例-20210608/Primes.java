import java.util.ArrayList;

/**
 * 練習問題2
 * https://ksuap.github.io/2020spring/lesson03/assignments/#2-素数の一覧
 */
public class Primes{
    void run(String[] args){
        Integer max = this.parseMax(args);
        ArrayList<Integer> primes = this.generatePrimes(max);
        this.printList(primes);
    }

    void printList(ArrayList<Integer> primes){
        for(Integer i = 0; i < primes.size(); i++){
            System.out.printf("%5d ", primes.get(i));
            if(i % 10 == 9){ // 10個出力するごとに改行する．
                System.out.println();
            }
        }
        System.out.println();
    }

    // デバッグ用
    void printFlags(ArrayList<Boolean> flags){
        System.out.println("    0 1 2 3 4 5 6 7 8 9");
        System.out.print("    ");
        for(Integer i = 0; i < flags.size(); i++){
            if(flags.get(i)){
                System.out.print("* ");
            }
            else{
                System.out.print("  ");
            }
            if(i % 10 == 9){
                System.out.printf("%n%3d ", ((i + 1) / 10));
            }
        }
        System.out.println();
    }

    ArrayList<Integer> generatePrimes(Integer max){
        ArrayList<Boolean> flags = this.initializeList(max);
        for(Integer i = 2; i < flags.size(); i++){
            if(flags.get(i)){
                for(Integer j = i * 2; j < flags.size(); j = j + i){
                    flags.set(j, false);
                }
                // printFlags(flags);
            }
        }
        return this.primesList(flags);
    }

    ArrayList<Integer> primesList(ArrayList<Boolean> flags){
        ArrayList<Integer> primes = new ArrayList<>();
        for(Integer i = 2; i < flags.size(); i++){
            if(flags.get(i)){
                primes.add(i);
            }
        }
        return primes;
    }
    ArrayList<Boolean> initializeList(Integer max){
        ArrayList<Boolean> flags = new ArrayList<>();
        for(Integer i = 0; i <= max; i++){
            flags.add(true);
        }
        flags.set(0, false);
        flags.set(1, false);
        // printFlags(flags);
        return flags;
    }

    // コマンドライン引数が指定されていなければデフォルト値を返し，指定されて入ればその値を整数値で返す．
    Integer parseMax(String[] args){
        if(args.length == 0){
            return 200;
        }
        return new Integer(args[0]);
    }
    
    public static void main(String[] args){
        Primes primes = new Primes();
        primes.run(args);
    }
}
