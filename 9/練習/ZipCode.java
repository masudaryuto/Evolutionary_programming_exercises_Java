import java.util.HashMap;
import java.io.*;

public class ZipCode {
    HashMap<String, String> address;

    void run(String[] args) throws IOException{
        this.initialize();
        
        for(String arg: args){
            this.searchAndPrint(arg);
        }
    }
    
    
    void searchAndPrint(String num){
        
        String name = this.address.get(num);
        
        if(name == null){
            
            System.out.printf("%s: 見つかりませんでした%n", num);
        }
        else{
            System.out.printf("%s: %s%n", num, name);
        }   
    }       
    void initialize() throws IOException{
        File file = new File("zipcode.csv");
        BufferedReader in = new BufferedReader(new FileReader(file));
        
        String line;
        String ans;
        
        this.address = new HashMap<>();
        while( (line = in.readLine()) != null ){
            
            String[] items = line.split(",");
            
            this.sampleCode(items, address);

            
            
        }
        
    }
    
    String stripQuote(String item){
        //ダブルクォートの削除
        if(item.matches("\".*\"")){
            return item.substring(1, item.length() - 1);
        }
        return item;
    }
    void sampleCode(String[] items, HashMap<String, String> address){
        String ans = "";
        for(Integer i=6; i<9; i++){
            String original = items[i];
            String value = this.stripQuote(original);
            ans += value;
        }
        // originalには「"クォートで囲まれた文字列"」が代入されており，
        // valueには「クォートで囲まれた文字列」が代入される．
        address.put(this.stripQuote(items[2]), ans);
    }

    
    
    
    
    
    public static void main(String[] args) throws IOException{
        ZipCode zip = new ZipCode();

        zip.run(args);
    }
    
}