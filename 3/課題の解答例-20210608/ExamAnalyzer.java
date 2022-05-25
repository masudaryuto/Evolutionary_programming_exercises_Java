import java.util.ArrayList;
import java.util.Random;

/**
 * 練習問題4
 * https://ksuap.github.io/2020spring/lesson03/assignments/#4-試験成績の分析
 */
public class ExamAnalyzer{
    void run(){
        ArrayList<ExamScore> list = this.createExamScores();
        this.analyzeAndPrint(list);
    }

    ArrayList<ExamScore> createExamScores(){
        ArrayList<ExamScore> list = new ArrayList<>();

        for(Integer i = 0; i < 10; i++){
            ExamScore score = this.createRandomScore(i.toString());
            list.add(score);
            // もちろん，1行で書いても良い．
            // list.add(this.createRandomScore(i.toString()));
        }
        return list;
    }
    
    ExamScore createRandomScore(String name){
        Random random = new Random();
        Integer math = random.nextInt(101);
        Integer physics = random.nextInt(101);
        Integer english = random.nextInt(101);
        return this.createExamScore(math, physics, english, name);
    }

    ExamScore createExamScore(Integer math, Integer physics, Integer english, String name){
        ExamScore score = new ExamScore();
        score.math = math;
        score.physics = physics;
        score.english = english;
        score.name = name;
        return score;
    }

    ExamScore sumOfScore(ArrayList<ExamScore> list){
        ExamScore es = createExamScore(0, 0, 0, "sum");
        for(ExamScore score: list){
            es.math += score.math;
            es.physics += score.physics;
            es.english += score.english;
        }
        return es;
    }

    ExamScore findMaxScore(ArrayList<ExamScore> list){
        ExamScore es = createExamScore(0, 0, 0, "max");
        for(ExamScore score: list){
            es.math = Math.max(score.math, es.math);
            es.physics = Math.max(es.physics, score.physics);
            es.english = Math.max(es.english, score.english);
        }
        return es;
    }

    ExamScore findMinScore(ArrayList<ExamScore> list){
        ExamScore es = createExamScore(100, 100, 100, "min");
        for(ExamScore score: list){
            es.math = Math.min(score.math, es.math);
            es.physics = Math.min(score.physics, es.physics);
            es.english = Math.min(score.english, es.english);
        }
        return es;
    }

    void analyzeAndPrint(ArrayList<ExamScore> list){
        ExamScore sum = sumOfScore(list);
        ExamScore max = findMaxScore(list);
        ExamScore min = findMinScore(list);

        System.out.println("       math   phys   eng    ave");
        System.out.printf( "ave   %6.3f %6.3f %6.3f%n", 1.0 * sum.math / list.size(),
                           1.0 * sum.physics / list.size(), 1.0 * sum.english / list.size());
        System.out.printf( "%3s   %6d %6d %6d%n", max.name, max.math, max.physics, max.english);
        System.out.printf( "%3s   %6d %6d %6d%n", min.name, min.math, min.physics, min.english);
        for(ExamScore score: list){
            System.out.printf("%3s   %6d %6d %6d ", score.name, score.math, score.physics, score.english);
            System.out.printf("%6.3f%n", (score.math + score.physics + score.english) / 3.0);
        }
    }

    public static void main(String[] args){
        ExamAnalyzer analyzer = new ExamAnalyzer();
        analyzer.run();
    }
}
