/**
 * 
 */
package lambda.sample;

import java.util.OptionalInt;
import java.util.Random;

/**
 * @author debmalyajash
 *
 */
public class Lesson3Mine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println(rand.ints().findFirst());
		System.out.println(rand.ints().findAny());
		
			
	}

	
}
