public class StudentIdValidator {

    void run(String[] id){

        for(Integer i=0; i<id.length; i++){

            this.validate(id[i]);
        }
    }
    void validate(String id){

        if(id.length() != 6){
            System.out.printf("%s: not student id%n", id);
        }
        else{
            this.validateId(id);
        }
    }
    void validateId(String id){
        Integer sum = 0;

        for(Integer i=0; i<id.length(); i++){
            //char -> int
            sum += Integer.valueOf(id.substring(i,i+1));
        }
        if(sum % 10 == 0){
            System.out.printf("%s: valid%n", id);
        }
        else{
            System.out.printf("%s: invalid%n", id);
        }
    }
    public static void main(String[] args){

        StudentIdValidator number = new StudentIdValidator();

        number.run(args);
    }
}