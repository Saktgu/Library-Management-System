 package main;

import mypack.DAO;
import Frame.*;
public class main { 
    public static StartPage sp;
    public static HomePage hp;
    public static Settings s;
    public static void main(String[] args)throws Exception {
        DAO dao=new DAO();
        dao.createConnection();
        int a=dao.count();                                                      
        sp=new StartPage(a);
//        dao.print();
    }
}