import java.util.Scanner;
import java.lang.*;
import java.util.Calendar;


public class Program
{
    public static void main(String[] args)
    {
        
        Scanner x = new Scanner(System.in);
        String b = x.nextLine();
        
        int curdate = Calendar.getInstance().get(Calendar.DAY_OF_MONTH); 
      int curmonth = Calendar.getInstance().get(Calendar.MONTH)+1; 
      int curyear = Calendar.getInstance().get(Calendar.YEAR); 
     
        int birthdate=0, birthmonth=0, birthyear=0;
        if (b.length() < 8)
            System.out.println("Please enter your DOB preferably in dd mm yyyy (or) dd m yyyy (or) d m yyyy  (or) d mm yyyy formats");
        else
        {
        if (b.length() == 10 || b.length() == 8)
        try
        {
           String c = b.substring(0,2);
        String d = b.substring(3,5);
        String f = b.substring(6,10);
           birthdate = Integer.parseInt(c);
           birthmonth = Integer.parseInt(d);
           birthyear = Integer.parseInt(f);
        }
        catch(Exception e)
        {
           String c = b.substring(0,1);
           birthdate = Integer.parseInt(c);
           String d = b.substring(2,3);
           birthmonth = Integer.parseInt(d);
           String f = b.substring(4,8);
           birthyear = Integer.parseInt(f);
        }
        
        if (b.length() == 9)
        {
       try
        {
           String c = b.substring(0,2);
        String d = b.substring(3,4);
        String f = b.substring(5,9);
           birthdate = Integer.parseInt(c);
           birthmonth = Integer.parseInt(d);
           birthyear = Integer.parseInt(f);
        }
        catch(Exception e)
        {
           String c = b.substring(0,1);
           birthdate = Integer.parseInt(c);
           String d = b.substring(2,4);
           birthmonth = Integer.parseInt(d);
           String f = b.substring(5,9);
           birthyear = Integer.parseInt(f);
        }
        }
        if (birthyear <= 0 || birthmonth <= 0 || birthdate <=0 || birthmonth > 12 || birthdate > 31)
        System.out.println("Check once and enter correctly");
        else
        {
        System.out.println("Your birthday is: " + birthdate + "/" + birthmonth + "/" + birthyear);
        System.out.println("Today is: " + curdate + "/" + curmonth + "/" + curyear);
        if ((birthyear > curyear )|| ((birthyear == curyear ) && (birthmonth > curmonth)) ||((birthyear == curyear ) && (birthmonth == curmonth) && (birthdate > curdate)))
        System.out.println("Wow!! You are a person from future!!");
        else
        {
        String age = calc(birthmonth, curmonth, birthyear, curyear, birthdate, curdate);
        int years = Integer.parseInt(age.split(",.,")[0]);
        int months = Integer.parseInt(age.split(",.,")[1]);
        int days = Integer.parseInt(age.split(",.,")[2]);
        if (years == 0)
        {
            if (months == 0)
            {
                if (days == 0)
                    System.out.println("Happy Birthday kid.. Welcome to the world");
                else
                    System.out.println("Your age is: " + days + " days");
            }
            else
            {
                 if (days == 0)
                    System.out.println("Your age is: " + months + " months");
                else
                    System.out.println("Your age is: " + months + " months " + days + " days");
            }
        }
        else
        {
           if (months == 0)
            {
                if (days == 0)
                {
                    System.out.println("Your age is: " + years + " years" );
                    System.out.println("Happy Birthday..");
                }
                else
                    System.out.println("Your age is: " + years + " years" + days + " days");
            }
            else
            {
                 if (days == 0)
                    System.out.println("Your age is: " + years + " years"+ months + " months");
                else
                    System.out.println("Your age is: " + years + " years "+ months + " months " + days + " days");
            } 
        }
        }
        }
        }
    }
    public static String calc(int x1, int x2, int x3, int x4, int x5, int x6)       /* x1= birthmonth, x2=curmonth, x3=birthyear, x4=curyear, x5=birthdate, x6=curdate */ 
    {
        if (x1 > x2)
        {
            int y = x4 - x3 - 1;
            int m = 0,d = 0;
            if (x5 <= x6)
            {
                 m = 12 - x1 + x2;
                 d = x6 - x5;
            }
            else if (x5 > x6)
            {
                 m = 11 - x1 + x2;
                 d = x5 - x6;
            }
            return (y + ",.," +m+ ",.," +d);
        }
        else if (x1 <= x2)
        {
            int y = x4 - x3;
            int m = 0,d = 0;
            if (x5 <= x6)
            {
                 m = x2 - x1;
                 d = x6 - x5;
            }
            else if (x5 > x6)
            {
                 m = x2 - x1 - 1;
                 if (x1==4 || x1==6 || x1==9 || x1==11)
                 d = 30 - x5 + x6;
                 else if (x1==2)
                 {
                 if (x4 % 4 == 0)
                     d = 29 - x5 + x6;
                else d = 28 - x5 + x6;
                }
                else d = 31 - x5 + x6;
            }
            return(y + ",.," +m+ ",.," +d);
        }
        return "";
    }
}
