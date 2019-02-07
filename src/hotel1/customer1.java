package hotel1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.joda.time.*;
class customer1 {
private String name, date1, date2;
private int roomType; //1 for deluxe 2 for semi deluxe 3 for platinum suite
private double fees;
private GregorianCalendar checkIn, checkOut;

	public void setName(String s)
	{
	  this.name = s;
	}
	public String getName()
	{
	  return name;
	}
	public void setRoomType(int i)
	{
	  this.roomType = i;
	}
	public void setCheckIn(int year, int month, int day)
	{
	    System.out.println(year+" "+month+" "+day);
            date1 = ""+day+"/"+month+"/"+year;
            checkIn = new GregorianCalendar(year, month-1, day);
	}
	public void setCheckOut(int year, int month, int day)
	{
	   System.out.println(year+" "+month+" "+day);
            date2 = ""+day+"/"+month+"/"+year;
           checkOut = new GregorianCalendar(year, month-1, day);
	}
        public boolean checkDate()
        {
            Date start = checkIn.getTime();
            Date today = checkOut.getTime();
            return (Days.daysBetween(new DateTime(start), new DateTime(today)).getDays()<=0);
        }
        
        public boolean isValidDate(){
         
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    sdf.setLenient(false);
                    try {

			Date date = sdf.parse(date1);
                        date = sdf.parse(date2);
			System.out.println(date1+"\n"+date2);

                    } catch (ParseException pe) {

			System.out.println("Invalid date");
			return false;
		}
                      return true;
        }
	public double getFees()   //Will need to import org.joda.time.*;
	{
		int stayDur;
                Date start = checkIn.getTime(); //new Date(checkIn.YEAR-1900, checkIn.MONTH, checkIn.DAY_OF_MONTH); // YMD (-1900 cuz date takes year from 1900. ie 1901 = 1)
		Date today = checkOut.getTime(); //new Date(checkOut.YEAR-1900 , checkOut.MONTH, checkOut.DAY_OF_MONTH); 
                System.out.println(start);
                System.out.println(today);
                
		stayDur = Days.daysBetween(new DateTime(start), new DateTime(today)).getDays();
		System.out.println(stayDur);
                double extraCharge = 1000*roomType;
                try
                {
                CalculateFees fee = new CalculateFees(name,4000,extraCharge,stayDur);
               
                    fee.join();
                    fees=fee.getTotal();
                }catch(InterruptedException ie)
                {}
                
//Thread.sleep(500);
                
                return fees;
   		 
	}
	public GregorianCalendar getCheckIn() //Will use to check for InvalidDateException, ie checkIn<checkOut Research compareTo in order to do so
	{
		return checkIn;
	}
	public GregorianCalendar getCheckOut()
	{
		return checkOut;
	}
	
}