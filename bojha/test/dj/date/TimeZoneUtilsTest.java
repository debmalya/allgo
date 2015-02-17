package dj.date;

import java.util.Date;
import java.util.TimeZone;

import junit.framework.Assert;

import org.junit.Test;


public class TimeZoneUtilsTest
{

  @Test
  public void testConvertDateTime ()
  {
    Date myDate = new Date();
    String melbourneTime = TimeZoneUtils.convertDateTime (myDate, TimeZone.getTimeZone ("Asia/Singapore"), TimeZone.getTimeZone ("Australia/Melbourne"));
    Assert.assertNotNull(melbourneTime);
    String kolkataTime = TimeZoneUtils.convertDateTime (myDate, TimeZone.getTimeZone ("Asia/Singapore"), TimeZone.getTimeZone ("Asia/Kolkata"));
    Assert.assertNotNull(melbourneTime);
    System.out.println ("myDate :" + myDate + " melbourne time " + melbourneTime+" kolkata time "+ kolkataTime);
    
  }

}
