/**
 * 
 */
package com.deb.bots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author debmalyajash
 *
 */
public class CFBot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] code1 = new String[] { "def is_even_sum(a, b):",
				"    return (a + b) % 2 == 0" };
		String[] code2 = new String[] {
				"def is_even_sum(summand_1, summand_2):",
				"    return (summand_1 + summand_2) % 2 == 0" };
		System.out.println(plagiarismCheck(code1, code2));

	}

	/**
	 * Each CodeFights Company Bot is trained by engineers from that specific
	 * company. The way it works is that a representative group of engineers
	 * from each company is identified as trainers before the bot goes live, and
	 * they CodeFight against the bot during a training phase. The current
	 * training algorithm is definitely more complex, but let's assume it works
	 * this way:
	 * 
	 * For each trainer we collect two pieces of information per task
	 * [answerTime, correctness]. In this case, the bot's correct answer time
	 * for a given task would be the average of the correct answer times from
	 * the trainers. Given all of the training information for a specific task,
	 * calculate the bot's answer time.
	 * 
	 * Example
	 * 
	 * For trainingData = [[3, 1], [6, 1]] the output should be
	 * companyBotStrategy(trainingData) = 4.5.
	 * 
	 * Both trainers have solved the task correctly, so the answer is (3 + 6) /
	 * 2 = 4.5.
	 * 
	 * For trainingData = [[4, 1], [4, -1], [0, 0], [6, 1]] the output should be
	 * companyBotStrategy(trainingData) = 5.0
	 * 
	 * Only the 1st and the 4th trainers (1-based) submitted correct solutions,
	 * so the answer is (4 + 6) / 2 = 5.0.
	 * 
	 * For trainingData = [[4, -1], [0, 0], [5, -1]] the output should be
	 * companyBotStrategy(trainingData) = 0.0
	 * 
	 * No correct answers were given for the task.
	 * 
	 * [input] array.array.integer trainingData
	 * 
	 * The ith element of trainingData contains exactly 2 elements:
	 * trainingData[i][0] is the answer time for the ith person and
	 * trainingData[i][1] is correctness. If a trainer answered correctly, then
	 * correctness equals 1; If a trainer answered incorrectly, then correctness
	 * equals -1; If a trainer didn't give any answer, answerTime and
	 * correctness both equal to 0. [output] float
	 * 
	 * The time the bot will take to solve a specific task. Return 0 if none of
	 * the trainers answered correctly. Your output will be considered correct
	 * if its absolute error does not exceed 10-5 compared to our tests.
	 * 
	 * @param trainingData
	 * @return
	 */
	double companyBotStrategy(int[][] trainingData) {
		int c = 0;
		int t = 0;
		double d = 0.00d;
		for (int i = 0; i < trainingData.length; i++) {
			if (trainingData[i][1] == 1) {
				c++;
				t += trainingData[i][0];
			}
		}
		if (c > 0) {
			d = (double) t / c;
		}
		return d;
	}

	/**
	 * CodeFights supports different challenge types. One of them asks you to
	 * find a bug on a single line of the given code, usually referred to as a
	 * DEBUGGING challenge. Behind the scenes, we correctly implement each
	 * challenge ourselves and then use special comments with specific prefixes
	 * to introduce the buggy lines. Here is an image to help you visualize what
	 * that looks like:
	 * 
	 * 
	 * 
	 * As you can see, each of the special comments looks like this:
	 * 
	 * <spaces>//DB <id>//<buggy line>
	 * 
	 * where <spaces> is a string consisting of zero or more spaces (for
	 * indentation), DB indicates that this comment is for a DEBUGGING challenge
	 * (let's assume this is the only type we support), id is a positive integer
	 * that helps us enumerate these and <buggy line> is some code that's almost
	 * identical to the line to be replaced but with an inserted bug (that is
	 * guaranteed not to contain any '/' symbols).
	 * 
	 * When importing these to our database, each of the special comments is
	 * used to create a debugging challenge. The importing script looks for the
	 * last non-special-comment line above the special comment and replaces it
	 * with "<spaces><buggy line>" while removing all the other special comments
	 * from the code. Examples below can help clarify this process further.
	 * 
	 * Your task is to produce DEBUGGING challenges given source code that
	 * includes the special comments and the id of the desired DEBUGGING
	 * challenge.
	 * 
	 * Example
	 * 
	 * For source = [ "ans = 0", "for i in range(n):", "    for j in range(n):",
	 * "    //DB 3//for j in range(1, n):",
	 * "    //DB 2//for j in range(n + 1):", "        ans += 1", "return ans" ],
	 * challengeId = 3 the output should be
	 * 
	 * taskMaker(source, challengeId) = [ "ans = 0", "for i in range(n):",
	 * "    for j in range(1, n):", "        ans += 1", "return ans" ] For
	 * source = [ "ans = 0;", "for (var i = 0; i < n; i++) {",
	 * "    for (var j = 0; j < n; j++) {",
	 * "    //DB 3//for (var j = 1; j < n; j++) {",
	 * "    //DB 2//for (var j = 0; j < n + 1; j++) {", "        ans++;",
	 * "    }", "}", "return ans;" ], challengeId = 2 the output should be
	 * 
	 * taskMaker(source, challengeId) = [ "ans = 0;",
	 * "for (var i = 0; i < n; i++) {", "    for (var j = 0; j < n + 1; j++) {",
	 * "        ans++;", "    }", "}", "return ans;" ] [input] array.string
	 * source
	 * 
	 * The source string. It is guaranteed that it doesn't contain any comments
	 * except the special ones. It is also guaranteed that for each possible
	 * subtask type and id, it contains not more than one special comment that
	 * starts with "<spaces>//DB <id>//". [input] integer challengeId
	 * 
	 * The id of the desired DEBUGGING challenge. It is guaranteed to be a
	 * positive integer less than 1000. [output] array.string
	 * 
	 * The resulting DEBUGGING challenge after the proper replacements are
	 * complete.
	 */
	public static String[] taskMaker(String[] source, int challengeId) {
		List<String> li = new ArrayList<>();

		for (String each : source) {
			if (!each.contains("//DB")) {
				li.add(each);

			} else {

				if (each.contains(challengeId + "//")) {
					li.remove(li.get(li.size() - 1));
					each = each.replaceAll("//DB ", "");
					each = each.replaceAll(challengeId + "//", "");
					li.add(each);
				}

			}
		}
		return li.toArray(new String[0]);

	}

	/**
	 * Ever so often on Codefights, a user tries to submit a duplicate solution
	 * they copied from someone else. Generally these are pretty easy to detect
	 * and block. However, it gets trickier when you have a duplicate solution
	 * with some variables renamed to avoid getting caught.
	 * 
	 * The cheating usually happens as follows: in a text editor the
	 * "Find and replace" function is applied to all occurrences of some
	 * variable name A that consists of letters, digits, underscores, and starts
	 * with a non-digit character (since it's a variable name), to change it to
	 * some other variable name B that fulfills the same constraints.
	 * 
	 * It would appear that after applying this "Find and replace" procedure
	 * multiple times it would be impossible to detect duplicates, but this
	 * isn't the case. Your goal is to implement an algorithm that compares two
	 * code snippets and determines whether one of them could be produced from
	 * the other using the above-described approach.
	 * 
	 * Note. Here is a formal definition of how "Find and replace" function
	 * works. When searching for string A to replace all of its occurrences in
	 * string S with string B, it first finds the leftmost occurrence of A in S.
	 * Then it replaces this occurrence of A with B. Then it repeats the above
	 * procedure for the suffix of S which starts immediately after the last
	 * character of the inserted copy of B. The process repeats until the
	 * remaining suffix contains no occurrences of A.
	 * 
	 * Example
	 * 
	 * For code1 = [ "def is_even_sum(a, b):", "    return (a + b) % 2 == 0" ],
	 * code2 = [ "def is_even_sum(summand_1, summand_2):",
	 * "    return (summand_1 + summand_2) % 2 == 0" ] the output should be
	 * plagiarismCheck(code1, code2) = true (all occurrences of a are replaced
	 * with summand_1, and all occurrences of b are replaced with summand_2).
	 * 
	 * For code1 = [ "function is_even_sum(a, b) {",
	 * "  return (a + b) % 2 === 0;", "}" ], code2 = [
	 * "function is_even_sum(a, b) {", "  return (a + b) % 2 !== 1;", "}" ] the
	 * output should be plagiarismCheck(code1, code2) = false.
	 * 
	 * [input] array.string code1
	 * 
	 * [input] array.string code2
	 * 
	 * [output] boolean
	 * 
	 * true if code2 can be obtained from code1 using zero or more
	 * "Find and replace" operations, false otherwise. CODE
	 * 
	 * @param code1
	 * @param code2
	 * @return
	 */
	static boolean plagiarismCheck(String[] code1, String[] code2) {
		int e = 0;
		// Number of lines do not match
		if (code1.length != code2.length) {
			return false;
		}
		// removing variable names and comparing.
		// Better to get the variable name and replace them throughout the code.
		for (int i = 0; i < code1.length; i++) {
			remove(code1, i);
			remove(code2, i);
			if (code1[i].equals(code2[i])) {
				e++;
			}
		}
		if (e == code1.length) {
			return true;
		}
		return false;
	}

	private static void remove(String[] code1, int i) {
		int b = code1[i].indexOf("(");
		if (code1[i].indexOf("(") > -1) {
			code1[i] = code1[i].substring(0, b + 1)
					+ code1[i].substring(code1[i].indexOf(")"));
			b = code1[i].indexOf("(");
		}
	}

	int lineUp(String commands) {
		int r = 0;
		char prev = ' ';
		boolean s = false;

		if (commands.trim().length() == 0) {
			return 1;
		}
		commands = commands.toUpperCase();
		for (int i = 0; i < commands.length(); i++) {
			char c = commands.charAt(i);
			if ((c == 'L' || c == 'R') && (prev == 'L' || prev == 'R') && !s) {
				r++;
				s = true;
			} else if ((s && c == 'A') || (prev == ' ' && c == 'A')) {
				r++;
				s = true;
			} else {
				s = false;
			}
			prev = c;
		}

		return r;

	}

	/**
	 * A noob programmer was given two simple tasks: sum and sort the elements
	 * of the given array
	 * 
	 * a = [a1, a2, ..., an]. He started with summing and did it easily, but
	 * decided to store the sum he found in some random position of the original
	 * array which was a bad idea. Now he needs to cope with the second task,
	 * sorting the original array a, and it's giving him trouble since he
	 * modified it.
	 * 
	 * Given the array shuffled, consisting of elements a1, a2, ..., an, a1 + a2
	 * + ... + an in random order, return the sorted array of original elements
	 * a1, a2, ..., an.
	 * 
	 * Example
	 * 
	 * shuffledArray([1, 12, 3, 6, 2]) = [1, 2, 3, 6]
	 * 
	 * 1 + 3 + 6 + 2 = 12, which means that 1, 3, 6 and 2 are original elements
	 * of the array.
	 * 
	 * shuffledArray([1, -3, -5, 7, 2]) = [-5, -3, 2, 7]
	 * 
	 * [input] array.integer shuffled
	 * 
	 * Array of at least two integers. It is guaranteed that there is an index i
	 * such that shuffled[i] = shuffled[0] + ... + shuffled[i - 1] + shuffled[i
	 * + 1] + ... + shuffled[n]. [output] array.integer
	 * 
	 * A sorted array of shuffled.length - 1 elements.
	 * 
	 * @param shuffled
	 * @return
	 */
	static int[] shuffledArray(int[] shuffled) {
		int l = shuffled.length;
		int[] r = new int[l - 1];
		int[] s = new int[l];
		Arrays.sort(shuffled);
		int ns = 0;
		int ni = -1;
		for (int i = 0; i < s.length; i++) {
			if (i > 0) {
				s[i] += s[i - 1];
			}
			if (s[i] < 0) {
				ns += s[i];
				ni = i;
			}
			s[i] += shuffled[i];
		}

		if (s[l - 1] == s[l - 2] * 2) {
			System.arraycopy(shuffled, 0, r, 0, l - 1);
		} else {
			int m = l / 2;

			for (int i = 0; i < l; i++) {
				if (i < m + (l % 2 == 1 ? 0 : -1)) {
					r[i] = shuffled[i];
				} else if (i > m + (l % 2 == 1 ? 0 : -1)) {
					r[i - 1] = shuffled[i];
				}
			}

		}

		return r;
	}

	/**
	 * In CodeFights marathons, each task score is calculated independently. For
	 * a specific task, you get some amount of points if you solve it correctly,
	 * or you get a 0. Here is how the exact number of points is calculated:
	 * 
	 * If you solve a task on your first attempt within the first minute, you
	 * get maxScore points. Each additional minute you spend on the task adds a
	 * penalty of (maxScore / 2) * (1 / marathonLength) to your final score.
	 * Each unsuccessful attempt adds a penalty of 10 to your final score. After
	 * all the penalties are deducted, if the score is less than maxScore / 2,
	 * you still get maxScore / 2 points. Implement an algorithm that calculates
	 * this score given some initial parameters.
	 * 
	 * Example
	 * 
	 * For marathonLength = 100, maxScore = 400, submissions = 4,
	 * successfulSubmissionTime = 30 the output should be:
	 * marathonTaskScore(100, 400, 4, 30) = 310
	 * 
	 * Three unsuccessful attempts cost 10 * 3 = 30 points. 30 minutes adds 30 *
	 * (400 / 2) * (1 / 100) = 60 more points to the total penalty. So the final
	 * score is 400 - 30 - 60 = 310.
	 * 
	 * Keeping the same input parameters as above but changing the number of
	 * attempts to 95 we get: marathonTaskScore(100, 400, 95, 30) = 200
	 * 
	 * 400 - 10 * 94 - 30 * (400 / 2) * (1 / 100) = -600. But the score for this
	 * task cannot be less than 400 / 2 = 200, so the final score is 200 points.
	 * 
	 * For marathonLength = 100, maxScore = 400, submissions = 4,
	 * successfulSubmissionTime = -1 the output should be:
	 * marathonTaskScore(100, 400, 95, -1) = 0
	 * 
	 * The task wasn't solved, so it doesn't give any points.
	 * 
	 * [input] integer marathonLength
	 * 
	 * A positive integer representing the length of the marathon in minutes.
	 * [input] integer maxScore
	 * 
	 * A positive integer. It is guaranteed that maxScore is divisible by 2 *
	 * marathonLength. [input] integer submissions
	 * 
	 * A positive integer equal to the number of submissions made by the user
	 * for the specific task. [input] integer successfulSubmissionTime
	 * 
	 * An integer equal to the time of successful submission in minutes since
	 * the beginning of the marathon (for example, if a successful submission
	 * was made on the first minute then successfulSubmissionTime = 0). If all
	 * submissions were unsuccessful then successfulSubmissionTime = -1.
	 * successfulSubmissionTime < marathonLength
	 * 
	 * [output] integer
	 * 
	 * The final score for the task.
	 * 
	 * @param marathonLength
	 * @param maxScore
	 * @param submissions
	 * @param successfulSubmissionTime
	 * @return
	 * 
	 */
	int marathonTaskScore(int marathonLength, int maxScore, int submissions,
			int successfulSubmissionTime) {
		if (successfulSubmissionTime == 1) {
			return maxScore;
		} else {
			int p = (10 * (submissions - 1));
			int q = (maxScore / 2) * (1 / marathonLength);
			int t = maxScore - p - q;

			if (t < (maxScore / 2)) {
				return maxScore / 2;
			}
			return t;

		}
	}

	/**
	 * When you click the VS Fight button on CodeFights, the system tries to
	 * match you with the best opponent possible. The matching algorithm has
	 * become more complex over time,but initially it was a simple search for
	 * someone whose XP is as close to yours as possible.
	 * 
	 * The easiest way to understand how it used to conduct the search is as
	 * follows:
	 * 
	 * 
	 * 
	 * Imagine that each user looking for an opponent is standing at the center
	 * of a search circle on a horizontal XP axis. All the search circles have
	 * the same radius (the search radius), and initially search radius is equal
	 * to 0. At each step, the search radius is increased by 1. A match is found
	 * as soon as two search circles intersect. These circles are then removed
	 * immediately. For the sake of simplicity, assume that on each step no more
	 * than one pair of circles can intersect. Given a list of requests as user
	 * XPs, match them up using the algorithm described above.
	 * 
	 * Example
	 * 
	 * opponentMatching([200, 100, 70, 130, 100, 800, 810]) = [[1, 4], [5, 6],
	 * [2, 3]]
	 * 
	 * Initially, search ranges for users 1 and 4 (these are their IDs equal to
	 * 0-based indices) coincide, so they form the first pair. After 5 steps
	 * search circles of users 5 and 6 intersect. Thus, they form the second
	 * pair. After 25 more steps search circles of users 2 and 3 intersect.
	 * Thus, they form the third pair. Finally, user 0 remains without an
	 * opponent. [input] array.integer XP
	 * 
	 * Array of positive integers.
	 * 
	 * XP[i] equals XP points earned by the user with ID = i.
	 * 
	 * XP[i] ≤ 109 [output] array.array.integer
	 * 
	 * Array of pairs of opponents. Pairs should be stored in the same order as
	 * they were formed by the above-described algorithm. Elements in pairs
	 * should be sorted according to their IDs.
	 * 
	 * @param XP
	 * @return
	 */
	int[][] opponentMatching(int[] XP) {
		int[][] r = new int[XP.length][XP.length];
		SortedMap<Integer, List<Integer>> m = new TreeMap<>();

		for (int i = 0; i < XP.length; i++) {
			List<Integer> v = m.get(XP[i]);
			if (v == null) {
				v = new ArrayList<>();
			}
			v.add(i);
			m.put(XP[i], v);
		}
		return r;
	}

	/**
	 * 
	 * @param source
	 * @return
	 */

	int shortestSolutionLength(String[] source) {
		int r = 0;
		boolean ig = false;
		for (String e : source) {

			for (int i = 0; i < e.length(); i++) {
				if (e.charAt(i) == '/' && i < e.length() && e.charAt(i) == '*') {
					ig = true;
					i++;
				} else if (e.charAt(i) != ' ' && !ig) {
					r++;
				} else if (e.charAt(i) == '*' && i < e.length()
						&& e.charAt(i) == '\\') {
					ig = false;
					i++;
				} else if (e.charAt(i) == '/' && i < e.length()
						&& e.charAt(i) == '/') {
					continue;
				}
			}
			
		}
		return r;
	}
	
	
}
