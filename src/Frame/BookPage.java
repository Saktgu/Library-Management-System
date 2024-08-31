package Frame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mypack.Storage;
public class BookPage extends JFrame implements ActionListener{
    JButton b1,b2,b3,b0;
    public BookPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zbook.jpg")));
        this.setUndecorated(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        
        b0=new JButton("back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        b1=new JButton("Add Book");
        b1.setBounds(900,200,200,70);
        b1.setFont(new Font("",Font.PLAIN,23));
        b1.addActionListener(this);
        b2=new JButton("Remove Book");
        b2.setBounds(900,350,200,70);
        b2.setFont(new Font("",Font.PLAIN,23));
        b2.addActionListener(this);
        b3=new JButton("Show book");
        b3.setBounds(900,500,200,70);
        b3.setFont(new Font("",Font.PLAIN,23));
        b3.addActionListener(this);
        this.add(b0);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        
        this.setVisible(true);
        this.pack();
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            AddBook ab=new AddBook();
        }
        else if(ae.getSource()==b2){
            RemoveBook rb=new RemoveBook();
        }
        else if(ae.getSource()==b0){
            this.dispose();
        }
        else if(ae.getSource()==b3){
            ShowBookPage sbp=new ShowBookPage();
        }
    }
}
