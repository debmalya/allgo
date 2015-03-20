import static org.junit.Assert.assertEquals;

import org.junit.Assert;
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
  public void testGetBinary() {
	  MathUtil util = new MathUtil();
	  Assert.assertTrue("1".equals(util.toBinaryString(1)));
	  Assert.assertTrue("10".equals(util.toBinaryString(2)));
	  Assert.assertTrue("11".equals(util.toBinaryString(3)));
	  Assert.assertTrue("100".equals(util.toBinaryString(4)));
	  Assert.assertTrue("101".equals(util.toBinaryString(5)));
	  Assert.assertTrue("110".equals(util.toBinaryString(6)));
	  Assert.assertTrue("111".equals(util.toBinaryString(7)));
  }
  

}
