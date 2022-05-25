import java.util.HashMap;


public class Dictionary {
    HashMap<String, String> data;

    void run(String[] args){
        this.english_dict();

        for(Integer i=0; i<args.length; i++){
            this.compare(args[i]);
        }
    }

    void compare(String str){

        if(this.data.get(str) != null){

            System.out.printf("%s: %s%n", str, this.data.get(str));
        }
        else{
            System.out.printf("%s: 見つかりませんでした.%n", str);
        }
    }

    void english_dict(){
        
        //ハッシュマップの変数にハッシュマップを入れてあげることをどこかでやらないとエラーになる。Arrayとかは別にいい。
        this.data = new HashMap<>();
        data.put("desk", "机");
        data.put("sun", "太陽");
        data.put("chair", "椅子");
        data.put("watch", "腕時計,懐中時計");
        data.put("japan", "日本");
        data.put("english", "英語");
        data.put("corona", "コロナ");
        data.put("man", "男");
        data.put("dream", "夢");
        data.put("map", "地図");
        

    }

    public static void main(String[] args){

        Dictionary dict = new Dictionary();

        dict.run(args);
    }
}