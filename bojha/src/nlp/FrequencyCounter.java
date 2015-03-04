package nlp;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyCounter {
	private int totalWordCount;
	
	private Map<String,Integer> frequencyMap = new TreeMap<>();
	
	public void displayText(String text) {
		String[] values = text.split(" ");
		totalWordCount = values.length;
		for (String eachWord:values) {
			Integer count = frequencyMap.get(eachWord);
			if (count == null) {
				count = 0;
			}
			frequencyMap.put(eachWord, ++count);
			
		}
		
	}

	public int getTotalWordCount() {
		return totalWordCount;
	}

	public Map<String, Integer> getFrequencyMap() {
		return frequencyMap;
	}
	
	
}
