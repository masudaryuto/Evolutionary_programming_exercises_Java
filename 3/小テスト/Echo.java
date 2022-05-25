public class Echo{
    boolean n_flag=false;
    boolean h_flag=false;
    void run(String[] args){

        judge_echo(args);

        if(h_flag) {
            this.help();
        }
        else{
            print_echo(args);
        }
    }
    
    void judge_echo(String[] args){
        for(Integer i=0; i<args.length; i++){
            if(args[i].equals("-h")){
                h_flag = true;
            }
            if(args[i].equals("-n")){
                n_flag = true;
            }
        }
    }

    void print_echo(String[] args){
        for(Integer i=0; i < args.length; i++){
            if(args[i].startsWith("-")){
                continue;
            }
            System.out.printf("%s ",args[i]);

        }
        if(!n_flag){
            System.out.println();
        }
    }
    void help(){
        System.out.printf("java Echo [OPTIONS] <string...>%n");
        System.out.printf("OPTIONS%n");
        System.out.printf("    -h: このメッセージを表示して終了する.%n");
        System.out.printf("    -n: 改行せずに出力する.%n");
    }
    public static void main(String[] args){
        Echo ec = new Echo();

        ec.run(args);
    }
}