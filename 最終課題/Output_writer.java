/******
 * ステップ5~6
 * Output_writer.java
 * 学生証番号：054227
 * 氏名：増田 琉斗
*******/

import java.util.*;
import java.io.*;

public class Output_writer {
    ArrayList<String> data = new ArrayList<>();

    void Input_line(String line){
        data.add(line);
    }

    void Write_line(String file_name) throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter(new File(file_name)));
        
        for(String line: this.data){
            out.println(line);
        }
        out.close();
    }




}