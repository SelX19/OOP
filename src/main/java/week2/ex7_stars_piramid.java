package week2;

/*Create a method called drawStarsPiramid that will accept the number of rows as a parameter,
and print a half pyramid shape where the number of rows will be dictated by the sent parameter.*/

public class ex7_stars_piramid {
    public static void main(String[] args) {
        drawStarsPiramid(5);
    }

    public static void drawStarsPiramid(int rows){
        for(int i=1; i<=rows; i++){ //number of rows
            for(int j=1; j<=i; j++){ //equal number of columns
                System.out.print(" * ");
            }
            System.out.println(); //moving to the next line after each row
        }
    }
}

