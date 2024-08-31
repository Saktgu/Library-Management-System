
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

public class AddBook extends JFrame implements ActionListener{
    
    DAO dao=new DAO();
    JLabel l1,l2,l3,l4,l5,l6,le;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton b0,b1;
    
    public AddBook(){
        
        dao.createConnection();
        
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zaddbooks.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        
        le=new JLabel("");
        le.setBounds(650,100,200,70);
        le.setForeground(Color.red);
        
        l1=new JLabel("Book Id");
        l1.setFont(new Font("",Font.PLAIN,30));
        l1.setForeground(Color.WHITE);
        l1.setBounds(100,100,200,70);
        
        tf1=new JTextField();
        tf1.setFont(new Font("",Font.PLAIN,23));
        tf1.setBounds(400,100,200,70);
        
        l2=new JLabel("Book Name");
        l2.setFont(new Font("",Font.PLAIN,30));
        l2.setForeground(Color.WHITE);
        l2.setBounds(100,170,200,70);
        
        tf2=new JTextField();
        tf2.setFont(new Font("",Font.PLAIN,23));
        tf2.setBounds(400,170,200,70);
        
        l3=new JLabel("Author");
        l3.setFont(new Font("",Font.PLAIN,30));
        l3.setForeground(Color.WHITE);
        l3.setBounds(100,240,200,70);
        
        tf3=new JTextField();
        tf3.setFont(new Font("",Font.PLAIN,23));
        tf3.setBounds(400,240,200,70);
        
        l4=new JLabel("Published Year");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("",Font.PLAIN,25));
        l4.setBounds(100,310,200,70);
        
        tf4=new JTextField();
        tf4.setFont(new Font("",Font.PLAIN,23));
        tf4.setBounds(400,310,200,70);
        
        l5=new JLabel("Edition");
        l5.setFont(new Font("",Font.PLAIN,30));
        l5.setForeground(Color.WHITE);
        l5.setBounds(100,380,200,70);
        
        tf5=new JTextField();
        tf5.setFont(new Font("",Font.PLAIN,23));
        tf5.setBounds(400,380,200,70);
        
        l6=new JLabel("Stock");
        l6.setFont(new Font("",Font.PLAIN,30));
        l6.setForeground(Color.WHITE);
        l6.setBounds(100,450,200,70);
        
        tf6=new JTextField();
        tf6.setFont(new Font("",Font.PLAIN,23));
        tf6.setBounds(400,450,200,70);
        
        b0=new JButton("back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        
        b1=new JButton("Add");
        b1.setFont(new Font("",Font.PLAIN,23));
        b1.setBounds(300,600,200,70);
        b1.addActionListener(this);
        
        
        this.add(le);
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
        this.add(b1);
        this.add(b0);
        
        this.pack();
        this.setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b0){
            this.dispose();
        }
        
        if(ae.getSource()==b1){
            String id=tf1.getText();
            if(id.length()!=7){
                le.setBounds(650,100,200,70);
                le.setText("Id must be 7 characters length");
            }
            else{
                int a=dao.checkbid(id);
                if(a==0){
                    le.setBounds(650,100,200,70);
                    le.setText("id is already used");
                }
                else if(a==1){
                    le.setText("");
                    dao.bookEntry(id, tf2.getText(), tf3.getText(), tf4.getText(),Integer.parseInt(tf5.getText()), Integer.parseInt(tf6.getText()));
                    tf1.setText("");
                    tf2.setText("");
                    tf3.setText("");
                    tf4.setText("");
                    tf5.setText("");
                    tf6.setText("");
//                    tf.setText("");
                }
            }
        }
    }
    
}

