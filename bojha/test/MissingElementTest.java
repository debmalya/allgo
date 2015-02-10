import org.junit.Assert;
import org.junit.Test;


public class MissingElementTest {

	@Test
	public void testSolution() {
		MissingElement missingElement = new MissingElement();
		int missing = missingElement.solution(new int[]{2, 3, 1, 5});
		Assert.assertEquals("Expected 4 but found " + missing, missing, 4);
		
		missing = missingElement.solution(new int[]{2, 5, 1, 4});
		Assert.assertEquals("Expected 3 but found " + missing, missing, 3);
	}

}
