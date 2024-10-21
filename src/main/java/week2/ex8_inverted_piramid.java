package week2;

/*Write a program to print the inverted half pyramid shape*/

public class ex8_inverted_piramid {
    public static void main(String[] args) {
        inverted_piramid(10);
    }

    public static void inverted_piramid(int n) {
        for(int i=n; i>=1; i--){
            for(int j=0;j<i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
