package week1;

/*Create a program that asks the user for two numbers and prints the greater of those two.
The program should also handle the case in which the two numbers are equal. */

import java.util.Scanner;

public class ex6_comparision {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number1 = Integer.parseInt(reader.nextLine());


        System.out.println("Enter another number: ");
        int number2 = Integer.parseInt(reader.nextLine());

        if(number1 > number2) {
            System.out.println("Number " + number1 + " is a greater number among the two entered numbers.");
        }
        else if(number1 == number2) {
            System.out.println("Numbers " + number1 + " and " + number2 + " are equal.");
        }
        else {
            System.out.println("Number " + number2 + " is a greater number among the two entered numbers.");
        }

    }
}
