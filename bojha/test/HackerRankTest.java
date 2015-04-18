import static org.junit.Assert.*;

import org.junit.Test;


public class SolutionTest {

	@Test
	public void testSolution() {
		Solution solution = new Solution();
		int r = solution.solution(new int[]{1, 1, 0, 1, 0, 0});
		assertEquals(4, r);
		
	    r = solution.solution(new int[]{1, 1, 1, 1, 0, 1});
		assertEquals(5, r);
		
		r = solution.solution(new int[]{1, 1, 1, 1, 0, 0, 0, 1, 0, 0});
		assertEquals(6, r);
		
		r = solution.solution(new int[]{1, 1, 1, 1, 0, 0,0,1,0});
		assertEquals(5, r);
		
	}

}
