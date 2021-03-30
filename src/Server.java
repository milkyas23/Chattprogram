import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) {
        int port = 1234;
        boolean run = true;
//        ServerSocket serverSocket;
//        Socket socket;


        try {
            ServerSocket serverSocket= new ServerSocket(port);

                Socket socket = serverSocket.accept();

                DataInputStream din = new DataInputStream(socket.getInputStream());
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                String msgin = "Mikey säger"+"", msgout = "Mikey svarar"+ "";
                while (!msgin.equals("end")) {
                    msgin = din.readUTF();
                    System.out.println("klienten säger: " + msgin);
                    msgout = br.readLine();
                    dout.writeUTF(msgout);
                    dout.flush();
                }
                socket.close();

//                while (run) {
//                    System.out.println("Client name is \"" + name + "\"");
//                    System.out.println("Sending feedback");
//                    PrintStream out = null;
//                    out.println("SERVER: Welcome " + name + "! Keep up the good work");
//                    BufferedReader in = null;
//                    try {
//                        name = in.readLine();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Skapa server socket
// accept anslutning till en socket
// plocka ut in och out ur socketen
// sedan kan chatloopen köras