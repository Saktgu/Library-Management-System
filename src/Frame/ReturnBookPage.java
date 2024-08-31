package Frame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import mypack.DAO;
import mypack.Storage;
public class ReturnBookPage extends JFrame implements ActionListener{
    JTable t1;
    DefaultTableModel dtm;
    JButton b1,b0;
    int key=0,row=0;
    ResultSet rs;
    DAO dao=new DAO();
    public ReturnBookPage(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"zreturnbook.jpg")));
        this.setUndecorated(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        dtm=new DefaultTableModel();
        t1=new JTable(dtm);
        t1.setBounds(500,450,700,250);
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.addColumn("");
        dtm.insertRow(row,new String[]{"User Id","User name","Book Id"});
        dao.createConnection();
        rs=dao.getCheckStatus(Storage.uid);
        try{
            while(rs.next()){
                row++;
                dtm.insertRow(row, new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
            }
        }
        catch(Exception ex){
            System.out.println("abcd");
            System.out.println(ex);
        }
        b1=new JButton("Return");
        b1.setBounds(300,500,150,60);
        b1.setFont(new Font("",Font.PLAIN,23));
        b1.addActionListener(this);
        b0=new JButton("bACK");
        b0.setBounds(0,0,50,50);
        b0.addActionListener(this);
        this.add(b0);
        this.add(b1);
        this.add(t1);
        
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            dao.createConnection();
            String bookid=(String)t1.getValueAt(t1.getSelectedRow(),2 );
            int a=dao.checkStatus(bookid);
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
