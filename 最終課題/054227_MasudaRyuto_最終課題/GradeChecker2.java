/******
 * ステップ2
 * GradeChecker2.java
 * 学生証番号：054227
 * 氏名：増田 琉斗
*******/

import java.util.*;
import java.io.*;

public class GradeChecker2 {

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

        this.output();
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
    
    void output() {
        for(Integer i=1; i<=this.max_num; i++){
            boolean exam_flag = false;
            if(exam_data.get(i) == null){
                exam_data.put(i, 0.000);
                exam_flag = true;
            }
            if(miniexam_data.get(i) == null){
                miniexam_data.put(i, 0);
            }
            Double seiseki = Math.ceil(((70.0*exam_data.get(i))/100.0) + ((25.0*assignment_data.get(i))/60.0) + (5.0*miniexam_data.get(i)/14.0));
            if(exam_flag){
                System.out.printf("%d,%2.0f,,%d,%d,K%n", i, seiseki, assignment_data.get(i), miniexam_data.get(i));
            }
            else{
                System.out.printf("%d,%2.0f,%.3f,%d,%d", i, seiseki, exam_data.get(i), assignment_data.get(i), miniexam_data.get(i));
                this.grade(seiseki);
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

        GradeChecker2 grade = new GradeChecker2();

        grade.run(args);
    }
}