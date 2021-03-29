import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args, JOptionPane JOptionPane) {
        String ip = (String) javax.swing.JOptionPane.showInputDialog(null,"IP?","Connect to..", javax.swing.JOptionPane.QUESTION_MESSAGE);
        int port = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(null,"Port?","Connect to..", javax.swing.JOptionPane.QUESTION_MESSAGE));       ;
        Socket socket = null;

        try {
            socket = new Socket(ip,port);
        } catch (Exception e) {
            System.out.println("Client failed to connect");
            System.exit(0);
        }

        // GO
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            boolean run = true;
            while (run) {
                out.println(javax.swing.JOptionPane.showInputDialog(null, "Name?", "Identify yourself!"));

                String msg = in.readLine();
                javax.swing.JOptionPane.showMessageDialog(null, msg, "Server said", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            in.close();
            out.close();
            socket.close();
            System.out.println("Done!");
        } catch (Exception e) {
            System.out.println("Client failed to communicate");
        }
    }



}
