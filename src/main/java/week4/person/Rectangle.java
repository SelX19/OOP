package week4.person;

public class Rectangle extends Shape{

    private double width;
    private double height;

    public Rectangle(double width, double height, String color, FillType fillType) {
        super(color, fillType);
        this.width = width;
        this.height = height;
    }

    @Override
    public void displayInfo(){
        System.out.println("Color: " + this.getColor());
        System.out.println("Filled/Not filled: " + this.getFillType());
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + this.getArea());
    }

    public double getArea(){
       return width*height;
    }

}
