
public class MathUtil
{

  public MathUtil ()
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


  public static long getSmallestMultiple(long term) {
    long result  = 1;
    for (int i =2; i <=term; i++) {
      result = lcd(result,i);
    }
    return result;
  }
  
  
  public static long lcd(long a,long b) {
    return a * b / gcd(a,b);
  }

  public static long gcd (long a, long b)
  {
    if (b == 0)
    {
      return a;
    }
    else
      if (a == 0)
      {
        return b;
      }
      else
        if (a > b)
        {
          if (a % b == 0)
          {
            return b;
          }
          return gcd (a, a % b);
        }
        else
        {
          if (b % a == 0)
          {
            return a;
          }
          return gcd (b % a, b);
        }
  }
  
  public int getNumberOfFipsRequired(int number1,int number2) {
    String value = Integer.toBinaryString (number1 ^ number2);
    int count = 0;
    for (int i = 0; i < value.length (); i++) {
      if (value.charAt (i) == '1') {
        count++;
      }
    }
    return count;
  }
} 
