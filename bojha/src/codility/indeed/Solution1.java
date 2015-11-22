/**
 * 
 */
package codility.indeed;

/**
 * @author debmalyajash
 *
 */
public class Solution1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int solution(String S) {
	        // write your code in Java SE 8
	        String[] p = S.split(" ");
	        int maxLength = 0;
	        
	        for (String each:p){
	        	int letters = 0;
	        	int digits = 0;
	        	boolean valid = true;
	        	
	        	
	        	for (int i = 0 ; i < each.length(); i++) {
	        		char c = each.charAt(i);
	        		if ((c >= 'a' && c <='z') || (c>='A' && c <= 'Z')){
	        			letters++;
	        		} else if (c >= '0' && c <='9'){
	        			digits++;
	        		} else {
	        			valid = false;
	        		}
	        	}
	        	
	        	if (valid) {
	        		if (letters % 2 == 0 && digits % 2 == 1) {
	        			maxLength  = Math.max(maxLength, each.length());
	        		}
	        	}
	        }
	        
	        return maxLength;
	    }
}
