import java.util.Stack;


public class AllButOne {
	public long countRemainders(int num) {
		long value = Long.valueOf(toBinaryString(num));
		int originalNum = num;
		while (value % originalNum != 0) {
			num++;
			value = Long.valueOf(toBinaryString(num));
			
		}
		return value;
	}
	
	 /**
	   * Convert to a binary string.
	   * @param num
	   * @return
	   */
	  private String toBinaryString(long num) {
		  Stack<Long> values = new Stack<Long>();
		  
		  while (num > 1) {
			  values.add(num % 2);
			  num /= 2;
		  }
		  values.add(num);
		  
		  StringBuilder returnValue = new StringBuilder();
		  while (!values.isEmpty()) {
			  returnValue.append(values.pop());
		  }
		  return returnValue.toString();
	  }
}
