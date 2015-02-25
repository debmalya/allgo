package deb.algo;

public class InsertionSort
{

  public Comparable[] sort (Comparable[] values)
  {
    for (int i = 1; i < values.length; i++)
    {

     
     
      for ( int j = i; j > 0; j--)
      {
        
        if (values[j - 1].compareTo (values[j]) > 0)
        {

          Comparable swap = values[j];
          values[j] = values[j - 1];
          values[j - 1] = swap;

        }
      }
    
    }
    return values;
  }
}
