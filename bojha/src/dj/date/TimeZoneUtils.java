package dj.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public class TimeZoneUtils
{

  public TimeZoneUtils ()
  {
    // TODO Auto-generated constructor stub
  }



  /**
   * @param args
   */
  public static void main (String[] args)
  {
    // TODO Auto-generated method stub

  }

  
  /**
   * Method to convert YYYY-MM-DD hh:mm:ss of a particular time zone to another
   * time zone
   * 
   * @param referenceDateTime
   *          The reference time (YYYY-MM-DD hh:mm:ss)
   * @param referenceTimeZone
   *          The reference time zone
   * @param targetTimeZone
   *          The target time zone
   * 
   * @return The converted time (YYYY-MM-DD hh:mm:ss)
   * 
   */
  public static String convertDateTime (Date referenceDateTime, TimeZone referenceTimeZone, TimeZone targetTimeZone)
  {
    // Given a time of YYYY-MM-DD hh:mm:ss in reference, get the time in target
    // time zone
    Calendar referenceCal = new GregorianCalendar (referenceTimeZone);
    referenceCal.set (Calendar.YEAR, Integer.parseInt ((new SimpleDateFormat ("yyyy")).format (referenceDateTime)));
    // Subtract 1 because month constants starts from index 0
    referenceCal.set (Calendar.MONTH, Integer.parseInt ((new SimpleDateFormat ("MM")).format (referenceDateTime)) - 1);
    referenceCal.set (Calendar.DATE, Integer.parseInt ((new SimpleDateFormat ("dd")).format (referenceDateTime)));
    referenceCal.set (Calendar.HOUR_OF_DAY, Integer.parseInt ((new SimpleDateFormat ("HH")).format (referenceDateTime)));
    referenceCal.set (Calendar.MINUTE, Integer.parseInt ((new SimpleDateFormat ("mm")).format (referenceDateTime)));
    referenceCal.set (Calendar.SECOND, Integer.parseInt ((new SimpleDateFormat ("ss")).format (referenceDateTime)));

    // Create a Calendar object with the target time zone and set
    // the UTC from referenceCal
    Calendar targetCal = new GregorianCalendar (targetTimeZone);
    targetCal.setTimeInMillis (referenceCal.getTimeInMillis ());

    // Get the time in the local time zone
    String format = String.format ("%%0%dd", Integer.valueOf (2));
    String formatYear = String.format ("%%0%dd", Integer.valueOf (4));

    String year = String.format (formatYear, Long.valueOf (targetCal.get (Calendar.YEAR)));
    // Add 1 because month constants starts from index 0
    String month = String.format (format, Long.valueOf (targetCal.get (Calendar.MONTH) + 1));
    String day = String.format (format, Long.valueOf (targetCal.get (Calendar.DATE)));
    String hours = String.format (format, Long.valueOf (targetCal.get (Calendar.HOUR_OF_DAY)));
    String minutes = String.format (format, Long.valueOf (targetCal.get (Calendar.MINUTE)));
    String seconds = String.format (format, Long.valueOf (targetCal.get (Calendar.SECOND)));

    return new StringBuilder (year).append ("-").append (month).append ("-").append (day).append (" ").append (hours).append (":").append (minutes).append (":").append (seconds).toString ();

  }

}
