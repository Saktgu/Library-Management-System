package Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import mypack.DAO;
public class Settings extends JFrame implements ActionListener, MouseMotionListener{
    public static JButton b1,b2,b3,b4;
    JPanel p1,p2,p3,p4,p5;
    JLabel l1;
    JCheckBox cb1;
    DAO dao=new DAO();
    public static boolean flagd=true,flaga=true,flags=true;
    public Settings(){
        this.setUndecorated(true);
        this.setVisible(true);
        this.setBounds(100,100,700,400);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        l1=new JLabel("Settings");
        l1.setBounds(550,0,100,30);
        l1.setFont(new Font("",Font.BOLD,25));
        p1=new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.LIGHT_GRAY);
                g.drawLine(0,39,1280, 39);
            }
        };
        p1.setLayout(null);
        p1.setBounds(0,0,1280,40);
        b1=new JButton(new ImageIcon("C:\\Users\\M.S.SAKTHIVEL\\Desktop\\sakthivel\\java\\images\\back.jpg"));
        b1.setBounds(0,0,40,40);
        b1.addActionListener(this);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        p1.addMouseMotionListener(this);
        p1.add(l1);
        p1.add(b1);
        p2=new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.LIGHT_GRAY);
                g.drawLine(259, 0, 259, 680);
            }
        };
        p2.setBounds(0,40,260,680);
        p2.setLayout(null);
        b2=new JButton(){
            protected void paintComponent(Graphics g){
                super.paintComponent((Graphics2D)g);
                if(flagd){}
                else{
                    g.setColor(new Color(10,170,255));
                    g.fillRoundRect(0, 0, 240, 60, 30, 30);
                }
                g.setFont(new Font("",Font.BOLD,20));
                dao.createConnection();
                int d=dao.getMode();
                if(d==1){
                    g.setColor(Color.BLACK);
                    g.drawString("Display", 80, 40);
                }
                else{
                    g.setColor(Color.WHITE);
                    g.drawString("Display", 80, 40);
                }
            }
        };
        b2.setBounds(5,20,240,60);
        b2.setContentAreaFilled(false);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.addActionListener(this);
        b2.addMouseMotionListener(this);
        b3=new JButton(){
            protected void paintComponent(Graphics g){
                super.paintComponent((Graphics2D)g);
                if(flaga){}
                else{
                    g.setColor(new Color(10,170,252));
                    g.fillRoundRect(0, 0, 240, 60, 30, 30);
                }
                g.setFont(new Font("",Font.BOLD,20));
                dao.createConnection();
                int d=dao.getMode();
                if(d==1){
                    g.setColor(Color.BLACK);
                    g.drawString("Admin", 80, 40);
                }
                else{
                    g.setColor(Color.WHITE);
                    g.drawString("Admin", 80, 40);
                }
            }
        };
        b3.setBounds(5,80,240,60);
        b3.setContentAreaFilled(false);
        b3.setFocusPainted(false);
        b3.setBorderPainted(false);
        b3.addActionListener(this);
        b3.addMouseMotionListener(this);
        b4=new JButton(){
            protected void paintComponent(Graphics g){
                super.paintChildren((Graphics2D)g);
                if(flags){}
                else{
                    g.setColor(new Color(10,170,252));
                    g.fillRoundRect(0, 0, 240, 60, 30, 30);
                }
                g.setFont(new Font("",Font.BOLD,20));
                dao.createConnection();
                int d=dao.getMode();
                if(d==1){
                    g.setColor(Color.BLACK);
                    g.drawString("Storage", 80, 40);
                }
                else{
                    g.setColor(Color.WHITE);
                    g.drawString("Storage", 80, 40);
                }
            }
        };
        b4.setBounds(5,140,240,60);
        b4.setFocusPainted(false);
        b4.setContentAreaFilled(false);
        b4.setBorderPainted(false);
        b4.addActionListener(this);
        b4.addMouseMotionListener(this);
        p2.addMouseMotionListener(this);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p3=new JPanel();
        p3.setBounds(260,40,1022,680);
        p3.setLayout(null);
        p3.addMouseMotionListener(this);
        p4=new JPanel();
        p4.setBounds(260,40,1030,680);
        p4.setLayout(null);
        p4.setVisible(false);
        cb1=new JCheckBox("Dark theme");
        cb1.setBounds(40,40,300,40);
        cb1.setBackground(Color.WHITE);
        cb1.addActionListener(this);
        p4.addMouseMotionListener(this);
        p4.add(cb1);
        p5=new JPanel();
        p5.setBounds(260, 40, 1030, 680);
        p5.setVisible(false);
        p5.setLayout(null);
        dao.createConnection();
        int a=dao.getMode();
        if(a==1){
            this.setWhite();
            cb1.setSelected(false);
        }
        else{
            this.setBlack();
            cb1.setSelected(true);
        }
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1)
            this.dispose();
        else if (ae.getSource()==b2){
            p4.setVisible(true);
            p3.setVisible(false);
            p5.setVisible(false);
        }
        else if (ae.getSource()==b3){
            p5.setVisible(true);
            p3.setVisible(false);
            p4.setVisible(false);
        }
        else if(ae.getSource()==cb1){
            dao.createConnection();
            if(cb1.isSelected()){
                this.setBlack();
                dao.setMode(0);
            }
            else{
                this.setWhite();
                dao.setMode(1);
            }
        }
    }
    public void setBlack(){
        p1.setBackground(Color.BLACK);
        l1.setForeground(Color.WHITE);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        p4.setBackground(Color.BLACK);
        cb1.setForeground(Color.WHITE);
        cb1.setBackground(Color.BLACK);
        p5.setBackground(Color.BLACK);
        p2.repaint();
    }
    public void setWhite(){
        p1.setBackground(Color.WHITE);        
        l1.setForeground(Color.BLACK);
        p2.setBackground(Color.WHITE);
        p3.setBackground(Color.WHITE);
        p4.setBackground(Color.WHITE);
        cb1.setForeground(Color.BLACK);
        cb1.setBackground(Color.WHITE);
        p5.setBackground(Color.WHITE);
        p2.repaint();
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
        if(e.getSource()==b2){
            flagd=false;
            b2.repaint();
            flaga=true;
            flags=true;
            b3.repaint();
        }
        else if(e.getSource()==b3){
            flaga=false;
            b3.repaint();
            flagd=true;
            flags=true;
            b2.repaint();
        }
        else if(e.getSource()==b4){
            flags=false;
            flaga=true;
            flagd=true;
            b2.repaint();
            b3.repaint();
        }
        else{
            flags=true;
            flaga=true;
            flagd=true;
            b2.repaint();
            b3.repaint();            
        }
    }
}