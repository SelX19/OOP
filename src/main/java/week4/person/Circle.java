package week4.person;

public class Circle extends Shape{

    double radius;

    public Circle(double radius, String color, FillType fillType){
        super(color, fillType);
        this.radius = radius;
    }

    @Override
    public void displayInfo(){
        System.out.println("Color: " + this.getColor());
        System.out.println("Filled/Not filled: " + this.getFillType());
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + this.getArea());
        System.out.println("Circumference: " + this.calculateCircumference(this.radius));
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    };

    public double calculateCircumference(double PI, double r){
        return 2 * PI * r;
    }

    public double calculateCircumference(double r){
        double PI = Math.PI;
        return 2 * PI * r;
    }
}
