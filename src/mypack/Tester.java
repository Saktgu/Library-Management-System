package mypack;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.net.InetAddress;

public class Tester{
    
    String datee,ide,namee;
    Scanner sa=new Scanner(System.in);
    public DAO dao=new DAO(); 
    CalenderCalc cc=new CalenderCalc();
    
    public void establishConnection()throws Exception{
        dao.createConnection();
    }
    
    public void user()throws Exception {
        String name,proffesion,phonenum,address,gmail,date,enddate;
        System.out.print("Enter your name : ");
        name=sa.next();
        System.out.print("Enter your addrees : ");
        address=sa.nextLine();
        address=sa.nextLine();
        System.out.print("Enter your proffesion : ");
        proffesion=sa.next();
        System.out.print("Enter your gmail : ");
        gmail=sa.next();
        System.out.print("Enter your Phonenum : ");
        phonenum=sa.next();
//        date=cc.getDate();
//        enddate=cc.addDate(date, 56);
//        dao.userEntry(name, proffesion, phonenum, address, gmail, date, enddate);
        
    }
    
    public void book()throws Exception{
        String bname,bid,author,pyear;
        int stock,edition;
        System.out.print("Enter the book name : ");
        bname=sa.next();
        System.out.print("Enter the author of the book ; ");
        author=sa.next();
        System.out.print("Enter the year it was published : ");
        pyear=sa.next();
        System.out.print("Enter the edition : ");
        edition=sa.nextInt();
        System.out.print("Enter book Id in sever letters : ");
        bid=sa.next();
        while (true){
            while(bid.length()!=7){
                System.out.println("You have to enter 7 characters ");
                System.out.print("Enter book Id in sever letters : ");
                bid=sa.next();
            }
            if (dao.checkbid(bid)==1)
                break;
            else{
                System.out.println("The book Id is already present, please enter another id ");
                System.out.print("Enter book Id in sever letters : ");
                bid=sa.next();            
            }
        }
        System.out.print("Enter number of stock : ");
        stock=sa.nextInt();
        dao.bookEntry(bid, bname, author, pyear, edition, stock);
    }
    
    
}



