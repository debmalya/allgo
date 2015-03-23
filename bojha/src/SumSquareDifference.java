/**
 * The sum of the squares of the first ten natural numbers is,

1**2 + 2**2 + ... + 10**2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)**2 = 55**2 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author debmalyajash
 *
 */
public class SumSquareDifference {
	public static void main(String[] args) {
		long sumOfSquares = 1L;
		long squareOfSum = 1L;
		
		for (long i = 2L; i <= 100L; i++) {
			sumOfSquares += (i * i);
			squareOfSum += i;
		}
		
		squareOfSum *= squareOfSum;
		long difference = squareOfSum - sumOfSquares;
		System.out.println("squareOfSum :"+squareOfSum + " sumOfSquares :"+ sumOfSquares+ " difference :" + difference);
	}
}
/**
An interesting fact related to this problem is that the difference between the square of the sum and the sum of the cubes is always 0, for any n:

(1+2+3+...+n)^2=(1^3)+(2^3)+(3^3)+...+(n^3)
*/