import static org.junit.Assert.*;

import org.junit.Test;


public class FrogJumpOverRiverTest {

	@Test
	public void testSolution() {
		FrogJumpOverRiver river = new FrogJumpOverRiver();
		river.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
	}

}
