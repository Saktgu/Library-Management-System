
package Frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mypack.DAO;
import mypack.Storage;

public class TakeBookPage extends JFrame implements KeyListener,ActionListener{
    
    JTable t1;
    JTextField tf1;
    JRadioButton rb1,rb2;
    JButton b1,b2,b0;
    DefaultTableModel dtm;
    int i=1,row=0;
    
    public TakeBookPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"ztakebook.jpg")));
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        
        b0=new JButton("Back");
        b0.setBounds(0, 0, 50, 50);
        b0.addActionListener(this);
        
        rb1=new JRadioButton("Search By Book Id");
        rb1.setBounds(100,100,300,60);
        rb1.setFont(new Font("",Font.PLAIN,23));
        rb1.setEnabled(true);
        rb1.addActionListener(this);
        
        rb2=new JRadioButton("Search By Author Name");
        rb2.setBounds(600,100,300,60);
        rb2.setFont(new Font("",Font.PLAIN,23));
        rb2.addActionListener(this);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        
        tf1=new JTextField("Search by Book Id");
        tf1.setBounds(200,250,300,70);
        tf1.setFont(new Font("",Font.PLAIN,23));
        tf1.addKeyListener(this);
        
        b1=new JButton("Search");
        b1.setBounds(600,250,150,60);
        b1.setFont(new Font("",Font.PLAIN,23));
        b1.addActionListener(this);
        
        b2=new JButton("Take");
        b2.setBounds(800,250,150,60);
        b2.setFont(new Font("",Font.PLAIN,23));
        b2.addActionListener(this);
        
        dtm=new DefaultTableModel();
        
        t1=new JTable(dtm);
        t1.setBounds(100,400,700,300);
        
        
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        
        dtm.insertRow(row, new String[]{"Id","Name","Author","Edition","Stock"});
        
        this.add(b0);
        this.add(rb1);
        this.add(rb2);
        this.add(tf1);
        this.add(b1);
        this.add(b2);
        this.add(t1);
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(i==1){
            tf1.setText("");
        }
        i++;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        DAO dao=new DAO();
        
        if(ae.getSource()==b1){
            row=0;
            ResultSet rs;
            String query="";
            dao.createConnection();
            if(rb1.isSelected()){
                query="select bid, bname, author, edition, stock from booklog where bid='"+tf1.getText()+"';";
            }
            else if(rb2.isSelected())
                query="select bid, bname, author, edition, stock from booklog where author='"+tf1.getText()+"';";
            try{
                rs=dao.getBookTable(query);
                while(rs.next()){
                    row++;
                    dtm.insertRow(row, new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
                }
            }
            catch(Exception ex){}
        }
        
        else if(ae.getSource()==rb1){
            tf1.setText("Search by BookId");
            i=1;
        }
        
        else if(ae.getSource()==rb2){
            tf1.setText("Search By Author");
            i=1;
        }
        else if(ae.getSource()==b2){
            String bid=(String)t1.getValueAt(t1.getSelectedRow(), 0);
            dao.createConnection();
            int a=dao.takeBook(bid);
            System.out.println(a);
            if(a==1){
                this.dispose();
            }
        }
        
        else if(ae.getSource()==b0){
            this.dispose();
        }
    }
    
    
}
