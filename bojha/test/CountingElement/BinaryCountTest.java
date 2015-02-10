package CountingElement;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryCountTest {

	@Test
	public void testSolution() {
		BinaryCount bc = new BinaryCount();
		int r = bc.solution(new int[]{1, 4, 5});
		assertEquals(4, r);
		System.out.println(Integer.MAX_VALUE < 1000000000);
		
		// Max load
		int[] m = new int[10000];
		for (int i = 0; i < 10000; i++) {
			m[i] = (int)Math.pow(2,i);
			System.out.print(m[i]+",");
		}
		r = bc.solution(m);
		System.out.println(r);
	}
	

}
