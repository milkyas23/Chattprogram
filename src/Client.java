import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args){


        try {
            String ip = (String) javax.swing.JOptionPane.showInputDialog(null, "IP?", "Connect to..", javax.swing.JOptionPane.QUESTION_MESSAGE);
            int port = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null, "Port?", "Connect to..", javax.swing.JOptionPane.QUESTION_MESSAGE));
            ;
            //Socket socket = null;
            Socket socket = new Socket(ip, port);

            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgin = "Mikey säger" + "", msgout = "Mikey svarar" + "";


            while (!msgin.equals("end")) {
                msgin = br.readLine();
                dout.writeUTF("Mikey säger" + msgin);
                msgout = din.readUTF();
                System.out.println("Mikey säger" + msgout);


            }
        }
        catch(Exception e){
                System.out.println("Client failed to connect");
                System.exit(0);
            }
        }
}

