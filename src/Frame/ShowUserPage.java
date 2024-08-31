package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import mypack.Storage;
import mypack.DAO;

public class ShowUserPage extends JFrame implements ActionListener{  
    JTable t1;
    ResultSet rs;
    JButton b0;
    DefaultTableModel dtm=new DefaultTableModel();
    int row=0;    
    public ShowUserPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zshowuser.jpg")));
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        
        t1=new JTable(dtm);
        t1.setBounds(50,150,700,400);        
        dtm.addColumn("Id");
        dtm.addColumn("Name");
        dtm.addColumn("Profession");
        dtm.addColumn("Phone number");
        dtm.addColumn("Address");
        dtm.addColumn("Gmail");
        dtm.addColumn("Start Date");
        dtm.addColumn("End Date");
        dtm.insertRow(row, new String[]{"Id","Name","Profession","Phone number","Address","Gmail","Start Date","End Date"});       
        DAO dao=new DAO();
        dao.createConnection();        
        try{
            rs=dao.getUserTable();
            while(rs.next()){
                String id=rs.getString(2);
                String name=rs.getString(3);
                String profession=rs.getString(4);
                String phnum=rs.getString(5);
                String addr=rs.getString(6);
                String gmail=rs.getString(7);
                String startdate=rs.getString(8);
                String Enddate=rs.getString(9);
                row++;
                dtm.insertRow(row, new String[]{id,name,profession,phnum,addr,gmail,startdate,Enddate});
            }
        }
        catch(Exception ex){}        
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
