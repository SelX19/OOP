package week2;

/*Create a program that calculates the sum of 2^0+2^1+2^2+...+2^n, where n is a number entered by the user.
The notation 2^i means raising the number 2 to the power of i, for example 2^4 = 2*2*2*2 = 16.*/

import java.util.Scanner;

public class ex5_sum_of_powers {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number to act as a power of 2: ");
        int n = Integer.parseInt(reader.nextLine());

        int i=0;
        int sum=0;
        while(i<=n){
            int power = (int) Math.pow(2, i); //P.S.: Math returns double value, has to be parsed to int type
            sum+=power;
            i++;
        }
        System.out.println("The sum of powers of 2, until 2^" + n + " is " + sum);
    }
}
