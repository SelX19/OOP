package week2;

/*Create a method printText that prints the following string of characters:
"In the beginning there were the swamp, the hoe and Java." and a line break.
Users should be able to enter  how many times the text should be printed.*/

import java.util.Scanner;

public class ex6_print_text_n_times {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String text = "In the beginning there were the swamp, the hoe and Java.\n";
        System.out.println("Enter the number of times you want to print a text: ");
        int times = Integer.parseInt(reader.nextLine());
        for(int i=1; i<=times; i++){
            System.out.println(text);
        }
    }
}
