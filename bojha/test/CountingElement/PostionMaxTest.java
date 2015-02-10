package CountingElement;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostionMaxTest {

	@Test
	public void test() {
		PostionMax max = new PostionMax();
		int r = max.solution(new int[]{4, 6, 2, 2, 6, 6, 1});
		assertEquals(4, r);
		
	}

}
