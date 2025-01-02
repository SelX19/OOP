package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*You should also implement the ChatClient class and there you need to have again the main method. Inside the main method you need to check if the command-line arguments include a username and server IP. If not, print a usage message and exit.
Retrieve the username and server IP from the command-line arguments and set the server port to desired port number.

Wrap the main code in a try block to catch IOExceptions.
Create a Socket object by connecting to the specified server IP and port.
Initialize a BufferedReader to read messages from the server and a PrintWriter to send messages to the server.
Use the writer to send the username to the server.
Start a new thread to continuously receive messages from the server.
Inside the thread, create a loop to read messages from the server and print them to the console. Handle IOExceptions by printing the stack trace.
Outside the thread, create a loop to read messages from the console and send them to the server using the writer.

This ChatClient class establishes a connection to the server, sends and receives messages, and provides a basic command-line interface for the user to interact with the chat system.

In order to test if your code works you need first to run ChatApplication.java
Then you need to enable running multiple instances in intelliJ. You need to go on:

run-> edit configurations -> modify options -> click on allow multiple instances -> click ok

Then go on:
run-> edit configurations -> edit configuration templates -> application -> in Program attributes paste this User 127.0.0.1 -> ok
*/
public class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server_ip>");
            return;
        }

        String username = args[0];
        String serverIp = args[1];
        int port = 12345; // Replace 12345 with your server's port number

        try (Socket socket = new Socket(serverIp, port);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            serverWriter.println(username);

            Thread readThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readThread.start();

            String userMessage;
            while ((userMessage = consoleReader.readLine()) != null) {
                serverWriter.println(userMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}