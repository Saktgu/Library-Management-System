package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.Connection;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

import mypack.DAO;
import mypack.Storage;

public class LoginPage extends JFrame implements ActionListener,KeyListener{
    
    boolean flag=true;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JPasswordField tf2;;
    JCheckBox cb;
    JButton b1,b2;
    InputStream is;
    Font ff;
    Image im,im1,im2,im3;
    
    public LoginPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zlogin.jpg")));
        this.setUndecorated(true);
        
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        try{
            im=ImageIO.read(new File(Storage.impath+"zulogo.png"));
            im1=ImageIO.read(new File(Storage.impath+"zsubmit.png"));
            im2=ImageIO.read(new File(Storage.impath+"zpassword.png"));
            im3=ImageIO.read(new File(Storage.impath+"zalert.png"));
        }
        catch(Exception e){
            System.out.println(e);
        }
        p1=new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D gg=(Graphics2D) g;
                gg.setColor(Color.white);
                gg.fillRoundRect(0,0,460,600,20,20);
                g.drawImage(im, 20, 222, null);
                g.drawImage(im2,20,327,null);
                g.setColor(Color.BLACK);
                g.drawLine(20,245,45,245);
                g.drawLine(20,350,45,350);
            }
        };
        p1.setOpaque(false);
        p1.setLayout(null);
        p1.setBounds(410,60,460,600);
        l1=new JLabel("Login");
        l1.setBounds(188,20,85,100);
        try{
            ff=Font.createFont(Font.TRUETYPE_FONT,new File(Storage.fopath+"f1.ttf"));
            ff=ff.deriveFont(35f);
            l1.setFont(ff);
        }
        catch(Exception ex){}
        l2=new JLabel("Username");
        l2.setFont(new Font("",Font.PLAIN,23));
        l2.setBounds(20,145,400,100);
        tf1=new JTextField("Type your Username"){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.drawLine(0, 25, 400, 25);
            }
        };
        Border bb=(BorderFactory.createEmptyBorder());
        tf1.setBorder(bb);
        tf1.setForeground(Color.GRAY);
        tf1.setBounds(45,220,355,26);
        tf1.setFont(new Font("",Font.PLAIN,20));
        tf1.addKeyListener(this);
        l3=new JLabel("Password");
        l3.setFont(new Font("",Font.PLAIN,23));
        l3.setBounds(20,250,400,100);
        tf2=new JPasswordField("Type your Password"){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(0, 25, 440, 25);
            }
        };
        tf2.setEchoChar((char)0);
        tf2.setForeground(Color.GRAY);
        tf2.setBounds(45,325,355,26);
        tf2.setFont(new Font("",Font.PLAIN,20));
        tf2.setBorder(bb);
        tf2.addKeyListener(this);
        cb=new JCheckBox("Show password",true);
        cb.setBounds(20,350,400,70);
        cb.setContentAreaFilled(false);
        cb.setFocusPainted(false);
        cb.setFont(new Font("",Font.BOLD,17));
        cb.addActionListener(this);
        b1=new JButton(""){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(im1, 0, 0, null);
                g.setColor(Color.WHITE);
                g.setFont(new Font("",Font.PLAIN,23));
                g.drawString("Submit", 160, 25);
            }
        };
        b1.setBounds(30,425,400,40);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.addActionListener(this);
        l4=new JLabel("g");
        l4.setVisible(false);
        l4.setForeground(Color.red);
//        b2=new JButton("demo");
//        b2.setBounds(0,0,100,100);
        p2=new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(im3, 0, 0, null);
            }
        };
        p2.setBounds(400,220,40,40);
        p2.setOpaque(false);
        p2.setVisible(false);
        p1.add(p2);
        p1.add(l4);
        p1.add(l2);
        p1.add(l1);
        p1.add(tf1);
        p1.add(l3);
        p1.add(tf2);
        p1.add(b1);
        p1.add(cb);
        this.add(p1);
                this.pack();
                this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==b1){
            DAO dao=new DAO();
            dao.createConnection();
            int s=0;
            String us=tf1.getText();
            String ps=tf2.getText();
            s=dao.checkAdminLogin(us, ps);
            if (s==1){
                if(!(tf1.getText().equals("") || tf1.getText().equals(" "))){
                    l4.setText("Incorrect userid");
                    l4.setBounds(130,145,400,100);
                    l4.setFont(new Font("",Font.PLAIN,17));
                    l4.setVisible(true);
                    p2.setBounds(400,220,40,40);
                    p2.setVisible(true);
                }
                else {
                    l4.setText("Blank spaces not allowed");
                    l4.setBounds(130,145,400,100);
                    l4.setFont(new Font("",Font.PLAIN,17));
                    l4.setVisible(true);
                    p2.setBounds(400,220,40,40);
                    p2.setVisible(true);
                }
            }
            else if (s==2){
                l4.setText("Incorrect Password");
                l4.setBounds(130,250,400,100);
                l4.setVisible(true);
                p2.setBounds(400,325,40,40);
                p2.setVisible(true);
            }
            else if (s==3){
                HomePage hp=new HomePage();
                this.dispose();
            }
            else if (s==5)
                System.out.print("Not");
        }
        else if(e.getSource()==cb){
            if(cb.isSelected()){
                tf2.setEchoChar((char)0);
                tf2.setFont(new Font("",Font.PLAIN,20));
            }
            else{
                tf2.setEchoChar('\u2022');
            }
        }
    }
    public void keyTyped(KeyEvent e) {    }
    public void keyPressed(KeyEvent e) {
        if (e.getSource()==tf1){
            if(tf1.getText().equals("Type your Username")){
                tf1.setText("");
                tf1.setForeground(Color.BLACK);
            }  
        }
        else if(e.getSource()==tf2){
            if(flag){
                cb.setSelected(false);
                flag=false;
            }
            if(tf2.getText().equals("Type your Password")){
                if(!(cb.isSelected())){
                    tf2.setEchoChar('\u2022');
                    tf2.setText("");
                    tf2.setForeground(Color.BLACK);
                }
                else{
                    tf2.setEchoChar((char)0);
                    tf2.setFont(new Font("",Font.PLAIN,20));
                }
            }  
        }
    }
    public void keyReleased(KeyEvent e) {    }
}
