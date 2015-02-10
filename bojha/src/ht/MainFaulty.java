package ht;

import java.util.Scanner;

public class MainFaulty {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		try {
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

		} finally {
			scanner.close();
		}

	}

	public static boolean processs(String myString) {
		MainFaulty x = new MainFaulty();

		Balance mainBalance = x.new Balance();
		Balance currentBalance = mainBalance;
		long remainingWeight = 0L;

		int len = myString.length();

		boolean isLeftTree = true;

		for (int i = 0; i < len; i++) {
			char now = myString.charAt(i);
			switch (now) {
			case '[':
				isLeftTree = true;
				Balance parentNode = currentBalance;
				// create a left node
				currentBalance = createNode(x, currentBalance, parentNode);
				break;

			case ']':
				break;

			case '?':

				if (!isLeftTree) {
					// Assign total left tree weight to it.
					// this situation is like 4,?. At this stage assign left
					// balance weight to right balance.
					// currentBalance = currentBalance.parent;
					long weight = currentBalance.left.weight;
					if (currentBalance.right == null) {

						currentBalance = createRightNode(x, currentBalance);
					}

					updateWeight(currentBalance, weight);

				} else {
					updateWeight(currentBalance, 0);
				}
				break;
			case ',':
				isLeftTree = false;
				currentBalance = callMyParent(currentBalance);
				break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				// first get rest of the string.
				String remaining = myString.substring(i);
				// get next "," position, in case of left part.
				String separator = ",";
				if (!isLeftTree) {
					// right part get next "]" position
					separator = "]";
				}
				int pos = remaining.indexOf(separator);
				if (pos > -1) {
					int weight = Integer.parseInt(remaining.substring(0, pos));
					if (!isLeftTree) {
						// is it a balanced tree ?
						currentBalance = createRightNode(x, currentBalance);

					}
					updateWeight(currentBalance, weight);
					if (!isLeftTree) {
						if (currentBalance.stableWeight > 0) {
							if (currentBalance.stableWeight < currentBalance.weight) {
								return false;
							}

						}
						remainingWeight = currentBalance.stableWeight
								- currentBalance.weight;

					}

					i += pos - 1;
				}

				break;
			default:
				break;
			}
		}

		if (remainingWeight == 0) {
			return true;
		} else {
			if (distributable(remainingWeight, currentBalance)) {
				return true;
			}
			return false;
		}
	}

	/**
	 * Check whether remaining weight can be distributed to "?" s.
	 * 
	 * @param remainingWeight
	 *            amount.
	 * @param currentBalance
	 * @return true, if possible to distribute, false otherwise.
	 */
	private static boolean distributable(long remainingWeight,
			Balance currentBalance) {
		long unstableWeight = Math.abs(remainingWeight);

		if (currentBalance.parent != null) {
			currentBalance = currentBalance.parent;
			int otherMemeberCount = currentBalance.unknownWeightCount;
			if (otherMemeberCount == 1) {
				// remaining weight can be balanced in single "?"
				return true;
			}

			if (currentBalance.unknownWeightCount > 0 && unstableWeight % currentBalance.unknownWeightCount == 0) {
				return true;
			}

			return distributable(unstableWeight, currentBalance);

		}
		return false;
	}

	/**
	 * Create a right node.
	 * 
	 * @param x
	 *            Main instance
	 * @param currentBalance
	 * @return newly created right node.
	 */
	private static Balance createRightNode(MainFaulty x, Balance currentBalance) {
		if (currentBalance.right == null) {
			currentBalance.right = x.new Balance();

		}
		currentBalance.right.parent = currentBalance;
		if (currentBalance.left.weight > 0 && currentBalance.right.weight == 0) {
			currentBalance.right.stableWeight = currentBalance.left.weight;
		}
		currentBalance = currentBalance.right;
		return currentBalance;
	}

	private static Balance callMyParent(Balance currentBalance) {
		currentBalance.parent.count += currentBalance.count;
		currentBalance.parent.weight += currentBalance.weight;
		currentBalance.parent.unknownWeightCount += currentBalance.unknownWeightCount;

		currentBalance = currentBalance.parent;

		/*
		while (currentBalance.right != null) {
			currentBalance = currentBalance.parent;
		}
		*/
		return currentBalance;
	}

	/**
	 * 
	 * @param x
	 *            - Main program instance.
	 * @param currentBalance
	 *            - current balance where the program pointer is now.
	 * @param parentNode
	 *            - parent of current node.
	 * @return - create node and return current balance.
	 */
	private static Balance createNode(MainFaulty x, Balance currentBalance,
			Balance parentNode) {
		if (currentBalance != null) {
			if (currentBalance.left == null) {
				currentBalance.left = x.new Balance();
				currentBalance.left.parent = currentBalance;
				currentBalance = currentBalance.left;
				currentBalance.parent = parentNode;

			} else if (currentBalance.right == null) {
				currentBalance.right = x.new Balance();
				currentBalance.right.parent = currentBalance;
				currentBalance = currentBalance.right;
				currentBalance.parent = parentNode;

			} else {
				// both left and right are full.
				// Not a happy coding.
				if (currentBalance.right.weight < currentBalance.left.weight) {
					return createNode(x, currentBalance.right, currentBalance);
				} else {
					return createNode(x, currentBalance.left, currentBalance);
				}
			}
		}
		return currentBalance;
	}

	private static void updateWeight(Balance nowBalance, long weight) {

		nowBalance.weight += weight;
		nowBalance.count++;
		if (weight == 0) {
			nowBalance.unknownWeightCount++;
		}

	}

	/**
	 * This data structure is used to create balance and check whether is it
	 * balanced or not. Try to follow red black tree structure.
	 * 
	 * @author debmalyajash
	 *
	 */
	class Balance {
		/* total weight of node left part + right part */
		long weight;
		/* total number of nodes including sub tree */
		int count;
		/* parent of current node */
		Balance parent;
		/* left part of the balance */
		Balance left;
		/* right part of the balance */
		Balance right;
		/* ideal weight to make the balance stable */
		long stableWeight;
		/* unknown weight count. If weight is "?" */
		int unknownWeightCount;

	}

}

// [3,?]
// [?,[?,?]]
// [[[?,?],5],?]
// [[[5,?],10],[?,?]]