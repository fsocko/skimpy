package BusinessLogic;
/**
 *
 ** @author fps
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
//Alina was here
/**
 * FILIP! CAN YOU DOCUMENT THE BLUE SECTIONS IN THIS FILE
 * A representation of a date.
 *
 */
public class DateMan
{
	/**
	 * Represents a date so the use by date of Food can be shown.
	 */
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Sets the initial date the Food is bought.
     * @param day The day of the month.
     * @param month The month of the year
     * @param year The year.
     * @return The initial date.
     */
    private Calendar setStartDate(int day, int month, int year)//date from which calendar is advanced. 
    {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.DAY_OF_MONTH, day);
        return date;
    }
    
    /**
     * Returns the date of expiration of the Food.
     * @param day The day of the month.
     * @param month The month of the year
     * @param year The year.
     * @param daysFromToday 
     * @return The expiration date.
     */
    public String getExpDate(int day, int month, int year, int daysFromToday)
    {
        Calendar c = setStartDate(day, month-1, year);
        c.add(Calendar.DATE, daysFromToday);
        String formatted = sdf.format(c.getTime());
        return formatted;
    }
    /**
     * Returns the date of expiration of the Food.
     * @param daysFromToday The expiration date from today.
     * @return The expiration date.
     */
      public String getExpDate(int daysFromToday) //exp date from today
    {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, daysFromToday);
        String formatted = sdf.format(c.getTime());
        return formatted;
    }
    
}

