package demo;


import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main1{
    public static void main(String[] args) {
        JPanel1 ob=new JPanel1();
        JFrame f1=new JFrame();
        
        f1.setVisible(true);
        f1.setLayout(null);
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ob.setBounds(50,50,400,550);
        f1.add(ob);
    }
}

class JPanel1 extends JPanel{
        /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    protected Color shadowColor = Color.red;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    /** Double values for Horizontal and Vertical radius of corner arcs */
    protected Dimension arcs = new Dimension(90,90);
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 5;
    /** The offset of shadow.  */
    protected int shadowOffset = 120;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 150;

//FOLLOWING CODES GOES HERE
    public JPanel1(){
        super();
        this.setOpaque(true);
    }
    @Override
    protected void paintComponent(Graphics g){
       super.paintComponent(g);
       int width = 400;
       int height = getHeight();
       int shadowGap = this.shadowGap;
       Graphics2D graphics = (Graphics2D) g;

       //Sets antialiasing if HQ.
       if (highQuality) {
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
           RenderingHints.VALUE_ANTIALIAS_ON);
       }

       //Draws shadow borders if any.
       if (shady) {
           graphics.setColor(Color.LIGHT_GRAY);
           graphics.fillRoundRect(16,248,148,32,30,30);// arc Dimension
       } else {
           shadowGap = 1;
       }

       //Draws the rounded opaque panel with borders.
       graphics.setColor(getBackground());
//       graphics.fillRoundRect(0, 0, width - shadowGap,
//       height - shadowGap, arcs.width, arcs.height);
       graphics.setColor(getForeground());
       graphics.setStroke(new BasicStroke(strokeSize));
       graphics.drawRoundRect(0, 0, width - shadowGap,
       height - shadowGap, arcs.width, arcs.height);

       //Sets strokes to default, is better.
       graphics.setStroke(new BasicStroke());
    }
}