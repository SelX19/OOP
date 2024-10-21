package week4.person;

public class Student extends Person{

    private int credits = 0;
    public Student(String name, String address) {
        super(name,address);
    }

    public int study(){
        return this.credits++;
    }

    public int credits() {
        return credits;
    }

    //overriding toString() method for this class, and inheriting and using other methods from parent class, such as getName()
    public String toString() {
        return this.getName() + "\n   " + this.getAddress();
    }

    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli); //printing object - its toString() version, and then printing out credits:
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());
    }

}
