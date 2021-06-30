
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class SocketServer {

    ServerSocket ss;
    Socket soc1;
    Socket soc2;
    DataInputStream in1;
    DataInputStream in2;
    DataOutputStream out1;
    DataOutputStream out2;

    public SocketServer(int port) {
        try {
            ss = new ServerSocket(port);
            System.out.println("Server listening on  "+ port);
            
            soc1 = ss.accept();
            soc2 = ss.accept();
            System.out.println("connected ...");

            in1 = new DataInputStream(soc1.getInputStream());
            in2 = new DataInputStream(soc2.getInputStream());

            out1 = new DataOutputStream(soc1.getOutputStream());
            out2 = new DataOutputStream(soc2.getOutputStream());

            new Thread(() -> {
                try {
                    String line1 = "";
                    while (true) {
                        line1 = in1.readUTF();
                        out2.writeUTF(line1);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();

            try {
                String line2 = "";
                while (true) {
                    line2 = in2.readUTF();
                    out1.writeUTF(line2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            System.out.println("Server closing connection");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}