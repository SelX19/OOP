package week2;

/*In this exercise, you need to create a guess number game.
The user enters  a number, which is in the range 0 to 100 (both 0 and 100 are possible).
Then the user has the chance to guess once, what the number is.
The program should print "The number is lower", "The number is greater" or
"Congratulations, your guess is correct!" depending on the number the user typed.
The guessing should be made repeatedly until the user types the right number.
The program also needs to include a variable of type int, which is used to count the guesses the user has made.
The program should always print the number of guesses along with the answer.*/

import java.util.Random;
import java.util.Scanner;

public class ex10_guess_game {

    public static void main(String[] args) {

        Random random = new Random();
        int targetNumber = random.nextInt(101);
        System.out.println("Target number is " + targetNumber + ".\n"); //optional - for me to check what the target number is, and if code is working

        int numberOfGuesses = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Please, guess a number. Number is in a range between 0 and 100 (inclusive):\n ");
        while(true){
            int inputNumber = Integer.parseInt(input.nextLine());
            if(inputNumber<targetNumber){
                numberOfGuesses++;
                System.out.println("The number is lower than expected one. Please, try again.\n Number of guesses is " + numberOfGuesses + ".\n");
            }
            else if(inputNumber>targetNumber){
                numberOfGuesses++;
                System.out.println("The number is higher than expected one. Please, try again.\n Number of guesses is " + numberOfGuesses + ".\n");
            }
            else{
                numberOfGuesses++;
                System.out.println("Congratulations! You have correctly guessed a number.\n Your total number of guesses is " + numberOfGuesses + ".");
                break;
            }

        }

    }
}
