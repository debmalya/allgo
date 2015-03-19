
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
	  long max = Math.max(a, b);
		if (a == 0 || b == 0 || a == b) {
			return max;
		}  else {			
			long min = Math.min(a, b);
			if (max % min == 0) {
				return min;
			}
			
			return gcd(max,max % min);
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
