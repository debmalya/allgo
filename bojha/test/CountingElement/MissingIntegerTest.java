package CountingElement;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissingIntegerTest {

	@Test
	public void test() {
		MissingInteger mi = new MissingInteger();
		int r = mi.solution(new int[]{1, 3, 6, 4, 1, 2});
		assertEquals(5, r);
		
		r = mi.solution(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE});
		assertEquals(1, r);
		
		
		int[] v = new int[100];
		for (int i = -100; i < 0; i++) {
			v[i + 100] = i;
		}
		
		
		r = mi.solution(v);
		assertEquals(1, r);
		
	}

}
