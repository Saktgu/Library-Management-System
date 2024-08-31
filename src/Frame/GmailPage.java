
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
import javax.swing.JProgressBar;

import mypack.DAO;
import mypack.Storage;

public class GmailPage extends JFrame implements ActionListener{
    JTable t1;
    JProgressBar pb1;
    JButton b1,b0,b2;
    ResultSet rs;
    DefaultTableModel dtm;
    int row=0;
    public GmailPage(int n){
        int nog=n;
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zgmail.jpg")));
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(null);
        this.setDefaultCloseOperation(3);
        dtm=new DefaultTableModel();
        t1=new JTable(dtm);
        t1.setBounds(50,100,800,500);
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.insertRow(row, new String[]{"user Id","User Name","Book Id","Start Date","End Date","Gmail","Sent Status"});
        try{
            DAO dao=new DAO();
            dao.createConnection();
            rs=dao.getBookStatus();
            while(rs.next()){
                row++;
                dtm.insertRow(row,new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
        }
        catch(Exception ex){}
        b1=new JButton("Send");
        b1.setBounds(900,550,100,100);
        b1.addActionListener(this);
        
        b2=new JButton("Print");
        b2.setBounds(1100,550,100,100);
        b2.addActionListener(this);
        
        if(nog==0)
            pb1=new JProgressBar(0,1);
        else
            pb1=new JProgressBar(0,nog);
        pb1.setBounds(100,650,700,30);
        Storage.jp1=pb1;
        pb1.setVisible(true);
        b0=new JButton("Back");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        this.add(b0);
        this.add(t1);
        this.add(b1);
        this.add(pb1);
        this.add(b2);
        
        this.pack();
        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            Thread t=new Thread(){
                public void run(){
                    DAO dao=new DAO();
                    pb1.setVisible(true);
                    dao.createConnection();
                    dao.sendMail();
                }
            };
            t.start();
        }
        else if(ae.getSource()==b0){
            this.dispose();
        }
        
        else if (ae.getSource()==b2){
            Thread t1=new Thread(){
                public void run(){
                    DAO dao=new DAO();
                    dao.createConnection();
                    dao.print();
                }
            };
            t1.start();
        }
    }
}
