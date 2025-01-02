package week12;

/*Now you should create a class called ChatApplication and there you should have a main method where you need to create an instance of the ChatServer class named chatServer.
Start the server by calling the start method on chatServer with the port number.

This class serves as the entry point for running the chat server. By executing the main method the instance of the ChatServer is created and the server starts listening for the incoming connections on the provided port.

*/
public class ChatApplication {
    public static void main(String[]args){
        ChatServer chatServer = new ChatServer();
        chatServer.start(23456);
    }
}
