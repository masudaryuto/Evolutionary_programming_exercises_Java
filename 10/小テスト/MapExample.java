import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class MapExample{
    void run(String gradeFile) throws IOException{
    HashMap<String, Integer> map = new HashMap<>();
    BufferedReader in = new BufferedReader(new FileReader(gradeFile));
    String line;
    Integer value1 = Integer.MAX_VALUE;
    Integer value2 = 0;
    Integer sum = 0;
    Integer count = 0;
    while((line = in.readLine()) != null){
    String[] items = line.split(",");
    Integer grade = parseAndPutGrade(map, items[1]);
    sum += grade; // (1)
    if(value1 > grade) value1 = grade; // (2)
    if(value2 < grade) value2 = grade; // (3)
    count++; // (4)
    }
    Double value3 = 1.0 * sum / count; // (5)
    this.printResult(map, value1, value2, value3);
    }
    void printResult(HashMap<String, Integer> map, Integer value1,
    Integer value2, Double value3){
    System.out.printf("統 : %d, %d, average: %2.3f%n", value1, value2,
    value3);
    for(Map.Entry<String, Integer> entry: map.entrySet()){
    System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
    }
    }
    Integer parseAndPutGrade(HashMap<String, Integer> map, String
    gradeString){
    Integer grade = new Integer(gradeString); // (6)
    if(grade < 60)
    map.put("不可", map.getOrDefault("不可", 0) + 1); // (5-1)
    else if(grade >= 60 && grade < 70)
    map.put("可", map.getOrDefault("可", 0) + 1); // (5-2)
    else if(grade >= 70 && grade < 80)
    map.put("良", map.getOrDefault("良", 0) + 1); // (5-3)
    else if(grade >= 80 && grade < 90)
    map.put("優", map.getOrDefault("優", 0) + 1); // (5-4)
    else if(grade >= 90)
    map.put("秀", map.getOrDefault("秀", 0) + 1); // (5-5)
    return grade;
    }
    public static void main(String[] args) throws IOException{
    MapExample example = new MapExample();
    example.run(args[0]);
    }
    }