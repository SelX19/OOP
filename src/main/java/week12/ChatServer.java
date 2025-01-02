package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {

    private final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>()); //creating a thread-safe version of a list of client threads (1 client can access a server - as a shared resource at the time)

    /*Create a method named start that takes a port number as a parameter. Inside this method:
Create a ServerSocket on the specified port.
Print a message indicating that the server is running.
Enter into a loop to continuously accept incoming client connections.
For each new connection, create a Socket object and a corresponding ClientHandler.
Add the ClientHandler to the list and start a new thread to handle the client.
*/
    public void start(int portNumber){
        try(ServerSocket serverSocket = new ServerSocket(portNumber)){
            System.out.println("ChatServer is running on the port: " + portNumber);

            while(true){
                Socket client = serverSocket.accept(); //new client object
                ClientHandler clientHandler = new ClientHandler(client); //new thread that client object will run on
                clients.add(clientHandler); //add thread to the list of threads
                new Thread(clientHandler).start(); //Thread used since clientHandler implements Runnable; start creates new thread and executes it
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    /*Create a private method named broadcastMessage that takes a message (String) and the sender (ClientHandler) as parameters.
Iterate through the list of clients and send the message to each client except the sender.
*/
    private void broadcastMessage(String message, ClientHandler sender){
        for(ClientHandler client : clients){
            if(client!=sender){ //ensuring that a message is not broadcasted back to the sender. sending it to all other clients
                client.sendMessage(message);
            }
        }
    }

    /*Create a private inner class named ClientHandler that implements the Runnable interface.
    Maintain references to the client's Socket, BufferedReader, and PrintWriter. Implement a constructor to initialize these components.

Implement the run method in the ClientHandler class. Inside this method:
Read the client's username and print a message about the user joining the chat.
Broadcast this joining message to all clients.
Enter into a loop to continuously read messages from the client and broadcast them to others.
Handle IOExceptions and, in the finally block, close the client's socket and remove the ClientHandler from the list.

Implement a method named sendMessage in the ClientHandler class to send messages to the client.
*/
    private class ClientHandler implements Runnable{
        private final Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket socket){ /*The ClientHandler can directly use the socket to read from and write to the connected client.
This allows each ClientHandler to independently manage communication with its assigned client, even while other clients are also connected.*/
            this.socket=socket;
        }

        @Override
        public void run(){
            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);

                username = reader.readLine();
                System.out.println(username + " has joined the chat.");
                broadcastMessage(username + "has joined the chat.", this);

                String message;

                while((message=reader.readLine())!=null){
                    broadcastMessage(username + ": " + message, this);
                }
            }
            catch(IOException e){
                System.out.println(username + " disconnected.");
            }
            finally{
                try{
                    socket.close();
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                clients.remove(this);
                broadcastMessage(username + " has left the chat.", this);
            }
        }

        public void sendMessage(String message){
            writer.println(message);
        }
    }
}
