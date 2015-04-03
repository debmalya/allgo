package dj.math;

import junit.framework.Assert;

import org.junit.Test;


public class RandomGeneratorTest
{

  @Test
  public void test ()
  {
    for (int i = 0; i < 1000000; i++) {
      long l= RandomGenerator.randomWithinRange (200L, 400L);
      Assert.assertTrue("Number must be >= 200 && <= 400 " + l,l >= 200L && l <= 400L);
    }
  }

}
