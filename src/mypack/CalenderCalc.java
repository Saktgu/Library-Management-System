
package mypack;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderCalc {
    Date date;
    SimpleDateFormat sdf;
    String sdate;
    
    
    public String getDate1(){
        date =new Date();
        sdf=new SimpleDateFormat("dd/MM/yyyy");
        sdate=sdf.format(date);
        return sdate;
    }
    
    public String addDate(String date,int adder){
        try{
            Calendar cal=Calendar.getInstance();
            cal.setTime(sdf.parse(date));
            cal.add(Calendar.DAY_OF_MONTH,adder);
            String enddate=sdf.format(cal.getTime());
            return enddate;
        }
        catch(Exception ex){}
        return null;
    }
    
    public int checkDate(String sd1,String sd2){
        String s1,s2;
        s1=sd1;
        s2=sd2;
        int arr1[]=new int[3],arr2[]=new int[3];
        arr1[0]=Integer.parseInt(s1.substring(0, 2));
        arr1[1]=Integer.parseInt(s1.substring(3, 5));
        arr1[2]=Integer.parseInt(s1.substring(6, 10));
        arr2[0]=Integer.parseInt(s2.substring(0, 2));
        arr2[1]=Integer.parseInt(s2.substring(3, 5));
        arr2[2]=Integer.parseInt(s2.substring(6, 10));
        System.out.println(arr1[0]+" "+arr1[1]+" "+arr1[2]);
        System.out.println(arr2[0]+" "+arr2[1]+" "+arr2[2]);
        if (arr2[2]>arr1[2]){
            return 1;
        }
        else{
            if (arr2[2]<arr1[2]){
                return 0;
            }
            else{
                if(arr2[1]<arr1[1]){
                    return 0;
                }
                else{
                    if(arr2[1]>arr1[1]){
                        return 1;
                    }
                    else{
                        if(arr2[0]<=arr1[0]){
                            return 0;
                        }
                        else if(arr2[0]>arr1[0]){
                            return 1;
                        }
                    }
                }
            }
        }
        return 5;
    }
    
}
