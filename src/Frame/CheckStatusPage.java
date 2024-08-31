
package Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mypack.Storage;
import mypack.DAO;

public class CheckStatusPage extends JFrame implements ActionListener{
    JButton b1,b2,b3,b0;
    DAO dao=new DAO();
    public CheckStatusPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zblackcat.jpg")));
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        b1=new JButton("User");
        b1.setBounds(100,100,100,100);
        b1.addActionListener(this);
        b2=new JButton("Book");
        b2.setBounds(300,100,100,100);
        b2.addActionListener(this);
        b3=new JButton("Gmail");
        b3.setBounds(500,100,100,100);
        b3.addActionListener(this);
        b0=new JButton("Back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        this.add(b0);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            ShowUserPage sup=new ShowUserPage();
        }
        else if(ae.getSource()==b2){
            ShowBookPage sbp=new ShowBookPage();
        }
        else if(ae.getSource()==b3){
            int nog;
            dao.createConnection();
            nog=dao.getNOG();
            System.out.println(nog);
            GmailPage g;
            g=new GmailPage(nog);
        }
        else if(ae.getSource()==b0){
            this.dispose();
        }
    }
}
