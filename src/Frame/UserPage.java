package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mypack.DAO;
import mypack.Storage;

public class UserPage extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1,tf2;
    JButton b1,b2,b0,b3;
   
    public UserPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zuser.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setBounds(0,0,1280,680);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        
        b0=new JButton("back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        
        l1=new JLabel("ID");
        l1.setBounds(100,200,200,100);
        l1.setFont(new Font("",Font.PLAIN,30));
        l1.setForeground(Color.WHITE);
        
        tf1=new JTextField();
        tf1.setFont(new Font("",Font.PLAIN,25));
        tf1.setBounds(290,220,200,70);
        
        l2=new JLabel("Password");
        l2.setBounds(100,350,200,100);
        l2.setFont(new Font("",Font.PLAIN,30));
        l2.setForeground(Color.WHITE);
        
        tf2=new JTextField();
        tf2.setFont(new Font("",Font.PLAIN,25));
        tf2.setBounds(290,370,200,70);
        
        l3=new JLabel("");
        l3.setBounds(400,350,200,50);
        l3.setForeground(Color.red);
        
        b1=new JButton("Submit");
        b1.setBounds(290,560,200,60);
        b1.setFont(new Font("",Font.PLAIN,27));
        b1.addActionListener(this);
        
        b2=new JButton("New User");
        b2.setBounds(900,220,200,100);
        b2.setFont(new Font("",Font.PLAIN,27));
        b2.addActionListener(this);
        
        b3=new JButton("Show User");
        b3.setBounds(900,370,200,100);
        b3.setFont(new Font("",Font.PLAIN,27));
        b3.addActionListener(this);
        
        this.add(b0);
        this.add(l1);
        this.add(tf1);
        this.add(l2);
        this.add(tf2);
        this.add(l3);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        
        //this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        DAO dao=new DAO();
        dao.createConnection();
        
        if (ae.getSource()==b0){
            this.dispose();
        }
        
        else if(ae.getSource()==b2){
            String s[]=dao.getId();
            NewUser nu=new NewUser(s);
        }
        
        else if(ae.getSource()==b1){
            int a=dao.checkUser(tf1.getText(),tf2.getText());
            if (a==1){
                Storage.id=tf1.getText();
                UserDetailPage udp=new UserDetailPage();
            }
            else if(a==2){
                l3.setText("password");
            }
            else if(a==3){
                l3.setText("userid");
            }
        }
        
        else if(ae.getSource()==b3){
            ShowUserPage sup=new ShowUserPage();
        }
    }
}
