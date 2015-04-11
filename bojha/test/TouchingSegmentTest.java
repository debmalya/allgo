

import org.junit.Assert;
import org.junit.Test;

public class TouchingSegmentTest {

	@Test
	public void testGetNumberOfLines() {
		int result = TouchingSegment.getNumberOfLines(new String[] { "2 3",
				"1 3", "1 5", "3 4", "4 5" });
		Assert.assertEquals(5, result);
		
		result = TouchingSegment.getNumberOfLines(new String[] { "1 2",
				"1 3", "2 3", "1 4", "1 5","5 10"  });
		Assert.assertEquals(6, result);
		
		result = TouchingSegment.getNumberOfLines(new String[] { "1 2",
				"1 3", "2 3", "1 4", "1 5" });
		Assert.assertEquals(5, result);
		
		result = TouchingSegment.getNumberOfLines(new String[] { "1 5",
				"1 6", "1 7", "8 10" });
		Assert.assertEquals(4, result);
		
		result = TouchingSegment.getNumberOfLines(new String[] { "1 2",
				"3 4", "5 6" });
		Assert.assertEquals(2, result);
	}

}
