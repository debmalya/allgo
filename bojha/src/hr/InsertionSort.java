/**
 * 
 */
package hr;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author debmalyajash
 *
 */
public class InsertionSort {

	public static void insertionSortPart2a(int[] ar) {
		// Fill up the code for the required logic here
		// Manipulate the array as required
		// The code for Input/Output is already provided
		for (int i = 0; i < ar.length - 1; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				if (ar[j] < ar[i]) {
					int temp = ar[j];
					ar[j] = ar[i];
					ar[i] = temp;
				}
			}
			printArray(ar);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void insertIntoSorted(int[] arr) {
		// Fill up this function
		for (int i = arr.length - 1; i > -1; i--) {
			int temp = arr[i];
			
			for (int j = i; j > 0; j--) {
				if (arr[j - 1] > temp) {
					arr[j] = arr[j - 1];
					printArray(arr);
					if (j == 1) {
						arr[j -1] = temp;
						printArray(arr);
					}
				} else if (arr[j - 1] < temp && temp < arr[j]) {
					arr[j] = temp;
					printArray(arr);
					break;
				}

			}
		}
	}
	
	public static void insertionSortPart2(int[] arr) {
		// Fill up this function
		for (int i = 1; i < arr.length; i++) {
			int k = i;
			for (int j = i - 1; j > -1; j--) {
				if (arr[j] > arr[k]) {
					int temp = arr[k];
					arr[k] = arr[j];
					arr[j] = temp;
					k = j;
				}
					
			}
			printArray(arr);
		}
	}


}
