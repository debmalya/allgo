import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HighestPrimeFactorTest {

	@Test
	public void test() {
		HighestPrimeFactor facotr = new HighestPrimeFactor();
		List<Long> factorList = HighestPrimeFactor.getPrimeFactorList(4);

		for (int i = 0; i < factorList.size(); i++) {
			assertEquals(2, factorList.get(i).longValue());
		}

		List<Long> factorList1 = HighestPrimeFactor.getPrimeFactorList(6);

		factorList1.addAll(factorList);

		long[] values = new long[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		long lcd = HighestPrimeFactor.lcd(values);
		assertEquals(2520, lcd);
		values = new long[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20 };
		lcd = HighestPrimeFactor.lcd(values);
		
		for (int i = 0; i < values.length; i++) {
			Assert.assertTrue(lcd+" must be divisible by " + values[i], (lcd%values[i] == 0));
		}
		System.out.println(lcd);

	}

}
