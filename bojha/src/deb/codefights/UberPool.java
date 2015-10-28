/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class UberPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Uber has introduced UberPool to make sure there are fewer cars on the
	 * road, which means less traffic, faster travel times and cheaper rides.
	 * Here is how UberPool works: it matches different riders heading in the
	 * same direction, giving a driver two pick-up and two drop-off locations on
	 * the same trip. UberPool is limited to two riders per trip, which means
	 * that sometimes a driver has to choose which request to accept.
	 * 
	 * Consider a city represented as integer points on the Cartesian plane,
	 * with roads parallel to the axes. There's a driver who picked up a
	 * passenger at point A and is heading to point B with them, taking one of
	 * the shortest possible routes. When the driver reaches point C, she
	 * receives two more requests: one from a rider at point X, another from a
	 * rider at point Y. Both riders are also going to point B.
	 * 
	 * Your task is to find out which additional rider should be picked up (if
	 * any), taking into account that the final length of the trip can't be more
	 * than two times longer than the length of the trip with no extra riders.
	 * If both requests meet this condition, accept the one with the shortest
	 * route. If the lengths of the routes are the same, accept the first
	 * request.
	 * 
	 * Example
	 * 
	 * For A = [0, 0], B = [3, 3], C = [3, 1], X = [5, 0] and Y = [2, 2] the
	 * answer should be 2.
	 * 
	 * The initial distance is 6, the route with the passenger at point X is of
	 * length 12, the route with the passenger at point Y is of length 8. Both
	 * pick-ups are possible; however, it's better to pick up the passenger at
	 * Y, since the route with him is shorter. See the picture below for
	 * details.
	 * 
	 * 
	 * 
	 * [input] array.integer A
	 * 
	 * The departure point, represented as array of two integers - x and y
	 * coordinates. [input] array.integer B
	 * 
	 * The destination point. [input] array.integer C
	 * 
	 * The point at which two new requests came in. [input] array.integer X
	 * 
	 * Coordinates of the first request. [input] array.integer Y
	 * 
	 * Coordinates of the second request. [output] integer
	 * 
	 * Return 1 if the passenger at point X should be picked up, 2 if the
	 * passenger at point Y should be picked up, or -1 if it's impossible to
	 * accept any of the additional requests.
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @param X
	 * @param Y
	 * @return [[0,0],[3,3],[3,1],[5,0],[2,2]]
	 */
	int uberPool(int[] A, int[] B, int[] C, int[] X, int[] Y) {
		int d = Math.abs(A[0] - B[0]) + Math.abs(A[1] - B[1]);
		int cd = Math.abs(C[0] - A[0]) + Math.abs(C[1] - A[1]);
		int xd = Math.abs(X[0] - C[0]) + Math.abs(X[1] - C[1])
				+ Math.abs(X[0] - B[0]) + Math.abs(X[1] - B[1]);
		int yd = Math.abs(Y[0] - C[0]) + Math.abs(Y[1] - C[1])
				+ Math.abs(Y[0] - B[0]) + Math.abs(Y[1] - B[1]);

		if (xd <= yd && xd > d && yd > d)
			return 1;
		else if (xd > yd && xd > d && yd > d)
			return 2;
		else
			return -1;
	}

	/**
	 * A bracket sequence is called regular if it is possible to insert some
	 * numbers and signs into the sequence in such a way that the new sequence
	 * will represent a correct arithmetic expression.
	 * 
	 * For a string consisting of only '('s and ')'s, determine if it is a
	 * regular bracket sequence or not.
	 * 
	 * Example
	 * 
	 * Given ()() we could insert (1 + 2) * (2 + 4) which is a valid arithmetic
	 * expression, hence: regularBracketSequence1("()()") = true
	 * 
	 * [input] string sequence
	 * 
	 * [output] boolean
	 * 
	 * true if the bracket sequence is regular, false otherwise
	 * 
	 * @param sequence
	 * @return
	 */
	boolean regularBracketSequence1(String sequence) {

		int balance = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == '(') {
				balance++;
			} else {
				balance--;
			}
			if (balance < 0) {
				return false;
			}
		}
		if (balance != 0) {
			return false;
		}
		return true;
	}

	/**
	 * In a rectangular matrix of integers, call an element top-zero-free if on
	 * top of that element (in the same column) there are no 0s. Find the sum of
	 * all top-zero-free elements.
	 * 
	 * Example
	 * 
	 * matrixElementsSum([[0, 1, 1, 2], [0, 5, 0, 0], [2, 0, 3, 3]]) = 1 + 5 + 1
	 * + 2 = 9 [input] array.array.integer matrix
	 * 
	 * 2-dimensional array of integers representing a rectangular matrix.
	 * [output] integer
	 * 
	 * @param matrix
	 * @return
	 */
	int matrixElementsSum(int[][] matrix) {

		int result = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[j][i] == 0) {
					break;
				}
				result += matrix[j][i];
			}
		}

		return result;
	}

	/**
	 * The detective is investigating a gambling case and is interrogating N
	 * suspects. They are all telling the same story.
	 * 
	 * They were playing a game. Initially, they all had the same amount of
	 * money, which was a positive integer. In each round, each of the players
	 * optionally bet an arbitrary amount of money (no more than he or she had
	 * at the time) into a common pot, which, after the round ended, was
	 * redistributed among all the players in some way.
	 * 
	 * The detective knows exactly how much money each of the players had at the
	 * end of their game and wants to determine whether it is possible that they
	 * are telling the truth. Your task is to help him. You are given an array
	 * of non-negative integers of length N - the amount of money each player
	 * had after the game. Return true if it is possible the players are telling
	 * the truth, and false otherwise.
	 * 
	 * Example
	 * 
	 * For [3, 4, 8] the answer is true. One possible course of the game is that
	 * the players had 5 units of money each and the game lasted only one round.
	 * During that round, all players went all-in and bet 5 each. After the
	 * round ended, the pot of 15 was redistributed as [3, 4, 8]. The end-state
	 * [4, 4, 5, 4] is impossible. [input] array.integer L
	 * 
	 * An array of non-negative integers - the amounts of money each player
	 * allegedly had after the game. [output] boolean
	 * 
	 * true if the end-state is possible, false otherwise.
	 * 
	 * @param L
	 * @return
	 */
	boolean bettingGame(int[] L) {

		int s = 0;
		for (int i = 0; i < L.length; i++) {
			s += L[i];
		}
		if (s == 0) {
			return false;
		}

		return s % L.length == 0 ? true : false;
	}
}
