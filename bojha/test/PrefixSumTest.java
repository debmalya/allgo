

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Debmalya Jash
 *
 */
public class PrefixSumTest {

	/**
	 * Test method for {@link PrefixSum#getIndex(java.lang.String)}.
	 */
	@Test
	public void testGetIndex() {
		
		int index = PrefixSum.getIndex0("2 3 1 6");
		Assert.assertEquals(2, index);
		
	    index = PrefixSum.getIndex0("5 4 2 3 1 2");
		Assert.assertEquals(2, index);	
		
		index = PrefixSum.getIndex0("6 1 -1 1 -1 1 -1");
		Assert.assertEquals(2, index);
		
		index = PrefixSum.getIndex0("3 0 0 0");
		Assert.assertEquals(1, index);
		
		index = PrefixSum.getIndex0("3 0 1 2");
        Assert.assertEquals(0, index);
		
		index = PrefixSum.getIndex0("3 1 1 1");
        Assert.assertEquals(0, index);
        
        index = PrefixSum.getIndex0("3 0 1 1 1");
        Assert.assertEquals(0, index);
				
		index = PrefixSum.getIndex0("5 4 -2 1 1 -2");
		Assert.assertEquals(3, index);
		
		index = PrefixSum.getIndex0("5 9 8");
		Assert.assertEquals(0, index);
		
		index = PrefixSum.getIndex0("5 9 1 8");
		Assert.assertEquals(1, index);
		
		
	}

}
