package Frame;

import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import mypack.Storage;

public class HomePage extends JFrame implements ActionListener,MouseMotionListener{
    
    JLabel l1,l2;
    JButton b1,b2,b5,b6,bs;
    Font ff;
    boolean flag=true,flag1=true,flag2=true,flag3=true,flag4=true;
    int count=0;
    
    public HomePage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zhome.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        l1=new JLabel("Library");
        l1.setBounds(100,50,500,100);
        l1.setForeground(Color.WHITE);
        l2=new JLabel("  M  a  n  a  g  e  m  e  n  t");
        l2.setBounds(100,110,500,100);
        l2.setForeground(Color.pink);
        try{
            ff=Font.createFont(Font.TRUETYPE_FONT,new File(Storage.fopath+"f1.ttf"));
            ff=ff.deriveFont(100f);
            l1.setFont(ff);
            ff=ff.deriveFont(30f);
            l2.setFont(ff);
        }
        catch(Exception ex){}
        b1=new JButton(""){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if (flag){
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("",Font.PLAIN,35));
                    g.drawString("User", 40, 40);
                }
                else{
                    int x[]={0,0,280,300},y[]={0,50,60,0};
                    g.setColor(Color.pink);
                    g.fillPolygon(x, y, 4);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("",Font.BOLD,35));
                    g.drawString("User", 40, 40);
                }
            }
        };
        b1.setBounds(120,250,300,60);
        b1.setFocusPainted(false);
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.addActionListener(this);
        b1.addMouseMotionListener(this);
        b2=new JButton(""){
            protected void paintComponent(Graphics g1){
                super.paintComponent(g1);
                if(flag1){
                    g1.setColor(Color.WHITE);
                    g1.setFont(new Font("",Font.PLAIN,35));
                    g1.drawString("Book", 40, 40);
                }
                else{
                    int x[]={20,280,300,0},y[]={0,0,60,60};
                    g1.setColor(Color.pink);
                    g1.fillPolygon(x,y,4);
                    g1.setColor(Color.BLACK);
                    g1.setFont(new Font("",Font.BOLD,35));
                    g1.drawString("Book",40,40);
                }
            }
        };
        b2.setBounds(120,330,300,60);
        b2.setFocusPainted(false);
        b2.setBorderPainted(false);
        b2.setContentAreaFilled(false);
        b2.addActionListener(this);
        b2.addMouseMotionListener(this);
        b5=new JButton(""){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(flag2){
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("",Font.PLAIN,35));
                    g.drawString("Check Status", 40, 40);
                }
                else{
                    int x[]={0,300,300,20},y[]={10,0,60,60};
                    g.setColor(Color.pink);
                    g.fillPolygon(x, y, 4);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("",Font.BOLD,35));
                    g.drawString("Check Status",40,40);
                }
            }
        };
        b5.setBounds(120,410,300,60);
        b5.setFont(new Font("",Font.PLAIN,35));
        b5.setFocusPainted(false);
        b5.setBorderPainted(false);
        b5.setContentAreaFilled(false);
        b5.addActionListener(this);
        b5.addMouseMotionListener(this);
        bs=new JButton(""){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(flag3){
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("",Font.PLAIN,35));
                    g.drawString("Settings", 40, 40);
                }
                else{
                    int x[]={0,300,300,0},y[]={0,0,60,60};
                    g.setColor(new Color(252,4,128));
                    g.fillPolygon(x, y, 4);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("",Font.BOLD,35));
                    g.drawString("Setting", 40, 40);
                }
            }
        };
        bs.setBounds(120,490,300,60);
        bs.setFont(new Font("",Font.PLAIN,35));
        bs.setFocusPainted(false);
        bs.setBorderPainted(false);
        bs.setContentAreaFilled(false);
        bs.addActionListener(this);
        bs.addMouseMotionListener(this);
        b6=new JButton(""){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                if(flag4){
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("",Font.PLAIN,35));
                    g.drawString("Quit", 40, 40);
                }
                else{
                    int x[]={0,300,280,20},y[]={0,0,60,60};
                    g.setColor(Color.pink);
                    g.fillPolygon(x,y,4);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("",Font.PLAIN,35));
                    g.drawString("Quit", 40, 40);
                }
            }
        };
        b6.setBounds(120,490,300,60);
        b6.setFont(new Font("",Font.PLAIN,35));
        b6.setFocusPainted(false);
        b6.setBorderPainted(false);
        b6.setContentAreaFilled(false);
        b6.addActionListener(this);
        b6.addMouseMotionListener(this);
        this.addMouseMotionListener(this);
        this.add(l1);
        this.add(l2);
        this.add(b1);
        this.add(b2);
        this.add(b5);
        this.add(b6);
       
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==this.b1){
            UserPage up=new UserPage();
        }
        else if (ae.getSource()==b2){
            BookPage bp=new BookPage();
        }
        else if(ae.getSource()==this.b6){
            ThankYou tu=new ThankYou();
            this.dispose();
            new Timer(4000,(e)->{tu.dispose();}).start();
        }
        else if (ae.getSource()==this.bs){
            Settings s=new Settings();
        }
        else if(ae.getSource()==b5){
            CheckStatusPage csp=new CheckStatusPage();
        }
    }
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
        if(e.getSource()==b1){
            flag=false;
            b1.repaint();
            flag1=true;
            flag2=true;
            flag3=true;
            flag4=true;
            b2.repaint();
            b5.repaint();
            b6.repaint();
            bs.repaint();
        }
        else if(e.getSource()==b2){
            flag1=false;
            b2.repaint();
            flag=true;
            flag2=true;
            flag3=true;
            flag4=true;
            b1.repaint();
            b5.repaint();
            b6.repaint();
            bs.repaint();
        }
        else if(e.getSource()==b5){
            flag2=false;
            b5.repaint();
            flag1=true;
            flag=true;
            flag3=true;
            flag4=true;
            b1.repaint();
            b2.repaint();
            b6.repaint();
            bs.repaint();
        }
        else if(e.getSource()==bs){
            flag3=false;
            bs.repaint();
            flag1=true;
            flag2=true;
            flag4=true;
            b1.repaint();
            b2.repaint();
            b5.repaint();
            b6.repaint();
        }
        else if (e.getSource()==b6){
            flag4=false;
            b6.repaint();
            flag1=true;
            flag2=true;
            flag3=true;
            b1.repaint();
            b2.repaint();
            b5.repaint();
            bs.repaint();
        }
        else{
            flag=true;
            flag1=true;
            flag2=true;
            flag3=true;
            flag4=true;
            b1.repaint();
            b2.repaint();
            b5.repaint();
            b6.repaint();
            bs.repaint();
        }
    }
}