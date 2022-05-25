import java.util.ArrayList;

public class FibonacciList {
    
    void run(String[] args){
      Integer maxIndex = 10;// 何項目まで求めるか．
      if(args.length != 0){
          maxIndex = Integer.valueOf(args[0]);
      }

      ArrayList<Integer> list = getFibonacciList(maxIndex);
      System.out.println(list);
    }

    // getFibonacciListメソッドを作成する．
    ArrayList<Integer> getFibonacciList(Integer maxIndex){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        Integer tmp;

        for(Integer i=2; i<maxIndex; i++){
            tmp = list.get(i-1) + list.get(i-2);
            list.add(tmp);
        }
        return list;
    }

    // mainメソッドを作成する．
    public static void main(String[] args){
        FibonacciList fib = new FibonacciList();

        fib.run(args);
    }

}