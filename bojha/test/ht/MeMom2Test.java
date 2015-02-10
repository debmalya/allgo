package ht;

import org.junit.Assert;
import org.junit.Test;

public class MeMom2Test {

	@Test
	public void testProcess() {
		String result = MeMom2.process(new String[] { "3 2", "1", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("1 3", result);
		
		result = MeMom2.process(new String[] { "3 2", "1", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("1 3 2", result);

		result = MeMom2.process(new String[] { "3 2", "2", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("2 1", result);
		
		result = MeMom2.process(new String[] { "3 2", "2", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("2 1 3", result);
		
		result = MeMom2.process(new String[] { "3 2", "3", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("3 1 2", result);

		result = MeMom2.process(new String[] { "5 5", "1", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("1 5", result);
		
		result = MeMom2.process(new String[] { "5 5", "1", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("1 5 3", result);

		result = MeMom2.process(new String[] { "5 5", "5", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("5 1", result);
		
		result = MeMom2.process(new String[] { "5 5", "5", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("5 1 3", result);
		
		result = MeMom2.process(new String[] { "5 5", "5", "4", "1 2 3 4" });
		System.out.println(result);
		Assert.assertEquals("5 1 3 2", result);
		
		result = MeMom2.process(new String[] { "5 5", "5", "5", "1 2 3 4 5" });
		System.out.println(result);
		Assert.assertEquals("5 1 3 2 4", result);

		result = MeMom2.process(new String[] { "5 5", "3", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("3 1", result);
		
		result = MeMom2.process(new String[] { "5 5", "3", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("3 1 5", result);
		
		result = MeMom2.process(new String[] { "5 5", "3", "5", "1 2 3 4 5" });
		System.out.println(result);
		Assert.assertEquals("3 1 5 2 4", result);


		result = MeMom2.process(new String[] { "5 5", "2", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("2 5", result);
		
		result = MeMom2.process(new String[] { "5 5", "2", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("2 5 1", result);
		
		result = MeMom2.process(new String[] { "5 5", "2", "5", "1 2 3 4 5" });
		System.out.println(result);
		Assert.assertEquals("2 5 1 3 4", result);

		result = MeMom2.process(new String[] { "5 5", "4", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("4 1", result);

		result = MeMom2.process(new String[] { "5 5", "4", "5", "1 2 3 4 5" });
		System.out.println(result);
//		TODO : Disputed it should be 4 1 2 3 5
		Assert.assertEquals("4 1 2 5 3", result);

		result = MeMom2.process(new String[] { "3 2", "3", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("3 1", result);

		result = MeMom2.process(new String[] { "20000 2", "1", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("1 20000", result);

		result = MeMom2
				.process(new String[] { "20000 2", "10000", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("10000 1", result);

		result = MeMom2
				.process(new String[] { "20000 2", "10000", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("10000 1 20000", result);

		result = MeMom2
				.process(new String[] { "20000 2", "20000", "2", "1 2" });
		System.out.println(result);
		Assert.assertEquals("20000 1", result);

		result = MeMom2
				.process(new String[] { "20000 2", "20000", "3", "1 2 3" });
		System.out.println(result);
		Assert.assertEquals("20000 1 10000", result);
		
		result = MeMom2
				.process(new String[] { "20000 3", "500", "4", "1 2 3 20000" });
		System.out.println(result);
		
		result = MeMom2
				.process(new String[] { "20000 3", "10000", "3", "1 2 20000" });
		System.out.println(result);
	}

	@Test
	public void testAssignSeat() {
		boolean[] occupied = new boolean[]{false,false,false,true,false};
		int r = MeMom2.assingnSeat(occupied, 3);
		Assert.assertEquals(0, r);
		occupied[r] = true;
		
		r = MeMom2.assingnSeat(occupied, 3);
		Assert.assertEquals(1, r);
		occupied[r] = true;
		
		r = MeMom2.assingnSeat(occupied, 3);
		Assert.assertEquals(2, r);
		occupied[r] = true;
		
		r = MeMom2.assingnSeat(occupied, 3);
		Assert.assertEquals(4, r);
		occupied[r] = true;
		
		
	}
}
