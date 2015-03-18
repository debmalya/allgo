import java.math.BigInteger;

import junit.framework.Assert;

import org.junit.Test;



public class EvenFibonacciTest
{

  @Test
  public void testFibonacciSum ()
  {
    EvenFibonacci even = new EvenFibonacci ();
    BigInteger value = even.fibonacciSum (10L);
    Assert.assertEquals(10,value.intValueExact ());
    
    value = even.fibonacciSum (89L);
    Assert.assertEquals(44,value.intValueExact ());
    
    value = even.fibonacciSum (4000000L);
    System.out.println (value);
  }

}
