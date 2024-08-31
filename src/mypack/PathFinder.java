
package mypack;

public class PathFinder {
    String cwd;
    
    public PathFinder(){
        this.cwd=System.getProperty("user.dir");
    }
    
    public String getCWD(){
        return cwd;
    }
    
    public String getImageCWD(){
        return (cwd+"\\src\\ZImages\\");
    }
    
    public String getFontCWD(){
        return (cwd+"\\src\\ZFont\\");
    }
    
    public static void main(String[] args) {
        System.out.println(Storage.impath+"\n"+Storage.fopath);
    }
}
