import java.util.Random;
import java.util.ArrayList;

public class ExamAnalyzer{

    void run(){
        ArrayList<ExamScore> exam = new ArrayList<>();

        String name;

        for(Integer i=0; i<10; i++){

            //Integer -> String
            name = Integer.toString(i);
            exam.add(this.createRandomScore(name));
        }

        this.Exam_print(exam);
    }

    ExamScore createRandomScore(String name){
        Random random = new Random();
        Integer math = random.nextInt(101);
        Integer physics = random.nextInt(101);
        Integer english = random.nextInt(101);
        return this.createExamScore(math, physics, english, name);
    }

    ExamScore createExamScore(Integer math, Integer physics, Integer english, String name){

        ExamScore exam = new ExamScore();
        exam.math = math;
        exam.phys = physics;
        exam.eng = english;
        exam.name = name;

        return exam;
    }

    void Exam_print(ArrayList<ExamScore> exam){
        System.out.printf("      math   phys   eng   ave%n");
        
        this.ave1(exam);
        this.max(exam);
        this.min(exam);
        this.ave2(exam);

    }
    void ave1(ArrayList<ExamScore> exam){

        Double ave_math = 0.0;
        Double ave_phys = 0.0;
        Double ave_eng = 0.0;

        for(Integer i=0; i<exam.size(); i++){
            ave_math += exam.get(i).math;
            ave_phys += exam.get(i).phys;
            ave_eng += exam.get(i).eng;
        }
        ave_math /= exam.size();
        ave_phys /= exam.size();
        ave_eng /= exam.size();

        System.out.printf("ave  %6.3f %6.3f %6.3f%n", ave_math, ave_phys, ave_eng);
    }
    void ave2(ArrayList<ExamScore> exam){

        Double ave = 0.0;

        for(Integer i=0; i<exam.size(); i++){
            ave = (exam.get(i).math + exam.get(i).phys + exam.get(i).eng) / 3.0;
            System.out.printf("  %s  %6d %6d %6d %6.3f%n", exam.get(i).name, exam.get(i).math, exam.get(i).phys, exam.get(i).eng, ave);
        }

    }

    void max(ArrayList<ExamScore> exam){
        Integer max_math = 0;
        Integer max_phys = 0;
        Integer max_eng = 0;

        for(Integer i=0; i<exam.size(); i++){
            if( exam.get(i).math > max_math){
                max_math = exam.get(i).math;
            }
            if( exam.get(i).phys > max_phys){
                max_phys = exam.get(i).phys;
            }
            if( exam.get(i).eng > max_eng){
                max_eng = exam.get(i).eng;
            }
        }
        
        System.out.printf("max  %6d %6d %6d%n", max_math, max_phys, max_eng);
    }

    void min(ArrayList<ExamScore> exam){
        Integer min_math = 100;
        Integer min_phys = 100;
        Integer min_eng = 100;

        for(Integer i=0; i<exam.size(); i++){

            if( exam.get(i).math < min_math){
                min_math = exam.get(i).math;
            }
            if( exam.get(i).phys < min_phys){
                min_phys = exam.get(i).phys;
            }
            if( exam.get(i).eng < min_eng){
                min_eng = exam.get(i).eng;
            }
        }
        
        System.out.printf("min  %6d %6d %6d%n", min_math, min_phys, min_eng);
    }


    public static void main(String[] args){

        ExamAnalyzer ex = new ExamAnalyzer();

        ex.run();
    }
}