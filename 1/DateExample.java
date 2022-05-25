import java.util.Date;

public class DateExample{
  void run(){
    // year は 1900年からの経過年数．
    // month は 0 から始まる．
    Date date1 = new Date(115, 8, 29, 9, 0);
    Date date2 = date1;
    System.out.printf("date1: %s%n", date1);
    System.out.printf("date2: %s%n", date2);

    // Year を +1 している．
    date1.setYear(date1.getYear() + 1);
    System.out.printf("date1: %s%n", date1);
    System.out.printf("date2: %s%n", date2);
  }
  public static void main(String[] args){
    DateExample example = new DateExample();
    example.run();
  }
}
