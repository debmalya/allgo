import junit.framework.Assert;

import org.junit.Test;



public class ZeroFactorTest
{

  @Test
  public void testGetEachZ ()
  {
    int result = ZeroFactor.getEachZ (3);
    Assert.assertEquals (0, result);
    result = ZeroFactor.getEachZ (60);
    Assert.assertEquals (14, result);
    result = ZeroFactor.getEachZ (100);
    Assert.assertEquals (24, result);
    result = ZeroFactor.getEachZ (1024);
    Assert.assertEquals (253, result);
    result = ZeroFactor.getEachZ (23456);
    Assert.assertEquals (5861, result);
    result = ZeroFactor.getEachZ (8735373);
    Assert.assertEquals (2183837, result);
    System.out.println (ZeroFactor.getEachZ (1000000000));
  }

}
