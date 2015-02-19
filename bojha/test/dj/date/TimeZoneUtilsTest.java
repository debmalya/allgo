package dj.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Assert;
import org.junit.Test;


public class TimeZoneUtilsTest
{

  SimpleDateFormat format = new SimpleDateFormat ("YYYY-MM-DD hh:mm:ss");
  
  @Test
  public void testConvertDateTime ()
  {
    Date myDate = new Date();
    String melbourneTime = TimeZoneUtils.convertDateTime (myDate, TimeZone.getTimeZone ("Asia/Singapore"), TimeZone.getTimeZone ("Australia/Melbourne"));
    Date melbourneDate = validateDateTime (melbourneTime);
    
    String kolkataTime = TimeZoneUtils.convertDateTime (myDate, TimeZone.getTimeZone ("Asia/Singapore"), TimeZone.getTimeZone ("Asia/Kolkata"));
    Date kolkataDate = validateDateTime (kolkataTime);
    
    Assert.assertTrue (melbourneDate.after (kolkataDate));
    
  }

  private Date validateDateTime (String melbourneTime)
  {
    Assert.assertNotNull(melbourneTime);
    Date validatedDate = null;
    try
    {
       validatedDate = format.parse (melbourneTime);
    }
    catch (ParseException e)
    {
     Assert.assertFalse (e.getMessage (),true);
    }
    return validatedDate;
  }

}
