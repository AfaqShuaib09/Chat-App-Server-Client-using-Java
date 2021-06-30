
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class BtnHandler implements ActionListener{
    
    SocketClient refs;
    public BtnHandler(SocketClient s) {
        refs = s;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //To .
        if(ae.getActionCommand().equals("Send"))
        {
            String s = refs.g.textField.getText();
            if(s=="")
                return;
            refs.g.textArea.setText(refs.g.textArea.getText()+refs.g.frame.getTitle()+": "+s+'\n');
            try {
                refs.out.writeUTF(refs.g.frame.getTitle()+":"+s);
            } catch (IOException ex){
                ex.printStackTrace();
            }
            refs.g.textField.setText("");
        }
    }
}
