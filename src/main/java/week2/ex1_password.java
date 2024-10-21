package week2;

/* Create a program that asks the user for a password.
If the password is right, a secret message is shown to the user.*/

import java.util.Scanner;

    //Create a program that asks the user for a password. If the password is right, a secret message is shown to the user.
    public class ex1_password {

        public static void main(String[] args) {

            Scanner reader = new Scanner(System.in);
            String truePassword = "carrot";
            String secretCode = "dnfjdfkng snfkrkj";

            while(true) {
                System.out.println("Please, enter your password:");
                String password = reader.nextLine();
                if (password.equals(truePassword)){
                    System.out.println("Right!!     " + "Secret is " + "´" + secretCode + "´");break;
                }
            }

        }
    }

