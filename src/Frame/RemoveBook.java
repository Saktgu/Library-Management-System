package Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mypack.DAO;
import mypack.Storage;

public class RemoveBook extends JFrame implements ActionListener{
    DAO dao=new DAO();
    JLabel l1,l2;
    JButton b0,b1,b2;
    JTextField tf1,tf2;
    public RemoveBook(){
        
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zremovebook.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        
        b0=new JButton("back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        l1=new JLabel("Book ID");
        l1.setFont(new Font("",Font.PLAIN,27));
        l1.setForeground(Color.WHITE);
        l1.setBounds(100,100,100,50);
        tf1=new JTextField();
        tf1.setFont(new Font("",Font.PLAIN,23));
        tf1.setBounds(250,100,200,50);
        b1=new JButton("Remove stock");
        b1.setFont(new Font("",Font.PLAIN,23));
        b1.setBounds(600, 90, 250, 70);
        b1.addActionListener(this);
        b2=new JButton("Remove Book");
        b2.setFont(new Font("",Font.PLAIN,23));
        b2.setBounds(900, 90, 250, 70);
        b2.addActionListener(this);
        this.add(l1);
        this.add(tf1);
        this.add(b0);
        this.add(b1);
        this.add(b2);
        
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b0){
            this.dispose();
        }
        else if(ae.getSource()==b2){
            dao.createConnection();
            boolean c=dao.deleteBook(tf1.getText());
            System.out.println(c);
        }
        else if (ae.getSource()==b1){
            dao.createConnection();
            boolean c=dao.reduceStock(tf1.getText());
            System.out.println(c);
        }
    }
}
