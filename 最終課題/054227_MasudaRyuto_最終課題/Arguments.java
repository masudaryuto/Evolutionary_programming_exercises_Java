/******
 * ステップ5~6
 * Arguments.java
 * 学生証番号：054227
 * 氏名：増田 琉斗
*******/

import java.io.*;
import java.util.*;

public class Arguments {
    ArrayList<String> arguments = new ArrayList<>();
    String exam = "exam_new";
    String assignments = "assignments_new";
    String miniexam = "miniexam_new";
    String output = "";

    void parse(String[] args){
        for(Integer i=0; i<args.length; i++){
            if(!args[i].startsWith("-")){
                arguments.add(args[i]);
            }
            else {
                i = parseOption(args, i);
            }
        }
    }
    Integer parseOption(String[] args, Integer i){
        if(Objects.equals(args[i], "-record")){
            i++;
            this.exam = args[i];
        }
        else if(Objects.equals(args[i], "-assignments")){
            i++;
            this.assignments = args[i];
        }
        else if(Objects.equals(args[i], "-miniexam")){
            i++;
            this.miniexam = args[i];
        }
        else if(Objects.equals(args[i], "-output")){
            i++;
            this.output = args[i];
        }
        else{
            this.score_id(i, args);
        }
        return i;
    }
    void score_id(Integer num, String[] args){
        if(Objects.equals(args[num], "-score")){
            arguments.add(args[num]);
        }
        else if(Objects.equals(args[num], "-id")){
            arguments.add(args[num]);
        }
    }
}