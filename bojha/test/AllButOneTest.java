import static org.junit.Assert.*;

import org.junit.Test;


public class AllButOneTest {

	@Test
	public void testCountRemainders() {
		AllButOne allButOne  = new AllButOne();
		assertEquals(100L,allButOne.countRemainders(4));
		assertEquals(10L,allButOne.countRemainders(2));
		assertEquals(111L,allButOne.countRemainders(3));
		assertEquals(110L,allButOne.countRemainders(5));
		assertEquals(1110L,allButOne.countRemainders(6));
	}

}
