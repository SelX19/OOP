package week1;

/*Create a program that asks the user for two integers and then prints their sum.*/

import java.util.Scanner;

public class ex4_user_input_sum {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number1 = Integer.parseInt(reader.nextLine());

        System.out.print("Enter another integer: ");
        int number2 = Integer.parseInt(reader.nextLine());

        int sum = number1 + number2;

        System.out.println("The sum of " + number1 + " and " + number2 + " is: " + sum);
    }
}
