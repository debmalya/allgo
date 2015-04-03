package dj.math;

import org.junit.Assert;
import org.junit.Test;


public class RandomGeneratorTest
{

  @Test
  public void test ()
  {
	long minCount = 0;
	long maxCount = 0;
	long minRange = 200L;
	long maxRange = 401L;
    for (int i = 0; i < 1000000; i++) {
      long l= RandomGenerator.randomWithinRange (minRange, maxRange);
      Assert.assertTrue("Number must be >= 200 && <= 400 " + l,l >= 200L && l <= 400L);
      if (l == minRange) {
    	  minCount++;
      } else if (l == maxRange - 1) {
    	  maxCount++;
      }
    }
    System.out.println(minRange+" occurs " + minCount);
    System.out.println((maxRange - 1)+" occurs " + maxCount);
  }

}
