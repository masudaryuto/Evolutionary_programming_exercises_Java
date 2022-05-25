/******
 * ステップ5
 * GradeChecker5.java
 * 学生証番号：054227
 * 氏名：増田 琉斗
*******/
import java.util.*;
import java.io.*;

public class GradeChecker5 {

    HashMap<Integer, Double> exam_data = new HashMap<>();
    HashMap<Integer, Integer> assignment_data = new HashMap<>();
    HashMap<Integer, Integer> miniexam_data = new HashMap<>();
    Integer max_num = 0;
    



    void run(String[] args) throws IOException{
        Boolean output_flag = false;
        Arguments arguments = new Arguments();
        Output_writer output_writer = new Output_writer();

        arguments.parse(args);
        this.create_IsnotFileExit(arguments);
        output_flag = output_judge(output_flag, arguments.output);
        this.perform(arguments, output_flag, output_writer);
        if(output_flag){
            output_writer.Write_line(arguments.output);
        }
    }

    void create_IsnotFileExit(Arguments arguments) throws IOException{
        if(!new File(arguments.exam).exists()){
            BufferedOutputStream exam_new = new BufferedOutputStream(new FileOutputStream(new File(arguments.exam)));
        }
        if(!new File(arguments.assignments).exists()){
            BufferedOutputStream assignment_new = new BufferedOutputStream(new FileOutputStream(new File(arguments.assignments)));
        }
        if(!new File(arguments.miniexam).exists()){
            BufferedOutputStream miniexam_new = new BufferedOutputStream(new FileOutputStream(new File(arguments.miniexam)));
        }
    }
    Boolean output_judge(Boolean output_flag, String output_file) throws IOException{
        if(output_file != ""){
            output_flag = true;
        }
        return output_flag;
    }

    
    void perform(Arguments arguments, Boolean output_flag, Output_writer output_writer)throws IOException{
        BufferedReader exam_file = new BufferedReader(new FileReader(new File(arguments.exam)));
        BufferedReader assignment_file = new BufferedReader(new FileReader(new File(arguments.assignments)));
        BufferedReader miniexam_file = new BufferedReader(new FileReader( new File(arguments.miniexam)));
        
        this.exam_process(exam_file);
        this.assignment_process(assignment_file);
        this.miniexam_process(miniexam_file);

        //主に出力
        this.person_seiseki_process(output_flag, output_writer);
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
    
    void person_seiseki_process(Boolean output_flag, Output_writer output_writer){
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

            this.person_grade_output(i, exam_flag, seiseki, output_flag, output_writer);
        }
        this.general_statistics(seiseki, output_flag, output_writer);
    }
    void person_grade_output(Integer num, Boolean exam_flag, HashMap<Integer, Double> seiseki, Boolean output_flag, Output_writer output_writer){
        Boolean attend_flag = false;
        if(exam_flag){
            if(!output_flag){
                System.out.printf("%d,%2.0f,,%d,%d,%s%n", num, seiseki.get(num), assignment_data.get(num), miniexam_data.get(num), "K");
            }
            output_writer.Input_line(num.toString() + "," + String.format("%2.0f", seiseki.get(num)) + ",," + assignment_data.get(num).toString() + "," + miniexam_data.get(num).toString() + ",K");
            exam_data.remove(num);
        }
        else{
            attend_flag = this.judge_attend(num, attend_flag);
            seiseki = this.change_seiseki(num, seiseki);
            if(!output_flag){
                System.out.printf("%d,%2.0f,%.3f,%d,%d,%s%n", num, seiseki.get(num), exam_data.get(num), assignment_data.get(num), miniexam_data.get(num), this.grade(seiseki.get(num), attend_flag));
            }
            output_writer.Input_line(num.toString() + "," + String.format("%2.0f", seiseki.get(num)) + "," + String.format("%.3f", exam_data.get(num)) + "," + assignment_data.get(num).toString() + "," + miniexam_data.get(num).toString() + "," + this.grade(seiseki.get(num), attend_flag));
        }
    }
    
    Boolean judge_attend(Integer num, Boolean attend_flag){
        if( miniexam_data.get(num) <= 7){
            attend_flag = true;
        }
        return attend_flag;
    }
    HashMap<Integer, Double> change_seiseki(Integer num, HashMap<Integer, Double> seiseki){
        if( exam_data.get(num) >= 80 && exam_data.get(num) >= seiseki.get(num)){
            seiseki.put(num, Math.ceil(exam_data.get(num)));
        }
        return seiseki;
    }
    
    String grade(Double score, Boolean attend_flag){
        String grade = "K";
        if( score < 60.0 && attend_flag) grade = "※";

        else if( 60.0 <= score && score < 70.0) grade = "可";
        else if( 70.0 <= score && score < 80.0) grade = "良";
        
        else if( 80.0 <= score && score < 90.0) grade = "優";
        else if(90.0 <= score) grade = "秀";
        else grade = "不可";
        return grade;
    }

