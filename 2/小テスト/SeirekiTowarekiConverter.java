public class SeirekiToWarekiConverter{

    void run(String[] args){
        

        if(args.length == 0){
            System.out.printf("西暦 2017: 平成29年%n");
        }
        else{
            Integer num = Integer.valueOf(args[0]);
            if(num < 1868){
                System.out.printf("西暦 %d: 明治より前であるため判定できません.%n", num);
            }
            else if( 1868 <= num && num < 1912){
                if( num == 1868){
                    System.out.printf("西暦 %d: 明治元年%n", num);
                }
                else{
                    System.out.printf("西暦 %d: 明治%d年%n", num, num-1867);
                }
            }
            else if( 1912 <= num && num < 1926){
                if(num == 1912){
                    System.out.printf("西暦 %d: 明治%d年 (大正元年)%n", num, num-1867);
                }
                else{
                    System.out.printf("西暦 %d: 大正%d年%n", num, num-1911);
                }
            }
            else if( 1926 <= num && num < 1989){
                if(num == 1926){
                    System.out.printf("西暦 %d: 大正%d年 (昭和元年)%n", num, num-1911);

                }
                else{

                    System.out.printf("西暦 %d: 昭和%d年%n", num, num-1925);

                }
            }
            else if( 1989 <= num && num < 2019){
                if(num == 1989){
                    System.out.printf("西暦 %d: 昭和%d年 (平成元年)%n", num, num-1925);

                }
                else{
                    System.out.printf("西暦 %d: 平成%d年%n", num, num-1988);

                }
            }
            else if( 2019 <= num){
                if(num == 2019){
                    System.out.printf("西暦 %d: 平成%d年 (令和元年)%n", num, num-1988);

                }
                else{
                    System.out.printf("西暦 %d: 令和%d年%n", num, num-2018);
                    

                }
            }
        }
    }
    public static void main(String[] args){

        SeirekiToWarekiConverter seireki = new SeirekiToWarekiConverter();

        seireki.run(args);
    }
}