import java.util.ArrayList;

public class Primes {

    void run(String[] args){
        Integer n = 200;
        if(args.length != 0){
            n = Integer.valueOf(args[0]);
        }

        //nまでの素数を探す。
        ArrayList<Integer> primes_list = this.generatePrimes(n);

        this.list_print(primes_list);
    }

    ArrayList<Integer> generatePrimes(Integer max){
        ArrayList<Boolean> primes = new ArrayList<>();
        for(Integer i=0; i<=max; i++){
            primes.add(true); //全て素数と定義。
        }
        //0と1は素数では無いので、falseとおく。
        primes.set(0, false);
        primes.set(1, false);

        for(Integer i=2; i<primes.size(); i++){

            //配列(リスト).get(インデックス番号)
            //primesがfalseの時実行。
            if(!primes.get(i)){
                continue;
            }            
            //素数かどうか判別。
            primes = this.primes_judge(i, primes);
        }
        //整数リストに、素数を代入してから返す。
        return primesList(primes);
    }

    ArrayList<Boolean> primes_judge(Integer x, ArrayList<Boolean> primes){

        for(Integer j=x+1; j<primes.size(); j++){

            if(!primes.get(j)){
                continue;
            }

            if(j % x == 0){
                primes.set(j, false);
            }
        }

        return primes;
    }

    

    ArrayList<Integer> primesList(ArrayList<Boolean> primes){
        ArrayList<Integer> returnList = new ArrayList<>();
        for(Integer i=2; i<primes.size(); i++){

            //素数なら
            if(primes.get(i)){
                returnList.add(i);
            }
        }

        return returnList;
    }

    void list_print(ArrayList<Integer> primes){
        Integer count = 1;

        for(Integer c: primes){
            System.out.printf("%5d ", c);

            if( count % 10 == 0 ){
                System.out.println();
            }
            count++;
        }
        System.out.println();
    }
    
    
    public static void main(String[] args){

        Primes pr = new Primes();

        pr.run(args);
    }
}