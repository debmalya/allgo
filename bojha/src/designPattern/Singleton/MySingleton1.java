/**
 * 
 */
package designPattern.Singleton;

/**
 * @author debmalyajash
 *
 */
public class MySingleton1 {
	
	private MySingleton1(){
		
	}
	
	public static MySingleton1 getInstance() {
        try {
            return MySingleton1ManagerHolder.instance;
        } catch (ExceptionInInitializerError ex) {

        }
        return null;
    }
	
	
	
	private static class MySingleton1ManagerHolder {
        private final static MySingleton1 instance = new MySingleton1();
    }
}
