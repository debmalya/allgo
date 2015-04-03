package dj.math;

import java.util.Random;


public class RandomGenerator
{

  public RandomGenerator ()
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
  
  public static long randomWithinRange(long minRange,long maxRange) {
    Random random = new Random();
    
    long r = random.nextLong();
    if (minRange < maxRange) {
        long n = maxRange - minRange, m = n - 1;
        if ((n & m) == 0L)  // power of two
            r = (r & m) + minRange;
        else if (n > 0L) {  // reject over-represented candidates
            for (long u = r >>> 1;            // ensure nonnegative
                 u + m - (r = u % n) < 0L;    // rejection check
                 u = random.nextLong() >>> 1) // retry
                ;
            r += minRange;
        }
        else {              // range not representable as long
            while (r < minRange || r >= maxRange)
                r = random.nextLong();
        }
    }
    return r;
  }

}
