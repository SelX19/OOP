package week4.person;

public class Teacher extends Person{

    private int salary;

    public Teacher(String name, String address, int salary){
        super(name,address);
        this.salary =salary;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }

    //overriding toString() method for this class and its objects

    public String toString(){
        return this.getName() + "\n  " + this.getAddress() + "\n  salary  " + this.getSalary() + " euros/month";
    }

    public static void main(String[] args) {
        Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println( pekka );
        System.out.println( esko );




        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println( olli );
        //I have not defined credits in toString method for printing for Student object. Hence, I need to either edit toString method and delete sout printing from main in Student class, or add here printing line for credits (I will do that)
        System.out.println("   credits "+ olli.credits());
    }

}
