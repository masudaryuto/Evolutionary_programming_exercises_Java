public class PersonManager{

    void run(){
        //
        Person person1 = this.createPerson("Haruaki", "Tamada");
        this.printPerson(person1);
    }
    Person createPerson(String name1, String name2){
      Person person = new Person();
      person.givenName = name1;
      person.familyName = name2;
      return person;
    }
    void printPerson(Person person){
        System.out.printf("%s, %s%n",person.familyName, person.givenName);
    }
    public static void main(String[] args){
      PersonManager app = new PersonManager();
      app.run();
    }
  }

  