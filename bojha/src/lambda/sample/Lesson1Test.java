/**
 * 
 */
package lambda.sample;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class Lesson1Test {

	/**
	 * Test method for {@link lambda.sample.Lesson1Mine#getFirstLetters(java.util.List)}.
	 */
	@Test
	public final void testGetFirstLetters() {
		List<String> myList = new ArrayList<String>();
		myList.add("Debmalya");
		myList.add("Jash");
		
		Lesson1Mine lesson1 = new Lesson1Mine();
		Assert.assertEquals("DJ", lesson1.getFirstLetters(myList));
		
		myList = new ArrayList<String>();
		myList.add("Debmalya");
		myList.add("Jash");
		myList.add("Raju");
		Assert.assertEquals("DJR", lesson1.getFirstLetters(myList));
		
		myList = new ArrayList<String>();
		myList.add("Debmalya");
		myList.add("Jash");
		myList.add("raju");
		Assert.assertEquals("DJr", lesson1.getFirstLetters(myList));
	}
	
	@Test
	public final void testRemoveOddLengthLetter() {
		List<String> myList = new ArrayList<String>();
		myList.add("Debmalya");
		myList.add("Jash");
		Lesson1Mine lesson1 = new Lesson1Mine();
		List<String> newList = lesson1.removeDuplicate(myList);
		Assert.assertFalse(myList.size() != newList.size());
		
		myList = new ArrayList<String>();
		myList.add("Debmalya");
		myList.add("Jash");
		myList.add("Poi");
		
	    newList = lesson1.removeDuplicate(myList);
		Assert.assertFalse(myList.size() != newList.size());
	}

}
