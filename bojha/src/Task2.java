/**
 * 
 */

/**
 * @author debmalyajash
 *
 */
public class Task2 {
	public String solution(String S) {
		// write your code in Java SE 8
		// write your code in Java SE 8
		String[] ch = new String[] { "AB", "BA", "CB", "BC", "AA", "CC" };
//		String[] re = new String[] { "AA", "AA", "CC", "CC", "A", "C" };
		 String[] re = new String[]{"A","A","CC","C","A","C"};
		String prevS = S;

		while (true) {
			boolean matchFound = false;
			for (int i = 0; i < ch.length; i++) {
				S = S.replace(ch[i], re[i]);
				if (!prevS.equals(S)) {
					matchFound = true;
				}
			}
			if (!matchFound) {
				break;
			} else {
				prevS = S;
			}
		}
		return S;
	}
}
