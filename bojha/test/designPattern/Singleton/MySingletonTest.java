/**
 * 
 */
package designPattern.Singleton;



import org.junit.Assert;
import org.junit.Test;

/**
 * @author debmalyajash
 *
 */
public class MySingletonTest {

	@Test
	public final void test() {
		MySingleton singleton = MySingleton.getInstance();
		Assert.assertNotNull("Singleton instance should not be null",singleton);
		
		long initializationTime = MySingleton.getInitializationTime();
		Assert.assertTrue("initializationTime should be greater than 0",initializationTime > 0);
		
		MySingleton singleton1 = MySingleton.getInstance();
		Assert.assertSame("Two singleton instances should be same",singleton, singleton1);
		
		long initializationTime1 = MySingleton.getInitializationTime();
		Assert.assertEquals("Initialization time should be same ", initializationTime, initializationTime1);
		
		
		
		MySingleton1 mySingleton1 = MySingleton1.getInstance();
		MySingleton1 mySingleton2 = MySingleton1.getInstance();
		Assert.assertSame("Two singleton instances should be same",mySingleton1, mySingleton2);
	}

}
