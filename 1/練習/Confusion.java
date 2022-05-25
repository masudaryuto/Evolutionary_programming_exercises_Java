import java.util.Objects;
public class Confusion{
void run(String[] array){
String name1 = "tamada";
String name2 = array[0];
if(array[0] == name1){
System.out.println("array[0] == name1: true");
}
if(array[0] == name2){
System.out.println("array[0] == name2: true");
}
if(Objects.equals(array[0], name1)){
System.out.println("array[0] equals name1: true");
}
}
public static void main(String[] args){
Confusion confusion = new Confusion();
confusion.run(args);
}
}