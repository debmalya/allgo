import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EquilibriumIndexTest {

	@Test
	public void test() {
		EquilibriumIndex ei = new EquilibriumIndex();
		int r = ei.solution(new int[] { -1, 3, -4, 5, 1, -6, 2, 1 });

		assertEquals(1, r);

		r = ei.solution(new int[] { Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE , Integer.MIN_VALUE, Integer.MAX_VALUE});
		assertEquals(3, r);
		
		r = ei.solution(new int[] { Integer.MAX_VALUE});
		assertEquals(0, r);
	}

}
