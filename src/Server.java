import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private String name;

    public void main(String[] args) {
        int port = 1234;
        boolean run = true;
        ServerSocket serverSocket;
        Socket socket;


        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for connections!");
                socket = serverSocket.accept();

                while (run) {
                    System.out.println("Client name is \"" + name + "\"");
                    System.out.println("Sending feedback");
                    PrintStream out = null;
                    out.println("SERVER: Welcome " + name + "! Keep up the good work");
                    BufferedReader in = null;
                    try {
                        name = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Skapa server socket
// accept anslutning till en socket
// plocka ut in och out ur socketen
// sedan kan chatloopen köras