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
public class MatrixTest {

	/**
	 * Test method for {@link deb.codefights.Matrix#SpiralMatrix(int)}.
	 */
	@Test
	public final void testSpiralMatrix() {
		int[][] expecteds = new int[1][1];
		expecteds[0][0] = 1;

		int n = 1;
		int[][] actuals = Matrix.SpiralMatrix(n);

		for (int i = 0; i < n; i++) {
			Assert.assertArrayEquals(expecteds[i], actuals[i]);
		}
		
		n = 2;
		actuals = Matrix.SpiralMatrix(n);

		expecteds = new int[][]{{1,2},{4,3}};
		for (int i = 0; i < n; i++) {
			Assert.assertArrayEquals(expecteds[i], actuals[i]);
		}
		
		n = 3;
		actuals = Matrix.SpiralMatrix(n);

		expecteds = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
		for (int i = 0; i < n; i++) {
			Assert.assertArrayEquals(expecteds[i], actuals[i]);
		}
		
		n = 5;
		actuals = Matrix.SpiralMatrix(n);

		expecteds = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
		for (int i = 0; i < n; i++) {
			Assert.assertArrayEquals(expecteds[i], actuals[i]);
		}
	}

}
