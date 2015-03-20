import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class HighestPrimeFactorTest {

	@Test
	public void test() {
		HighestPrimeFactor facotr = new HighestPrimeFactor();
		List<Long> factorList = HighestPrimeFactor.getPrimeFactorList(4);
		
		for (int i = 0; i < factorList.size(); i++) {
			assertEquals(2,factorList.get(i).longValue());
		}
		
		List<Long> factorList1 = HighestPrimeFactor.getPrimeFactorList(6);
		
		factorList1.addAll(factorList);
		
		
		long[] values = new long[]{1,2,3,4,5,6,7,8,9,10};
		long lcd = HighestPrimeFactor.lcd(values);
		assertEquals(2520, lcd);
		
	}

}