    void general_statistics(HashMap<Integer, Double> seiseki, Boolean output_flag, Output_writer output_writer){

        this.data_sum(seiseki, output_flag, output_writer);
        this.data_size(seiseki, output_flag, output_writer);
        this.grade_num(seiseki, output_flag, output_writer);
    }
    
    void data_sum(HashMap<Integer, Double> seiseki, Boolean output_flag, Output_writer output_writer){
        Double sum=0.0, sum_60point=0.0, count=0.0;
        for(Integer i=1; i<=this.max_num; i++){
            if(seiseki.get(i) >= 60){
                sum_60point += seiseki.get(i);
                count++;
            }
            sum += seiseki.get(i);
        }
        if(!output_flag){
            System.out.printf("Avg: %.3f (%.3f)%n", sum/this.max_num, sum_60point/count);
        }
        output_writer.Input_line("Avg: " + String.format("%.3f", (sum/this.max_num)) + " (" + String.format("%.3f", (sum_60point/count)) + ")" );
    }
    void data_size(HashMap<Integer, Double> seiseki, Boolean output_flag, Output_writer output_writer){
        Double max=0.0, min=101.0, max_point60=0.0, min_point60=101.0;
        for(Integer i=1; i<=this.max_num; i++){
            if(seiseki.get(i) >= 60){
                if(max_point60 <= seiseki.get(i)) max_point60 = seiseki.get(i);
    
                if(min_point60 >= seiseki.get(i)) min_point60 = seiseki.get(i);
            }
            if(max <= seiseki.get(i)) max = seiseki.get(i);

            if(min >= seiseki.get(i)) min = seiseki.get(i);
        }
        if(!output_flag){
            System.out.printf("Max: %.3f (%.3f)%n", max, max_point60);
            System.out.printf("Min: %.3f (%.3f)%n", min, min_point60);
        }
        output_writer.Input_line("Max: "+String.format("%.3f",max)+ " (" + String.format("%.3f", max_point60) +")" );
        output_writer.Input_line("Min: "+String.format("%.3f",min)+ " (" + String.format("%.3f", min_point60) +")");
    }
    
    void grade_num(HashMap<Integer, Double> seiseki, Boolean output_flag, Output_writer output_writer){
        HashMap<String, Integer> seiseki_count = new HashMap<>();
        seiseki_count = this.seiseki_count_setting(seiseki_count);
        for(Integer i=1; i<=this.max_num; i++){
            Boolean attend_flag = false;
            if(exam_data.get(i) == null){
                continue;
            }
            if(miniexam_data.get(i) <= 7){
                attend_flag = true;
            }
            seiseki_count = this.grade_count(seiseki.get(i), seiseki_count, attend_flag);
        }

        seiseki_count.put("K", this.max_num - seiseki_count.get("秀") - seiseki_count.get("優") - seiseki_count.get("良") - seiseki_count.get("可") - seiseki_count.get("不可") - seiseki_count.get("※"));
        if(!output_flag){
            this.grade_num_output(seiseki_count);
        }
        this.grade_num_write(seiseki_count, output_writer);
    }
    void grade_num_output(HashMap<String, Integer> seiseki_count){
        System.out.printf("秀:   %d%n", seiseki_count.get("秀"));
        System.out.printf("優:   %d%n", seiseki_count.get("優"));
        System.out.printf("良:   %d%n", seiseki_count.get("良"));
        System.out.printf("可:   %d%n", seiseki_count.get("可"));
        System.out.printf("不可: %d%n", seiseki_count.get("不可"));
        System.out.printf("K:    %d%n", seiseki_count.get("K"));
        System.out.printf("※:    %d%n", seiseki_count.get("※"));
    }
    void grade_num_write(HashMap<String, Integer> seiseki_count, Output_writer output_writer){
        output_writer.Input_line("秀:   "+seiseki_count.get("秀").toString());
        output_writer.Input_line("優:   "+seiseki_count.get("優").toString());
        output_writer.Input_line("良:   "+seiseki_count.get("良").toString());
        output_writer.Input_line("可:   "+seiseki_count.get("可").toString());
        output_writer.Input_line("不可: "+seiseki_count.get("不可").toString());
        output_writer.Input_line("K:    "+seiseki_count.get("K").toString());
        output_writer.Input_line("※:    "+seiseki_count.get("※").toString());
    }

    HashMap<String, Integer> seiseki_count_setting(HashMap<String, Integer> seiseki_count){
        seiseki_count.put("不可", 0);
        seiseki_count.put("可", 0);
        seiseki_count.put("良", 0);
        seiseki_count.put("優", 0);
        seiseki_count.put("秀", 0);
        seiseki_count.put("K", 0);
        seiseki_count.put("※", 0);

        return seiseki_count;
    }

    HashMap<String, Integer> grade_count(Double score, HashMap<String, Integer> seiseki_count, Boolean attend_flag){
        if( score < 60.0 && !attend_flag){
            seiseki_count.put("不可", seiseki_count.get("不可")+1);
        }
        else if( score < 60.0 && attend_flag){
            seiseki_count.put("※", seiseki_count.get("※")+1);
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

        GradeChecker5 grade = new GradeChecker5();

        grade.run(args);
    }
}