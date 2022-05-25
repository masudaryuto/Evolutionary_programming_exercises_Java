
import java.util.LinkedList;
import java.util.Iterator;
public class GreetingList{
void run(){
LinkedList<String> list = new LinkedList<>();
list.add("おはようございます");
list.add("Good Morning");
list.add("Guten Morgen");
list.add("Bon matin");
list.add("Buona mattina");
System.out.println(list.size()); // (1)
System.out.println(list.get(3)); // (2)
// (5)
for(Iterator<String> i = list.iterator(); i.hasNext(); ){
    
System.out.println(i.next());
}
// // listの要素を順に出力する．
// for(Iterator<String> i = /* (3) */; /* (4) */; ){
// System.out.println(/* (5) */);
// }
}
public static void main(String[] args){
GreetingList list = new GreetingList();
list.run();
}
}