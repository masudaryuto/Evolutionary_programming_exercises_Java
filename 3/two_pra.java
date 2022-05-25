public class two_pra {

    void run(){

        Person person1 = this.createPerson("Haruaki", "Tamada");
        Person person2 = this.createPerson("Hayato", "Sagisaka");

        Person person3 = person1;
        person3 = this.bigname(person3);

        //person1は変更していないのに、参照元をコピーしたperson3と一緒に変更された。
        this.print(person1);
    }

    Person createPerson(String name1, String name2){
        Person person = new Person();
        person.givenName = name1;
        person.familyName = name2;
        return person;
    }

    Person bigname(Person person3){
        person3.familyName = person3.familyName.toUpperCase();

        return person3;
    }

    void print(Person person){
        System.out.printf("%s, %s%n",person.familyName, person.givenName);

    }
    
    public static void main(String[] args){
        two_pra pr  = new two_pra();

        pr.run();
    }
}