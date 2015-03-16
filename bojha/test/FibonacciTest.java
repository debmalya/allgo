import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

	private static final int HIGHEST_TERM = 10000;

  @Test
	public void testGetFibonacci() {
		// fail("Not yet implemented");
		Fibonacci fibo = new Fibonacci();
		long startTime = System.currentTimeMillis ();
		
		BigInteger[] values = fibo.getFibonacci(HIGHEST_TERM);
		
		Assert.assertEquals(HIGHEST_TERM, values.length);
		Assert.assertTrue(values.length == HIGHEST_TERM);
//		printArray(values);
		System.out.println ("Time taken :" + (System.currentTimeMillis () - startTime)+ " ms");
		try {
			values = fibo.getFibonacci(-30);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Passing negative value should through IllegalArgumentException ",true);
		}
		
		values = fibo.getFibonacci(0);

		
	}

	
	
	public void printArray(BigInteger[] values) {
	  for (int i = 0; i < values.length; i++) {
	    System.out.println (values[i]);
	  }
	}

}
