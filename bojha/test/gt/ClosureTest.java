/**
 * 
 */
package gt;



import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ClosureTest {

	/**
	 * Test method for {@link gt.Closure#getClosureCount(int[][])}.
	 */
	@Test
	public final void testGetClosureCount() {
		Closure closure = new Closure();
		int actual = closure.getClosureCount(new int[][]{{1,0,0,0},{0,1,0,0},{1,1,0,1}});
		Assert.assertEquals(3, actual);
		
		actual = closure.getClosureCount(new int[][]{{1,0,0,0},{0,1,0,0},{1,0,0,1}});
		Assert.assertEquals(4, actual);
		
		actual = closure.getClosureCount(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,1}});
		Assert.assertEquals(2, actual);
	}

}
