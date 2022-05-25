/******
 * ステップ1
 * GradeChecker1.java
 * 学生証番号：054227
 * 氏名：増田 琉斗
*******/


import java.io.*;
import java.util.*;


public class GradeChecker1{
    HashMap<Integer, Double> data = new HashMap<>();
    void run(String[] args) throws IOException{
        File csv_file = new File(args[0]);

        this.process(csv_file);
    }

    void process(File file) throws IOException{

        BufferedReader csv_file = new BufferedReader(new FileReader(file));

        String line = "";
        Integer max_num = 0;
        while( (line = csv_file.readLine()) != null ){

            max_num = this.data_check(line);
        }
        csv_file.close();

        this.output(max_num);
    }

    Integer data_check(String line) throws IOException{

        String[] grades = line.split(",");
        Integer num = Integer.valueOf(grades[0]);
        Double score = Double.parseDouble(grades[1]);

        data.put(num, score);

        return num;
    }
    
    void output(Integer max_num) {
        for(Integer i=1; i<=max_num; i++){
            boolean exam_flag = false;
            if(data.get(i) == null){
                exam_flag = true;
            }
            if(exam_flag){
                System.out.printf("%d, 0.000,K%n", i);
            }
            else{
                System.out.printf("%d, %.3f", i, data.get(i));
                this.grade(data.get(i));
            }
        }
    }
    
    void grade(Double score){
        if( score < 60.0 ){
            System.out.println(",不可");
        }
        else if( 60.0 <= score && score < 70.0){
            System.out.println(",可");
        }
        else if( 70.0 <= score && score < 80.0){
            System.out.println(",良");
        }
        else if( 80.0 <= score && score < 90.0){
            System.out.println(",優");
        }
        else if(90.0 <= score){
            System.out.println(",秀");
        }
    }

    public static void main(String[] args) throws IOException{

        GradeChecker1 grade = new GradeChecker1();

        grade.run(args);
    }
}