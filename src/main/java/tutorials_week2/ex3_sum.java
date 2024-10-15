package tutorials_week2;

import java.util.Scanner;

/*Create a program that reads numbers from the user and prints their sum.
The program should stop asking for numbers when the user enters the number 0.
*/
public class ex3_sum {

    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        int sum = 0;

        while(true){
            System.out.println("Please enter a number to add to a sum, or enter 0 to finish addition:");
            int number = Integer.parseInt(reader.nextLine());
            sum+=number;
            System.out.println("Sum so far: " + sum);

            if(number==0){
                System.out.println("The final sum: " + sum);
                break;
            }
        }
    }


}
