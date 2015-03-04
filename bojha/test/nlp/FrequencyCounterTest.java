package nlp;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class FrequencyCounterTest {

	@Test
	public void test() {
		FrequencyCounter fc = new FrequencyCounter();
		fc.displayText("Not yet implemented");
		
		assertEquals(3, fc.getTotalWordCount());
		
		Map<String, Integer> map = fc.getFrequencyMap();
		assertEquals(1, (int)map.get("Not"));
		assertEquals(1, (int)map.get("yet"));
		assertEquals(1, (int)map.get("implemented"));
		
		
	}

}
