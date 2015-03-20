/**
 * 
 A robot has to move in a grid which is in the form of a matrix. It can go to
 * 1.) A(i,j)--> A(i+j,j) (Down) 2.) A(i,j)--> A(i,i+j) (Right)
 * 
 * Given it starts at (1,1) and it has to go to A(m,n), find the minimum number
 * of STEPS it has to take to get to (m,n) and write public static int
 * minSteps(int m,int n)
 * 
 * For instance to go from (1,1) to m=3 and n=2 it has to take (1, 1) -> (1, 2)
 * -> (3, 2) i.e. 2 steps
 * 
 * @author debmalyajash
 *
 */
public class Robot {
	public static int minSteps(int m, int n) {

		int i = 1, j = 1;
		int step = i + j;
		int result = 0;

		result += (m - 1) / step;
		result += (m - 1) % step;
		result += (n - 1) / step;
		result += (n - 1) % step;

		return result;
	}
}
