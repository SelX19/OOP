package additional_exercises;

import java.util.Scanner;

public class ex1_is_prime {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter a number: ");
        int number = Integer. parseInt(input.nextLine());

        if(number % 2 == 0){
            System.out.println(number + " is not a prime number.");
        }
        else{
            System.out.println(number + " is a prime number.");
        }
    }

}
