package week2;

//Create a program that asks the user for three numbers and then prints their sum.

import java.util.Scanner;

public class ex2_sum3 {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter a number: ");
        int number1 = Integer.parseInt(reader.nextLine());
        System.out.println("Please, enter another number: ");
        int number2 = Integer.parseInt(reader.nextLine());
        System.out.println("Please, enter one more number: ");
        int number3 = Integer.parseInt(reader.nextLine());

        int result = suma(number1, number2, number3);

        System.out.println("Result of adding up input values is: " + result);
    }

    public static int suma (int n1, int n2, int n3){
        return n1+n2+n3;
    }

}
