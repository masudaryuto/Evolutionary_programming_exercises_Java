
import java.awt.Color;
public class EZGraphicsTest{
void run() throws InterruptedException{
init();
EZCircle circle1 =
EZ.addCircle(125, 125, 40, 40, Color.RED, true); // (3)
EZCircle circle2 =
EZ.addCircle(125, 275, 40, 40, Color.RED, true); // (4)
animation(circle1, circle2);
}
void init(){
EZ.initialize(400, 400);
for(Integer x = 50; x < 400; x += 50){
EZ.addLine(x, 25, x, 375, Color.BLACK); // (1)
}
for(Integer y = 50; y < 400; y += 50){
EZ.addLine(25, y, 375, y, Color.BLACK); // (2)
}
}
void animation(EZCircle circle1, EZCircle circle2)
throws InterruptedException{
Integer dx = 50;
Integer dy = -50;
while(true){
Thread.sleep(1000);
circle1.translateTo(circle1.getXCenter(),
circle1.getYCenter() + dy);
circle2.translateTo(circle2.getXCenter() + dx,
circle2.getYCenter());
EZ.refreshScreen();
if(circle1.getYCenter() > 300
|| circle1.getYCenter() < 100){
dy = dy * -1;
}
if(circle2.getXCenter() > 300
|| circle2.getXCenter() < 100){
dx = dx * -1;
}
}
}
public static void main(String[] args) throws InterruptedException{
EZGraphicsTest test = new EZGraphicsTest();
test.run();
}
}