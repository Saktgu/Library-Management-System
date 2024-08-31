package mypack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import mypack.Storage;
import mypack.CalenderCalc;
import mypack.PDF;
import demo.main2;
import Gmail.GEmailSender;

public class DAO{
    public int a=0;
    Connection con;
    Statement st,st1;
    ResultSet rs;
    String query;
    String url= "jdbc:mysql://localhost:3306/user";
    String uname="root";
    String pass="Sakthi@1405";
    
    public void createConnection(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,uname,pass);
            st=con.createStatement();
            st1=con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void closeConnection(){
        try{
            st.close();
            st1.close();
            con.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void userEntry(String name,String profession,String phonenumber,String address,String gmail,String date,String enddate,String Id,int a,String password){
        try{
            query = "insert into userlog values("+a+",'"+Id+"','"+ name + "','" + profession  + "','"+phonenumber+"','"+address+"','"+gmail+"','"+date+"','"+enddate+"','"+password+"');";
            int count=st.executeUpdate(query);
        }
        catch(Exception ex){System.out.println(ex);}
        
    }
    
    public String[] getId(){
        try{
            String Id,arr[]=new String[2];
            int a;
            st = con.createStatement();
            query ="select max(snum) from userlog;";
            ResultSet rs=st.executeQuery(query);
            rs.next();
            int b=rs.getInt(1);
            a=b+1;
            Id="CL"+String.format("%03d", a);
            arr[0]=Id;
            arr[1]=""+a;
            rs.close();
            return arr;
        }
        catch(Exception ex){}
        
        return null;
    }
    
    public int checkbid(String bid){
        try{
            query="select * from booklog where bid='"+bid+"';";
            st=con.createStatement();
            rs=st.executeQuery(query);
            String a;
            boolean hasnext=rs.next();
            rs.close();
            if(hasnext)
                return 0;
            else
                return 1;
        }
        catch(Exception ex){}
        return 4;
    }
    
    public void bookEntry(String bid,String bname,String author,String pyear,int edition,int stock){
        try{
        query="insert into booklog values('"+bid+"','"+bname+"','"+author+"','"+pyear+"',"+edition+","+stock+");";
        int count=st.executeUpdate(query);
        }
        catch(Exception ex){}
    }
    
    public int checkAdminLogin(String username,String password){
        try{
            String p;
            st=con.createStatement();
            query="select * from admin where uname='"+username+"';";
            rs=st.executeQuery(query);
            if(rs.next()){
                p=rs.getString(2);
                if(p.equals(password)){
                    return 3;
                    
                }
                else{
                    return 2;
                    
                }
            }
            else{
                return 1;
            }
        }
        catch(Exception ex){}
        return 0;
    }
    
    public void demo(){
        try{
            a=0;
            query="select * from demo;";
            rs=st.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString(1)+" ");
                a+=1;
                try{Thread.sleep(2);}catch(Exception ex){}
                Storage.jp1.setValue(a);
            }
        }
        catch(Exception e){}
    }
    
    public int checkUser(String id, String password){
        try{
            query="select id,password from userlog where id='"+id+"';";
            rs=st.executeQuery(query);
            if(rs.next()){
                if(rs.getString(2).equals(password))
                    return 1;
                else
                    return 2;
            }
            else
                return 3;
        }
        catch(Exception ex){}
        return -1;
    }
    
    public String[] getTuple(String id){
        String[] row=new String[8];
        try{
            query="select * from userlog where id='"+id+"';";
            rs=st.executeQuery(query);
            rs.next();
            row[0]=rs.getString(3);
            row[1]=rs.getString(4);
            row[2]=rs.getString(5);
            row[3]=rs.getString(6);
            row[4]=rs.getString(7);
            row[5]=rs.getString(10);
            row[6]=rs.getString(8);
            row[7]=rs.getString(9);
        }
        catch(Exception ex){System.out.println(ex);}
        return row;
    }
    
