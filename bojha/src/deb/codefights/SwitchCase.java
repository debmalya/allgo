/**
 * 
 */
package deb.codefights;

/**
 * @author debmalyajash
 *
 */
public class SwitchCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String SC(String s) {
		char[] sc = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (sc[i] >= 'a' && sc[i] <='z'){
				sc[i]  = Character.toUpperCase(sc[i]);
			}else if (sc[i] >= 'A' && sc[i] <='Z'){
				sc[i]  = Character.toLowerCase(sc[i]);
			}
		}
		return new String(sc);
	}
	

}
