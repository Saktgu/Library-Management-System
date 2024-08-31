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
import javax.swing.JPasswordField;

import mypack.Storage;
import mypack.DAO;
import mypack.CalenderCalc;

public class NewUser extends JFrame implements ActionListener{
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField tf0,tf1,tf2,tf3,tf4,tf5;
    JPasswordField pwf1,pwf2;
    JButton b1,b2;
    String id;
    int a;
    DAO dao=new DAO();
    Thread t;
    CalenderCalc cc=new CalenderCalc();
    public NewUser(String s[]){
        id=s[0];
        a=Integer.parseInt(s[1]);
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"znewuser.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        l0=new JLabel("ID");
        l0.setFont(new Font("",Font.BOLD,30));
        l0.setForeground(Color.WHITE);
        l0.setBounds(700,100,200,70);
        tf0=new JTextField();
        tf0.setFont(new Font("",Font.BOLD,23));
        tf0.setBounds(1000,100,200,70);
        tf0.setEditable(false);
        tf0.setText(id);
        l1=new JLabel("Name");
        l1.setFont(new Font("",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        l1.setBounds(100,100,200,70);
        tf1=new JTextField();
        tf1.setFont(new Font("",Font.BOLD,23));
        tf1.setBounds(400,100,200,70);
        l2=new JLabel("Address");
        l2.setFont(new Font("",Font.BOLD,30));
        l2.setForeground(Color.WHITE);
        l2.setBounds(100,170,200,70);
        tf2=new JTextField();
        tf2.setFont(new Font("",Font.BOLD,23));
        tf2.setBounds(400,170,200,70);
        l3=new JLabel("Proffession");
        l3.setFont(new Font("",Font.BOLD,30));
        l3.setForeground(Color.WHITE);
        l3.setBounds(100,240,200,70);
        tf3=new JTextField();
        tf3.setFont(new Font("",Font.BOLD,23));
        tf3.setBounds(400,240,200,70);
        l4=new JLabel("gmail");
        l4.setFont(new Font("",Font.BOLD,30));
        l4.setForeground(Color.WHITE);
        l4.setBounds(100,310,200,70);
        tf4=new JTextField();
        tf4.setFont(new Font("",Font.BOLD,23));
        tf4.setBounds(400,310,200,70);
        l5=new JLabel("Phone Number");
        l5.setFont(new Font("",Font.BOLD,30));
        l5.setForeground(Color.WHITE);
        l5.setBounds(100,380,300,70);
        tf5=new JTextField();
        tf5.setFont(new Font("",Font.BOLD,23));
        tf5.setBounds(400,380,200,70);
        l6=new JLabel("Password");
        l6.setFont(new Font("",Font.BOLD,30));
        l6.setForeground(Color.WHITE);
        l6.setBounds(700,170,200,70);
        pwf1=new JPasswordField();
        pwf1.setFont(new Font("",Font.BOLD,23));
        pwf1.setBounds(1000,170,200,70);
        l7=new JLabel("Confirm Password");
        l7.setFont(new Font("",Font.BOLD,30));
        l7.setForeground(Color.WHITE);
        l7.setBounds(700,240,300,70);
        pwf2=new JPasswordField();
        pwf2.setFont(new Font("",Font.BOLD,23));
        pwf2.setBounds(1000,240,200,70);
        l8=new JLabel("");
        l8.setFont(new Font("",Font.BOLD,30));
        l8.setForeground(Color.WHITE);
        l8.setBounds(1000,330,200,70);
        l8.setForeground(Color.red);
        b1=new JButton("Submit");
        b1.setFont(new Font("",Font.BOLD,23));
        b1.setBounds(100,640,200,60);
        b1.addActionListener(this);
        b2=new JButton("Finish");
        b2.setFont(new Font("",Font.BOLD,23));
        b2.setBounds(400,640,200,60);
        b2.addActionListener(this);
        this.add(l0);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        this.add(l7);
        this.add(l8);
        this.add(tf0);
        this.add(tf1);
        this.add(tf2);
        this.add(tf3);
        this.add(tf4);
        this.add(tf5);
        this.add(pwf1);
        this.add(pwf2);
        this.add(b1);
        this.add(b2);
        
        //this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            if(pwf1.getText().equals(pwf2.getText())){
                dao.createConnection();
                String s1=cc.getDate1(),s2=cc.addDate(s1, 56);               
                dao.userEntry( tf1.getText(),tf3.getText(), tf5.getText(), tf2.getText(), tf4.getText(),s1,s2, id, a,pwf1.getText());
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                pwf1.setText("");
                pwf2.setText("");
                String ss[]=dao.getId();
                id=ss[0];
                a=Integer.parseInt(ss[1]);
                tf0.setText(id);
            }
            else{
                pwf1.setText("");
                pwf2.setText("");
                l8.setText("incorrect");
            }
        }
        else if (e.getSource()==b2){
            this.dispose();
        }
    }
}