    public int count(){
        int count=0;
        try{
            query="select count(*) from userlog";
            rs=st.executeQuery(query);
            rs.next();
            count=rs.getInt(1);
        }
        catch(Exception ex){
            
        }
        return count;
    }
    
    public void update(){
        CalenderCalc cc=new CalenderCalc();
        Functionality f=new Functionality();
        try{
            String sdate=cc.getDate1();
            query="select uid,edate from bookstatus";
            rs=st.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2).equals("null")){
                    continue;
                }
                int a=cc.checkDate(rs.getString(2), sdate);
                System.out.println("summa:"+a);
                if(a==0){
                    continue;
                }
                else{
                    query="update bookstatus set edate='null' where uid='"+rs.getString(1)+"';";
                    int v=st1.executeUpdate(query);
                    continue;
                }
                
            }
        } 
        catch(Exception ex){
            System.out.println("hello");
            System.out.println(ex);
            System.out.println(ex);
        }
        int counter=1;
        try{
            query="select id,edate from userlog";
            rs=st.executeQuery(query);
            while(rs.next()){
                String s1=rs.getString(2);
                if(s1.equals("null")){
                    Storage.jp1.setValue(counter);
                    f.suspend(100);
                    counter+=1;
                    continue;
                }
                String s2=cc.getDate1();
                int a=cc.checkDate(s1, s2);
                if(a==0){
                    Storage.jp1.setValue(counter);
                    f.suspend(100);
                    counter+=1;
                    continue;
                }
                else{
                    String id=rs.getString(1);
                    query="update userlog set edate='null' where id='"+id+"';";
                    int aa=st1.executeUpdate(query);
                    Storage.jp1.setValue(counter);
                    f.suspend(100);
                    counter+=1;
                }
            }
        }
        catch(Exception ex){
            System.out.print(ex);
        }
    }
    
    public void setMode(int a){
        try{
            query="update settings set mode="+a+";";
            int b=st.executeUpdate(query);
        }
        catch(Exception ex){}
    }
    
    public int getMode(){
        try{
            query="select * from settings";
            rs=st.executeQuery(query);
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception ex){}
        return 5;
    }
    
    public ResultSet getTable(){
        try{
            query="select bid,bname,author,stock from booklog";
            rs=st.executeQuery(query);
            return rs;
        }
        catch(Exception ex){}
        return rs;
    }
    
    public boolean deleteBook(String bid){
        try{
            query="delete from booklog where bid='"+bid+"';";
            int a=st.executeUpdate(query);
            if(a==0){
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception ex){
            
        }
        return false;
    }
    
    public boolean reduceStock(String bid){
        try{
            query="select stock from booklog where bid='"+bid+"';";
            rs=st.executeQuery(query);
            if(rs.next()==false){
                return false;
            }
            else{
                
                int stock=rs.getInt(1);
                
                if(stock==0){
                    return false;
                }
                stock--;
                query="update booklog set stock="+stock+" where bid='"+bid+"';";
                int a=st.executeUpdate(query);
                
                if(a==0){
                    return false;
                }
                else{
                    return true;
                }
            }
            
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean updateUser(String id,String name,String proffession,String ph_no,String address,String gmail,String password){
        try{
            query="update userlog set name='"+name+"', profession='"+proffession+"', pnum='"+ph_no+"', address='"+address+"', gmail='"+gmail+"', password='"+password+"' where id='"+id+"';";
            
            int a=st.executeUpdate(query);
            System.out.println("after execution");
            if(a==0){
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception ex){
            System.out.print(ex);
        }
        return false;
    }
    
    public ResultSet getUserTable(){
        try{
            query="select * from userlog";
            rs=st.executeQuery(query);
            return rs;
        }
        catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    
    public ResultSet getBookTable(String q){
        try{
            query=q;
            rs=st.executeQuery(query);
            return rs;
        }
        catch(Exception ex){
            return null;
        }
    }

    public int takeBook(String bookid){
        CalenderCalc cc=new CalenderCalc();
        query="select stock from booklog where bid = '"+bookid+"';";
        try{
            rs=st.executeQuery(query);
            rs.next();
            int stock=rs.getInt(1);
            if(stock==0){
                return 0;
            }
            stock-=1;
            System.out.println(stock);
            query="update booklog set stock ="+stock+" where bid='"+bookid+"';";
            int a=st.executeUpdate(query);
            if(a==1){
                String sdate=cc.getDate1();
                String edate=cc.addDate(sdate, 15);
                query="insert into bookstatus values('"+Storage.uid+"', '"+Storage.uname+"','"+bookid+"','"+sdate+"','"+edate+"','"+Storage.gmail+"',0);";
                int b=st.executeUpdate(query);
                if(b==1){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                return 0;
            }
        }
        catch(Exception ex){  
            System.out.println(ex);
            return -1;
        }
    }

    public int checkStatus(String bookid){
        try{
            System.out.println(bookid);
            System.out.println(Storage.uid);
            query="select * from bookstatus where bid='"+bookid+"' and uid='"+Storage.uid+"';";
            rs=st.executeQuery(query);
            System.out.println("after and");
            if(rs.next()){
                query="update booklog set stock=stock+1 where bid='"+bookid+"';";
                int a=st.executeUpdate(query);
                System.out.println("after +1");
                if(a==1){
                    query="delete from bookstatus where bid='"+bookid+"' and uid='"+Storage.uid+"';";
                    int b=st.executeUpdate(query);
                    System.out.println("after delete");
                    if(b==1){
                        return 1;
                    }
                    else
                        return 5;
                }
                else
                    return 10;
            }
            else{
                return 4;
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return -1;
    }

    public ResultSet getCheckStatus(String uid){
        try{
            query="select * from bookstatus where uid='"+uid+"';";
            rs=st.executeQuery(query);
            return rs;
        }
        catch(Exception ex){
            System.out.println("abcd");
            System.out.println(ex);
            return null;
        }
    }

    public ResultSet getBookStatus(){
        try{
            query="select * from bookstatus";
            rs=st.executeQuery(query);
            return rs;
        }
        catch(Exception ed){
            return null;
        }
    }

    public int getNOG(){
        try{
            query="select edate from bookstatus;";
            rs=st.executeQuery(query);
            int nog=0;
            while(rs.next()){
                if(rs.getString(1).equals("null")){
                    nog++;
                }
            }
            return nog;
        }
        
        catch(Exception ex){
            return 0;
        }
    }

    public void sendMail(){
        int counter=0;
        try{
            rs=this.getBookStatus();
            while(rs.next()){
                if(rs.getString(5).equals("null")){
                    if(rs.getInt(7)==0){
                        GEmailSender gEmailSender = new GEmailSender();
                        String to = rs.getString(6);
                        System.out.println(to);
                        System.out.println("sutharson.in@gmail.com");
                        String from = "sakthivelms1405@gmail.com";
                        String subject = "Library";
                        String text = "Late";
                        System.out.println("before");
                        boolean b = gEmailSender.sendEmail(to, from, subject, text);
                        System.out.println(b);
                        if(b){
                            query="update bookstatus set gs=1 where gmail='"+rs.getString(6)+"';";
                            int a=st1.executeUpdate(query);
                        }
                        System.out.println("after");
                        counter++;
                        Storage.jp1.setValue(counter);
                    }
                    else{
                        counter++;
                        Storage.jp1.setValue(counter);
                    }
                }
                else{
                    counter++;
                    Storage.jp1.setValue(counter);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        counter++;
        Storage.jp1.setValue(counter);
    }
    
    public void print(){
        try{
            query="select * from bookstatus;";
            rs=st.executeQuery(query);
            PDF pdf=new PDF();
            pdf.make(rs);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
