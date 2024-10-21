package week2;

/*Create a program that asks the user for the first number and the last number,
and then prints all numbers between those two. Use a while loop.

If the first number is greater than the last number,
the program prints those numbers. */

import java.util.Scanner;

public class ex4_numbers_in_between {
    public static void main (String[] args){

        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter an initial number for the list of numbers: ");
        int firstNumber = Integer.parseInt(reader.nextLine());
        System.out.println("Please, enter the final number for a list of numbers: ");
        int lastNumber = Integer.parseInt(reader.nextLine());

        if (firstNumber <= lastNumber) {
            // Print numbers in ascending order
            int currentNumber = firstNumber + 1;
            while (currentNumber < lastNumber) {
                System.out.println(currentNumber);
                currentNumber++; //not including first and last number
            }
        } else {
            // Print numbers in descending order
            int currentNumber = firstNumber;
            while (currentNumber >= lastNumber) {
                System.out.println(currentNumber);
                currentNumber--; //including first and last number
            }
        }

        reader.close();

    }
}
