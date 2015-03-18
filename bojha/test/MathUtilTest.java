import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.Test;



public class MathUtilTest
{

  @Test
  public void testGcd ()
  {

    assertEquals (2, MathUtil.gcd (2, 6));
    assertEquals (2, MathUtil.gcd (2, 0));
    assertEquals (2, MathUtil.gcd (0, 2));
    assertEquals (0, MathUtil.gcd (0, 0));
    assertEquals (1, MathUtil.gcd (4, 3));
    assertEquals (1, MathUtil.gcd (3, 4));
  }



  @Test
  public void testLcd ()
  {

    assertEquals (6, MathUtil.lcd (2, 6));
    assertEquals (0, MathUtil.lcd (2, 0));
    assertEquals (12, MathUtil.lcd (4, 3));
    assertEquals (12, MathUtil.lcd (3, 4));
  }



  @Test
  public void testGetSmallest ()
  {
    long value = MathUtil.getSmallestMultiple (10);

    for (int i = 2; i < 11; i++)
    {
      Assert.assertTrue(value + " should be divisible by " + i , value % i == 0);
    }
    
    value = MathUtil.getSmallestMultiple (20);

    for (int i = 2; i < 21; i++)
    {
      Assert.assertTrue(value + " should be divisible by " + i , value % i == 0);
    }
  }

}
