package week4.person;

public class Shape {

    private String color;
    private FillType fillType;

    //constructor:

    public Shape(String color, FillType fillType) {
        this.color = color;
        this.fillType = fillType;
    }

    //getters:

    public String getColor() {
        return color;
    }

    public FillType getFillType() {
        return fillType;
    }

    public void displayInfo(){
        System.out.println("Color: " + color);
        System.out.println("Filled/Not filled: " + fillType);
    }

}
