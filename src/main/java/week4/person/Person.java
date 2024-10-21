package week4.person;

public class Person {

    private String name;
    private String address;

    public Person(String name, String address){
        this.name=name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString(){
        return this.getName() + "\n" + "   " + this.getAddress();
    }

    public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");

        System.out.println(pekka);
        System.out.println(esko);

    }

}
