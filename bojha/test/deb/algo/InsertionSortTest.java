package deb.algo;

import org.junit.Test;

public class InsertionSortTest {
	@Test
	public void testSort() {
	  int length = 10;
		Integer[] values = new Integer[length];
		
		for (int i = 0;i < length;i ++) {
		    values[i] = (int)(Math.random()*100);
		}
		
		printValues(values,"Before sort");
		
		InsertionSort insertionSort = new InsertionSort ();
		values = (Integer[])insertionSort.sort (values);
		
		printValues(values,"After sort");
	}

  private void printValues (Integer[] values,String message)
  {
    // TODO Auto-generated method stub
    System.out.println ("\n------------" + message);
     for (int i =0; i< values.length; i++) { 
       System.out.print (values[i]+"\t");
     }
  }

}
