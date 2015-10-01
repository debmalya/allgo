/**
 * 
 */
package amazed;

import java.util.Collections;
import java.util.List;

/**
 * @author debmalyajash
 *
 */
public class Item {
	String itemId;
	int quantitySold;

	/**
	 * Find the ith most popular item in the list.
	 */
	String find(List<Item> items, int i) { 
	// your code goes here 
		
		Collections.sort(items,(Item i1,Item i2) ->
				i1.quantitySold > i2.quantitySold ? 1 : 
				i1.quantitySold < i2.quantitySold ? -1 : 0);
		return items.get(i).itemId;
	}
}
