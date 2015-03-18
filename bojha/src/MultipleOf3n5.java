import java.util.HashSet;
import java.util.Set;



public class MultipleOf3n5
{

  public MultipleOf3n5 ()
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



  public long getSum (int n)
  {
    long total = 0;
    int multipleOf3 = 3;
    int multipleOf5 = 5;
    Set<Integer> numbersUsed = new HashSet<Integer> ();


    while (multipleOf3 < n)
    {
      if (numbersUsed.add (multipleOf3))
      {
        total += multipleOf3;
        multipleOf3 += 3;
      }
    }

      while (multipleOf5 < n)
      {
        if (numbersUsed.add (multipleOf5))
        {
          total += multipleOf5;
        }
        multipleOf5 += 5;
      }
    

    return total;
  }


}
