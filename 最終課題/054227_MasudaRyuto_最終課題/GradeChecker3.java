/******
 * ステップ3
 * GradeChecker3.java
 * 学生証番号：054227
 * 氏名：増田 琉斗
*******/

import java.util.*;
import java.io.*;

public class GradeChecker3 {

    HashMap<Integer, Double> exam_data = new HashMap<>();
    HashMap<Integer, Integer> assignment_data = new HashMap<>();
    HashMap<Integer, Integer> miniexam_data = new HashMap<>();


    Integer max_num = 0;


    void run(String[] args) throws IOException{
        File exam_file = new File(args[0]);
        File assignment_file = new File(args[1]);
        File miniexam_file = new File(args[2]);
        this.perform(exam_file, assignment_file, miniexam_file);
    }

    
    void perform(File file1, File file2, File file3) throws IOException{
        BufferedReader exam_file = new BufferedReader(new FileReader(file1));
        BufferedReader assignment_file = new BufferedReader(new FileReader(file2));
        BufferedReader miniexam_file = new BufferedReader(new FileReader(file3));
        
        this.exam_process(exam_file);
        this.assignment_process(assignment_file);
        this.miniexam_process(miniexam_file);

        this.person_seiseki_process();
    }

    void exam_process(BufferedReader exam_file) throws IOException{

        String line = "";

        while( (line = exam_file.readLine()) != null ){
            this.exam_check(line);
        }
        exam_file.close();
    }
    void assignment_process(BufferedReader assignment_file) throws IOException{
        String line = "";

        while( (line = assignment_file.readLine()) != null ){
            this.assignment_sum(line);
        }
        assignment_file.close();

    }
    void miniexam_process( BufferedReader miniexam_file ) throws IOException{
        String line = "";

        while( (line = miniexam_file.readLine()) != null ){
            this.miniexam_check(line);
        }
        miniexam_file.close();
    }

    void miniexam_check(String line){
        String[] score = line.split(",");
        Integer num = 0;

        for(Integer i=1; i<score.length; i++){

            if(score[i].equals("")){
                continue;
            }
            num += 1;
            
        }
        miniexam_data.put(Integer.valueOf(score[0]), num);
    }

    void assignment_sum(String line){

        String[] score = line.split(",");
        Integer sum = 0;

        for(Integer i=1; i<score.length; i++){
            if(score[i].equals("")){
                continue;
            }
            else{
                sum += Integer.valueOf(score[i]);
            }
        }
        assignment_data.put(Integer.valueOf(score[0]), sum);
    }

    void exam_check(String line) throws IOException{

        String[] grades = line.split(",");
        Integer num = Integer.valueOf(grades[0]);
        Double score = Double.parseDouble(grades[1]);
        exam_data.put(num, score);
        this.max_num = num;
    }
    
