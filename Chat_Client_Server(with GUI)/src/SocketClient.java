
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class SocketClient {
    Socket soc;
    GUI g;
    DataInputStream in;
    DataOutputStream out; 
    BtnHandler hnd; 
    public SocketClient(String addr, int port,String name) {
        try {
            soc = new Socket(addr, port);
            System.out.println("connected to server");
            g= new GUI(name);
   
            hnd = new BtnHandler(this);
            g.btn.addActionListener(hnd);
            Scanner keyboard = new Scanner(System.in);
            out = new DataOutputStream(soc.getOutputStream());
            in = new DataInputStream(soc.getInputStream());
            
            try {
                while (true) {
                    String line = "";
                    line = in.readUTF();
                    g.textArea.setText(g.textArea.getText()+line+'\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

