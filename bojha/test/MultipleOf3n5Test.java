import junit.framework.Assert;

import org.junit.Test;



public class MultipleOf3n5Test
{

  @Test
  public void testGetSum ()
  {
    MultipleOf3n5 mul = new MultipleOf3n5 ();
    
    Assert.assertEquals(23L,mul.getSum (10));
    long result = mul.getSum (1000);
    System.out.println (result);
//    Assert.assertEquals(23L,mul.getSum (10));
  }

}
