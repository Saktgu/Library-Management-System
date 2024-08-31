

package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import mypack.Storage;
import mypack.DAO;

public class UserDetailPage extends JFrame implements ActionListener{
    
    String id=Storage.id;
    DAO dao=new DAO();
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf9;
    JCheckBox cb1;
    JButton b1,b2,b3,b4,bs;
    
    public UserDetailPage(){
        
        dao.createConnection();
        String row[]=dao.getTuple(id);
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zshowdetails.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        
        l1=new JLabel("Id");
        l1.setFont(new Font("",Font.PLAIN,30));
        l1.setForeground(Color.WHITE);
        l1.setBounds(100,100,200,70);
        
        tf1=new JTextField();
        tf1.setBounds(300,100,300,70);
        tf1.setFont(new Font("",Font.PLAIN,23));
        tf1.setText(id);
        tf1.setEditable(false);
        
        l2=new JLabel("Name");
        l2.setFont(new Font("",Font.PLAIN,30));
        l2.setForeground(Color.WHITE);
        l2.setBounds(100,170,200,70);
        
        tf2=new JTextField();
        tf2.setBounds(300,170,300,70);
        tf2.setFont(new Font("",Font.PLAIN,23));
        tf2.setText(row[0]);
        tf2.setEditable(false);
        
        l3=new JLabel("Profession");
        l3.setFont(new Font("",Font.PLAIN,30));
        l3.setForeground(Color.WHITE);
        l3.setBounds(100,240,200,70);
        
        tf3=new JTextField();
        tf3.setBounds(300,240,300,70);
        tf3.setFont(new Font("",Font.PLAIN,23));
        tf3.setText(row[1]);
        tf3.setEditable(false);
        
        l4=new JLabel("Phone number");
        l4.setFont(new Font("",Font.PLAIN,30));
        l4.setForeground(Color.WHITE);
        l4.setBounds(100,310,200,70);
        
        tf4=new JTextField();
        tf4.setBounds(300,310,300,70);
        tf4.setFont(new Font("",Font.PLAIN,23));
        tf4.setText(row[2]);
        tf4.setEditable(false);
        
        l5=new JLabel("Address");
        l5.setFont(new Font("",Font.PLAIN,30));
        l5.setForeground(Color.WHITE);
        l5.setBounds(100,380,200,70);
        
        tf5=new JTextField();
        tf5.setBounds(300,380,300,70);
        tf5.setFont(new Font("",Font.PLAIN,23));
        tf5.setText(row[3]);
        tf5.setEditable(false);
        
        l6=new JLabel("gmail");
        l6.setFont(new Font("",Font.PLAIN,30));
        l6.setForeground(Color.WHITE);
        l6.setBounds(100,450,200,70);
        
        tf6=new JTextField();
        tf6.setBounds(300,450,300,70);
        tf6.setFont(new Font("",Font.PLAIN,23));
        tf6.setText(row[4]);
        tf6.setEditable(false);
        
        l7=new JLabel("Password");
        l7.setFont(new Font("",Font.PLAIN,30));
        l7.setForeground(Color.WHITE);
        l7.setBounds(100,520,200,70);
        
        tf7=new JTextField();
        tf7.setBounds(300,520,300,70);
        tf7.setFont(new Font("",Font.PLAIN,23));
        tf7.setText(row[5]);
        tf7.setEditable(false);
        
        if(row[7].equals("null")){
            l8=new JLabel("Prime status");
            l8.setFont(new Font("",Font.PLAIN,30));
            l8.setForeground(Color.WHITE);
            l8.setBounds(700,100,200,70);
            
            cb1=new JCheckBox("");
            cb1.setBounds(1000,100,20,40);
            cb1.setFont(new Font("",Font.PLAIN,80));
            cb1.setEnabled(false);
            
            this.add(l8);
            this.add(cb1);
        }
        else{
            l8=new JLabel("Prime status");
            l8.setFont(new Font("",Font.PLAIN,30));
            l8.setForeground(Color.WHITE);
            l8.setBounds(700,100,200,70);
            
            cb1=new JCheckBox("",true);
            cb1.setBounds(1000,100,20,40);
            cb1.setFont(new Font("",Font.PLAIN,80));
            cb1.setEnabled(false);
            
            l9=new JLabel("Prime last date");
            l9.setFont(new Font("",Font.PLAIN,30));
            l9.setForeground(Color.WHITE);
            l9.setBounds(700,170,200,70);
            
            tf9=new JTextField();
            tf9.setBounds(1000,170,300,70);
            tf9.setText(row[7]);
            tf9.setEditable(false);
            
            this.add(l8);
            this.add(cb1);
            this.add(l9);
            this.add(tf9);
        }
        
        b1=new JButton("back");
        b1.setBounds(0,0,50,50);
        b1.setFont(new Font("",Font.PLAIN,23));
        b1.addActionListener(this);
        
        b2=new JButton("Edit");
        b2.setBounds(100,640,200,50);
        b2.setFont(new Font("",Font.PLAIN,23));
        b2.addActionListener(this);
        
        bs=new JButton("Save");
        bs.setBounds(100,640,200,50);
        bs.setFont(new Font("",Font.PLAIN,23));
        bs.addActionListener(this);
        bs.setVisible(false);
        
        b3=new JButton("Take Book");
        b3.setBounds(350,640,200,50);
        b3.setFont(new Font("",Font.PLAIN,23));
        b3.addActionListener(this);
        
        b4=new JButton("Return Book");
        b4.setBounds(600,640,200,50);
        b4.setFont(new Font("",Font.PLAIN,23));
        b4.addActionListener(this);
        
        this.add(l1);
        this.add(tf1);
        this.add(l2);
        this.add(tf2);
        this.add(l3);
        this.add(tf3);
        this.add(l4);
        this.add(tf4);
        this.add(l5);
        this.add(tf5);
        this.add(l6);
        this.add(tf6);
        this.add(l7);
        this.add(tf7);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(bs);
        
        this.pack();
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            this.dispose();
        }
        
        else if (ae.getSource()==b2){
            tf2.setEditable(true);
            tf3.setEditable(true);
            tf4.setEditable(true);
            tf5.setEditable(true);
            tf6.setEditable(true);
            tf7.setEditable(true);
            bs.setVisible(true);
            b2.setVisible(false);
        }
        
        if(ae.getSource()==bs){
            String id=tf1.getText();
            String name=tf2.getText();
            String proffession=tf3.getText();
            String ph_no=tf4.getText();
            String address=tf5.getText();
            String gmail=tf6.getText();
            String password=tf7.getText();
            dao.createConnection();
            boolean c=dao.updateUser(id, name, proffession, ph_no, address, gmail, password);
            System.out.println(c);
            bs.setVisible(false);
            b2.setVisible(true);
        }
        
        else if(ae.getSource()==b3){
            Storage.uname=tf2.getText();
            Storage.uid=tf1.getText();
            Storage.gmail=tf6.getText();
            TakeBookPage tbp=new TakeBookPage();
        }
        
        else if(ae.getSource()==b4){
            Storage.uid=tf1.getText();
            Storage.uname=tf2.getText();
            ReturnBookPage rbp=new ReturnBookPage();
        }
    }
}
