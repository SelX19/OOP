package week1;

/* Create a program that asks the user for a number and tells if the number is positive (i.e. greater than zero).*/

import java.util.Scanner;

public class ex5_is_positive {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = Integer.parseInt(reader.nextLine());

        if(number>0){
            System.out.println("Number " + number + " is positive.");
        }
        else if(number==0){
            System.out.println("Number " + number + " is not a regular positive number. It is zero.");
        }
        else{
            System.out.println("Number " + number + " is not positive. It is negative.");
        }

    }
}
