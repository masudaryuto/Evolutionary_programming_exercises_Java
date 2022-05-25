import java.util.Date;
public class DateConfusion{
void run(){
Date date;
Date date2;
date = new Date();
this.updateDate1(date);
this.printDate(date); // (1)
date = new Date();
this.updateDate2(date);
this.printDate(date); // (2)
date = new Date();
this.updateDate3(date);
this.printDate(date); // (3)
date = new Date();
date2 = this.updateDate4(date);
this.printDate(date2); // (4)
date = new Date();
date2 = this.updateDate5(date);
this.printDate(date2); // (5)
}
void printDate(Date date){
System.out.printf("%4d-%02d-%02d%n",
date.getYear() + 1900, date.getMonth() + 1,
date.getDate());
}
void updateDate1(Date d){
d.setYear(d.getYear() + 1);
}
void updateDate2(Date d){
d = new Date(d.getYear() + 1, d.getMonth(), d.getDate());
}
Date updateDate3(Date d){
d.setYear(d.getYear() + 1);
return d;
}
Date updateDate4(Date d){
Date d2 = new Date(d.getYear() + 1, d.getMonth(), d.getDate());
return d2;
}
Date updateDate5(Date d){
d = new Date(d.getYear() + 1, d.getMonth(), d.getDate());
return d;
}
public static void main(String[] args){
DateConfusion confusion = new DateConfusion();
confusion.run();
}
}