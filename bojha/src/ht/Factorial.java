package ht;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			int noOfTestCases = scanner.nextInt();

			int[] inputs = new int[noOfTestCases];
			for (int i = 0; i < noOfTestCases; i++) {
				inputs[i] = scanner.nextInt();
			}

			for (int eachInput : inputs) {
				System.out.println(factorial(eachInput));
			}
		} catch (Throwable th) {
			System.err.println("ERR :" + th.getMessage());
		}

	}

	public static BigInteger factorial(long eachInput) {
		if (eachInput < 2) {
			return BigInteger.ONE;
		} else {
			BigInteger valu = BigInteger.valueOf(eachInput);
			return valu.multiply(factorial(eachInput -1));
		}
		
	}

}
