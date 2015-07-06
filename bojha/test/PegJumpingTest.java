import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class PegJumpingTest {

	/**
	 * Test method for
	 * {@link PegJumping#getPossibleMovements(int, int, boolean[][])}.
	 */
//	@Test
	public final void testGetPossibleMovements() {
		boolean[][] occupancy = new boolean[][] {
				{ true, false, true, false, false, true, true, true, true,
						true, true, true, true, true, true, false, false, true,
						false, true },
				{ false, false, true, false, false, true, true, true, true,
						true, true, true, true, true, true, true, false, false,
						true, true, },
				{ true, true, false, false, true, true, true, true, true, true,
						true, true, true, true, true, false, false, true, true,
						true, },
				{ false, true, true, false, false, true, true, true, true,
						true, true, true, true, true, true, false, false, true,
						true, true, },
				{ false, false, false, true, true, true, true, true, true,
						true, true, true, false, false, true, false, false,
						true, false, true, },
				{ false, false, true, true, false, false, true, true, true,
						true, false, false, true, true, true, true, true,
						false, false, true, },
				{ false, false, true, false, false, true, true, true, false,
						false, true, true, false, false, true, false, true,
						false, false, false, },
				{ false, false, true, false, true, true, true, false, false,
						true, true, false, true, false, true, false, false,
						false, true, false, },
				{ true, true, true, true, true, true, true, true, true, false,
						false, true, false, false, false, false, false, false,
						false, false, },
				{ false, false, false, true, true, true, true, true, true,
						true, false, false, true, true, false, false, true,
						false, false, true, },
				{ false, true, true, true, true, true, true, true, true, true,
						true, true, false, false, true, false, false, true,
						false, true, },
				{ false, false, true, true, true, true, true, true, true,
						false, false, true, true, false, true, true, true,
						false, false, true, },
				{ false, false, true, true, true, true, true, true, false,
						false, true, true, false, true, true, true, false,
						false, true, false, },
				{ false, true, false, true, true, true, true, false, false,
						true, false, false, false, true, false, false, false,
						true, true, true, },
				{ false, true, false, true, true, true, true, true, false,
						false, true, false, false, true, true, true, false,
						false, true, true, },
				{ true, true, false, false, true, true, false, false, true,
						false, false, true, false, true, true, true, true,
						false, false, true, },
				{ true, true, true, true, false, false, true, true, false,
						false, false, false, true, false, true, false, false,
						true, true, false, },
				{ true, true, true, true, true, true, true, true, true, true,
						true, false, false, true, false, true, true, false,
						false, true, },
				{ true, true, true, true, false, false, true, false, false,
						true, false, false, true, true, false, false, true,
						false, false, true, } };
		String result = PegJumping.getPossibleMovements(0, 0, occupancy);
		Assert.assertNull(result);

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[i].length; j++) {
				result = PegJumping.getPossibleMovements(i, j, occupancy);
				System.out.println(result);
			}
		}

	}
	
	@Test
	public void testPossibleMovements() {
		boolean[][] occupancy = new boolean[][] {{false,false,false},{false,false,true},{false,false,true}};
		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[i].length; j++) {
				String result = PegJumping.getPossibleMovements(i, j, occupancy);
				System.out.println(result);
			}
		}
	}
}
