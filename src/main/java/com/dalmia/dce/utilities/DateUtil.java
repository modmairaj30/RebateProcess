package com.dalmia.dce.utilities;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  

 public class DateUtil {  
       public static String  dateToString(Date dateObj){
    	   if(dateObj!=null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                String strDate = dateFormat.format(dateObj);  
                return strDate;
    	   }
              return null;   
        }  
   
       /*
       public static String  dateToDate(Date dateObj){
    	  if(dateObj!=null) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");  
                String strDate = dateFormat.format(dateObj);  
                Date lDate = strDate;
                return lDate;
    	   }
              return null;   
        }  */
}  

