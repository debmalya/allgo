/**
 * 
 */
package amazed;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class ItemTest {

	/**
	 * Test method for {@link amazed.Item#find(java.util.List, int)}.
	 */
	@Test
	public final void testFind() {
		List<Item> itemList = new ArrayList<Item>();
		
		for (int i = 11; i > 0; i--) {
			Item item = new Item();
			item.itemId=Integer.toString(i);
			item.quantitySold=i;
			
			itemList.add(item);
		}
		
		Item item = new Item();
		Assert.assertEquals("11", itemList.get(0).itemId);
		Assert.assertEquals("1", item.find(itemList, 0));
	}

}
