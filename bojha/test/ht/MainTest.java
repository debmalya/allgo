package ht;

import static org.junit.Assert.*;

import java.math.BigInteger;

import junit.framework.Assert;

import org.junit.Test;

public class MainTest {
	@Test
	public void testFactorial() {
		BigInteger earlier = BigInteger.ONE;
		for (int i = 1; i < 101; i++) {
			BigInteger result = Main.factorial(i);
			earlier = earlier.multiply(BigInteger.valueOf(i)) ;
			assertTrue(earlier.equals(result));
			System.out.println(i+" -> " + result);
		}
	}
}
