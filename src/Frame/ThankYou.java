package Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mypack.Storage;

public class ThankYou extends JFrame{
    
    public ThankYou(){
        this.setContentPane(new JLabel(new ImageIcon(Storage.impath+"ztu.jpg")));
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLayout(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.pack();
    }
    
}
