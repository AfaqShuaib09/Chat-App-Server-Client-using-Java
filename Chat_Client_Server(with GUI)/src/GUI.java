
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class GUI{
    static int count=0;
    JFrame frame;
    JButton btn;
    String msg;
    boolean flag= false;
    JTextArea textArea;
    JScrollPane jsp;
    JTextField textField;       
      
   public GUI(String S){
      initGUI(S);
}
    public void initGUI(String S) {
        frame=new JFrame(S);
        frame.setLocation(count*400,0);
        frame.getContentPane().setLayout(new FlowLayout());
       
        count++;
        textArea = new JTextArea(30, 30);
        textArea.setBackground(Color.darkGray);
        textArea.setForeground(Color.white);
        jsp = new JScrollPane(textArea); 
        jsp.setLayout(new ScrollPaneLayout());
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frame.getContentPane().add(jsp);
        
        textField = new JTextField(25);
        Font bigFont = textField.getFont().deriveFont(Font.PLAIN,13f);
        textField.setFont(bigFont);
        frame.add(textField);
        btn = new JButton("Send");
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.WHITE);
        frame.add(btn);
        
        //btn.addActionListener(hnd);
        
        frame.setSize(370, 570);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }
}
