import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class ZeroOne {
	
	private static BigInteger divisor = new BigInteger("2");

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String num = scanner.nextLine();
			
			BigInteger input = new BigInteger(num);
			long value = Long.parseLong(toBinaryString(input));
			long originalNum = value;
			
			while (value % originalNum != 0) {
				input = input.add(BigInteger.ONE);
				value = Long.parseLong(toBinaryString(input));				
			}
			System.out.println(value);
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}
	

	 /**
	   * Convert to a binary string.
	   * @param num
	   * @return binary string.
	   */
	  private static String toBinaryString(BigInteger num) {
		  Stack<Integer> values = new Stack<Integer>();
		  
		  
		  while (num.compareTo(BigInteger.ONE) > 0) {
			  values.add(num.mod(divisor).intValue());
			  num = num.divide(divisor);
		  }
		  values.add(num.intValue());
		  
		  StringBuilder returnValue = new StringBuilder();
		  while (!values.isEmpty()) {
			  returnValue.append(values.pop());
		  }
		  return returnValue.toString();
	  }

}
