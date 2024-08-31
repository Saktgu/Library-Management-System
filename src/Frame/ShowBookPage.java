package Frame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import mypack.DAO;
import mypack.Storage;

public class ShowBookPage extends JFrame implements ActionListener{    
    ResultSet rs;
    JButton b0;
    int row=0;
    DAO dao=new DAO();
    JTable t1;
    DefaultTableModel dtm=new DefaultTableModel();    
    public ShowBookPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zshowbook.jpg")));
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);        
        t1=new JTable(dtm);
        t1.setBounds(200, 100, 650, 500);
        t1.setFont(new Font("",Font.PLAIN,17));
        t1.setForeground(Color.BLACK);
        t1.setBackground(Color.WHITE);
        t1.setGridColor(Color.GREEN);        
        dtm.addColumn("Book Id");
        dtm.addColumn("Book name");
        dtm.addColumn("author");
        dtm.addColumn("stock");
        dtm.insertRow(row, new String[]{"Book d","Book name","author","stock"});
        try{
            dao.createConnection();
            rs=dao.getTable();
            while(rs.next()){
                row++;
                dtm.insertRow(row, new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)+""});
            }
        }
        catch(Exception ex){        }        
        b0=new JButton("Back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);        
        this.add(b0);
        this.add(t1);
        
        this.pack();
        this.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) {
        this.dispose();
    }
}