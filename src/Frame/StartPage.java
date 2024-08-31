package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import main.main;
import mypack.DAO;
import mypack.Storage;

public class StartPage extends JFrame {
    DAO dao=new DAO();
    JLabel l1,l2;
    JButton b1;
    JProgressBar pb;
    public StartPage(int a){
        this.getContentPane().setBackground(new Color(0,0,0));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        
        Storage.jp1=new JProgressBar(0,a);
        pb=Storage.jp1;
        pb.setBounds(500,500,300,20);
        pb.setValue(0);
        pb.setForeground(Color.WHITE);
        pb.setBackground(Color.BLACK);
        pb.setVisible(false);
        
        l1=new JLabel("Loading");
        l1.setBounds(590,530,150,100);
        l1.setForeground(Color.WHITE);
        l1.setVisible(false);
        
        b1=new JButton(new ImageIcon(Storage.impath+"zstartbutton.jpg"));
        b1.setBounds(470,200,320,325);
        b1.setContentAreaFilled(false);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.addActionListener((ActionEvent e) -> {
            Thread t1=new Thread(){
                @Override
                public void run(){
                    b1.setVisible(false);
                    l2.setVisible(false);
                    pb.setVisible(true);
                    l1.setVisible(true);
                    l1.setFont(new Font("",Font.BOLD,27));
                    dao.createConnection();
                    dao.update();
                    LoginPage lp=new LoginPage();
                    main.sp.dispose();
                }
            };
            t1.start();
        });
        
        l2=new JLabel("Click to Launch the Application");
        l2.setBounds(400,550,550,100);
        l2.setFont(new Font("",Font.BOLD,35));
        l2.setForeground(Color.WHITE);
        l2.setVisible(true);
        
        this.add(b1);
        this.add(pb);
        this.add(l1);
        this.setVisible(true);
        this.add(l2);
    }

    
}
