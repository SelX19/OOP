package additional_exercises;

/*Create a simple calculator that can do a addition and subtraction,
 and also by typing quit you can leave from the program*/

import java.util.Scanner;

public class ex2_calculator {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Please, enter numbers you would like to perform an operation on: ");
        int num1 = Integer.parseInt(reader.nextLine());
        int num2 = Integer.parseInt(reader.nextLine());

        int sum = num1 + num2;
        int subtraction = num1-num2;
        int product = num1 * num2;
        double division = num1 / (double)num2;

        System.out.print("Please, enter a sign (+; -; /; *) for an operation you would like to perform or `quit` to exit calculator: ");
        String operation = reader.nextLine();

        switch(operation) {
            case "+":
                System.out.println("The sum is: " + sum);
                break;
            case "*":
                System.out.println("The product is: " + product);
                break;

                case "-":
                    System.out.println("The result of subtraction is: " + subtraction);
                    break;

                    case "/":
                        System.out.println("The result of division is: " + division);
                        break;

            case "quit":
                System.exit(0);

        }

    }
}
