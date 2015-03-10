import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testGetFibonacci() {
		// fail("Not yet implemented");
		Fibonacci fibo = new Fibonacci();
		int[] values = fibo.getFibonacci(30);
		Assert.assertEquals(30, values.length);
		Assert.assertTrue(values.length == 30);
		try {
			values = fibo.getFibonacci(-30);
		} catch (IllegalArgumentException iae) {
			Assert.assertTrue("Passing negative value should through IllegalArgumentException ",true);
		}
		values = fibo.getFibonacci(0);

		
	}

	@Test
	public void testFibonacci() {
		Fibonacci fibo = new Fibonacci();
		Assert.assertEquals(0, fibo.fibonacci(0));
		Assert.assertEquals(1, fibo.fibonacci(1));
		Assert.assertEquals(1, fibo.fibonacci(2));
		Assert.assertEquals(2, fibo.fibonacci(3));
		Assert.assertEquals(3, fibo.fibonacci(4));
		Assert.assertEquals(5, fibo.fibonacci(5));
		Assert.assertEquals(8, fibo.fibonacci(6));
		// System.out.println(fibo.fibonacci(50));
		System.out.println(fibo.fibonacci(-1));
		System.out.println(fibo.fibonacci(-2));
		System.out.println(fibo.fibonacci(-3));
		System.out.println(fibo.fibonacci(-4));
		System.out.println(fibo.fibonacci(-5));
		System.out.println(fibo.fibonacci(-6));
		System.out.println(fibo.fibonacci(-7));
		System.out.println(fibo.fibonacci(-8));
	}

}
