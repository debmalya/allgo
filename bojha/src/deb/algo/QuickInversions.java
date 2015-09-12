package deb.algo;

import ht.InversionCounter;

import java.util.Scanner;

public class QuickInversions {

	private static int intervsionCount = 0;
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int numberOfTestCases = scanner.nextInt();
			int[] output = new int[numberOfTestCases];
			for (int i = 0; i < numberOfTestCases; i++) {
				int arrayLength = scanner.nextInt();
				scanner.nextLine();
				String[] values = scanner.nextLine().split(" ");
				int[] arr = new int[arrayLength];
				for (int j = 0; j < arrayLength; j++) {
					arr[j] = Integer.parseInt(values[j]);
				}
				qsort(arr,0,arrayLength - 1);
				output[i] = intervsionCount;
				intervsionCount = 0;
			}
			
			
			for (int i = 0; i < numberOfTestCases; i++) {
				System.out.println(output[i]);
			}
		}

	}
	
	public static void qsort(int[] v,int left,int right) {
		int i, last;
		if (left >= right) {
			return;
		}
		swap(v,left,(left+right)/2); /* move partition element */
		last = left;
		
		for (i=left+1; i <= right; i++) {
			if (v[i] < v[left]) {
				swap(v,++last,i);
			}
		}
		
		swap(v,left,last);
		qsort(v,left,last-1);
		qsort(v,last+1,right);
		
	}
	
	public static void swap(int[] v,int i, int j) {
		if (v[i] > v[j]) {
			intervsionCount++;
		}
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	
	}

}
