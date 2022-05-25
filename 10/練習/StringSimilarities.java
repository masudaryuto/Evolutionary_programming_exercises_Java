import java.io.*;
import java.util.*;


public class StringSimilarities {

    void run(String[] args){

        String str1 = args[0];
        String str2 = args[1];

        this.simpson(str1, str2);
        this.jaccard(str1, str2);
        this.dice(str1, str2);
        this.cosine(str1, str2);
        this.levenshtein(str1, str2);
    }

    void simpson(String str1, String str2){

        
        Double count = 0.0;
        
        ArrayList<Character> char_str1 = this.getList(str1);
        ArrayList<Character> char_str2 = this.getList(str2);
        
        Double short1 = 0.0;
        if(char_str1.size() >= char_str2.size()){
            short1 = Double.valueOf(char_str2.size());
        }
        else{
            short1 = Double.valueOf(char_str1.size());
        }

        for(Integer i=0; i<char_str2.size(); i++){

            if(char_str1.contains(char_str2.get(i))){
                count++;
            }
        }
        
        System.out.printf("simpson(%s, %s)=%f%n", str1, str2, count / short1);
        
    }
    void jaccard(String str1, String str2){

        Double count = 0.0;

        ArrayList<Character> char_str = this.getList(str1+str2);
        ArrayList<Character> char_str1 = this.getList(str1);
        ArrayList<Character> char_str2 = this.getList(str2);
        
        Double tmp = Double.valueOf(char_str.size());

        for(Integer i=0; i<char_str2.size(); i++){

            if(char_str1.contains(char_str2.get(i))){
                count++;
            }
        }
        
        System.out.printf("jaccard(%s, %s)=%f%n", str1, str2, count / tmp);
    }
    void dice(String str1, String str2){
        
        Double count = 0.0;

        ArrayList<Character> char_str1 = this.getList(str1);
        ArrayList<Character> char_str2 = this.getList(str2);
        
        Double tmp = Double.valueOf(char_str1.size()+char_str2.size());

        for(Integer i=0; i<char_str2.size(); i++){

            if(char_str1.contains(char_str2.get(i))){
                count++;
            }
        }
        
        System.out.printf("dice(%s, %s)=%f%n", str1, str2, 2*count / tmp);
    }
    void cosine(String str1, String str2){
                
        Double count = 0.0;

        ArrayList<Character> char_str = this.getList(str1 + str2);
        ArrayList<Double> v1 = new ArrayList<>();
        ArrayList<Double> v2 = new ArrayList<>();

        v1 = this.vector(str1, char_str);
        v2 = this.vector(str2, char_str);
        
        Double v1_size = this.v_size(v1);
        Double v2_size = this.v_size(v2);

        Double v_v = this.v_v_size(v1, v2);

        
        
        System.out.printf("cosine(%s, %s)=%f%n", str1, str2, v_v / (v1_size * v2_size));
    }
    void levenshtein(String str1, String str2){

        Table<Integer> table = new Table<Integer>(str1.length()+1, str2.length()+1);

        
        table = this.initialize(table, str1, str2);
        for(Integer y=1; y<=str2.length(); y++){


            for(Integer x=1; x<=str1.length(); x++){
                Integer a = table.get(x-1, y-1);
                Integer b = table.get(x-1, y);
                Integer c = table.get(x, y-1);

                Integer min = a;

                if(a >= b){
                    min = b;
                }
                if (a >= c){
                    min = c;
                }


                //flag = false 一致してない。
                if(str1.charAt(x-1) == str2.charAt(y-1)){


                    table.set(min + 0, x, y);

                }
                else{
                    
                    table.set(min + 1, x, y);
                }
                
  
            }
        }




        Integer item = table.get(str1.length(), str2.length());


        System.out.printf("edit_distance(%s, %s)=%d%n", str1, str2, item);

    }

    Table<Integer> initialize(Table table, String str1, String str2){

        for(Integer i=0; i<=str1.length(); i++){

            table.set(i, i, 0);
        }
        for(Integer i=0; i<=str2.length(); i++){

            table.set(i, 0, i);
        }

        return table;

    }

    Double v_size(ArrayList<Double> v){

        Double count = 0.0;
        for(Integer i=0; i<v.size(); i++){
            count += (v.get(i) * v.get(i));
        }
        

        return Math.sqrt(count);
    }

    Double v_v_size(ArrayList<Double> v1, ArrayList<Double> v2){

        Double count = 0.0;
        for(Integer i=0; i<v1.size(); i++){

            count += v1.get(i)*v2.get(i);

        }
        
        return count;
    }
    
    ArrayList<Double> vector(String str, ArrayList<Character> char_str){

        ArrayList<Double> v = new ArrayList<>();
        HashMap<Character, Double> map = new HashMap<>();

        for(Integer i=0; i<char_str.size(); i++){

            map.put(char_str.get(i), 0.0);
        }

        for(Integer i=0; i<str.length(); i++){

            if(map.get(str.charAt(i)) != null){

                if(map.get(str.charAt(i)) >= 1.0){

                    map.replace(str.charAt(i), map.get(str.charAt(i))+1);
                }
                else{
                    map.replace(str.charAt(i), 1.0);
                }

            }

        }

        for(Map.Entry<Character, Double> entry: map.entrySet()){
            v.add(entry.getValue());
        }

        //System.out.println(map);


        return v;
    }
    ArrayList<Character> getList(String str){
        ArrayList<Character> list = new ArrayList<Character>();
        for(Integer i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            if(!list.contains(c)){
                list.add(c);
            }
        }
        return list;
    }

    public static void main(String[] args){

        StringSimilarities str = new StringSimilarities();

        str.run(args);
    }
}