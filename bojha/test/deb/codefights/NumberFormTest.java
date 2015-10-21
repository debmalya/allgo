/**
 * 
 */
package deb.codefights;



import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class NumberFormTest {

	/**
	 * Test method for {@link deb.codefights.NumberForm#NumberFormula(int)}.
	 */
	@Test
	public final void testNumberFormula() {
		int[] expecteds = new int[]{1,2,3,4,6,8,9,12,16,18};
		
		for (int i = 0; i < expecteds.length; i++) {
			int actuals = NumberForm.NumberFormula(i);
			Assert.assertEquals(expecteds[i]+"<- ->"+ actuals,expecteds[i], actuals);
		}
	}

}
