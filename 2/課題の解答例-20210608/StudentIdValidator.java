/**
 * 練習問題2
 * https://ksuap.github.io/2020spring/lesson02/assignments/#2-学生証番号の正当性を検証するプログラム
 *
 * @author Haruaki Tamada
 */
public class StudentIdValidator{
    void run(String[] args){
        // args.length の args は 配列であるため，長さは length で取得する．
        for(Integer i = 0; i < args.length; i++){
            // コマンドライン引数を一つずつ渡している．
            this.validate(args[i]);
        }
    }

    /**
     * コマンドライン引数の一つの正当性を確認する．
     */
    void validate(String id){
        // String型の実体の長さ（文字列の長さ）であるため，length() で取得する．
        if(id.length() != 6){
            System.out.printf("%s: not student id%n", id);
            return;
        }
        if(this.validateId(new Integer(id))){
            System.out.printf("%s: valid%n", id);
        }
        else{
            System.out.printf("%s: invalid%n", id);
        }            
    }

    /**
     * id を 10 で割った余りは1桁目の数値が得られる．
     * id を 10 で割った答えは2桁目以降の値が得られる．
     */
    Boolean validateId(Integer id){
        Integer remain = 1;
        Integer sum = 0;
        for(Integer i = 0; i < 6; i++){
            Integer id2 = id / remain;
            sum = sum + (id2 % 10);
            remain = remain * 10;
        }
        System.out.printf("sum: %d%n", sum);

        return sum % 10 == 0;
    }

    public static void main(String[] args){
        StudentIdValidator validator = new StudentIdValidator();
        validator.run(args);
    }
}
