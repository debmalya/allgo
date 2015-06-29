



import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class CodeFightsTest {

	/**
	 * Test method for {@link CodeFights#minBoxes(int[])}.
	 */
	@Test
	public final void testMinBoxes() {
		CodeFights fights = new CodeFights();
		int actual = fights.minBoxes(new int[]{9,9,9,3});
		Assert.assertEquals(4, actual);
		
		actual = fights.minBoxes(new int[]{6, 7, 2, 4});
		Assert.assertEquals(2, actual);
		
		actual = fights.minBoxes(new int[]{6, 7, 3, 4});
		Assert.assertEquals(2, actual);
		
		actual = fights.minBoxes(new int[]{6, 7, 4, 4});
		Assert.assertEquals(3, actual);
		
		actual = fights.minBoxes(new int[]{9,9,9,3});
		Assert.assertEquals(4, actual);
		
		actual = fights.minBoxes(new int[]{7,4,2,3,5,1,8});
		Assert.assertEquals(3, actual);
		
	}

	@Test
	public final void testMobious(){
		CodeFights fights = new CodeFights();
		int actual = fights.mobious("10");
		Assert.assertEquals(1,actual);
	}
}
