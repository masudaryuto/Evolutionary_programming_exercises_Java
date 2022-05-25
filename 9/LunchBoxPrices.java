import java.util.HashMap;

public class LunchBoxPrices{
    HashMap<String, Integer> prices;

    void run(String[] args){
        this.initialize();
        for(String arg: args){
            this.searchAndPrint(arg);
        }
    }

    void searchAndPrint(String lunchBoxName){
        
        Integer price = this.prices.get(lunchBoxName);// お弁当の料金を prices から取得(get)する．

        if(price == null){ // お弁当が見つからなかった．
      // ここに見つからなかった旨を出力する処理を書く．
            System.out.printf("%s: 見つかりませんでした%n", lunchBoxName);
        }
        else{
      // お弁当の料金を出力する．
            System.out.printf("%s: %d円%n", lunchBoxName, price);
        }   
    }       
    void initialize(){ // お弁当の料金表を作成するメソッド．
        this.prices = new HashMap<>();
        prices.put("日の丸弁当", 200);
        // 他のお弁当の料金も追加する（10個程度）．
        prices.put("のり弁当", 350);
        prices.put("幕ノ内弁当", 400);
        prices.put("ステーキ弁当", 800);
        prices.put("ハンバーグ弁当", 550);
        prices.put("唐揚げ弁当", 450);
        prices.put("サービス弁当", 350);
        prices.put("おにぎり弁当", 250);
        prices.put("上幕ノ内弁当", 800);
        prices.put("サンドウィッチ弁当", 400);
    }
  // mainメソッドは省略．


    public static void main(String[] args){

        LunchBoxPrices lunch = new LunchBoxPrices();

        lunch.run(args);
    }
}