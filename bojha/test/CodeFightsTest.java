



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
//	@Test
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
	
	@Test
	public final void testChandosNumber() {
		CodeFights fights = new CodeFights();
		int actual = fights.nthChandosNumber(1);
		Assert.assertEquals(5,actual);
		actual = fights.nthChandosNumber(2);
		Assert.assertEquals(25,actual);
		actual = fights.nthChandosNumber(3);
		Assert.assertEquals(30,actual);
		
		actual = fights.nthChandosNumber(4);
		Assert.assertEquals(125,actual);
		
		actual = fights.nthChandosNumber(5);
		Assert.assertEquals(130,actual);
		
		actual = fights.nthChandosNumber(9);
		Assert.assertEquals(630,actual);
	}
	
	@Test
	public final void testNum_Calc(){
		CodeFights fights = new CodeFights();
		int actual = fights.Num_Calc(10);
		Assert.assertEquals(6, actual);
		
		actual = fights.Num_Calc(9);
		Assert.assertEquals(7, actual);
		
		actual = fights.Num_Calc(8);
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public final void testisPairMult(){
		CodeFights fights = new CodeFights();
		Assert.assertTrue(fights.isPairMult(new int[]{1,2,3,6,15,25}, 30));
		Assert.assertFalse(fights.isPairMult(new int[]{2,3,6,15,25},  10));
		Assert.assertTrue(fights.isPairMult(new int[]{1,2,3},6));
	}
}
