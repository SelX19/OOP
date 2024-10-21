package week2;

/*Modify the previously created starts piramid in a way that now you are not printing the stars
but in each row numbers from 1 to the current row count.*/

public class ex9_numbers_piramid {
    public static void main(String[] args) {
        DrawNumbersPiramid(5);
    }
    public static void DrawNumbersPiramid(int n){
            for(int i=1; i<=n; i++){ //number of rows
                for(int j=1; j<=i; j++){ //equal number of columns
                    System.out.print(j + " ");
                }
                System.out.println(); //moving to the next line after each row
            }
    }
}
