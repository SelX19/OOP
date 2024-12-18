package week11;

public class Student {

    private int ID;
    private String name;
    private String university;
    private String department;
    private double GPA;

    public Student(int ID, String name, String university, String department, double GPA){
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getUniversity(){
        return university;
    }

    public String getDepartment(){
        return department;
    }

    public double getGPA(){
        return GPA;
    }

    @Override
    public String toString(){
        return name;
    }
}
