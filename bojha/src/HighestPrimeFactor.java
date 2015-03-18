public class HighestPrimeFactor
{

  public HighestPrimeFactor ()
  {
    // TODO Auto-generated constructor stub
  }



  /**
   * @param args
   */
  public static void main (String[] args)
  {

    System.out.println (getHighestPrimeFactor (600851475143L));
    System.out.println (getHighestPrimeFactor (6857));
  }



  public static long getHighestPrimeFactor (long value)
  {
    long divisor = 2L;
    while (value > 1)
    {
      while (value % divisor == 0)
      {
        value /= divisor;
      }
      if (value > 1)
      {
        divisor += 1;
      }
      if (divisor * divisor > value) {
        divisor = value;
        break;
      }
    }
    return divisor;
  }
}
