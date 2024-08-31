
package demo;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import mypack.DAO;
import mypack.Storage;

public class main2 extends JFrame {

    JProgressBar pb;
    public static Thread t1;
    public main2(){
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(500,500);
        this.setDefaultCloseOperation(3);
        Storage.jp1=new JProgressBar(0,1000);
        pb=Storage.jp1;
        pb.setBounds(100,100,300,100);
        pb.setValue(0);
        
        
        this.add(pb);
    }
    
    
    public void iterate(){
        DAO dao=new DAO();
        dao.createConnection();
        dao.demo();
    }
    
    public static void main(String[] args) {
        main2 m=new main2();
        m.iterate();
    }
}

