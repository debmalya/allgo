package ht;

import java.util.Scanner;

public class PropertyGuru {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			String value = scanner.nextLine();
			int noOfTestCases = Integer.parseInt(value);

			String[] inputs = new String[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				inputs[i] = scanner.nextLine();
			}

			for (String eachInput : inputs) {
				if (processs(eachInput)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		}

	}

	/**
	 * Process the string and determine the stability of the balance.
	 *
	 * @param myString
	 *            - each input String
	 * @return true if stable, false otherwise
	 */
	public static boolean processs(String myString) {
		if (!(myString.contains(",") && myString.contains("[") && myString.contains("]"))) {
			return false;
		}
		
		while (myString.contains("[?,?]")) {
			myString = myString.replace("[?,?]", "??");
		}
		
		
		
		return processEachUnit(myString);
	}

	/**
	 * Find the main smallest balance of the format [?,?] and check whether is
	 * it balance or not. If balanced then continue processing. Else return
	 * false.
	 *
	 * @param myString
	 *            each input string.
	 * @return true if stable, false otherwise.
	 */
	public static boolean processEachUnit(String myString) {
		// Get last position of "[".
	   
		int endIndex = myString.lastIndexOf("[");
		if (endIndex > -1) {
			String nextInput = myString.substring(0, endIndex);
			String remaining = myString.substring(endIndex + 1);
			endIndex = remaining.indexOf("]");
			if (endIndex > -1) {
				String mainUnit = remaining.substring(0, endIndex);
				remaining = remaining.substring(endIndex+1);
				if (!mainUnit.contains(",")) {
					return true;
				}
				mainUnit = processMainUnit(mainUnit);
				if ("NO".equals(mainUnit)) {
					return false;
				}
				
			    nextInput = nextInput+mainUnit+remaining;
			    return processEachUnit(nextInput);
			} else {
				return false;
			}

		}  else if ( myString.contains(",")) {
			return false;
		}
		return true;
	}

	/**
	 * Check the main part of the form [?,?]
	 *
	 * @param mainUnit
	 * @return "NO" if not possible to continue.
	 */
	public static String processMainUnit(String mainUnit) {
		// Get weight in each part of balance.
		if (!mainUnit.contains(",")) {
			return "NO";
		}
		
		String[] values = mainUnit.split(",");
		int leftValue = 0;
		int rightValue = 0;

		if (values[0].contains("?") && values[1].contains("?")) {
			return mainUnit.replace(",", "");
		}
		try {
			leftValue = Integer.parseInt(values[0]);
		} catch (NumberFormatException nfe) {
			// Not a number.
		}

		try {
			rightValue = Integer.parseInt(values[1]);
		} catch (NumberFormatException nfe) {
			// Not a number.
		}
		// Both are number and not equal.
		if (leftValue > 0 && rightValue > 0 && leftValue != rightValue) {
			return "NO";
		} else if (leftValue > 0  && leftValue == rightValue) {
			return Integer.toString(leftValue + rightValue);
		} else {
			//
			return isDistributable(values[0], values[1]);
		}

	}

	public static String isDistributable(String leftValue, String rightValue) {
		int distributionAmount = 0;
		try {
			if (!leftValue.contains("?")) {
				distributionAmount = Integer.parseInt(leftValue);
				return isDistributable(distributionAmount, rightValue);
			} else if (!rightValue.contains("?")) {
				distributionAmount = Integer.parseInt(rightValue);
				return isDistributable(distributionAmount, leftValue);
			}
		} catch (NumberFormatException nfe) {

		}
		return "NO";
	}

	public static String isDistributable(int distributionAmount,
			String rightValue) {
		int originalLength = rightValue.length();
		int withoutQuestionLength = rightValue.replace("?", "").length();

		int noOfQuestions = originalLength - withoutQuestionLength;
		long totalAmount = distributionAmount;
		if (noOfQuestions == 1) {
			return Integer.toString(2 * distributionAmount);
		}
		while (noOfQuestions > 0) {
			if (distributionAmount % 2 == 1 && noOfQuestions != 1) {
				return "NO";
			}
			distributionAmount /= 2;
			totalAmount += distributionAmount;
			noOfQuestions--;
			if (noOfQuestions == 1) {
				totalAmount += distributionAmount;
				noOfQuestions--;
			}
		}
		
		return Long.toString(totalAmount);
	}
	
	public static String[] getParts(String test) {
		String[] result = new String[2];
		
		int partitionIndex = test.lastIndexOf("],[");
		result[0] = test.substring(1, partitionIndex+1);
		result[1] = test.substring(partitionIndex+"],[".length() - 1,test.length() - 1);
		return result;
	}
	
}

// [3,?]
// [?,[?,?]]
// [[[?,?],5],?]
// [[[5,?],10],[?,?]]
