package ht;

import java.util.Scanner;

public class CopyOfMain {

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
		CopyOfMain x = new CopyOfMain();
		Balance mainBalance = x.new Balance();
		Balance currentBalance = mainBalance;

		int len = myString.length();
		int noOfOpenBrackets = 0;
		boolean isOpen = false;
		boolean isLeftTree = true;

		for (int i = 0; i < len; i++) {
			char now = myString.charAt(i);
			switch (now) {
			case '[':
				isOpen = true;
				noOfOpenBrackets++;
				// create a left node
				isLeftTree = true;
				if (noOfOpenBrackets > 1) {
					Balance parentNode = currentBalance;

					currentBalance.left = x.new Balance();
					currentBalance.left.parent = currentBalance;
					currentBalance = currentBalance.left;
					currentBalance.parent=parentNode;

					parentNode.child = currentBalance;
				}

				break;
			case ']':
				isOpen = false;
				noOfOpenBrackets--;
				// now check whether tree is balanced or not.
				if (noOfOpenBrackets > 0) {
					// open bracket means we need to go upper level.
					
					if (currentBalance.left != null) {
						currentBalance.parent.weight += currentBalance.left.weight;
						currentBalance.parent.count++;
					}
					
					if (currentBalance.right != null) {
						currentBalance.parent.weight += currentBalance.right.weight;
						currentBalance.parent.count++;
					}
					
					currentBalance = currentBalance.parent;
				}
				break;
			case '?':

				if (!isLeftTree) {
					// Assign total left tree weight to it.
					// this situation is like 4,?. At this stage assign left
					// balance weight to right balance.
					if (currentBalance.right == null) {
						currentBalance.right = x.new Balance();
					}
				

					if (currentBalance.left.weight > 0) {
//						currentBalance.right.weight = currentBalance.left.weight;

						currentBalance.weight += currentBalance.right.weight;
						updateWeight(currentBalance.right,
								currentBalance.left.weight);
					}
				} else {
					if (currentBalance.left == null) {
						currentBalance.left = x.new Balance();
						currentBalance.left.parent = currentBalance;

					}
					currentBalance.weight = 0;
					updateWeight(currentBalance, 0);
				}
				break;
			case ',':
				isLeftTree = false;
				// right balance part starts here.
				// currentBalance.parent.right = x.new Balance();
				// currentBalance.parent.right.parent = currentBalance.parent;
				// currentBalance = currentBalance.parent.right;
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
						currentBalance.right = x.new Balance();
						currentBalance.right.parent = currentBalance;
						updateWeight(currentBalance.right, weight);

						if (currentBalance.left.weight == 0) {
							// this situation is like ?,4. Then left balance
							// weight will be 0. This time we know the correct
							// weight for left balance.

							if (currentBalance.count > 0
									&& currentBalance.right.weight
											% currentBalance.count == 0) {
								// this is to check whether right balance can be
								// distributed across left pane. (e.g.)
								// [[?,?],5] here weight 5 can not be
								// distributed in left pane as multiple of 1.

								currentBalance.left.weight = currentBalance.right.weight;
								// Add newly added left part to the weight of
								// the
								// balance.
								updateWeight(currentBalance.left, weight);

							} else if (currentBalance.parent != null
									&& currentBalance.parent.count != 0
									&& currentBalance.weight == 0) {
								if (weight % currentBalance.parent.count == 1) {
									return false;
								}
							} else {
								return false;
							}

						}

						if (currentBalance.left.weight != currentBalance.right.weight) {
							// it is not balanced
							return false;
						}
					} else {
						currentBalance.left = x.new Balance();
						currentBalance.left.parent = currentBalance;
						updateWeight(currentBalance.left, weight);

					}
					i += pos - 1;
				}

				break;
			default:
				break;
			}
		}

		return true;
	}

	private static void updateWeight(Balance nowBalance, long weight) {

		nowBalance.weight = weight;
		nowBalance.count++;

		/*
		while (nowBalance.parent != null) {
			nowBalance.parent.count++;
			nowBalance.parent.weight += weight;
			nowBalance.parent = nowBalance.parent.parent;

		}
		*/

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
		/* whether balance is properly balanced or not */
		boolean isBalanced;
		/* Child balance of the current one */
		Balance child;

		/**
		 * Get total weight of balance.
		 * 
		 * @return total weight of balance.
		 */
		public long getTotalWeight() {
			return getWeightOfLeftPart() + getWeightOfRightPart();
		}

		/**
		 * 
		 * @return whether balance is really balanced or not. True means
		 *         balanced. False means not balanced.
		 */
		public boolean isBalanced() {
			if (getWeightOfRightPart() == getWeightOfLeftPart()) {
				return true;
			}
			return false;
		}

		/**
		 * 
		 * @return weight of right part.
		 */
		public long getWeightOfRightPart() {
			if (right != null) {
				return weight + right.getWeightOfRightPart();
			}
			return weight;
		}

		/**
		 * 
		 * @return weight of left part.
		 */

		public long getWeightOfLeftPart() {

			if (left != null) {
				return weight + left.getWeightOfLeftPart();
			}
			return weight;
		}
	}

}
