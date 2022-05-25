public class PersonM2 {
    void run(){
        //コピーしているのと一緒。
        Person2 person2 = this.create("ryuto", "masuda", "054227");
        
        //値渡し。
        this.print_person(person2);

    }

    Person2 create(String name, String myozi, String id){
        //新しくオブジェクトを作り、値を入れている。
        Person2 person2 = new Person2();
        person2.name = name;
        person2.myozi = myozi;
        person2.id = id;

        return person2;
    }

    void print_person(Person2 person2){
        System.out.printf("%s, %s, %s%n", person2.myozi, person2.name, person2.id);
    }
    public static void main(String[] args){
        PersonM2 pr = new PersonM2();

        pr.run();
    }
}