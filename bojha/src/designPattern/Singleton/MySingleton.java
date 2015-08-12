/**
 * 
 */
package designPattern.Singleton;

/**
 * @author debmalyajash
 *
 */
public class MySingleton {
	private static MySingleton INSTANCE;

	private static long initializationTime;

	private MySingleton() {

	}

	public static MySingleton getInstance() {
		if (INSTANCE == null) {
			synchronized (MySingleton.class) {
				INSTANCE = new MySingleton();
				initializationTime = System.currentTimeMillis();
			}			
		}
		return INSTANCE;
	}
	
	public static long getInitializationTime(){
		return initializationTime;
	}
}
