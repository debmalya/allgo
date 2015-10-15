import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class CodeFights50 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 *
	 Create a Function that can calculate the nth root of the given number. I
	 * am really sorry, but for some reason I am unable to set the output to
	 * float. So this challenge is kind of incomplete and easy (that was a
	 * hint).
	 *
	 * Example:
	 *
	 * nroot(8, 3) = 2
	 *
	 * Since 23 = 8.
	 *
	 * [input] integer num The number which root should be calculated.
	 *
	 * [input] integer root The degree of the root.
	 *
	 * [output] integer The answer.
	 *
	 *
	 * @param num
	 * @param root
	 * @return
	 */
	static int nroot(int num, int root) {
		for (int i = 1; i <= num; i++) {
			int v = (int) Math.pow(i, root);
			if (v >= num) {
				return i;
			}
		}
		return 1;
	}

	/**
	 * Find All Happy Numbers in the Given Range
	 * 
	 * A happy number is a number defined by the following process: Given a
	 * positive integer, replace it by the sum of the squares of its digits, and
	 * repeat the process until the number either equals 1 (it will not change
	 * any further), or it loops endlessly in a cycle which does not include 1.
	 * Those numbers for which this process ends in 1 are happy numbers, while
	 * those that do not end in 1 are unhappy numbers (or sad numbers).
	 * 
	 * Find all happy numbers in the given range [1..Range], inclusive.
	 * 
	 * Example
	 * 
	 * 70 -> 7**2 + 0 = 49 49 -> 4**2 + 9**2 = 16 + 81 = 97 97 -> 9**2 + 7**2 =
	 * 81 + 49 = 130 130 -> 1**2 + 3**2 + 0 = 1 + 9 = 10 10 -> 1**2 + 0 = 1
	 * 
	 * Hence 70 is a happy number.
	 * 
	 * [input] integer Range
	 * 
	 * Range ≤ 2000. [output] array.integer
	 * 
	 * Happy numbers from the given range, returned in ascending order.
	 * 
	 * 
	 * @param Range
	 * @return
	 */
	static int[] HappyNumbers(int Range) {
		SortedSet<Integer> h = new TreeSet<Integer>();
		List<Integer> u = new ArrayList<Integer>();
		
		int i = 1;
		for (; i <= Range; i++) {
			if (i == 7) {
				System.out.println("Here");
			}
			if (u.contains(i) || h.contains(i)) {
				continue;
			}
			int sum = getSum(i);
			List<Integer> b = new ArrayList<Integer>();
			
			if (sum == 1 || h.contains(sum)) {
				h.add(i);
			}
			else if (!u.contains(sum)) {
				
				while (sum > 0) {
					b.add(sum);
					if (u.contains(sum) || h.contains(sum)) {
						break;
					}
					if (sum < 10) {
						u.add(i);
						u.addAll(b);
						break;
					}
					sum = getSum(sum);
					if (h.contains(sum) || sum == 1) {
						h.add(i);
						h.addAll(b);
					} else if (u.contains(sum)) { 
						break;
					} 
				}

			}

		}
//		return h.stream().mapToInt(Integer->Integer.intValue()).toArray();
		
		int[] r = new int[h.size()];
		i = 0;
		for (int e: h) {
			if (e <= Range)
			r[i++] = e;
		}
		int[] j = new int[i];
		System.arraycopy(r, 0, j, 0, i);
		
		return j;
		
	}

	private static int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += Math.pow(n % 10, 2);
			n /= 10;
		}
		return sum;
	}
}
