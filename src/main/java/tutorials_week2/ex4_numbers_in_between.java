package tutorials_week2;

import java.util.Scanner;

/*Create a program that asks the user for the first number and the last number
and then prints all numbers between those two. Use a while loop.
If the first number is greater than the last number, the program prints those numbers.*/
public class ex4_numbers_in_between {
    public static void main (String[] args){

        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter an initial number for the list of numbers: ");
        int number1 = Integer.parseInt(reader.nextLine());
        System.out.println("Please, enter the final number for a list of numbers: ");
        int number2 = Integer.parseInt(reader.nextLine());

        int i = number1++;
        if(number1>number2){
            System.out.println(number1);
        }
        while(i>number1 && i<number2){
            System.out.println(i);
            i++;
        }
        if(number1>number2){
            System.out.println(number2);
        }

    }
}
