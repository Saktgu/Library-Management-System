
package mypack;

import javax.swing.JProgressBar;

public class Storage {
    public static String id="";
    public static JProgressBar jp1;
    public static String uid="";
    public static String uname="";
    public static String gmail="";
    private static PathFinder pf=new PathFinder();
    public static String impath=pf.getImageCWD();
    public static String fopath=pf.getFontCWD();
}
