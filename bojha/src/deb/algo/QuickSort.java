package deb.algo;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void qsort(Comparable[] v,int left,int right) {
		int i, last;
		if (left >= right) {
			return;
		}
		swap(v,left,(left+right)/2); /* move partition element */
		last = left;
		
		for (i=left+1; i <= right; i++) {
			if (v[i].compareTo(v[left]) < 0) {
				swap(v,++last,i);
			}
		}
		
		swap(v,left,last);
		qsort(v,left,last-1);
		qsort(v,last+1,right);
		
	}
	
	public void swap(Comparable[] v,int i, int j) {
		Comparable temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	
	}

}
