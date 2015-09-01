import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class PlantirTest {

	@Test
	public final void test() {
		String[] allRows  = new String[]{"TTP",
				"PTP",
				"TPP",
				"PTP",
				"TPT"};
		
		int actual = Plantir.flipColumn(0, allRows);
		System.out.println(actual);
	}

}