    void person_seiseki_process() {
        HashMap<Integer, Double> seiseki = new HashMap<>();
        for(Integer i=1; i<=this.max_num; i++){
            Boolean exam_flag = false;
            if(exam_data.get(i) == null){
                exam_data.put(i, 0.000);
                exam_flag = true;
            }
            if(miniexam_data.get(i) == null){
                miniexam_data.put(i, 0);
            }
            seiseki.put(i, Math.ceil(((70.0*exam_data.get(i))/100.0) + ((25.0*assignment_data.get(i))/60.0) + (5.0*miniexam_data.get(i)/14.0)));
            this.person_grade_output(i, exam_flag, seiseki);
        }
        this.general_statistics(seiseki);
    }
    void person_grade_output(Integer num, Boolean exam_flag, HashMap<Integer, Double> seiseki){
        if(exam_flag){
            System.out.printf("%d,%2.0f,,%d,%d,K%n", num, seiseki.get(num), assignment_data.get(num), miniexam_data.get(num));
            exam_data.remove(num);
        }
        else{
            System.out.printf("%d,%2.0f,%.3f,%d,%d", num, seiseki.get(num), exam_data.get(num), assignment_data.get(num), miniexam_data.get(num));
            this.grade(seiseki.get(num));
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

    void general_statistics(HashMap<Integer, Double> seiseki){
        this.data_sum(seiseki);
        this.data_size(seiseki);
        this.grade_num(seiseki);
    }
    
    void data_sum(HashMap<Integer, Double> seiseki){
        Double sum=0.0, sum_60point=0.0, count=0.0;
        for(Integer i=1; i<=this.max_num; i++){
            if(seiseki.get(i) >= 60){
                sum_60point += seiseki.get(i);
                count++;
            }
            sum += seiseki.get(i);
        }
        System.out.printf("Avg: %.3f (%.3f)%n", sum/this.max_num, sum_60point/count);
    }
    void data_size(HashMap<Integer, Double> seiseki){
        Double max=0.0, min=101.0, max_point60=0.0, min_point60=101.0;
        for(Integer i=1; i<=this.max_num; i++){
            if(seiseki.get(i) >= 60){
                if(max_point60 <= seiseki.get(i)) max_point60 = seiseki.get(i);
                
                if(min_point60 >= seiseki.get(i)) min_point60 = seiseki.get(i);
            }
            if(max <= seiseki.get(i)) max = seiseki.get(i);

            if(min >= seiseki.get(i)) min = seiseki.get(i);
        }
        System.out.printf("Max: %.3f (%.3f)%n", max, max_point60);
        System.out.printf("Min: %.3f (%.3f)%n", min, min_point60);
    }
    
    void grade_num(HashMap<Integer, Double> seiseki){
        HashMap<String, Integer> seiseki_count = new HashMap<>();
        seiseki_count = this.seiseki_count_setting(seiseki_count);
        for(Integer i=1; i<=this.max_num; i++){
            if(exam_data.get(i) == null){
                continue;
            }
            seiseki_count = this.grade_count(seiseki.get(i), seiseki_count);
        }
        seiseki_count.put("K", this.max_num - seiseki_count.get("秀") - seiseki_count.get("優") - seiseki_count.get("良") - seiseki_count.get("可") - seiseki_count.get("不可"));
        System.out.printf("秀:   %d%n", seiseki_count.get("秀"));
        System.out.printf("優:   %d%n", seiseki_count.get("優"));
        System.out.printf("良:   %d%n", seiseki_count.get("良"));
        System.out.printf("可:   %d%n", seiseki_count.get("可"));
        System.out.printf("不可: %d%n", seiseki_count.get("不可"));
        System.out.printf("K:    %d%n", seiseki_count.get("K"));
    }

    HashMap<String, Integer> seiseki_count_setting(HashMap<String, Integer> seiseki_count){
        seiseki_count.put("不可", 0);
        seiseki_count.put("可", 0);
        seiseki_count.put("良", 0);
        seiseki_count.put("優", 0);
        seiseki_count.put("秀", 0);
        seiseki_count.put("K", 0);

        return seiseki_count;
    }

    HashMap<String, Integer> grade_count(Double score, HashMap<String, Integer> seiseki_count){
        if( score < 60.0 ){
            seiseki_count.put("不可", seiseki_count.get("不可")+1);
        }
        else if( 60.0 <= score && score < 70.0){
            seiseki_count.put("可", seiseki_count.get("可")+1);
        }
        else if( 70.0 <= score && score < 80.0){
            seiseki_count.put("良", seiseki_count.get("良")+1);
        }
        else if( 80.0 <= score && score < 90.0){
            seiseki_count.put("優", seiseki_count.get("優")+1);
        }
        else if(90.0 <= score){
            seiseki_count.put("秀", seiseki_count.get("秀")+1);
        }
        return seiseki_count;
    }
    
    public static void main(String[] args) throws IOException{

        GradeChecker3 grade = new GradeChecker3();

        grade.run(args);
    }
}